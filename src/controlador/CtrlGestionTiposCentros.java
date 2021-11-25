package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.ArrayList;
import modelo.CentroAtencionCRUD;
import vista.GestionTiposCentros;

/**
 * Controlador para la gestion de tipos de CM
 * 
 * @author Gustavo
 */
public class CtrlGestionTiposCentros implements ActionListener{
  private GestionTiposCentros gestionTipos;
  private CentroAtencionCRUD centroCrud;
  
  /**
   * Constructor de la clase.
   * 
   * @param pGestionTipos  ventana para la gestión de tipos de CM
   */
  public CtrlGestionTiposCentros(GestionTiposCentros pGestionTipos){
    this.gestionTipos = pGestionTipos;
    this.centroCrud = new CentroAtencionCRUD();
    this.gestionTipos.btnRegistrarArea.addActionListener(this);
  }
  
  /**
   * Inicia la ventana
   */
  public void iniciar(){
    cargarTipos();
    this.gestionTipos.setTitle("Gestión de Tipos de CM");
    this.gestionTipos.setLocationRelativeTo(null);
  }
  
  /**
   * Carga los tipos registrados
   */
  private void cargarTipos(){
    ArrayList<String> tipos = this.centroCrud.consultarTipos();
    DefaultListModel modelo = new DefaultListModel();
    for (int i = 0; i < tipos.size(); i++){
      modelo.add(i, tipos.get(i));
    }
    this.gestionTipos.listTiposCentros.setModel(modelo);
  }

  /**
   * Botones de la ventana
   * 
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.gestionTipos.btnRegistrarArea){
      
      if (!this.gestionTipos.txtNuevoTipoCentro.getText().equals("")){
      
        String tipo = this.gestionTipos.txtNuevoTipoCentro.getText();
        if (this.centroCrud.registrarTipo(tipo)){
          cargarTipos();
          JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo tipo de CM");
        } else {
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
          }
      } else{
        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
      }
    }
  }
}
