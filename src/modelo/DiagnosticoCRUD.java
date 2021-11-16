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

    
    
    
    
    
    
    public ArrayList consultarDiagnosticoPaciente(String Ced){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Diagnostico> diagnostico = new ArrayList<>();

        String sql = "SELECT * FROM cita_atencion WHERE cedula_paciente=?";
        try{
          ps = con.prepareStatement(sql);
          ps.setString(1, Ced);
          rs = ps.executeQuery();


          while (rs.next()){

          //  Area contenedor = new Area(rs.getString("nombre"),rs.getInt("id_area"));  

            Diagnostico diagno = new Diagnostico();
            diagno.setNombre(rs.getString("nombreDiag"));
            diagno.setId(rs.getInt("id_diagnostico"));
            diagnostico.add(diagno);

            System.out.println("Estos son los nombres de los diagnosticos que de la lista" + diagno.getNombre());

            //LISTAAREAS.add(contenedor);

          }
          return diagnostico;

        } catch (SQLException ex){
          System.err.println(ex);
          return diagnostico;

        } finally {
          try {
            con.close();
          } catch (SQLException ex) {
            System.err.println(ex);
          }
        }
  }
    
 
}

