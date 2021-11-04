package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Gustavo
 */
public class EnfermeroCRUD extends Conexion{
  
  public EnfermeroCRUD(){}
  
  public boolean registrarEnfermero(Enfermero pEnfermero){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_enfermero(?,?,?,?,?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pEnfermero.getCedula());
      ps.setString(2, pEnfermero.getPassword());
      ps.setString(3, pEnfermero.getNombre());
      ps.setString(4, pEnfermero.getTipoFuncionario());
      ps.setDate(5, Date.valueOf(pEnfermero.getFechaIngreso()));
      ps.setString(6, pEnfermero.getArea().getNombreArea());
      ps.setInt(7, pEnfermero.getCentro().getId());
      ps.setBoolean(8, pEnfermero.isPersonalCargo());
      ps.setBoolean(9, pEnfermero.isExperienciaCapacitaciones());
      ps.execute();
      return true;
      
    } catch (SQLException ex){
      System.out.println(ex.getMessage());
      return false;
    } finally {
      try{
        con.close();
      } catch (SQLException ex){
        System.out.println(ex.getMessage());
      }
    }
  }
}
