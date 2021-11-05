package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class PacienteCRUD extends Conexion{
  public PacienteCRUD(){}
  
  public boolean registrarPaciente(Paciente pPaciente){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_paciente(?,?,?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pPaciente.getCedula());
      ps.setString(2, pPaciente.getPassword());
      ps.setString(3, pPaciente.getNombre());
      ps.setDate(4, Date.valueOf(pPaciente.getFechaNacimiento()));
      ps.setString(5, pPaciente.getTipoSangre());
      ps.setString(6, pPaciente.getNacionalidad());
      ps.setString(7, pPaciente.getLugarResidencia());
      ps.execute();
      return true;
      
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
  
  public boolean registrarTelefonos(Paciente pPaciente){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "INSERT INTO paciente_telefonos (cedula_paciente, telefono) VALUES " 
            + completarQuery(pPaciente); 
    
    try{
      ps = con.prepareStatement(sql);
      ps.execute();
      return true;
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
  
  private String completarQuery(Paciente pPaciente) {
    String query = "";
    for (int i = 0; i < pPaciente.getTelefonos().size(); i++){
      query += "(" + pPaciente.getCedula() + ", '" + pPaciente.getTelefonos().get(i) + "')";
      if (i == pPaciente.getTelefonos().size() - 1){
        query += ";";
      } else {
        query += ",";
      }
    }
    return query;
  }
}
