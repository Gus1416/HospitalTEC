package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import vista.Asignar_Cita_Doctor;

/**
 * @author sebcor "Vencer sin peligro es ganar sin gloria"- Séneca
 */
public class CtrlAsignarCita_Doctor implements ActionListener {
  private AreaCRUD CRUDarea;
  private PacienteCRUD CRUDPaciente;
  private Citas cita;
  private CitasCRUD CRUDcita;
  private Asignar_Cita_Doctor vistaAsignar;
  
  public CtrlAsignarCita_Doctor() {}

  public CtrlAsignarCita_Doctor(AreaCRUD pAREACRUD, PacienteCRUD CRUDPaciente, Citas cita,
          CitasCRUD CRUDcita, Asignar_Cita_Doctor vistaAsignar) {
    this.CRUDarea = pAREACRUD;
    this.CRUDPaciente = CRUDPaciente;
    this.cita = cita;
    this.CRUDcita = CRUDcita;
    this.vistaAsignar = vistaAsignar;
    this.vistaAsignar.btnAsignarCita.addActionListener(this);
    this.vistaAsignar.btnVolver.addActionListener(this);
  }

  public void iniciar() {
    cargarAreaEspecialidad();
    cargarPacientes();
    vistaAsignar.setTitle("Gestor de Planes de Estudio");
    vistaAsignar.setLocationRelativeTo(null);
  }

  public void cargarAreaEspecialidad() {   
    ArrayList<Area> areas = CRUDarea.consultarAreas();
    for (int i = 0; i < areas.size(); i++)
    {
      vistaAsignar.CBAreaEspecialidad.addItem(areas.get(i).getNombreArea());
    }
  }

  public void cargarPacientes() {      
    ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
    for (int i = 0; i < pacientes.size(); i++) {
      vistaAsignar.CBPaciente.addItem(pacientes.get(i).getNombre());
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaAsignar.btnAsignarCita){
      String nombreArea = vistaAsignar.CBAreaEspecialidad.getSelectedItem().toString();
      String nombrePaciente = vistaAsignar.CBPaciente.getSelectedItem().toString();
      int idArea = 0;
      String cedulaPaciente = null;
      ArrayList<Area> areas = CRUDarea.consultarAreas();
      for (int i = 0; i < areas.size(); i++) {
        if (areas.get(i).getNombreArea().matches(nombreArea) == true) {
          idArea = areas.get(i).getIdArea();
        }
      }

      ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
      for (int i = 0; i < pacientes.size(); i++){
        if (pacientes.get(i).getNombre().equals(nombrePaciente) == true){
          cedulaPaciente = pacientes.get(i).getCedula();
          System.out.println("Esta es la cedula que me llega mi panita: " + pacientes.get(i).getCedula());
        }
      }

      cita.setiDArea(idArea);  // Implementar método para traerlo de la lista de áreas
      Date input = vistaAsignar.JDateChooser.getCalendar().getTime();
      cita.setFechaCita(input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
      cita.setCedulaPaciente(cedulaPaciente);   // Implementar método para traerlo de lista de pacientes  
      cita.setObservacionAdicional(vistaAsignar.TFObservaciones.getText());
      cita.setEstado(EstadoCita.ASIGNADA);
      if (CRUDcita.registrarCita(cita)){
        JOptionPane.showMessageDialog(null, "Cita Registrada");
        limpiar();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar la cita");
        limpiar();
      }
    }

    if (e.getSource() == vistaAsignar.btnVolver){
      vistaAsignar.setVisible(false);
    }
  }

  public void limpiar() {
    vistaAsignar.TFObservaciones.setText(null);
  }
}
