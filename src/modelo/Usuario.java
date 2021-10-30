package modelo;

/**
 *
 * @author Gustavo
 */
public class Usuario {
  private String cedula;
  private String password;
  
  public Usuario(){}
  
  public Usuario (String pCedula, String pPassword){
    this.cedula = pCedula;
    this.password = pPassword;
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
  
  
}
