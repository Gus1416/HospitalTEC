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
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.sql.Date;

/**
 *
 * @author sebcor
 */
public class TratamientoCRUD extends Conexion{
    
    
    public ArrayList consultarTratamientos(String Nombre){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Tratamiento> tratamientos = new ArrayList<>();
    
    String sql = """
                 SELECT db_hospitaltec.catalogo_diagnosticos.id_diagnostico,db_hospitaltec.catalogo_diagnosticos.nombre,
                 db_hospitaltec.catalogo_tratamientos.id_tratamiento,db_hospitaltec.catalogo_tratamientos.nombreT,
                 db_hospitaltec.catalogo_tratamientos.cantidad_dosis, db_hospitaltec.catalogo_tratamientos.tipo
                 FROM db_hospitaltec.catalogo_diagnosticos,db_hospitaltec.diagnostico_tratamiento,db_hospitaltec.catalogo_tratamientos
                 WHERE db_hospitaltec.catalogo_diagnosticos.id_diagnostico=db_hospitaltec.diagnostico_tratamiento.id_diagnostico AND db_hospitaltec.catalogo_tratamientos.id_tratamiento
                 = db_hospitaltec.diagnostico_tratamiento.id_tratamiento AND
                 db_hospitaltec.catalogo_diagnosticos.nombre= ?""";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1,Nombre);
      rs = ps.executeQuery();
      
      
      while (rs.next()){
          
        //Citas contenedor = new Citas(rs.getInt("id_cita"));  
          
          
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setNombre(rs.getString("nombreT"));
        tratamiento.setId(rs.getInt("id_tratamiento"));
        
        System.out.println("Esta es la cita que me llega mae:  "  + tratamiento.getNombre());
        
        
        tratamientos.add(tratamiento);
         System.out.println("");
        
      }
      return tratamientos;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return tratamientos;
      
    } finally {
      try {
        con.close();
      } catch (SQLException ex) {
        System.err.println(ex);
      }
    }
  }
    
    
  public boolean registrarAtencion(String Paciente,int Cita, String Diagnostico, String Nivel,String Observaciones
          , String Tratamiento,int Dosis, String TipoTratamiento){
      
      
    PreparedStatement ps = null;
    Connection con = getConexion();
    
        LocalDate now= LocalDate.now();
        Date pdate = Date.valueOf(now);
    
        String sql = "CALL registrar_atencion(?,?,?,?,?,?,?,?,?)";
        try{
          ps = con.prepareStatement(sql);
          ps.setString(1,Paciente);
          ps.setInt(2,Cita);
          ps.setString(3, Diagnostico);
          ps.setString(4,Nivel);
          ps.setString(5,Observaciones);
          ps.setString(6,Tratamiento);
          ps.setInt(7, Dosis);
          ps.setString(8, TipoTratamiento);
          ps.setDate(9, pdate);
          ps.execute();
          return true;

        } catch (SQLException e){
          System.err.println(e);
          return false;

        } finally {
          try {
            con.close();
          } catch (SQLException e){
            System.err.println(e);
          }
        }
    }  
    
    
    
    
    
    
    
    
    
    
    
}
