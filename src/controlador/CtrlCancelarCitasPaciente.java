package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArrayList;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.Correo;
import modelo.EstadoCita;
import modelo.Paciente;
import modelo.Sms;
import vista.CancelarCitasPaciente;

/**
 *
 * @author Gustavo
 */
public class CtrlCancelarCitasPaciente implements ActionListener{
  private CancelarCitasPaciente cancelarCitas;
  private Paciente paciente;
  private CitasCRUD citasCrud;
  private Correo correo;
  private Sms sms;
  
  public CtrlCancelarCitasPaciente(CancelarCitasPaciente pConsultaCitas, Paciente pPaciente){
    this.correo = new Correo();
    this.sms = new Sms();
    this.cancelarCitas = pConsultaCitas;
    this.paciente = pPaciente;
    this.citasCrud = new CitasCRUD();
    this.cancelarCitas.btnCancelarCita.addActionListener(this);
  }
  
  public void iniciar(){
    cargarCitasRegistradas();
    this.cancelarCitas.setTitle("Cancelar citas");
    this.cancelarCitas.setLocationRelativeTo(null);
  }
  
    private void cargarCitasRegistradas(){
    DefaultTableModel modelo = new DefaultTableModel();
    this.cancelarCitas.tbCitasRegistradas.setModel(modelo);
    ArrayList<Object[]> filas = this.citasCrud.consultarCitasRegistradas(this.paciente.getCedula());
    
    modelo.addColumn("Número de Cita");
    modelo.addColumn("Area");
    modelo.addColumn("Fecha");
    modelo.addColumn("Observación");
    modelo.addColumn("Estado de Cita");
    
    for (int i = 0; i < filas.size(); i++){
      modelo.addRow(filas.get(i));
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.cancelarCitas.btnCancelarCita){
      DefaultTableModel tm = (DefaultTableModel)this.cancelarCitas.tbCitasRegistradas.getModel();
      String idCita = String.valueOf(tm.getValueAt(this.cancelarCitas.tbCitasRegistradas.getSelectedRow(), 0));
      Citas cita = citasCrud.buscarCita(Integer.parseInt(idCita));
      cita.setEstado(EstadoCita.CANCELADA_POR_PACIENTE);

      ZoneId defaultZoneId = ZoneId.systemDefault();
      Date fechacita = Date.from(cita.getFechaCita().atStartOfDay(defaultZoneId).toInstant());

      if (validarCancelacion(fechacita)){
        String email = JOptionPane.showInputDialog(null, "Indique un correo electrónico");

        if (!email.equals("")){
          if (citasCrud.CancelarCita(cita)) {
            if (this.correo.enviarEmailCancelacion(email, paciente, cita)){
              this.sms.sms("La cita número " + cita.getiDCita() + " ha sido cancelada");
              cargarCitasRegistradas();
              JOptionPane.showMessageDialog(null, "La cita ha sido cancelada");
            }
          } else{
            JOptionPane.showMessageDialog(null, "Error al cancelar la cita");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Debe indicar un correo electrónico");
        }
      }
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
