package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que contiene las operaciones CRUD de los pacientes
 * 
 * @author Gustavo
 * @version  
 */
public class PacienteCRUD extends Conexion{
  public static ArrayList<Paciente> listaPacientes = new  ArrayList<Paciente> ();
  
  public PacienteCRUD(){}
  
  public static ArrayList<Paciente> getListaPacientes() {
    return listaPacientes;
  }

  public boolean registrarPaciente(Paciente pPaciente){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_paciente(?,?,?,?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pPaciente.getCedula());
      ps.setString(2, pPaciente.getPassword());
      ps.setString(3, pPaciente.getTipoUsuario());
      ps.setString(4, pPaciente.getNombre());
      ps.setDate(5, Date.valueOf(pPaciente.getFechaNacimiento()));
      ps.setString(6, pPaciente.getTipoSangre());
      ps.setString(7, pPaciente.getNacionalidad());
      ps.setString(8, pPaciente.getLugarResidencia());
      ps.execute();
      return true;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return false;
    } finally {
      try{
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
  
  public boolean registrarTelefonos(Paciente pPaciente){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "INSERT INTO paciente_telefonos (cedula_paciente, telefono) VALUES " 
            + completarQuery(pPaciente); 
    
    try{
      ps = con.prepareStatement(sql);
      ps.execute();
      return true;
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return false;
    } finally {
      try{
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
  
  private String completarQuery(Paciente pPaciente) {
    String query = "";
    for (int i = 0; i < pPaciente.getTelefonos().size(); i++){
      query += "(" + pPaciente.getCedula() + ", '" + pPaciente.getTelefonos().get(i) + "')";
      if (i == pPaciente.getTelefonos().size() - 1){
        query += ";";
      } else {
        query += ",";
      }
    }
    return query;
  }

  public ArrayList consultarPacientes(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Paciente> pacientes = new ArrayList<>();
    
    String sql = "SELECT * FROM paciente";
    
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while (rs.next()){ 
        Paciente contenedor = new Paciente();
        contenedor.setCedula(rs.getString("cedula_paciente"));
        contenedor.setNombre(rs.getString("nombre"));
        pacientes.add(contenedor);
        listaPacientes.add(contenedor);
      }
      return pacientes;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return pacientes;
      
    } finally {
      try {
        con.close();
      } catch (SQLException ex) {
        System.err.println(ex.getMessage());
      }
    }
  }
  
  public Paciente buscarPaciente(String pCedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Paciente paciente = new Paciente();
    
    String sql = "SELECT * FROM paciente WHERE cedula_paciente = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedula);
      rs = ps.executeQuery();
      
      if (rs.next()){
        paciente.setCedula(rs.getString("cedula_paciente"));
        paciente.setNombre(rs.getString("nombre"));
        paciente.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
        paciente.setTipoSangre(rs.getString("tipo_sangre"));
        paciente.setNacionalidad(rs.getString("nacionalidad"));
        paciente.setLugarResidencia(rs.getString("residencia"));
        return paciente;
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
  
  public Paciente buscarPacienteNombre(String pNombre){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Paciente paciente = new Paciente();
    
    String sql = "SELECT * FROM paciente WHERE nombre = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pNombre);
      rs = ps.executeQuery();
      
      if (rs.next()){
        paciente.setCedula(rs.getString("cedula_paciente"));
        paciente.setNombre(rs.getString("nombre"));
        paciente.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
        paciente.setTipoSangre(rs.getString("tipo_sangre"));
        paciente.setNacionalidad(rs.getString("nacionalidad"));
        paciente.setLugarResidencia(rs.getString("residencia"));
        return paciente;
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
  
  public boolean registrarHospitalizacion(HospitalizacionP pHospi){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_hospitalizacion(?,?,?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pHospi.getCentroAtencion());
      ps.setString(5, pHospi.getIdentificacion());
      ps.setString(2, pHospi.getDiagnostico());
      ps.setString(3, pHospi.getServicio());
      ps.setString(4, pHospi.getFuncionario()); 
      java.sql.Date sqlInicialDate = new java.sql.Date(pHospi.getFechaInicio().getTime());
      java.sql.Date sqlFinalDate = new java.sql.Date(pHospi.getFechaFinal().getTime());
      ps.setDate(6, sqlInicialDate);
      ps.setDate(7, sqlFinalDate);
      ps.execute();
      return true;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return false;
    } finally {
      try{
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
  
  public ArrayList<Citas> consultarCitasPaciente(Paciente pPaciente){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Citas> citas = new ArrayList();
    
    String sql = "SELECT * FROM cita WHERE cedula_paciente = ? AND estado_actual = 'REGISTRADA' OR estado_actual = 'ASIGNADA'";
    
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, pPaciente.getCedula());
      rs = ps.executeQuery();
      
      while(rs.next()){
        Citas cita = new Citas();
        cita.setiDCita(rs.getInt("id_cita"));
        cita.setiDArea(rs.getInt("id_area"));
        cita.setFechaCita(rs.getDate("fecha_hora").toLocalDate());
        cita.setObservacionAdicional(rs.getString("observacion"));
        cita.setCedulaPaciente(pPaciente.getCedula());
        citas.add(cita);
      }
      return citas;
      
      
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
        return null;
    }
  }
}