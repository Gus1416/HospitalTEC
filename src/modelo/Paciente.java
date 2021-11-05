package modelo;

import java.time.LocalDate;

/**
 *
 * @author Maria Laura
 */
public class Paciente extends Usuario {
  private String nombre;
  private LocalDate fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String lugarResidencia;
  private ArrayList<String> telefonos;

  public Paciente(String pCedula, String pPassword, String pNombre, LocalDate pFechaNacimiento, String pTipoSangre,
          String pNacionalidad, String pLugarResidencia, ArrayList<String> pTelefonos) {
    super(pCedula, pPassword);
    this.nombre = pNombre;
    this.fechaNacimiento = pFechaNacimiento;
    this.tipoSangre = pTipoSangre;
    this.nacionalidad = pNacionalidad;
    this.lugarResidencia = pLugarResidencia;
    this.telefonos = pTelefonos;
  }

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
