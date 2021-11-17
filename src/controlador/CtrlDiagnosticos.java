package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArrayList;
import modelo.Diagnostico;
import modelo.DiagnosticoCRUD;
import modelo.Tratamiento;
import modelo.TratamientoCRUD;
import vista.CatalogoDiagnosticos;

/**
 *
 * @author Gustavo
 */
public class CtrlDiagnosticos implements ActionListener{
  private CatalogoDiagnosticos vistaDiagnosticos;
  private DefaultListModel modeloLista;
  private DiagnosticoCRUD diagnosticoCrud;
  private TratamientoCRUD tratamientoCrud;
  
  public CtrlDiagnosticos (CatalogoDiagnosticos pDiagnosticos){
    this.vistaDiagnosticos = pDiagnosticos;
    this.diagnosticoCrud = new DiagnosticoCRUD();
    this.tratamientoCrud = new TratamientoCRUD();
    this.modeloLista = new DefaultListModel();
    this.vistaDiagnosticos.btnAgregarTratamientos.addActionListener(this);
    this.vistaDiagnosticos.btnVerTratamientosAsociados.addActionListener(this);
    this.vistaDiagnosticos.btnRegistrarDiagnostico.addActionListener(this);
  }
  
  public void iniciar(){
    cargarTratamientos();
    cargarDiagnosticos();
    this.vistaDiagnosticos.setTitle("Catálogo de Diagnósticos");
    this.vistaDiagnosticos.setLocationRelativeTo(null);
  }
  
  private void cargarDiagnosticos(){
    ArrayList<Object[]> diagnosticos = crearFilas(this.diagnosticoCrud.consultarDiagnosticos());
    DefaultTableModel modelo = new DefaultTableModel();
    this.vistaDiagnosticos.tbDiagnosticosRegistrados.setModel(modelo);
    
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    
    for (int i = 0; i < diagnosticos.size(); i++){
      modelo.addRow(diagnosticos.get(i));
    }
  }
    
  private void cargarTratamientos(){
    ArrayList<Tratamiento> tratamientos = tratamientoCrud.consultarTratamientos();
    for (int i = 0; i < tratamientos.size(); i++){
      this.vistaDiagnosticos.cbTratamientos.addItem(tratamientos.get(i).getNombre());
    }
  }
  
  private ArrayList<Object[]> crearFilas(ArrayList<Diagnostico> pTratamientos){
    ArrayList<Object[]> filas = new ArrayList();
    
    for (int i = 0; i < pTratamientos.size(); i++){
      Object[] fila = new Object[3];
      fila[0] = pTratamientos.get(i).getId();
      fila[1] = pTratamientos.get(i).getNombre();
      filas.add(fila);
    } 
    
    return filas;
  }
  
  private String mostrarTratamientosAsociados(int pIdDiagnostico){
    String msg = "";
    ArrayList<Tratamiento> tratamientos = tratamientoCrud.consultarTratamientos(pIdDiagnostico);
    
    for (int i = 0; i < tratamientos.size(); i++){
      msg += tratamientos.get(i).getNombre() + "\n";
    }
    
    return msg;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.vistaDiagnosticos.btnAgregarTratamientos){
      String tratamiento = (String)this.vistaDiagnosticos.cbTratamientos.getSelectedItem();
      modeloLista.addElement(tratamiento);
      this.vistaDiagnosticos.listTratamientos.setModel(modeloLista);
    }
    
    if (e.getSource() == this.vistaDiagnosticos.btnVerTratamientosAsociados){
      DefaultTableModel tm = (DefaultTableModel) this.vistaDiagnosticos.tbDiagnosticosRegistrados.getModel();
      String idDiagnostico = String.valueOf(tm.getValueAt(this.vistaDiagnosticos.tbDiagnosticosRegistrados.getSelectedRow(), 0));
      JOptionPane.showMessageDialog(null, mostrarTratamientosAsociados(Integer.parseInt(idDiagnostico)));
    }
    
    if (e.getSource() == this.vistaDiagnosticos.btnRegistrarDiagnostico){
      Diagnostico nuevoDiagnostico = new Diagnostico();
      String nombre = this.vistaDiagnosticos.txtNombreDiagnostico.getText();
      ArrayList<Tratamiento> tratamientos = recorrerLista();
      nuevoDiagnostico.setNombre(nombre);
      nuevoDiagnostico.setTratamientos(tratamientos);
      
      if (diagnosticoCrud.registrarDiagnostico(nuevoDiagnostico)){
        nuevoDiagnostico.setId(diagnosticoCrud.consultarUnDiagnostico(nombre).getId());
        if (diagnosticoCrud.registrarTratamientosAsociados(nuevoDiagnostico)){
          JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo diagnóstico");
          cargarDiagnosticos();
          limpiar();
        } else{
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
      } else{
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
      }
    }
  }
  
  private ArrayList<Tratamiento> recorrerLista(){
    ArrayList<Tratamiento> tratamientos = new ArrayList<>();
    for (int i = 0; i < this.modeloLista.getSize(); i++){
      tratamientos.add(tratamientoCrud.consultarUnTratamiento((String)this.modeloLista.getElementAt(i)));
    }
    return tratamientos;
  }
  
  private void limpiar(){
    this.vistaDiagnosticos.txtNombreDiagnostico.setText("");
    this.modeloLista.clear();
    this.vistaDiagnosticos.listTratamientos.setModel(modeloLista);
    this.vistaDiagnosticos.cbTratamientos.setSelectedIndex(0);
  }
}
