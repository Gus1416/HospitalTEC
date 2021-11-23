package modelo;

import java.time.LocalDate;

/**
 * Clase heredada que contiene la información del funcionario.
 * 
 * @author Sebastián
 * @version 15/11/2021
 */
public class Funcionario extends Usuario {
  private String nombre;
  private String tipoFuncionario;
  private LocalDate fechaIngreso;
  private Area area;
  private CentroAtencion centro;
  
  /**
   * Constructor por defecto
   */
  public Funcionario(){}

  /**
   * Constructor con parámetros.
   * 
   * @param pCedula la cédula del doctor
   * @param pPassword la contraseña del usuario
   * @param pTipoUsuario el tipo de usuario
   * @param pNombre el nombre del doctor
   * @param pTipoFuncionario el tipo de funcionario
   * @param pFechaIngreso la fecha en que se registra en el sistema
   * @param pArea el área al que pertenece el funcionario
   * @param pCentro el centro de atención en el que labora
   */
  public Funcionario(String pCedula, String pPassword, String pTipoUsuario, String pNombre, String pTipoFuncionario, 
          LocalDate pFechaIngreso, Area pArea, CentroAtencion pCentro) {
    super(pCedula, pPassword, pTipoUsuario);
    this.nombre = pNombre;
    this.tipoFuncionario = pTipoFuncionario;
    this.fechaIngreso = pFechaIngreso;
    this.area = pArea;
    this.centro = pCentro;
  }

  //Métodos accesores
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String Nombre) {
    this.nombre = Nombre;
  }

  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }
  
  public void setFechaIngreso(LocalDate FechaIngreso) {
    this.fechaIngreso = FechaIngreso;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public CentroAtencion getCentro() {
    return centro;
  }

  public void setCentro(CentroAtencion centro) {
    this.centro = centro;
  }

  public String getTipoFuncionario() {
    return tipoFuncionario;
  }

  public void setTipoFuncionario(String tipoFuncionario) {
    this.tipoFuncionario = tipoFuncionario;
  }
}

