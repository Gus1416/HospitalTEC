package modelo;

import java.time.LocalDate;

/**
 * Clase heredada que contiene la información de los doctores.
 * 
 * @author Sebastián
 * @version 15/11/2021
 */
public class Doctor extends Funcionario {
  private int codigoMedico;
  private ArrayList especialidades;
  
  /**
   * Constructor por defecto.
   */
  public Doctor(){}

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
   * @param pCodigoMedico el código de médico que identifica al doctor
   * @param pEspecialidades  la especialidad que ejerce el doctor
   */
  public Doctor(String pCedula, String pPassword, String pTipoUsuario, String pNombre, String pTipoFuncionario, 
          LocalDate pFechaIngreso, Area pArea, CentroAtencion pCentro, int pCodigoMedico, 
          ArrayList<String> pEspecialidades ) {
    super (pCedula, pPassword, pTipoUsuario, pNombre, pTipoFuncionario, pFechaIngreso, pArea, pCentro);
    this.codigoMedico = pCodigoMedico;
    this.especialidades = pEspecialidades;
  }

  //Métodos accesores
  
  public int getCodigoMedico() {
    return codigoMedico;
  }

  public void setCodigoMedico(int codigoMedico) {
    this.codigoMedico = codigoMedico;
  }

  public ArrayList getEspecialidades() {
    return especialidades;
  }

  public void setEspecialidades(ArrayList<String> especialidades) {
    this.especialidades = especialidades;
  }
}
