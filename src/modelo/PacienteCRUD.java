package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class PacienteCRUD extends Conexion{
  
  public PacienteCRUD(){}
  
  public static ArrayList<Paciente> LISTAPACIENTES = new  ArrayList<Paciente> ();

    public static ArrayList<Paciente> getLISTAPACIENTES() {
        return LISTAPACIENTES;
    }


  public ArrayList consultarPacientes(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Paciente> pacientes = new ArrayList<>();
    
    String sql = "SELECT * FROM paciente";
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while (rs.next()){
          
        Paciente contenedor = new Paciente();
        contenedor.setCedula(rs.getString("cedula_paciente"));
        contenedor.setNombre(rs.getString("nombre"));
        
        
        System.out.println("este es el id del contenedor pa: " + contenedor.getCedula() );
        System.out.println("este es el nombre del contenedor pa: " + contenedor.getNombre());
        pacientes.add(contenedor);
        
        LISTAPACIENTES.add(contenedor);
        
      }
      return pacientes;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return pacientes;
      
    } finally {
      try {
        con.close();
      } catch (SQLException ex) {
        System.err.println(ex);
      }
    }
  }
}
