package controlador.controladores_registros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.registros.RegistroSecretario;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroSecretario implements ActionListener{
  private RegistroSecretario registroSecretario;
  
  public CtrlRegistroSecretario(RegistroSecretario pRegistroSecretario){
    this.registroSecretario = pRegistroSecretario;
  }
  
  public void iniciar(){
    this.registroSecretario.setTitle("Registro de enfermeros");
    this.registroSecretario.setSize(750, 510);
    this.registroSecretario.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {}
  
}
