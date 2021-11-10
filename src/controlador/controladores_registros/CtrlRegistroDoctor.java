
package controlador.controladores_registros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.AreaCRUD;
import modelo.ArrayList;
import modelo.CentroAtencion;
import modelo.CentroAtencionCRUD;
import modelo.Doctor;
import modelo.DoctorCRUD;
import modelo.Funcionario;
import modelo.Hash;
import vista.registros.RegistroDoctor;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroDoctor implements ActionListener {
  private RegistroDoctor registroDoctor;
  private AreaCRUD areaCrud;
  private CentroAtencionCRUD centroCrud;
  private DoctorCRUD doctorCrud;
  private DefaultListModel modelo;
  
  private static ArrayList<Doctor> auxFuncionario  = new ArrayList<Doctor>();

    public ArrayList<Doctor> getAuxFuncionario() {
        return auxFuncionario;
    }
  
  
  
  
  public CtrlRegistroDoctor(RegistroDoctor pRegistroDoctor){
    this.registroDoctor = pRegistroDoctor;
    this.areaCrud = new AreaCRUD();
    this.centroCrud = new CentroAtencionCRUD();
    this.doctorCrud = new DoctorCRUD();
    this.modelo = new DefaultListModel();
    this.registroDoctor.btnAgregarEspecialidad.addActionListener(this);
    this.registroDoctor.btnRegistrarDoctor.addActionListener(this);
  }
  
  public void iniciar(){
    cargarAreas();
    cargarCentros();
    this.registroDoctor.setTitle("Registro de doctores");
    this.registroDoctor.setSize(750, 620);
    this.registroDoctor.setLocationRelativeTo(null);
  }
  
  private void cargarAreas(){
    ArrayList<Area> areas = areaCrud.consultarAreas();
    for (int i = 0; i < areas.size(); i++){
      this.registroDoctor.cbAreas.addItem(areas.get(i).getNombreArea());
    }
  }
  
  private void cargarCentros(){
    ArrayList<CentroAtencion> centros = centroCrud.consultarCentros();
    for (int i = 0; i < centros.size(); i++){
      this.registroDoctor.cbCentroAtencion.addItem(centros.get(i).getNombre());
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.registroDoctor.btnAgregarEspecialidad){
      String especialidad = this.registroDoctor.txtEspecialidad.getText();
      modelo.addElement(especialidad);
      this.registroDoctor.listEspecialidades.setModel(modelo);
      this.registroDoctor.txtEspecialidad.setText("");
    }
    
    if (e.getSource() == this.registroDoctor.btnRegistrarDoctor){
      String cedula = registroDoctor.txtCedulaDoctor.getText();
      String password = Hash.sha1(registroDoctor.passContrasena.getText());
      String tipoUsuario = "Funcionario";
      String nombre = registroDoctor.txtNombreDoctor.getText();
      String tipoFuncionario = "Doctor";
      LocalDate fechaIngreso = LocalDate.now();
      Area area = areaCrud.buscarArea((String)registroDoctor.cbAreas.getSelectedItem());
      CentroAtencion centro = centroCrud.buscarCentro((String)registroDoctor.cbCentroAtencion.getSelectedItem());
      int codigoMedico = Integer.parseInt(registroDoctor.txtCodigoMedico.getText());
      ArrayList<String> especialidades = recorrerLista();
      Doctor nuevoDoctor = new Doctor(cedula, password, tipoUsuario, nombre, tipoFuncionario, fechaIngreso, area, 
              centro, codigoMedico, especialidades);
      
      auxFuncionario.add(nuevoDoctor);
      
      
      
      if (doctorCrud.registrarDoctor(nuevoDoctor) && doctorCrud.registrarEspecialidades(nuevoDoctor)){
        JOptionPane.showMessageDialog(null, "Nuevo doctor registrado");
        limpiar();
      }else{
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
      }
    }
  }
  
  private ArrayList<String> recorrerLista(){
    ArrayList<String> especialidades = new ArrayList<>();
    for (int i = 0; i < this.modelo.getSize(); i++){
      especialidades.add((String)this.modelo.getElementAt(i));
    }
    return especialidades;
  }
  
  private void limpiar(){
    this.registroDoctor.txtNombreDoctor.setText("");
    this.registroDoctor.txtCedulaDoctor.setText("");
    this.registroDoctor.txtCodigoMedico.setText("");
    this.registroDoctor.passContrasena.setText("");
    this.registroDoctor.cbAreas.setSelectedIndex(0);
    this.registroDoctor.cbCentroAtencion.setSelectedIndex(0);
    this.modelo.clear();
    this.registroDoctor.listEspecialidades.setModel(modelo);
  }
}
