package modelo;

/**
 * Clase que contiene la información de los usuarios.
 * 
 * @author Gustavo
 * @version 15/11/2021
 */
public class Usuario {
  private String cedula;
  private String password;
  private String tipoUsuario;
  
  /**
   * Constructor por defecto
   */
  public Usuario(){}
  
  /**
   * Constructor con parámetros.
   * 
   * @param pCedula la cédula del usuario
   * @param pPassword  la contraseña del usuario
   */
  public Usuario(String pCedula, String pPassword){
    this.cedula = pCedula;
    this.password = pPassword;
  }
  
  /**
   * Constructor de la clase.
   * 
   * 
   * @param pCedula la cédula del usuario
   * @param pPassword la contraseña del usuario
   * @param pTipoUsuario  el tipo de usuario
   */
  public Usuario (String pCedula, String pPassword, String pTipoUsuario){
    this.cedula = pCedula;
    this.password = pPassword;
    this.tipoUsuario = pTipoUsuario;
  }

  //Métodos accesores
  
  public String getCedula() {
    return cedula;
  }

  public void setCedula(String pCedula) {
    this.cedula = pCedula;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String pPassword) {
    this.password = pPassword;
  } 

  public String getTipoUsuario() {
    return tipoUsuario;
  }

  public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }
}
