package controlador.controladores_registros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.registros.RegistroEnfermero;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroEnfermero implements ActionListener{
  private RegistroEnfermero registroEnfermero;
  
  public CtrlRegistroEnfermero(RegistroEnfermero pRegistroEnfermero){
    this.registroEnfermero = pRegistroEnfermero;
  }
  
    public void iniciar(){
    this.registroEnfermero.setTitle("Registro de enfermeros");
    this.registroEnfermero.setSize(750, 570);
    this.registroEnfermero.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
  }
  
}
