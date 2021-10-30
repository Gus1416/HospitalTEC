package hospitaltec;

import controlador.CtrlInicio;
import vista.Inicio;

/**
 *
 * @author Gustavo
 */
public class HospitalTEC {

  public static void main(String[] args) {
    Inicio inicio = new Inicio();
    CtrlInicio ctrlInicio = new CtrlInicio(inicio);
    ctrlInicio.iniciar();
    inicio.setVisible(true);
  }
}
