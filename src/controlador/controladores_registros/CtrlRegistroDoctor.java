
package controlador.controladores_registros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.registros.RegistroDoctor;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroDoctor implements ActionListener {
  private RegistroDoctor registroDoctor = new RegistroDoctor();
  
  public CtrlRegistroDoctor(RegistroDoctor pRegistroDoctor){
    this.registroDoctor = pRegistroDoctor;
  }
  
  public void iniciar(){
    this.registroDoctor.setTitle("Registro de doctores");
    this.registroDoctor.setSize(750, 620);
    this.registroDoctor.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
  }
  
}
