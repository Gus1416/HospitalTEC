package modelo;

import java.util.Date;

/**
 * Clase que contiene la información de las hospitalizaciones.
 * 
 * @author Sebastián
 * @version 22/11/2021
 */
public class HospitalizacionP {
  private String CentroAtencion;
  private String Identificacion;
  private String NombrePaciente;
  private String Diagnostico;
  private String Servicio;
  private String Funcionario;
  private Date FechaInicio;
  private Date FechaFinal;

  /**
   * Constructor de la clase.
   * 
   * @param CentroAtencion el nombre del centro de atención
   * @param Identificacion el identificador del internado
   * @param NombrePaciente el nombre del paciente
   * @param Diagnostico el nombre del diagnósticos
   * @param Servicio el servicio de la hospitalización
   * @param Funcionario el ombre dle funcionario
   * @param FechaInicio la fecha de inicio de la hospitalización
   * @param FechaFinal  la fecha de fin de la hospitalización
   */
  public HospitalizacionP(String CentroAtencion, String Identificacion, String NombrePaciente, String Diagnostico, String Servicio, String Funcionario, Date FechaInicio, Date FechaFinal) {
    this.CentroAtencion = CentroAtencion;
    this.Identificacion = Identificacion;
    this.NombrePaciente = NombrePaciente;
    this.Diagnostico = Diagnostico;
    this.Servicio = Servicio;
    this.Funcionario = Funcionario;
    this.FechaInicio = FechaInicio;
    this.FechaFinal = FechaFinal;
  }

  //Métodos accesores
  
  public String getCentroAtencion() {
    return CentroAtencion;
  }

  public void setCentroAtencion(String CentroAtencion) {
    this.CentroAtencion = CentroAtencion;
  }

  public String getIdentificacion() {
    return Identificacion;
  }

  public void setIdentificacion(String Identificacion) {
    this.Identificacion = Identificacion;
  }

  public String getNombrePaciente() {
    return NombrePaciente;
  }

  public void setNombrePaciente(String NombrePaciente) {
    this.NombrePaciente = NombrePaciente;
  }

  public String getDiagnostico() {
    return Diagnostico;
  }

  public void setDiagnostico(String Diagnostico) {
    this.Diagnostico = Diagnostico;
  }

  public String getServicio() {
    return Servicio;
  }

  public void setServicio(String Servicio) {
    this.Servicio = Servicio;
  }

  public String getFuncionario() {
    return Funcionario;
  }

  public void setFuncionario(String Funcionario) {
    this.Funcionario = Funcionario;
  }

  public Date getFechaInicio() {
    return FechaInicio;
  }

  public void setFechaInicio(Date FechaInicio) {
    this.FechaInicio = FechaInicio;
  }

  public Date getFechaFinal() {
    return FechaFinal;
  }

  public void setFechaFinal(Date FechaFinal) {
    this.FechaFinal = FechaFinal;
  }
}
