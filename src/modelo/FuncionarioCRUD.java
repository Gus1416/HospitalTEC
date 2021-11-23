package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Clase que contiene las operaciones CRUD de los funcionarios.
 * 
 * @author Gustavo
 * @version 15/11/2021
 */
public class FuncionarioCRUD extends Conexion{
  
  /**
   * Constructor por defecto.
   */
  public FuncionarioCRUD(){}
  
  /**
   * Busca un funcionario según la cédula.
   * 
   * @param pCedulaFuncionario la cédula del funcionario
   * @return un objeto de tipo Funcionario
   */
  public Funcionario buscarFuncionario(String pCedulaFuncionario){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Funcionario funcionario = new Funcionario();
    
    String sql = "CALL buscar_funcionario(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCedulaFuncionario);
      rs = ps.executeQuery();
      
      while (rs.next()){
        funcionario.setCedula(pCedulaFuncionario);
        funcionario.setNombre(rs.getString("nombre"));
        funcionario.setTipoFuncionario(rs.getString("tipo_funcionario"));
        funcionario.setFechaIngreso(rs.getDate("fecha_ingreso").toLocalDate());
        funcionario.setArea(new AreaCRUD().buscarArea(rs.getInt("id_area")));
        funcionario.setCentro(new CentroAtencionCRUD().buscarCentro(rs.getInt("codigo_centro")));
      }
      return funcionario;
      
    } catch (SQLException ex){
      System.err.println(ex.getMessage());
      return null;
    }
  }
}
