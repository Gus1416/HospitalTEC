package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class ConsultasPacienteCRUD extends Conexion{
  
  public ConsultasPacienteCRUD(){}
  
  public ArrayList<Object[]> pacienteCitasFechas(String pCedulaPaciente, java.util.Date pFecha1, 
          java.util.Date pFecha2){
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Citas_Fechas(?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setDate(2, new Date(pFecha1.getTime()));
      ps.setDate(3, new Date(pFecha2.getTime()));
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
  
  public ArrayList<Object[]> pacienteCitasEstado(String pCedulaPaciente, String pEstado){
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Citas_Estado(?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setString(2, pEstado);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
  
  public ArrayList<Object[]> pacienteCitasEspecialidad(String pCedulaPaciente, int pEspecialidad){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Citas_Especialidad(?,?)";
    
     try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setInt(2, pEspecialidad);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
  
  public ArrayList<Object[]> pacienteDiagnosticosFechas(String pCedulaPaciente, java.util.Date pFecha1, 
          java.util.Date pFecha2){
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Diagnostico_Fecha(?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setDate(2, new Date(pFecha1.getTime()));
      ps.setDate(3, new Date(pFecha2.getTime()));
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
  
  public ArrayList<Object[]> pacienteDiagnosticoNivel(String pCedulaPaciente, String pNivel){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Diagnostico_Nivel(?,?)";
    
     try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setString(2, pNivel);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
  
  public ArrayList<Object[]> pacienteDiagnosticoNombre(String pCedulaPaciente, String pNombreDiagnostico){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Diagnostico_Nombre(?,?)";
    
     try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setString(2, pNombreDiagnostico);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
  
  public ArrayList<Object[]> pacienteTratamientosFechas(String pCedulaPaciente, java.util.Date pFecha1, 
          java.util.Date pFecha2){
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Tratamiento_RangoFechas(?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setDate(2, new Date(pFecha1.getTime()));
      ps.setDate(3, new Date(pFecha2.getTime()));
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
   
  public ArrayList<Object[]> pacienteTratamientosTipo(String pCedulaPaciente, String pTipo){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Tratamiento_TipoTratamiento(?,?)";
    
     try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setString(2, pTipo);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
  
  public ArrayList<Object[]> pacienteTratamientosNombre(String pCedulaPaciente, String pNombre){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Paciente_Tratamiento_Nombre(?,?)";
    
     try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      ps.setString(2, pNombre);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
  
  public ArrayList<Object[]> pacienteHospitalizaciones(String pCedulaPaciente){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL Hospitalizacion_Paciente(?)";
    
     try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i+1);
        }
        objFilas.add(filas);
      }
      return objFilas;
      
    } catch (SQLException ex){
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
}
  
