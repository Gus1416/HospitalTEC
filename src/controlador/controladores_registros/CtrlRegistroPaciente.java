package controlador.controladores_registros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.ArrayList;
import modelo.Hash;
import modelo.Paciente;
import modelo.PacienteCRUD;
import vista.registros.RegistroPaciente;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroPaciente implements ActionListener{
  private RegistroPaciente registroPaciente;
  private PacienteCRUD pacienteCrud;
  private DefaultListModel modelo;
  
  public CtrlRegistroPaciente(RegistroPaciente pRegistroPaciente){
    this.registroPaciente = pRegistroPaciente;
    this.pacienteCrud = new PacienteCRUD();
    this.modelo = new DefaultListModel();
    this.registroPaciente.btnAgregarTelefono.addActionListener(this);
    this.registroPaciente.btnRegistrarPaciente.addActionListener(this);
  }
  
  public void iniciar() {
    this.registroPaciente.setTitle("Registro de pacientes");
    this.registroPaciente.setSize(750, 670);
    this.registroPaciente.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.registroPaciente.btnAgregarTelefono){
      String telefonos = this.registroPaciente.txtTelefono.getText();
      modelo.addElement(telefonos);
      this.registroPaciente.listTelefonos.setModel(modelo);
      this.registroPaciente.txtTelefono.setText("");
    }

    if (e.getSource() == this.registroPaciente.btnRegistrarPaciente){
      String cedula = registroPaciente.txtCedulaPaciente.getText();
      String password = Hash.sha1(registroPaciente.passContrasena.getText());
      String nombre = registroPaciente.txtNombrePaciente.getText();
      LocalDate fechaNacimiento = this.registroPaciente.dcFechaNacimiento.getCalendar().getTime().toInstant().
              atZone(ZoneId.systemDefault()).toLocalDate();
      String sangre = (String) this.registroPaciente.cbSangre.getSelectedItem();
      String nacionalidad = this.registroPaciente.txtNacionalidad.getText();
      String residencia = this.registroPaciente.txtResidencia.getText();
      ArrayList<String> telefonos = recorrerLista();
      Paciente nuevoPaciente = new Paciente(cedula, password, nombre, fechaNacimiento, sangre, nacionalidad,
              residencia, telefonos);
      if (pacienteCrud.registrarPaciente(nuevoPaciente) && pacienteCrud.registrarTelefonos(nuevoPaciente)) {
        JOptionPane.showMessageDialog(null, "Nuevo paciente registrado");
        limpiar();
      } else{
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
      }
    }
  }
  
  private ArrayList<String> recorrerLista() {
    ArrayList<String> telefonos = new ArrayList<>();
    for (int i = 0; i < this.modelo.getSize(); i++){
      telefonos.add((String) this.modelo.getElementAt(i));
    }
    return telefonos;
  }
  
  private void limpiar(){
    this.registroPaciente.txtCedulaPaciente.setText("");
    this.registroPaciente.txtNacionalidad.setText("");
    this.registroPaciente.txtNombrePaciente.setText("");
    this.registroPaciente.txtResidencia.setText("");
    this.registroPaciente.txtTelefono.setText("");
    this.registroPaciente.passContrasena.setText("");
    this.modelo.clear();
    this.registroPaciente.listTelefonos.setModel(modelo);
  }
}
