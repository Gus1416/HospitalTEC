package hospitaltec;

import controlador.CtrlInicio;

import vista.Inicio;

/**
 * Clase principal que ejecuta el programa.
 * 
 * @author Gustavo
 * @version 10/11/2021
 */
public class HospitalTEC {
  public static void main(String[] args) {
    Inicio inicio = new Inicio();
    CtrlInicio ctrlInicio = new CtrlInicio(inicio);
    ctrlInicio.iniciar();
    inicio.setVisible(true);
  }
}