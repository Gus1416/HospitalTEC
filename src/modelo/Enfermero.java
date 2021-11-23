package modelo;

import java.time.LocalDate;

/**
 * Clase heredada que contiene la información de los enfermeros.
 * 
 * @author Maria Laura
 * @version 15/11/2021
 */
public class Enfermero extends Funcionario {
  private boolean personalCargo;
  private boolean experienciaCapacitaciones;

  /**
   * Constructor por defecto.
   */
  public Enfermero(){}
  
  /**
   * Constructor con parámetros.
   * 
   * @param pCedula la cédula del enfermero
   * @param pPassword la contraseña del usuario
   * @param pTipoUsuario el tipo de usuario
   * @param pNombre el nombre del enfermero
   * @param pTipoFuncionario el tipo de funcionario
   * @param pFechaIngreso la fecha en que se registra en el sistema
   * @param pArea el área al que pertenece el funcionario
   * @param pCentro el centro de atención en el que labora
   * @param pPersonasACargo indicador de si ha tenido personas a cargo
   * @param pExpCapacitaciones indicador de si ha realizado capacitaciones
   */
  public Enfermero(String pCedula, String pPassword, String pTipoUsuario, String pNombre, String pTipoFuncionario, 
          LocalDate pFechaIngreso, Area pArea, CentroAtencion pCentro, boolean pPersonasACargo, 
          boolean pExpCapacitaciones) {
    super (pCedula, pPassword, pTipoUsuario, pNombre, pTipoFuncionario, pFechaIngreso, pArea, pCentro);
    this.personalCargo = pPersonasACargo;
    this.experienciaCapacitaciones = pExpCapacitaciones;
  }

  //Métodos accesores
  
  public boolean isPersonalCargo() {
    return personalCargo;
  }

  public void setPersonalCargo(boolean personalCargo) {
    this.personalCargo = personalCargo;
  }

  public boolean isExperienciaCapacitaciones() {
    return experienciaCapacitaciones;
  }

  public void setExperienciaCapacitaciones(boolean experienciaCapacitaciones) {
    this.experienciaCapacitaciones = experienciaCapacitaciones;
  }
}

