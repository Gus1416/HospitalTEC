package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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
  
    public Secretario buscarSecretario(String pCedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Secretario secretario = new Secretario();
    
    String sql = "CALL buscar_secretario(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedula);
      rs = ps.executeQuery();
      
      if (rs.next()){
        secretario.setCedula(pCedula);
        secretario.setNombre(rs.getString("nombre"));
        secretario.setFechaIngreso(rs.getDate("fecha_ingreso").toLocalDate());
        secretario.setArea(new AreaCRUD().buscarArea(rs.getInt("id_area")));
        secretario.setCentro(new CentroAtencionCRUD().buscarCentro(rs.getInt("codigo_centro")));
        return secretario;
      } else {
        return null;
      }
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    } finally {
      try {
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
}
