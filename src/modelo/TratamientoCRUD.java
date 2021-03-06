package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

/**
 * Clase que contiene las operaciones CRUD de los tratamientos.
 * 
 * @author Gustavo
 * @version  20/11/2021
 */
public class TratamientoCRUD extends Conexion{
  
  /**
   * Constructor de la clase
   */
  public TratamientoCRUD (){}
  
  /**
   * Regista un nuevo tratamiento en la base de datos.
   * 
   * @param pTratamiento Un objeto tratamiento
   * @return un booleano que indica si la operación se dio con éxito
   */
  public boolean registrarTratamiento(Tratamiento pTratamiento){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_tratamiento(?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pTratamiento.getNombre());
      ps.setInt(2, pTratamiento.getDosis());
      ps.setString(3, pTratamiento.getTipo());
      ps.execute();
      return true;
      
    } catch (SQLException ex) {
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
   * Consulta los tratamientos registrados.
   * 
   * @return una lista con los resultados de la búsqueda.
   */
  public ArrayList<Tratamiento> consultarTratamientos(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Tratamiento> tratamientos = new ArrayList<>();
    
    String sql = "SELECT * FROM catalogo_tratamientos";
    
    try {
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while (rs.next()){
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(rs.getInt("id_tratamiento"));
        tratamiento.setNombre(rs.getString("nombre"));
        tratamiento.setDosis(rs.getInt("cantidad_dosis"));
        tratamiento.setTipo(rs.getString("tipo"));
        tratamientos.add(tratamiento);
      }
      return tratamientos;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
      
    } finally {
      try {
        con.close();
      } catch(SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
  
  /**
   * Consulta un tratamiento según el diagnóstico.
   * 
   * @param pIdDiagnostico el identificador del diagnóstico
   * @return una lista con los resultados de la búsqueda
   */
  public ArrayList<Tratamiento> consultarTratamientos(int pIdDiagnostico){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Tratamiento> tratamientos = new ArrayList<>();
    
    String sql = "CALL consultar_tratamientos(?)";
    
    try {
      ps = con.prepareStatement(sql);
      ps.setInt(1, pIdDiagnostico);
      rs = ps.executeQuery();
      
      while (rs.next()){
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(rs.getInt("id_tratamiento"));
        tratamiento.setNombre(rs.getString("nombre"));
        tratamiento.setDosis(rs.getInt("cantidad_dosis"));
        tratamiento.setTipo(rs.getString("tipo"));
        tratamientos.add(tratamiento);
      }
      return tratamientos;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
      
    } finally {
      try {
        con.close();
      } catch(SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
  
  /**
   * Consulta los tratamientos según el nombre del tratamiento.
   * 
   * @param pNombre el nombre del diagnóstico
   * @return una lista con los resultados de la consulta
   */
  public ArrayList consultarTratamientos(String pNombre){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Tratamiento> tratamientos = new ArrayList<>();
    
    String sql = "CALL consultar_tratamientos2(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1,pNombre);
      rs = ps.executeQuery();
      
      
      while (rs.next()){ 
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setNombre(rs.getString("NombreTratamiento"));
        tratamiento.setId(rs.getInt("id_tratamiento"));
        tratamientos.add(tratamiento);
      }
      
      return tratamientos;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return tratamientos;
      
    } finally {
      try {
        con.close();
      } catch (SQLException ex) {
        System.err.println(ex);
      }
    }
  }
  
  /**
   * Consulta un tratamiento específico según el nombre.
   * 
   * @param pNombre el nombre del tratamiento
   * @return un objeto Tratamiento
   */
  public Tratamiento consultarUnTratamiento(String pNombre){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    
    String sql = "SELECT * FROM catalogo_tratamientos WHERE nombre = ?";
    
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, pNombre);
      rs = ps.executeQuery();
      
      if (rs.next()){
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(rs.getInt("id_tratamiento"));
        tratamiento.setNombre(rs.getString("nombre"));
        tratamiento.setDosis(rs.getInt("cantidad_dosis"));
        tratamiento.setTipo(rs.getString("tipo"));
        return tratamiento;
      } else {
        return null;
      }
      
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
      return null;
      
    } finally {
      try{
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
  
  /**
   * Registra una atención brindada a un paciente.
   * 
   * @param Paciente el nombre del paciente atendido
   * @param Cita el identificador de la cita
   * @param Diagnostico el nombre del diagnóstico
   * @param Nivel el nivel del diagnóstico
   * @param Observaciones observaciones anotadas durante la cita
   * @param Tratamiento el nombre del tratamiento 
   * @param Dosis la cantidad de dosis
   * @param TipoTratamiento el tipo de tratamiento
   * @return un booleano que indica el éxtio de la operación
   */
  public boolean registrarAtencion(String Paciente, int Cita, String Diagnostico, String Nivel, String Observaciones,
           String Tratamiento, int Dosis, String TipoTratamiento) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    LocalDate now = LocalDate.now();
    Date pdate = Date.valueOf(now);

    String sql = "CALL registrar_atencion(?,?,?,?,?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, Paciente);
      ps.setInt(2, Cita);
      ps.setString(3, Diagnostico);
      ps.setString(4, Nivel);
      ps.setString(5, Observaciones);
      ps.setString(6, Tratamiento);
      ps.setInt(7, Dosis);
      ps.setString(8, TipoTratamiento);
      ps.setDate(9, pdate);
      ps.execute();
      return true;

    } catch (SQLException e){
      System.err.println(e);
      return false;

    } finally{
      try {
        con.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }
}
