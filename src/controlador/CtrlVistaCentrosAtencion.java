package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArrayList;
import modelo.CentroAtencion;
import modelo.CentroAtencionCRUD;
import vista.VistaCentrosAtencion;

/**
 * Controlador para la gestion de CM
 * @author Gustavo
 */
public class CtrlVistaCentrosAtencion implements ActionListener{
  private VistaCentrosAtencion vistaCentros;
  private CentroAtencionCRUD centrosCrud;
  
  /**
   * Constructor de la clase.
   * 
   * @param pVistaCentros  ventana de gestión de CM
   */
  public CtrlVistaCentrosAtencion (VistaCentrosAtencion pVistaCentros){
    this.vistaCentros = pVistaCentros;
    this.centrosCrud = new CentroAtencionCRUD(); 
    this.vistaCentros.btnRegistrarCentro.addActionListener(this);
  }
  
  /**
   * Inicia la ventana.
   */
  public void iniciar(){
    cargarCentros();
    cargarTipos();
    this.vistaCentros.setTitle("Registro de Centros de Atención");
    this.vistaCentros.setSize(900, 620);
    this.vistaCentros.setLocationRelativeTo(null);
  }
  
  /**
   * Carga los CM registrados.
   */
  private void cargarCentros(){
    ArrayList<Object[]> centros = crearFilas(this.centrosCrud.consultarCentros());
    DefaultTableModel modelo = new DefaultTableModel();
    this.vistaCentros.tbCentrosRegistrados.setModel(modelo);
    
    modelo.addColumn("Código");
    modelo.addColumn("Nombre");
    modelo.addColumn("Ubicación");
    modelo.addColumn("Capacidad");
    modelo.addColumn("Tipo");
    
    for (int i = 0; i < centros.size(); i++){
      modelo.addRow(centros.get(i));
    }
  }
  
  /**
   * Carga los tipos de CM
   */
  private void cargarTipos(){
    ArrayList<String> tipos = this.centrosCrud.consultarTipos();
    for (int i = 0; i < tipos.size(); i++){
      this.vistaCentros.cbTiposCentro.addItem(tipos.get(i));
    }
  }  

  /**
   * Crea las filas de la tabla.
   * 
   * @param pCentros lista de centros.
   * 
   * @return  una lista con los centros.
   */
  private ArrayList<Object[]> crearFilas(ArrayList<CentroAtencion> pCentros){
    ArrayList<Object[]> filas = new ArrayList();
    
    for (int i = 0; i < pCentros.size(); i++){
      Object[] fila = new Object[5];
      fila[0] = pCentros.get(i).getId();
      fila[1] = pCentros.get(i).getNombre();
      fila[2] = pCentros.get(i).getLugar();
      fila[3] = pCentros.get(i).getCapacidadPacientes();
      fila[4] = pCentros.get(i).getTipo();
      filas.add(fila);
    }
    
    return filas;
  }
  
  /**
   * Botones de la ventana
   * 
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.vistaCentros.btnRegistrarCentro) {
      
      if (!this.vistaCentros.txtNombreCentro.getText().equals("")
              && !this.vistaCentros.txtUbicacion.getText().equals("")
              && (Integer) this.vistaCentros.jsCapacidad.getValue() != 0){
        String nombre = this.vistaCentros.txtNombreCentro.getText();
        String ubicacion = this.vistaCentros.txtUbicacion.getText();
        int capacidad = (Integer) this.vistaCentros.jsCapacidad.getValue();
        String tipo = (String) this.vistaCentros.cbTiposCentro.getSelectedItem();
        CentroAtencion nuevoCentro = new CentroAtencion(nombre, ubicacion, capacidad, tipo);
        
        if (this.centrosCrud.registrarCentro(nuevoCentro)){
          cargarCentros();
          JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo Centro de Atención");
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
    this.vistaCentros.txtNombreCentro.setText("");
    this.vistaCentros.txtUbicacion.setText("");
    this.vistaCentros.cbTiposCentro.setSelectedIndex(0);
    this.vistaCentros.jsCapacidad.setValue(0);
  }
  
}
