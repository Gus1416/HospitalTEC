package modelo;

import java.time.LocalDate;

/**
 * Clase que contiene la información de los pacientes
 * 
 * @author Maria Laura
 * @version 15/11/2021
 */
public class Paciente extends Usuario {
  private String nombre;
  private LocalDate fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String lugarResidencia;
  private ArrayList<String> telefonos;

  /**
   * Constructor por defecto.
   */
  public Paciente(){}
  
  /**
   * Constructor con parámetros.
   * 
   * @param pCedula la cédula del paciente
   * @param pPassword la contraseña del usuario
   * @param pTipoUsuario el tipo de usuario
   * @param pNombre el nombre del paciente
   * @param pFechaNacimiento fecha de nacimiento
   * @param pTipoSangre tipo de sangre del paciente
   * @param pNacionalidad nacionalidad
   * @param pLugarResidencia dirección del paciente
   * @param pTelefonos lista de teléfonos
   */
  public Paciente(String pCedula, String pPassword, String pTipoUsuario, String pNombre, LocalDate pFechaNacimiento, String pTipoSangre,
          String pNacionalidad, String pLugarResidencia, ArrayList<String> pTelefonos) {
    super(pCedula, pPassword, pTipoUsuario);
    this.nombre = pNombre;
    this.fechaNacimiento = pFechaNacimiento;
    this.tipoSangre = pTipoSangre;
    this.nacionalidad = pNacionalidad;
    this.lugarResidencia = pLugarResidencia;
    this.telefonos = pTelefonos;
  }

  //Métodos accesores
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getTipoSangre() {
    return tipoSangre;
  }

  public void setTipoSangre(String tipoSangre) {
    this.tipoSangre = tipoSangre;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public String getLugarResidencia() {
    return lugarResidencia;
  }

  public void setLugarResidencia(String lugarResidencia) {
    this.lugarResidencia = lugarResidencia;
  }

  public ArrayList getTelefonos() {
    return telefonos;
  }

  public void setTelefonos(ArrayList<String> telefonos) {
    this.telefonos = telefonos;
  }
}
