package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

/**
 * Clase que contiene las operaciones CRUD de los doctores.
 * 
 * @author Gustavo
 * @version 15/11/2021
 */
public class DoctorCRUD extends Conexion{
  
  /**
   * Constructor por defecto.
   */
  public DoctorCRUD(){}
  
  /**
   * Registra un nuevo doctor en la base de datos.
   * 
   * @param pDoctor un objeto Doctor
   * @return un booleano para verificar el éxito de la operación
   */
  public boolean registrarDoctor(Doctor pDoctor){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_doctor(?,?,?,?,?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pDoctor.getCedula());
      ps.setString(2, pDoctor.getPassword());
      ps.setString(3, pDoctor.getTipoUsuario());
      ps.setString(4, pDoctor.getNombre());
      ps.setString(5, pDoctor.getTipoFuncionario());
      ps.setDate(6, Date.valueOf(pDoctor.getFechaIngreso()));
      ps.setString(7, pDoctor.getArea().getNombreArea());
      ps.setInt(8, pDoctor.getCentro().getId());
      ps.setInt(9, pDoctor.getCodigoMedico());
      ps.execute();
      return true;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return false;
    } finally {
      try{
        con.close();
      } catch (SQLException ex) {
        System.err.println(ex);
      }
    }
  }
  
  /**
   * Registra las especialidades del doctor en la base de datos.
   * 
   * @param pDoctor un objeto Doctor
   * @return un booleano para verificar el éxito de la operación
   */
  public boolean registrarEspecialidades(Doctor pDoctor){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "INSERT INTO doctor_especialidades (codigo_medico, especialidad) VALUES" 
            + completarQuery(pDoctor);
    try{
      ps = con.prepareStatement(sql);
      ps.execute();
      return true;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return false;
    } finally {
      try {
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
  
  /**
   * Completar un query sql con inserciones múltiples.
   * 
   * @param pDiagnostico un objeto Doctor
   * @return una cadena con el query de inserción múltiple
   */
  private String completarQuery(Doctor pDoctor){
    String query = "";
    for (int i = 0; i < pDoctor.getEspecialidades().size(); i++){
      query += "(" + pDoctor.getCodigoMedico() + ", '" + pDoctor.getEspecialidades().get(i) + "')";
      if (i == pDoctor.getEspecialidades().size()-1){
        query += ";";
      } else {
        query += ",";
      }
    }
    return query;
  }
  
  /**
   * Busca un doctor específico según el nombre.
   * 
   * @param pCedula la cédula del doctor
   * @return un objeto Doctor
   */
  public Doctor buscarDoctor(String pCedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Doctor doctor = new Doctor();
    
    String sql = "SELECT * FROM doctor INNER JOIN funcionario INNER JOIN funcionario_centro_atencion "
            + "WHERE funcionario.cedula_funcionario = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedula);
      rs = ps.executeQuery();
      
      if (rs.next()){
        doctor.setCedula(pCedula);
        doctor.setCodigoMedico(rs.getInt("codigo_medico"));
        doctor.setNombre("nombre");
        doctor.setTipoFuncionario("tipo_funcionario");
        doctor.setFechaIngreso(rs.getDate("fecha_ingreso").toLocalDate());
        doctor.setArea(new AreaCRUD().buscarArea(rs.getInt("id_area")));
        doctor.setCentro(new CentroAtencionCRUD().buscarCentro(rs.getInt("codigo_centro")));
        doctor.setEspecialidades(obtenerEspecialidades(doctor.getCodigoMedico()));
        return doctor;
      } else {
        return null;
      }
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    } finally {
      try {
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
  
  /**
   * Consulta las especialidades de un doctor.
   * 
   * @param pCodigoMedico cédula del doctor
   * @return una lista con los resultados de la consulta
   */
  private ArrayList<String> obtenerEspecialidades (int pCodigoMedico){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<String> especialidades = new ArrayList();
    
    String sql = "SELECT * FROM doctor_especialidades WHERE codigo_medico = ?";
    
    try {
      ps = con.prepareStatement(sql);
      ps.setInt(1, pCodigoMedico);
      rs = ps.executeQuery();
      
      while (rs.next()){
        especialidades.add(rs.getString("especialidad"));
      }
      return especialidades;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    } finally {
      try {
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
}
