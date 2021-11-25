package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.AreaCRUD;
import modelo.ArrayList;
import vista.GestionAreas;

/**
 * Controlador para la gestión de areas.
 * 
 * @author Gustavo
 */
public class CtrlGestionAreas implements ActionListener{
  private GestionAreas gestionAreas;
  private AreaCRUD areaCrud;
  
  /**
   * Contructor de la clase
   * 
   * @param gestionAreas  ventana de gestión de áreas
   */
  public CtrlGestionAreas(GestionAreas gestionAreas){
    this.gestionAreas = gestionAreas;
    this.areaCrud = new AreaCRUD();
    this.gestionAreas.btnRegistrarArea.addActionListener(this);
  }
  
  /**
   * Inicia la ventana
   */
  public void iniciar(){
    cargarAreas();
    this.gestionAreas.setTitle("Gestión de Áreas");
    this.gestionAreas.setLocationRelativeTo(null);
  }
  
  /**
   * Carga las áreas.
   */
  public void cargarAreas(){
    ArrayList<Area> areas = this.areaCrud.consultarAreas();
    DefaultListModel modelo = new DefaultListModel();
    
    for (int i = 0; i < areas.size(); i++){
      modelo.add(i, areas.get(i).getIdArea()+ "-" + areas.get(i).getNombreArea()); 
    }
    this.gestionAreas.listAreas.setModel(modelo);
  }

  /**
   * Botones de la ventana.
   * 
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.gestionAreas.btnRegistrarArea){
      
        if (!this.gestionAreas.txtNuevaArea.getText().equals("")){

        Area nuevaArea = new Area();
        String nombreArea = this.gestionAreas.txtNuevaArea.getText();
        nuevaArea.setNombreArea(nombreArea);
        
        if (this.areaCrud.registrarArea(nuevaArea)){
          cargarAreas();
          JOptionPane.showMessageDialog(null, "Se ha registrado una nueva área");
        } else {
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
      } else {
        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
      }
    }
  }
}
