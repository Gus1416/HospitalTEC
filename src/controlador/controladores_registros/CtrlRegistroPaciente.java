package controlador.controladores_registros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.registros.RegistroPaciente;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroPaciente implements ActionListener{
  private RegistroPaciente registroPaciente;
  
  public CtrlRegistroPaciente(RegistroPaciente pRegistroPaciente){
    this.registroPaciente = pRegistroPaciente;
  }
  
  public void iniciar() {
    this.registroPaciente.setTitle("Registro de pacientes");
    this.registroPaciente.setSize(750, 700);
    this.registroPaciente.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {}
  
}
