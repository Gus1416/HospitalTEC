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
  private DiagnosticoCRUD diagnosticoCrud;
  private TratamientoCRUD tratamientoCrud;
  
  public CtrlDiagnosticos (CatalogoDiagnosticos pDiagnosticos){
    this.vistaDiagnosticos = pDiagnosticos;
    this.diagnosticoCrud = new DiagnosticoCRUD();
    this.tratamientoCrud = new TratamientoCRUD();
    this.vistaDiagnosticos.btnVerTratamientosAsociados.addActionListener(this);
  }
  
  public void iniciar(){
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
    if (e.getSource() == this.vistaDiagnosticos.btnVerTratamientosAsociados){
      DefaultTableModel tm = (DefaultTableModel) this.vistaDiagnosticos.tbDiagnosticosRegistrados.getModel();
      String idDiagnostico = String.valueOf(tm.getValueAt(this.vistaDiagnosticos.tbDiagnosticosRegistrados.getSelectedRow(), 0));
      JOptionPane.showMessageDialog(null, mostrarTratamientosAsociados(Integer.parseInt(idDiagnostico)));
    }
  }
}
