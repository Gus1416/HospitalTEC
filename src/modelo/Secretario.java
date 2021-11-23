package modelo;

import java.time.LocalDate;

/**
 * Clase heredada que contiene la informaci[on de los secretarios.
 * 
 * @author Maria Laura
 * @version  15/11/2021
 */
public class Secretario extends Funcionario {

  /**
   * Constructor por defecto
   */
  public Secretario(){}
  
  /**
   * Constructor con parámetros.
   * 
   * @param pCedula la cédula del secretario
   * @param pPassword la contraseña del usuario
   * @param pTipoUsuario el tipo de usuario
   * @param pNombre el nombre del secretario
   * @param pTipoFuncionario el tipo de funcionario
   * @param pFechaIngreso la fecha en que se registra en el sistema
   * @param pArea el área al que pertenece el funcionario
   * @param pCentro el centro de atención en el que labora
   */
  public Secretario(String pCedula, String pPassword, String pTipoUsuario, String pNombre, String pTipoFuncionario,
          LocalDate pFechaIngreso, Area pArea, CentroAtencion pCentro) {
    super(pCedula, pPassword, pTipoUsuario, pNombre, pTipoFuncionario, pFechaIngreso, pArea, pCentro);
  }
}
