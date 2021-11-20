
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
import modelo.EstadoCita;
import modelo.Paciente;
import vista.CancelarCitasPaciente;

/**
 *
 * @author Gustavo
 */
public class CtrlCancelarCitasPaciente implements ActionListener{
  private CancelarCitasPaciente cancelarCitas;
  private Paciente paciente;
  private CitasCRUD citasCrud;
  
  public CtrlCancelarCitasPaciente(CancelarCitasPaciente pConsultaCitas, Paciente pPaciente){
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
      
      LocalDate hoy = LocalDate.now();
      ZoneId defaultZoneId = ZoneId.systemDefault();
      Date fechacita = Date.from(cita.getFechaCita().atStartOfDay(defaultZoneId).toInstant());
      Date today = Date.from(hoy.atStartOfDay(defaultZoneId).toInstant());

      long diffInMillies = Math.abs(fechacita.getTime() - today.getTime());
      long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
      
      if (diff >= 1){
        if (citasCrud.CancelarCita(cita)) {
          cargarCitasRegistradas();
          JOptionPane.showMessageDialog(null, "Cita Cancelada");
        } else{
          JOptionPane.showMessageDialog(null, "Error al cancelar la cita la cita");
        }
      }
    }
  }
}
