
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.AreaCRUD;
import modelo.ArrayList;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.Correo;
import modelo.EstadoCita;
import modelo.Paciente;
import vista.SolicitarCitaPaciente;

/**
 *
 * @author Gustavo
 */
public class CtrlSolicitarCitaPaciente implements ActionListener{
  private SolicitarCitaPaciente solicitarCita;
  private Paciente paciente;
  private AreaCRUD areaCrud;
  private CitasCRUD citasCrud;
  private Correo correo;
  
  public CtrlSolicitarCitaPaciente(SolicitarCitaPaciente pSolicitarCita, Paciente pPaciente){
    this.correo = new Correo();
    this.solicitarCita = pSolicitarCita;
    this.areaCrud = new AreaCRUD();
    this.paciente = pPaciente;
    this.citasCrud = new CitasCRUD();
    this.solicitarCita.btnAsignarCita.addActionListener(this);
  }
  
  public void iniciar(){ 
    cargarAreaEspecialidad();
    this.solicitarCita.setTitle("Solicitar Cita");
    this.solicitarCita.setLocationRelativeTo(null);
  }
  
  public void cargarAreaEspecialidad() {   
    ArrayList<Area> areas = areaCrud.consultarAreas();
    for (int i = 0; i < areas.size(); i++){
      this.solicitarCita.CBAreaEspecialidad.addItem(areas.get(i).getNombreArea());
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.solicitarCita.btnAsignarCita){
      String email = JOptionPane.showInputDialog(null, "Indique un correo electrónico");
      
      if (!email.equals("")){
        Citas nuevaCita = new Citas();

        int area = areaCrud.buscarArea((String) this.solicitarCita.CBAreaEspecialidad.getSelectedItem()).getIdArea();
        LocalDate fecha = this.solicitarCita.JDateChooser.getCalendar().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String observaciones = this.solicitarCita.TFObservaciones.getText();
        EstadoCita estado = EstadoCita.REGISTRADA;
        String cedulaPaciente = this.paciente.getCedula();

        nuevaCita.setiDArea(area);
        nuevaCita.setFechaCita(fecha);
        nuevaCita.setObservacionAdicional(observaciones);
        nuevaCita.setEstado(estado);
        nuevaCita.setCedulaPaciente(cedulaPaciente);

        if (this.citasCrud.registrarCita(nuevaCita)){
          if (this.correo.enviarEmailConfirmacion(email, paciente, nuevaCita)){
            JOptionPane.showMessageDialog(null, "Se ha registrado una nueva cita");
            limpiar();
          } else {
            JOptionPane.showMessageDialog(null, "No se pudo enviar el correo electrónico");
          }
        } else{
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
      } else {
        JOptionPane.showMessageDialog(null, "Debe indicar un correo electrónico");
      }
    }
  }
  
  private void limpiar(){
    this.solicitarCita.TFObservaciones.setText("");
    this.solicitarCita.CBAreaEspecialidad.setSelectedIndex(0);
    this.solicitarCita.JDateChooser.setDate(null);
  }
  
}
