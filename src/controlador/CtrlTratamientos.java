package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArrayList;
import modelo.Tratamiento;
import modelo.TratamientoCRUD;
import vista.CatalogoTratamientos;

/**
 * Contorlador para el catalogo de tratamientos.
 * 
 * @author Gustavo
 */
public class CtrlTratamientos implements ActionListener{
  private CatalogoTratamientos vistaTratamientos;
  private TratamientoCRUD tratamientoCrud;
  
  /**
   * Constructor de la clase
   * 
   * @param pCatalogoTratamientos  ventana de tratamientos
   */
  public CtrlTratamientos(CatalogoTratamientos pCatalogoTratamientos){
    this.vistaTratamientos = pCatalogoTratamientos;
    this.tratamientoCrud = new TratamientoCRUD();
    this.vistaTratamientos.btnRegistrarTratamientos.addActionListener(this);
  }
  
  /**
   * Inicia la ventana
   */
  public void iniciar(){
    cargarTratamientos();
    this.vistaTratamientos.setTitle("Catálogo de Tratamientos");
    this.vistaTratamientos.setLocationRelativeTo(null);
  }
  
  /**
   * Carga los tratamientos.
   */
  private void cargarTratamientos(){
    ArrayList<Object[]> tratamientos = crearFilas(this.tratamientoCrud.consultarTratamientos());
    DefaultTableModel modelo = new DefaultTableModel();
    this.vistaTratamientos.tbTratamientosRegistrados.setModel(modelo);
    
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Cantidad de dosis");
    modelo.addColumn("Tipo");
    
    for (int i = 0; i < tratamientos.size(); i++){
      modelo.addRow(tratamientos.get(i));
    }
  }
  
  /**
   * Crea las filas de la tabla.
   *  
   * @param pTratamientos objeto tratamiento
   * @return una lista con los tratamientos
   */
  private ArrayList<Object[]> crearFilas(ArrayList<Tratamiento> pTratamientos){
    ArrayList<Object[]> filas = new ArrayList();
    
    for (int i = 0; i < pTratamientos.size(); i++){
      Object[] fila = new Object[4];
      fila[0] = pTratamientos.get(i).getId();
      fila[1] = pTratamientos.get(i).getNombre();
      fila[2] = pTratamientos.get(i).getDosis();
      fila[3] = pTratamientos.get(i).getTipo();
      filas.add(fila);
    } 
    
    return filas;
  }
 
  /**
   * Botones de la ventana.
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.vistaTratamientos.btnRegistrarTratamientos){
      
      if (!this.vistaTratamientos.txtNombreTratamiento.getText().equals("")){
      
        String nombre = this.vistaTratamientos.txtNombreTratamiento.getText();
        int dosis = (Integer) this.vistaTratamientos.jsDosis.getValue();
        String tipo = (String) this.vistaTratamientos.cbTiposTratamientos.getSelectedItem();
        Tratamiento nuevoTratamiento = new Tratamiento(nombre, dosis, tipo);

        if (this.tratamientoCrud.registrarTratamiento(nuevoTratamiento)){
          cargarTratamientos();
          JOptionPane.showMessageDialog(null, "Nuevo tratamiento registrado");
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
    this.vistaTratamientos.txtNombreTratamiento.setText("");
    this.vistaTratamientos.cbTiposTratamientos.setSelectedIndex(0);
    this.vistaTratamientos.jsDosis.setValue(0);
  }
}
