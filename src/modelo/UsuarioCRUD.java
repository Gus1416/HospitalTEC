package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class UsuarioCRUD extends Conexion{
  
  public UsuarioCRUD(){}
  
  public boolean login(Usuario pUsuario){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    
    String sql = "SELECT * FROM usuario WHERE cedula = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pUsuario.getCedula());
      rs = ps.executeQuery();
      
      if (rs.next()){
        if (pUsuario.getPassword().equals(rs.getString("password"))){
          pUsuario.setTipoUsuario(rs.getString("tipo_usuario"));
          return true;
        } else {
          return false;
        }
      } else{
        return false;     
      }      
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
