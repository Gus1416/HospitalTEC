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
import java.time.ZoneId;


/**
 *
 * @author sebcor
 */
public class CitasCRUD extends Conexion {
    

    public boolean registrarCita(Citas cita , int codigoMed){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
        String sql = "CALL registrar_cita(?,?,?,?,?)";
        try{
          ps = con.prepareStatement(sql);
          ps.setInt(1,cita.getiDArea());
          ps.setDate(2,java.sql.Date.valueOf(cita.getFechaCita()));
          ps.setString(3,cita.getObservacionAdicional());
          ps.setString(4,cita.getEstado().toString());
          ps.setString(5,cita.getCedulaPaciente());
          ps.setInt(6, codigoMed);
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
    
    public boolean CancelarCita(Citas cita){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
        String sql = "CALL cancelar_cita(?)";
        try{
          ps = con.prepareStatement(sql);
          ps.setInt(1,cita.getiDCita());
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
    
    
    
    
    
    

    
    public ArrayList consultarCitas(String cedula){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Citas> citas = new ArrayList<>();
    
    String sql = "SELECT * FROM cita WHERE cedula_paciente=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, cedula);
      rs = ps.executeQuery();
      
      
      while (rs.next()){
          
        Citas contenedor = new Citas(rs.getInt("id_cita"));  
          
          
        Citas cita = new Citas();
        cita.setiDCita(rs.getInt("id_cita"));
        cita.setCedulaPaciente(rs.getString("cedula_paciente"));
        cita.setAuxdate(rs.getDate("fecha_hora"));
        
        System.out.println("Esta es la cita que me llega mae:  "  + cita.getAuxdate());
        
        
        citas.add(cita);
          System.out.println("");
        
      }
      return citas;
      
    } catch (SQLException ex){
      System.err.println(ex);
      return citas;
      
    } finally {
      try {
        con.close();
      } catch (SQLException ex) {
        System.err.println(ex);
      }
    }
  }
}






    

