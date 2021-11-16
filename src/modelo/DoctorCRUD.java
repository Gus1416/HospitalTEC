package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Gustavo
 */
public class DoctorCRUD extends Conexion{
  
  public DoctorCRUD(){}
  
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
  
  public Doctor buscarDoctor(String pCedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Doctor doctor = new Doctor();
    
    String sql = """
                 SELECT *, nombre as Namf FROM db_hospitaltec.doctor INNER JOIN db_hospitaltec.funcionario INNER JOIN db_hospitaltec.funcionario_centro_atencion WHERE funcionario.cedula_funcionario= funcionario_centro_atencion.cedula_funcionario
                 AND doctor.cedula_funcionario = funcionario_centro_atencion.cedula_funcionario AND  funcionario_centro_atencion.cedula_funcionario = ?;""";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedula);
      rs = ps.executeQuery();
      
      if (rs.next()){
          
        doctor.setCedula(pCedula);
        doctor.setCodigoMedico(rs.getInt("codigo_medico"));
        doctor.setNombre(rs.getString("Namf"));
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
