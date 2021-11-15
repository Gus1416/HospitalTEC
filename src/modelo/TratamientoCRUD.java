package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class TratamientoCRUD extends Conexion{
  
  public TratamientoCRUD (){}
  
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
}
