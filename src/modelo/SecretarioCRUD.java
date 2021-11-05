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
    
    String sql = "CALL registrar_secretario(?,?,?,?,?,?,?)";
    
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, pSecretario.getCedula());
      ps.setString(2, pSecretario.getPassword());
      ps.setString(3, pSecretario.getNombre());
      ps.setString(4, pSecretario.getTipoFuncionario());
      ps.setDate(5, Date.valueOf(pSecretario.getFechaIngreso()));
      ps.setString(6, pSecretario.getArea().getNombreArea());
      ps.setInt(7, pSecretario.getCentro().getId());
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
