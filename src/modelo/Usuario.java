package modelo;

/**
 *
 * @author Gustavo
 */
public class Usuario {
  private String cedula;
  private String password;
  private String tipoUsuario;
  
  public Usuario(){}
  
  public Usuario(String pCedula, String pPassword){
    this.cedula = pCedula;
    this.password = pPassword;
  }
  
  public Usuario (String pCedula, String pPassword, String pTipoUsuario){
    this.cedula = pCedula;
    this.password = pPassword;
    this.tipoUsuario = pTipoUsuario;
  }

  /**
   * @return the cedula
   */
  public String getCedula() {
    return cedula;
  }

  /**
   * @param pCedula the cedula to set
   */
  public void setCedula(String pCedula) {
    this.cedula = pCedula;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param pPassword the password to set
   */
  public void setPassword(String pPassword) {
    this.password = pPassword;
  } 

  /**
   * @return the tipoUsuario
   */
  public String getTipoUsuario() {
    return tipoUsuario;
  }

  /**
   * @param tipoUsuario the tipoUsuario to set
   */
  public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }
}
