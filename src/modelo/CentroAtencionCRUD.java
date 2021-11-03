package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class CentroAtencionCRUD extends Conexion {
  
  public CentroAtencionCRUD(){}
  
  public ArrayList<CentroAtencion> consultarCentros(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<CentroAtencion> centros = new ArrayList<>();
    
    String sql = "SELECT * FROM centro_atencion";
    
    try{
      ps = con.prepareStatement(sql);   
      rs = ps.executeQuery();
      
      while (rs.next()){
        CentroAtencion centro = new CentroAtencion();
        centro.setId(rs.getInt("codigo_centro"));
        centro.setNombre(rs.getString("nombre"));
        centro.setLugar(rs.getString("ubicacion"));
        centro.setCapacidadPacientes(rs.getInt("capacidad"));
        centro.setTipo(rs.getString("tipo_centro"));
        centros.add(centro);
      }
      return centros;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return centros;
      
    } finally {
      try{
        con.close();
      } catch (SQLException ex){
        System.err.println(ex);
      }
    }
  }
  
  public CentroAtencion buscarCentro (String pNombreCentro){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    CentroAtencion centro = new CentroAtencion();
    
    String sql = "SELECT * FROM centro_atencion WHERE nombre = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pNombreCentro);
      rs = ps.executeQuery();
      
      while(rs.next()){
        centro.setId(rs.getInt("codigo_centro"));
        centro.setNombre(rs.getString("nombre"));
        centro.setLugar(rs.getString("ubicacion"));
        centro.setCapacidadPacientes(rs.getInt("capacidad"));
        centro.setTipo(rs.getString("tipo_centro"));
      }
      return centro;
    
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    }
  }  
    
  
}
