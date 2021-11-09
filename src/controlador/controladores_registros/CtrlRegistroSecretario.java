package controlador.controladores_registros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.AreaCRUD;
import modelo.ArrayList;
import modelo.CentroAtencion;
import modelo.CentroAtencionCRUD;
import modelo.Hash;
import modelo.Secretario;
import modelo.SecretarioCRUD;
import vista.registros.RegistroSecretario;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroSecretario implements ActionListener{
  private RegistroSecretario registroSecretario;
  private AreaCRUD areaCrud;
  private CentroAtencionCRUD centroCrud;
  private SecretarioCRUD secretarioCrud;
  
  public CtrlRegistroSecretario(RegistroSecretario pRegistroSecretario){
    this.registroSecretario = pRegistroSecretario;
    this.areaCrud = new AreaCRUD();
    this.centroCrud = new CentroAtencionCRUD();
    this.secretarioCrud = new SecretarioCRUD();
    this.registroSecretario.btnRegistrarSecretario.addActionListener(this);
  }
  
  public void iniciar(){
    cargarAreas();
    cargarCentros();
    this.registroSecretario.setTitle("Registro de enfermeros");
    this.registroSecretario.setSize(750, 510);
    this.registroSecretario.setLocationRelativeTo(null);
  }
  
    private void cargarAreas() {
    ArrayList<Area> areas = areaCrud.consultarAreas();
    for (int i = 0; i < areas.size(); i++){
      this.registroSecretario.cbAreas.addItem(areas.get(i).getNombreArea());
    }
  }
  
  private void cargarCentros(){
    ArrayList<CentroAtencion> centros = centroCrud.consultarCentros();
    for (int i = 0; i < centros.size(); i++){
      this.registroSecretario.cbCentroAtencion.addItem(centros.get(i).getNombre());
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) { 
    if (e.getSource() == this.registroSecretario.btnRegistrarSecretario){
      String cedula = registroSecretario.txtCedulaSecretario.getText();
      String password = Hash.sha1(registroSecretario.passContrasena.getText());
      String tipoUsuario = "Funcionario";
      String nombre = registroSecretario.txtNombreSecretario.getText();
      String tipoFuncionario = "Secretario";
      LocalDate fechaIngreso = LocalDate.now();
      Area area = areaCrud.buscarArea((String)registroSecretario.cbAreas.getSelectedItem());
      CentroAtencion centro = centroCrud.buscarCentro((String)registroSecretario.cbCentroAtencion.getSelectedItem());
      Secretario nuevoSecretario = new Secretario(cedula, password, tipoUsuario, nombre, tipoFuncionario, fechaIngreso, area, centro);
      if (this.secretarioCrud.registrarSecretario(nuevoSecretario)){
        JOptionPane.showMessageDialog(null, "Nuevo secretario registrado");
        limpiar();
      } else {
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
      }
    }
  }
  
  private void limpiar(){
    this.registroSecretario.txtCedulaSecretario.setText("");
    this.registroSecretario.txtNombreSecretario.setText("");
    this.registroSecretario.passContrasena.setText("");
    this.registroSecretario.cbAreas.setSelectedIndex(0);
    this.registroSecretario.cbCentroAtencion.setSelectedIndex(0);
  }
}
