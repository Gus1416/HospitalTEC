package modelo;

import java.time.LocalDate;

/**
 *
 * @author sebcor
 */
public class Doctor extends Funcionario {

  private int codigoMedico;
  private ArrayList especialidades;
  
  public Doctor(){}

  public Doctor(String pCedula, String pPassword, String pTipoUsuario, String pNombre, String pTipoFuncionario, 
          LocalDate pFechaIngreso, Area pArea, CentroAtencion pCentro, int pCodigoMedico, 
          ArrayList<String> pEspecialidades ) {
    super (pCedula, pPassword, pTipoUsuario, pNombre, pTipoFuncionario, pFechaIngreso, pArea, pCentro);
    this.codigoMedico = pCodigoMedico;
    this.especialidades = pEspecialidades;
  }

  
  
//    1. Cancelar cita de paciente
//    2. Asignar cita de paciente
//    3. Atender cita (Registrar diagnósticos y tratamientos).

  /**
   * @return the codigoMedico
   */
  public int getCodigoMedico() {
    return codigoMedico;
  }

  /**
   * @param codigoMedico the codigoMedico to set
   */
  public void setCodigoMedico(int codigoMedico) {
    this.codigoMedico = codigoMedico;
  }

  /**
   * @return the especialidades
   */
  public ArrayList getEspecialidades() {
    return especialidades;
  }

  /**
   * @param especialidades the especialidades to set
   */
  public void setEspecialidades(ArrayList<String> especialidades) {
    this.especialidades = especialidades;
  }
}
