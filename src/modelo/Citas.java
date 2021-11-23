package modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 * Clase que contiene la información de las citas.
 * 
 * @author Sebastián
 * @version 05/11/2021
 */
public class Citas {
  private int iDCita;
  private int iDArea;
  private String especialidad;
  private LocalDate fechaCita;
  private String observacionAdicional;
  private EstadoCita Estado;
  private String cedulaPaciente;
  private Date auxdate;

  /**
   * Constructor por defecto
   */
  public Citas() {
  }

  /**
   * Constructor con parámetros.
   *
   * @param iDCita identificador de la cita
   * @param iDArea identificador del area
   * @param especialidad especialidad de la cita
   * @param fechaCita fecha en la que se programó la cita.
   * @param observacionAdicional una observación realizada por el paciente
   * @param Estado el estado en el que se encuentra la cita
   * @param cedulaPaciente la cedula del paciente
   */
  public Citas(int iDCita, int iDArea, String especialidad, LocalDate fechaCita, String observacionAdicional,
          EstadoCita Estado, String cedulaPaciente) {
    this.iDCita = iDCita;
    this.iDArea = iDArea;
    this.especialidad = especialidad;
    this.fechaCita = fechaCita;
    this.observacionAdicional = observacionAdicional;
    this.Estado = Estado;
    this.cedulaPaciente = cedulaPaciente;
  }
  
  //Métodos accesores

  public Citas(int iDCita) {
    this.iDCita = iDCita;
  }

  public Date getAuxdate() {
    return auxdate;
  }

  public void setAuxdate(Date auxdate) {
    this.auxdate = auxdate;
  }

  public String getCedulaPaciente() {
    return cedulaPaciente;
  }

  public void setCedulaPaciente(String cedulaPaciente) {
    this.cedulaPaciente = cedulaPaciente;
  }

  public int getiDArea() {
    return iDArea;
  }

  public void setiDArea(int iDArea) {
    this.iDArea = iDArea;
  }

  public int getiDCita() {
    return iDCita;
  }

  public void setiDCita(int iDCita) {
    this.iDCita = iDCita;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public LocalDate getFechaCita() {
    return fechaCita;
  }

  public void setFechaCita(LocalDate fechaCita) {
    this.fechaCita = fechaCita;
  }

  public String getObservacionAdicional() {
    return observacionAdicional;
  }

  public void setObservacionAdicional(String observacionAdicional) {
    this.observacionAdicional = observacionAdicional;
  }

  public EstadoCita getEstado() {
    return Estado;
  }

  public void setEstado(EstadoCita Estado) {
    this.Estado = Estado;
  }
}
