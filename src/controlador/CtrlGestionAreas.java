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
 * 
 * @author Gustavo
 */
public class CtrlGestionAreas implements ActionListener{
  private GestionAreas gestionAreas;
  private AreaCRUD areaCrud;
  
  public CtrlGestionAreas(GestionAreas gestionAreas){
    this.gestionAreas = gestionAreas;
    this.areaCrud = new AreaCRUD();
    this.gestionAreas.btnRegistrarArea.addActionListener(this);
  }
  
  public void iniciar(){
    cargarAreas();
    this.gestionAreas.setTitle("Gestión de Áreas");
    this.gestionAreas.setLocationRelativeTo(null);
  }
  
  public void cargarAreas(){
    ArrayList<Area> areas = this.areaCrud.consultarAreas();
    DefaultListModel modelo = new DefaultListModel();
    
    for (int i = 0; i < areas.size(); i++){
      modelo.add(i, areas.get(i).getIdArea()+ "-" + areas.get(i).getNombreArea()); 
    }
    this.gestionAreas.listAreas.setModel(modelo);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.gestionAreas.btnRegistrarArea){
      Area nuevaArea = new Area();
      String nombreArea = this.gestionAreas.txtNuevaArea.getText();
      nuevaArea.setNombreArea(nombreArea);
      if (this.areaCrud.registrarArea(nuevaArea)){
        cargarAreas();
        JOptionPane.showMessageDialog(null, "Se ha registrado una nueva área");
      } else {
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
      }
    }
  }
}
