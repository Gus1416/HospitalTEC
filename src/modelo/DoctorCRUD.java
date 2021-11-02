package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Gustavo
 */
public class DoctorCRUD extends Conexion{
  
  public DoctorCRUD(){}
  
  public boolean registrarDoctor(Doctor pDoctor){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_doctor(?,?,?,?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pDoctor.getCedula());
      ps.setString(2, pDoctor.getPassword());
      ps.setString(3, pDoctor.getNombre());
      ps.setString(4, pDoctor.getTipoFuncionario());
      ps.setDate(5, Date.valueOf(pDoctor.getFechaIngreso()));
      ps.setString(6, pDoctor.getArea().getNombreArea());
      ps.setInt(7, pDoctor.getCentro().getId());
      ps.setInt(8, pDoctor.getCodigoMedico());
      ps.execute();
      return true;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return false;
    } finally {
      try{
        con.close();
      } catch (SQLException ex) {
        System.err.println(ex);
      }
    }
  }
}
