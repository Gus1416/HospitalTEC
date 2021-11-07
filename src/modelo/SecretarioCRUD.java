package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Gustavo
 */
public class SecretarioCRUD extends Conexion {
  public SecretarioCRUD(){}
  
  public boolean registrarSecretario(Secretario pSecretario){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_secretario(?,?,?,?,?,?,?,?)";
    
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, pSecretario.getCedula());
      ps.setString(2, pSecretario.getPassword());
      ps.setString(3, pSecretario.getTipoUsuario());
      ps.setString(4, pSecretario.getNombre());
      ps.setString(5, pSecretario.getTipoFuncionario());
      ps.setDate(6, Date.valueOf(pSecretario.getFechaIngreso()));
      ps.setString(7, pSecretario.getArea().getNombreArea());
      ps.setInt(8, pSecretario.getCentro().getId());
      ps.execute();
      return true;
      
    } catch (SQLException ex) {
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
