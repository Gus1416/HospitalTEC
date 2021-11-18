package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Paciente;
import vista.CancelarCitasPaciente;
import vista.ModuloPaciente;
import vista.SolicitarCitaPaciente;

/**
 *
 * @author Gustavo
 */
public class CtrlPaciente implements ActionListener{
  private ModuloPaciente moduloPaciente;
  private Paciente paciente;
  
  public CtrlPaciente (ModuloPaciente pModuloPaciente, Paciente pPaciente){
    this.moduloPaciente = pModuloPaciente;
    this.paciente = pPaciente;
    this.moduloPaciente.btnSolicitarCita.addActionListener(this);
    this.moduloPaciente.btnCancelarCita.addActionListener(this);
  }
  
  public void iniciar(){
    this.moduloPaciente.setTitle("Módulo de Paciente");
    this.moduloPaciente.setLocationRelativeTo(null);
  }
    
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.moduloPaciente.btnSolicitarCita){
      SolicitarCitaPaciente solicitarCita = new SolicitarCitaPaciente();
      CtrlSolicitarCitaPaciente ctrlSolicitarCita = new CtrlSolicitarCitaPaciente(solicitarCita, this.paciente);
      ctrlSolicitarCita.iniciar();
      solicitarCita.setVisible(true);
    }
    
    if (e.getSource() == this.moduloPaciente.btnCancelarCita){
      CancelarCitasPaciente cancelarCita = new CancelarCitasPaciente();
      CtrlCancelarCitasPaciente ctrlCancelarCita = new CtrlCancelarCitasPaciente(cancelarCita, this.paciente);
      ctrlCancelarCita.iniciar();
      cancelarCita.setVisible(true);
    }
  }
  
  
}
