package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author sebcor
 */
public class CitasCRUD extends Conexion {

  public boolean registrarCita(Citas cita) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "CALL registrar_cita(?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, cita.getiDArea());
      ps.setDate(2, java.sql.Date.valueOf(cita.getFechaCita()));
      ps.setString(3, cita.getObservacionAdicional());
      ps.setString(4, cita.getEstado().toString());
      ps.setString(5, cita.getCedulaPaciente());
      //ps.setInt(6, codigoMed);
      ps.execute();
      return true;

    } catch (SQLException e){
      System.err.println(e);
      return false;

    } finally{
      try{
        con.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }

  public boolean CancelarCita(Citas cita) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "CALL cancelar_cita(?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, cita.getiDCita());
      ps.setString(2, cita.getEstado().toString());
      ps.execute();
      return true;

    } catch (SQLException e){
      System.err.println(e);
      return false;

    } finally{
      try {
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }

  public ArrayList consultarCitas(String cedula) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Citas> citas = new ArrayList<>();

    String sql = "SELECT * FROM cita WHERE cedula_paciente=?";
    try
    {
      ps = con.prepareStatement(sql);
      ps.setString(1, cedula);
      rs = ps.executeQuery();

      while (rs.next())
      {

        Citas contenedor = new Citas(rs.getInt("id_cita"));

        Citas cita = new Citas();
        cita.setiDCita(rs.getInt("id_cita"));
        cita.setCedulaPaciente(rs.getString("cedula_paciente"));
        cita.setAuxdate(rs.getDate("fecha_hora"));

        System.out.println("Esta es la cita que me llega mae:  " + cita.getAuxdate());

        citas.add(cita);
        System.out.println("");

      }
      return citas;

    } catch (SQLException ex)
    {
      System.err.println(ex);
      return citas;

    } finally
    {
      try
      {
        con.close();
      } catch (SQLException ex)
      {
        System.err.println(ex);
      }
    }
  }
  
  public ArrayList<Object[]> consultarBitacoraCitas(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "SELECT * FROM bitacora_citas";
    
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
  
  public ArrayList<Object[]> consultarCitasRegistradas(String pCedulaPaciente){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "SELECT * FROM cita WHERE cedula_paciente = ? AND estado_actual = 'REGISTRADA'";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaPaciente);
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
  
  public Citas buscarCita(int pIdCita){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    
    String sql = "SELECT * FROM cita WHERE id_cita = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, pIdCita);
      rs = ps.executeQuery();
      
      if (rs.next()){
        Citas cita = new Citas();
        cita.setiDCita(rs.getInt("id_cita"));
        cita.setiDArea(rs.getInt("id_area"));
        cita.setFechaCita(rs.getDate("fecha_hora").toLocalDate());
        cita.setObservacionAdicional(rs.getString("observacion"));
        cita.setCedulaPaciente(rs.getString("cedula_paciente"));
        return cita;
      } else {
        return null;
      }
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
      
     } finally {
      try{
        con.close();
      } catch (SQLException ex){
        System.err.println(ex);
      }
    }
  }
}



