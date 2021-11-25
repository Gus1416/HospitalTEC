package controlador;

import controlador.controladores_registros.CtrlRegistroDoctor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.AreaCRUD;
import modelo.ArrayList;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.EstadoCita;
import modelo.Paciente;
import modelo.PacienteCRUD;
import vista.AsignarCitaDoctor;

/**
 * Controlador de la asignación de citas
 * 
 * @author sebcor 
 *
 */
public class CtrlAsignarCita_Doctor implements ActionListener {
  private AreaCRUD CRUDarea;
  private PacienteCRUD CRUDPaciente;
  private Citas cita;
  private CitasCRUD CRUDcita;
  private AsignarCitaDoctor vistaAsignar;
  private CtrlRegistroDoctor auxMed;

  /**
   * Constructor de la clase
   * 
   * @param pAREACRUD crud del area
   * @param CRUDPaciente crud de los pacientes
   * @param cita objeto cita
   * @param CRUDcita crud de la cita
   * @param vistaAsignar vista de asignacion
   * @param auxMed  objeto auxiliar
   */
  public CtrlAsignarCita_Doctor(AreaCRUD pAREACRUD, PacienteCRUD CRUDPaciente, Citas cita, CitasCRUD CRUDcita, 
          AsignarCitaDoctor vistaAsignar, CtrlRegistroDoctor auxMed) {
    this.CRUDarea = pAREACRUD;
    this.CRUDPaciente = CRUDPaciente;
    this.cita = cita;
    this.CRUDcita = CRUDcita;
    this.auxMed = auxMed;
    this.vistaAsignar = vistaAsignar;
    this.vistaAsignar.btnAsignarCita.addActionListener(this);
  }

  /**
   * Constructor por defecto
   */
  public CtrlAsignarCita_Doctor() {
  }

  /**
   * Inicia la ventana
   */
  public void iniciar() {
    cargarAreaEspecialidad();
    cargarPacientes();
    vistaAsignar.setTitle("Gestor de Planes de Estudio");
    vistaAsignar.setLocationRelativeTo(null);
  }

  /**
   * Carga las especialidades
   */
  public void cargarAreaEspecialidad() {      // Llenar los CB de Areas de especialidad  
    ArrayList<Area> areas = CRUDarea.consultarAreas();
    for (int i = 0; i < areas.size(); i++){
      vistaAsignar.CBAreaEspecialidad.addItem(areas.get(i).getNombreArea());
    }
  }

  /**
   * Carga la lista de pacientes
   */
  public void cargarPacientes() {      // Llenar los CB de Pacientes
    ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
    for (int i = 0; i < pacientes.size(); i++){
      vistaAsignar.CBPaciente.addItem(pacientes.get(i).getNombre());
    }
  }

  /**
   * Botones de la ventana
   * 
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaAsignar.btnAsignarCita){
      String nombreArea = vistaAsignar.CBAreaEspecialidad.getSelectedItem().toString();
      String nombrePaciente = vistaAsignar.CBPaciente.getSelectedItem().toString();

      int IDAREA = 0;
      String IDPACIENTE = null;

      ArrayList<Area> areas = CRUDarea.consultarAreas();
      for (int i = 0; i < areas.size(); i++){
        if (areas.get(i).getNombreArea().matches(nombreArea) == true) {
          IDAREA = areas.get(i).getIdArea();
        }
      }

      ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
      for (int i = 0; i < pacientes.size(); i++) {
        if (pacientes.get(i).getNombre().equals(nombrePaciente) == true) {
          IDPACIENTE = pacientes.get(i).getCedula();
          System.out.println("Esta es la cedula que me llega mi panita: " + pacientes.get(i).getCedula());
        }
      }

      cita.setiDArea(IDAREA);  // Implementar método para traerlo de la lista de áreas
      Date input = vistaAsignar.JDateChooser.getCalendar().getTime();
      cita.setFechaCita(input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
      cita.setCedulaPaciente(IDPACIENTE);   // Implementar método para traerlo de lista de pacientes  
      cita.setObservacionAdicional(vistaAsignar.TFObservaciones.getText());
      cita.setEstado(EstadoCita.ASIGNADA);

      //if (CRUDcita.registrarCita(cita,auxMed.getAuxFuncionario().get(0).getCodigoMedico())) {
      if (CRUDcita.registrarCita(cita)){
        JOptionPane.showMessageDialog(null, "Cita Registrada");
        limpiar();
      } else{
        JOptionPane.showMessageDialog(null, "Error al registrar la cita");
        limpiar();
      }
    }
  }

  public void limpiar() {
    vistaAsignar.TFObservaciones.setText(null);
  }
}
