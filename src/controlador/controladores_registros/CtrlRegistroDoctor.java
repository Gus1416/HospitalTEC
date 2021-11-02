
package controlador.controladores_registros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Area;
import modelo.AreaCRUD;
import modelo.ArrayList;
import modelo.CentroAtencion;
import modelo.CentroAtencionCRUD;
import vista.registros.RegistroDoctor;

/**
 *
 * @author Gustavo
 */
public class CtrlRegistroDoctor implements ActionListener {
  private RegistroDoctor registroDoctor;
  private AreaCRUD areaCrud;
  private CentroAtencionCRUD centroCrud;
  
  public CtrlRegistroDoctor(RegistroDoctor pRegistroDoctor){
    this.registroDoctor = pRegistroDoctor;
    this.areaCrud = new AreaCRUD();
    this.centroCrud = new CentroAtencionCRUD();
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
      
    }
  }
}
