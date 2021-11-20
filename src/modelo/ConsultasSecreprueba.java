
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
/**
 *
 * @author Maria Laura
 */
public class ConsultasSecreprueba extends Conexion{
    
    public ArrayList<Object[]> Citas() throws SQLException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Citas();";
     
        try{
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();  
            int cantidadColumnas = rsMd.getColumnCount();
             while (rs.next()){
                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++){
                  filas[i] = rs.getObject(i + 1);
                }
                objFilas.add(filas);
                }
             return objFilas;
             } catch (SQLException ex){
                System.err.println(ex);
                return objFilas;
    }
  }
}