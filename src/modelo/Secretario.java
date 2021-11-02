package modelo;

import java.time.LocalDate;

/**
 *
 * @author Maria Laura
 */
public class Secretario extends Funcionario {

  public Secretario(){}
  
  public Secretario(String pCedula, String pPassword, String pNombre, String pTipoFuncionario,
          LocalDate pFechaIngreso, Area pArea, CentroAtencion pCentro) {
    super(pCedula, pPassword, pNombre, pTipoFuncionario, pFechaIngreso, pArea, pCentro);
  }
}
