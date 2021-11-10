/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author sebcor
 */

public class DiagnosticoCRUD extends Conexion{
    
    
    
    public ArrayList consultarDiagnostico(){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        ArrayList<Diagnostico> diagnostico = new ArrayList<>();

        String sql = "SELECT * FROM catalogo_diagnosticos";
        try{
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();


          while (rs.next()){

          //  Area contenedor = new Area(rs.getString("nombre"),rs.getInt("id_area"));  

            Diagnostico diagno = new Diagnostico();
            diagno.setNombre(rs.getString("nombre"));
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
