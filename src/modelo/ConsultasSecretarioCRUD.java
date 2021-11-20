
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
public class ConsultasSecretarioCRUD  extends Conexion{
    
    public ArrayList<Object[]> Citas(){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Citas();";
         try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
     

    } finally{
      try {
        con.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
        return objFilas;
    }


 public ArrayList<Object[]> CitasEstado(String pEstado){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Cita_Estado(?);";
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pEstado);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
      return objFilas;
     
    }
       
    }
 
  public ArrayList<Object[]> CitasFechas(String pFecha1, String pFecha2){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Citas_Fechas(?,?);";
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pFecha1);
            ps.setString(2, pFecha2);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
      return objFilas;
     
    }
       
    }
   public ArrayList<Object[]> CitasPaciente(String pCedula){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Citas_Paciente(?);";
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pCedula);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
      return objFilas;
     
    }
}
   public ArrayList<Object[]> CitasEspecialidad(String pEspecialidad){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Cita_Especialidad(?);";
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pEspecialidad);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
      return objFilas;
     
    }
}
   /////Hospitalizaciones
      public ArrayList<Object[]> Hospitalizaciones(){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Hospitalizaciones_Registradas();";
         try {
            ps = con.prepareStatement(sql);
           
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
      return objFilas;
     
    }
}
      
        public ArrayList<Object[]> hospitalizacionFechas(String pFecha1, String pFecha2){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Hospitalizaciones_Fechas(?,?);";
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pFecha1);
            ps.setString(2, pFecha2);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
      return objFilas;
     
    }
       
    }
    public ArrayList<Object[]> hospitalizacionEspecialidad(String pEspecialidad){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Hospitalizacion_Especialidad(?);";
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pEspecialidad);
     
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
      return objFilas;
     
    }
       
    }
    public ArrayList<Object[]> hospitalizacionPaciente(String pPaciente){
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexion();
        ArrayList<Object[]> objFilas = new ArrayList<>();
        
        String sql = "call db_hospitaltec.Hospitalizacion_Paciente(?);";
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pPaciente);
     
            rs = ps.executeQuery();
            ResultSetMetaData rsMd= rs.getMetaData();
            int cantidadColumnas= rsMd.getColumnCount();
            
         
          while (rs.next()){
            Object[] filas= new Object [cantidadColumnas];
            for (int i= 0; i< cantidadColumnas;i++){
                filas[i]=rs.getObject(i+1);
            }
            objFilas.add(filas);
          }
      return objFilas;
         } catch (SQLException e) {
      System.err.println(e);
      return objFilas;
     
    }
       
    }    
}   


