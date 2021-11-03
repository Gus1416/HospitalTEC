package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class AreaCRUD extends Conexion{
  
  public AreaCRUD(){}
  
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
        Area area = new Area();
        area.setNombreArea(rs.getString("nombre"));
        areas.add(area);
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
        area.setNombreArea(rs.getString("nombre"));
      }
      return area;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    }
  }
}
