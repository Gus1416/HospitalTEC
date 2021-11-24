package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase con las operaciones CRUD para las áreas.
 * 
 * @author Gustavo
 * @version 15/11/2021
 */
public class AreaCRUD extends Conexion{
  //Atributos de la clase
  public static ArrayList<Area> LISTAAREAS = new  ArrayList<Area> ();
  
  /**
   * Constructor por defecto.
   */
  public AreaCRUD(){}

  /**
   * Obtiene la lista de áreas registradas.
   * 
   * @return una lista con objetos de tipo Area
   */
  public static ArrayList<Area> getLISTAAREAS() {
    return LISTAAREAS;
  }
  
  /**
   * Consulta las áreas registradas en la base de datos.
   * 
   * @return una lista con objetos de tipo Area
   */
  public ArrayList consultarAreas(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Area> areas = new ArrayList<>();
    
    String sql = "SELECT * FROM area";
    
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while (rs.next()){       
        Area contenedor = new Area(rs.getString("nombre"),rs.getInt("id_area"));  
        Area area = new Area();
        area.setNombreArea(rs.getString("nombre"));
        area.setIdArea(rs.getInt("id_area"));
        areas.add(area);
        LISTAAREAS.add(contenedor); 
      }
      
      return areas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return areas;
      
    } finally {
      try {
        con.close();
      } catch (SQLException ex) {
        System.err.println(ex);
      }
    }
  }
  
  /**
   * Busca un área en la base de datos mediante el nombre.
   * 
   * @param pNombreArea el nombre del área a buscar
   * @return un objeto de tipo Area
   */
  public Area buscarArea(String pNombreArea){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Area area = new Area();
    
    String sql = "SELECT * FROM area WHERE nombre = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pNombreArea);
      rs = ps.executeQuery();
      
      while(rs.next()){
        area.setIdArea(rs.getInt("id_area"));
        area.setNombreArea(rs.getString("nombre"));
      }
      return area;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    }
  }
  
  /**
   * Busca un área en la base de datos mediante el identificador.
   * 
   * @param pIdArea el identificador del área a buscar
   * @return un objeto de tipo Area
   */
  public Area buscarArea(int pIdArea){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Area area = new Area();
    
    String sql = "SELECT * FROM area WHERE id_area = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, pIdArea);
      rs = ps.executeQuery();
      
      while(rs.next()){
        area.setIdArea(rs.getInt("id_area"));
        area.setNombreArea(rs.getString("nombre"));
      }
      return area;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    }
  }
  
  public boolean registrarArea (Area pArea){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "INSERT INTO area SET nombre = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pArea.getNombreArea());
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
  
  public boolean eliminarArea(Area pArea){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "DELETE FROM area WHERE id_area = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, pArea.getIdArea());
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
}