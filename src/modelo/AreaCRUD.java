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
  
  public static ArrayList<Area> LISTAAREAS = new  ArrayList<Area> ();

    public static ArrayList<Area> getLISTAAREAS() {
        return LISTAAREAS;
    }
  
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
        area.setiDArea(rs.getInt("id_area"));
        areas.add(area);
        
        System.out.println("Estos son los nombres de las áreas que tiene la lista" + area.getNombreArea());
        
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
}
