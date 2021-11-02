package modelo;

import java.time.LocalDate;

/**
 *
 * @author Maria Laura
 */
public class Enfermero extends Funcionario {
  private boolean personalCargo;
  private boolean experienciaCapacitaciones;

  public Enfermero(){}
  
  public Enfermero(String pCedula, String pPassword, String pNombre, String pTipoFuncionario, 
          LocalDate pFechaIngreso, Area pArea, CentroAtencion pCentro, boolean pPersonasACargo, 
          boolean pExpCapacitaciones) {
    super (pCedula, pPassword, pNombre, pTipoFuncionario, pFechaIngreso, pArea, pCentro);
    this.personalCargo = pPersonasACargo;
    this.experienciaCapacitaciones = pExpCapacitaciones;
  }

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

