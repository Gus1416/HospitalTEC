package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class DiagnosticoCRUD extends Conexion{
  
  public DiagnosticoCRUD(){}
  
  public ArrayList<Diagnostico> consultarDiagnosticos(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Diagnostico> diagnosticos = new ArrayList();
    
    String sql = "select * from catalogo_diagnosticos";
    
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while (rs.next()){
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setId(rs.getInt("id_diagnostico"));
        diagnostico.setNombre(rs.getString("nombre"));
        diagnosticos.add(diagnostico);
      }
      
      return diagnosticos;
      
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

