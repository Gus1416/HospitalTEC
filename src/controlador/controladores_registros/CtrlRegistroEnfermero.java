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
import modelo.Enfermero;
import modelo.EnfermeroCRUD;
import modelo.Hash;
import vista.registros.RegistroEnfermero;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroEnfermero implements ActionListener{
  private RegistroEnfermero registroEnfermero;
  private AreaCRUD areaCrud;
  private CentroAtencionCRUD centroCrud;
  private EnfermeroCRUD enfermeroCrud;
  
  public CtrlRegistroEnfermero(RegistroEnfermero pRegistroEnfermero){
    this.registroEnfermero = pRegistroEnfermero;
    this.areaCrud = new AreaCRUD();
    this.centroCrud = new CentroAtencionCRUD();
    this.enfermeroCrud = new EnfermeroCRUD();
    this.registroEnfermero.btnRegistrarEnfermero.addActionListener(this);
  }
  
  public void iniciar(){
    cargarAreas();
    cargarCentros();
    this.registroEnfermero.setTitle("Registro de enfermeros");
    this.registroEnfermero.setSize(750, 570);
    this.registroEnfermero.setLocationRelativeTo(null);
  }
    
  private void cargarAreas() {
    ArrayList<Area> areas = areaCrud.consultarAreas();
    for (int i = 0; i < areas.size(); i++){
      this.registroEnfermero.cbAreas.addItem(areas.get(i).getNombreArea());
    }
  }
  
  private void cargarCentros(){
    ArrayList<CentroAtencion> centros = centroCrud.consultarCentros();
    for (int i = 0; i < centros.size(); i++){
      this.registroEnfermero.cbCentroAtencion.addItem(centros.get(i).getNombre());
    }
  } 

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.registroEnfermero.btnRegistrarEnfermero){
      if (!this.registroEnfermero.txtNombreEnfermero.getText().equals("")
              && !this.registroEnfermero.txtCedulaEnfermero.getText().equals("")
              && !this.registroEnfermero.passContrasena.getText().equals("")){
        
        String cedula = registroEnfermero.txtCedulaEnfermero.getText();
        String password = Hash.sha1(registroEnfermero.passContrasena.getText());
        String tipoUsuario = "Funcionario";
        String nombre = registroEnfermero.txtNombreEnfermero.getText();
        String tipoFuncionario = "Enfermero";
        LocalDate fechaIngreso = LocalDate.now();
        Area area = areaCrud.buscarArea((String) registroEnfermero.cbAreas.getSelectedItem());
        CentroAtencion centro = centroCrud.buscarCentro((String) registroEnfermero.cbCentroAtencion.getSelectedItem());
        boolean personasACargo = this.registroEnfermero.rbOpcionSi.isSelected();
        boolean experienciaCapacitaciones = this.registroEnfermero.rbOpcionSi1.isSelected();
        Enfermero nuevoEnfermero = new Enfermero(cedula, password, tipoUsuario, nombre, tipoFuncionario, fechaIngreso, area,
                centro, personasACargo, experienciaCapacitaciones);
        
        if (this.enfermeroCrud.registrarEnfermero(nuevoEnfermero)){
          JOptionPane.showMessageDialog(null, "Nuevo enfermero registrado");
          limpiar();
        } else{
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
      } else {
        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
      }
    }
  }
  
  private void limpiar(){
    this.registroEnfermero.txtCedulaEnfermero.setText("");
    this.registroEnfermero.txtNombreEnfermero.setText("");
    this.registroEnfermero.passContrasena.setText("");
    this.registroEnfermero.cbAreas.setSelectedIndex(0);
    this.registroEnfermero.cbCentroAtencion.setSelectedIndex(0);
  }
}
