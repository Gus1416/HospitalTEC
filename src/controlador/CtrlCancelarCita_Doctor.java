package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import modelo.ArrayList;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.Paciente;
import modelo.PacienteCRUD;
import vista.Cancelar_Cita_Doctor;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import modelo.EstadoCita;

/**
 * Controlador para la cancelación de cita.
 * 
 * @author sebcor
 */
public class CtrlCancelarCita_Doctor implements ActionListener {

  private PacienteCRUD CRUDPaciente;
  private CitasCRUD CRUDcita;
  private Cancelar_Cita_Doctor vistaCancelar;

  public static ArrayList<Citas> citas;
  public static Date firstDate;
  public static Date secondDate;
  public static Citas auxdate;

  /**
   * Constructor de la clase.
   * 
   * @param CRUDPaciente cruds del paciente
   * @param CRUDcita cruds de la cita
   * @param vistaCancelar  vista de cancelación
   */
  public CtrlCancelarCita_Doctor(PacienteCRUD CRUDPaciente, CitasCRUD CRUDcita, Cancelar_Cita_Doctor vistaCancelar) {
    this.CRUDPaciente = CRUDPaciente;
    this.CRUDcita = CRUDcita;
    this.vistaCancelar = vistaCancelar;
    this.vistaCancelar.btnCancelar.addActionListener(this);
    this.vistaCancelar.btnVolver.addActionListener(this);
    this.vistaCancelar.btnCargar.addActionListener(this);
  }

  /**
   * Constructor por defecto
   */
  public CtrlCancelarCita_Doctor() {
  }

  /**
   * Inicia la ventana
   */
  public void iniciar() {
    cargarPacientes();
    vistaCancelar.setTitle("Gestor de Planes de Estudio");
    vistaCancelar.setLocationRelativeTo(null);
  }

  /**
   * Carga la lista de pacientes
   */
  public void cargarPacientes() {      // Llenar los CB de Pacientes
    ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
    for (int i = 0; i < pacientes.size(); i++)
    {
      vistaCancelar.CBPaciente.addItem(pacientes.get(i).getNombre());
    }
  }

  /**
   * Botones de la ventana.
   * 
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
  
    if (e.getSource() == vistaCancelar.btnCargar) {
      String nombrePaciente = (String)vistaCancelar.CBPaciente.getSelectedItem();
      Paciente paciente = CRUDPaciente.buscarPacienteNombre(nombrePaciente);
      this.citas = CRUDPaciente.consultarCitasPaciente(paciente);
      for (int i = 0; i < citas.size(); i++){
        this.vistaCancelar.CBCita.addItem(Integer.toString(citas.get(i).getiDCita()));
      }

    }

    if (e.getSource() == vistaCancelar.btnCancelar) {
      int IDCITA = Integer.parseInt((String) vistaCancelar.CBCita.getSelectedItem());

      Citas citaB = CRUDcita.buscarCita(IDCITA);
      citaB.setEstado(EstadoCita.CANCELADA_POR_MÉDICO);
      auxdate = citaB;
      
      ZoneId defaultZoneId = ZoneId.systemDefault();
      Date fechacita = Date.from(citaB.getFechaCita().atStartOfDay(defaultZoneId).toInstant());
      
      if (validarCancelacion(fechacita)){

        if (CRUDcita.CancelarCita(citaB)) {
          JOptionPane.showMessageDialog(null, "Cita Cancelada");

        } else{
          JOptionPane.showMessageDialog(null, "Error al cancelar la cita la cita");
        }
      } else {
        JOptionPane.showMessageDialog(null, "No se puede cancelar esta cita");
      }
    }

    if (e.getSource() == vistaCancelar.btnVolver){
      vistaCancelar.setVisible(false);
    }
  }
  
  private boolean validarCancelacion(Date pFechaCita){
    LocalDate hoy = LocalDate.now();
    ZoneId defaultZoneId = ZoneId.systemDefault();
    Date today = Date.from(hoy.atStartOfDay(defaultZoneId).toInstant());
    
    long diffInMillies = Math.abs(pFechaCita.getTime() - today.getTime());
    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    
    return (diff >= 1);
  }
}



                
        
        
        
    

