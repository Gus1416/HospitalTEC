package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Paciente;
import vista.CancelarCitasPaciente;
import vista.ConsultasPaciente;
import vista.ModuloPaciente;
import vista.SolicitarCitaPaciente;

/**
 * Controlador para el módulo de pacientes.
 * 
 * @author Gustavo
 */
public class CtrlPaciente implements ActionListener{
  private ModuloPaciente moduloPaciente;
  private Paciente paciente;
  
  /**
   * Constructor de la clase.
   * 
   * @param pModuloPaciente ventana del módulo de paciente
   * @param pPaciente  objeto paciente
   */
  public CtrlPaciente (ModuloPaciente pModuloPaciente, Paciente pPaciente){
    this.moduloPaciente = pModuloPaciente;
    this.paciente = pPaciente;
    this.moduloPaciente.btnSolicitarCita.addActionListener(this);
    this.moduloPaciente.btnCancelarCita.addActionListener(this);
    this.moduloPaciente.btnConsultasPaciente.addActionListener(this);
  }
  
  /**
   * Inicia la ventana
   */
  public void iniciar(){
    this.moduloPaciente.setTitle("Módulo de Paciente");
    this.moduloPaciente.setLocationRelativeTo(null);
  }
    
  /**
   * Botones de la ventana
   * @param e 
   */
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
    
    if (e.getSource() == this.moduloPaciente.btnConsultasPaciente){
      ConsultasPaciente consultas = new ConsultasPaciente();
      CtrlConsultasPaciente ctrlConsultas = new CtrlConsultasPaciente(consultas, this.paciente);
      ctrlConsultas.iniciar();
      consultas.setVisible(true);
    }
  }
  
  
}
