
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sebcor
 */
public class ConsultasDocCRUD extends Conexion{
    
    public ArrayList<Object[]> PacienteDiagnosticoNivel(String Ced, String Nivel){
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
    
    
    
    
    
    
    
    
    
}
