package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

/**
 * 
 * @author Gustavo
 */
public class EnfermeroCRUD extends Conexion{
  
  public EnfermeroCRUD(){}
  
  public boolean registrarEnfermero(Enfermero pEnfermero){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_enfermero(?,?,?,?,?,?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pEnfermero.getCedula());
      ps.setString(2, pEnfermero.getPassword());
      ps.setString(3, pEnfermero.getTipoUsuario());
      ps.setString(4, pEnfermero.getNombre());
      ps.setString(5, pEnfermero.getTipoFuncionario());
      ps.setDate(6, Date.valueOf(pEnfermero.getFechaIngreso()));
      ps.setString(7, pEnfermero.getArea().getNombreArea());
      ps.setInt(8, pEnfermero.getCentro().getId());
      ps.setBoolean(9, pEnfermero.isPersonalCargo());
      ps.setBoolean(10, pEnfermero.isExperienciaCapacitaciones());
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
  
   public Doctor buscarEnfermero(String pCedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Doctor enfermero = new Doctor();
    
    String sql = "SELECT * FROM enfermero INNER JOIN funcionario INNER JOIN funcionario_centro_atencion "
            + "WHERE tipo_funcionario = 'Enfermero' and funcionario.cedula_funcionario = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedula);
      rs = ps.executeQuery();
      
      if (rs.next()){
         enfermero.setCedula(pCedula);
         enfermero.setNombre(rs.getString("nombre"));
         enfermero.setTipoFuncionario(rs.getString("tipo_funcionario"));
         enfermero.setFechaIngreso(rs.getDate("fecha_ingreso").toLocalDate());
         enfermero.setArea(new AreaCRUD().buscarArea(rs.getInt("id_area")));
         enfermero.setCentro(new CentroAtencionCRUD().buscarCentro(rs.getInt("codigo_centro")));
        return enfermero;
      } else {
        return null;
      }
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    } finally{
      try{
        con.close();
      } catch (SQLException ex){
        System.err.println(ex.getMessage());
      }
    }
  }
   
   public boolean AplicarVacuna(String ced, Date fechaApl, String Nombre , String Farmaceutica, int NumeroLote){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_vacuna(?,?,?,?,?)";
        
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, ced);
      ps.setDate(2, fechaApl);
      ps.setString(3, Nombre);
      ps.setString(4, Farmaceutica);
      ps.setInt(5, NumeroLote);
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
