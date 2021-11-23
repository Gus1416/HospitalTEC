package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
//import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que contiene las operaciones CRUD para las consultas del doctor.
 * 
 * @author Sebastián
 * @version 20/11/2021
 */
public class ConsultasDocCRUD extends Conexion{
    
  /**
   * Consuta los diagnósitos de un paciente según el nivel.
   * 
   * @param Ced la cédula del paciente
   * @param Nivel el nivel del diagnóstico consultado
   * @return una lista con los resultados de la consulta
   */
  public ArrayList<Object[]> PacienteDiagnosticoNivel(String Ced, String Nivel) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();

    String sql = "CALL Paciente_Diagnostico_Nivel(?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Integer.parseInt(Ced));
      ps.setString(2, Nivel);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
    
  /**
   * Consulta los diagnósticos de un paciente según el nombre del diagnóstico.
   * 
   * @param Ced la cédula del paciente
   * @param Nombre el nombre del diagnóstico
   * @return una lista con los resultados de la consulta
   */
  public ArrayList<Object[]> PacienteDiagnosticoNombreD(String Ced, String Nombre){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Diagnostico_Nombre(?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Integer.parseInt(Ced));
      ps.setString(2, Nombre);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  /**
   * Consulta los diagnósticos de un paciente según un rango de fechas.
   * 
   * @param Ced la cédula del paciente
   * @param date1 la primera fecha del rango
   * @param date2 la segunda fecha del rango
   * @return una lista con los resultados de la consulta
   */
  public ArrayList<Object[]> PacienteDiagnosticoDateRange(String Ced, Date date1, Date date2){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Diagnostico_Fecha(?,?,?)";
     
    LocalDate dateO = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate dateT = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Integer.parseInt(Ced));
      ps.setDate(2,java.sql.Date.valueOf(dateO));
      ps.setDate(3, java.sql.Date.valueOf(dateT));
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  /**
   * Consulta los tratamientos de un paciente según el nombre del tratamiento.
   * 
   * @param Ced la cédula del paciente
   * @param NombreT el nombre del tratamiento
   * @return una lista con los resultados de la consulta
   */
  public ArrayList<Object[]> PacienteTratamientoNombre(String Ced, String NombreT){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Tratamiento_Nombre(?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Integer.parseInt(Ced));
      ps.setString(2, NombreT);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
   
  /**
   * Consulta los tratamientos de un paciente según el tipo de tratamiento.
   * 
   * @param Ced la cédula del paciente
   * @param TipoT el tipo del tratamiento
   * @return una lista con los resultados de la consulta
   */ 
  public ArrayList<Object[]> PacienteTratamientoTipo(String Ced, String TipoT){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Tratamiento_TipoTratamiento(?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Integer.parseInt(Ced));
      ps.setString(2, TipoT);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }    
  
  public ArrayList<Object[]> PacienteDiagnosticoTrataDateRange(String Ced, Date date1, Date date2){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Tratamiento_RangoFechas(?,?,?)";
    
    
    LocalDate dateO = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate dateT = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Integer.parseInt(Ced));
      ps.setDate(2,java.sql.Date.valueOf(dateO));
      ps.setDate(3, java.sql.Date.valueOf(dateT));
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> CitaEspecialidad(String Especialidad){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Citas_Especialidad(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, Especialidad);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> CitaEstado(String Estado){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Citas_Estado(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, Estado);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> CitaRangoFechas(Date date1, Date date2){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Citas_RangoFechas(?,?)";
    
    
    LocalDate dateI = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate dateF = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
    try{
      ps = con.prepareStatement(sql);
      ps.setDate(1,java.sql.Date.valueOf(dateI));
      ps.setDate(2, java.sql.Date.valueOf(dateF));
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> DiagCantNivel(String Nivel){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Diagnosticos_Nivel(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, Nivel);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> DiagCantPaciente(int Cedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Diagnosticos_Paciente(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Cedula);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> TrataCantPaciente(int Cedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Tratamiento_Paciente(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Cedula);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> TrataCantTipo(String Tipo){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Tratamientos_Tipo(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, Tipo);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> TrataCantEspecialidad(String Especialidad){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Tratamiento_Especialidad(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, Especialidad);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> TrataConteGen(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Cantidad_Tratamientos_Gen()";
    
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  public ArrayList<Object[]> HospiPaci(int Cedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Hospitalizacion_Paciente(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Cedula);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;
  
    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
}