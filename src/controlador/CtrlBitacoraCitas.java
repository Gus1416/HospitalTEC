package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.ArrayList;
import modelo.CitasCRUD;
import vista.BitacoraCitas;

/**
 * Controlador de la bitácora de citas
 * 
 * @author Gustavo
 */
public class CtrlBitacoraCitas implements ActionListener{
  private BitacoraCitas bitacora;
  private CitasCRUD citasCrud;

  public CtrlBitacoraCitas(BitacoraCitas pBitacora) {
    this.bitacora = pBitacora;
    this.citasCrud = new CitasCRUD();
  }
  
  /**
   * Inicia la ventana
   */
  public void iniciar(){
    mostrarBitacora();
    this.bitacora.setTitle("Bitácora de Citas");
    this.bitacora.setLocationRelativeTo(null);
  }
  
  /**
   * Muestra la bitácora de citas
   */
  private void mostrarBitacora(){
    DefaultTableModel modelo = new DefaultTableModel();
    this.bitacora.tbBitacora.setModel(modelo);
    ArrayList<Object[]> filas = this.citasCrud.consultarBitacoraCitas();
    
    modelo.addColumn("Número de Cita");
    modelo.addColumn("Usuario que modifica");
    modelo.addColumn("Fecha de Modificación");
    modelo.addColumn("Estado de Cita");
    
    for (int i = 0; i < filas.size(); i++){
      modelo.addRow(filas.get(i));
    }
  }

  /**
   * Botones de la clase
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    
  }
  
}
