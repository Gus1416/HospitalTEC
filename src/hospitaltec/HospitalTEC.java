package hospitaltec;

import controlador.CtrlAsignarCita_Doctor;
import controlador.CtrlCancelarCita_Doctor;
import controlador.CtrlDoctor;
import controlador.CtrlInicio;
import modelo.AreaCRUD;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.PacienteCRUD;
import vista.Asignar_Cita_Doctor;
import vista.Cancelar_Cita_Doctor;
import vista.Inicio;
import vista.ModuloDoctor;

/**
 *
 * @author Gustavo
 */
public class HospitalTEC {

  public static void main(String[] args) {
//    Inicio inicio = new Inicio();
//    CtrlInicio ctrlInicio = new CtrlInicio(inicio);
//    ctrlInicio.iniciar();
//    inicio.setVisible(true);
//    
//    ModuloDoctor doc = new ModuloDoctor();
//    CtrlDoctor ctrlDoctor = new CtrlDoctor(doc);
//    ctrlDoctor.iniciar();
//    doc.setVisible(true);
    

//    AreaCRUD CRUDarea = new AreaCRUD();
//    PacienteCRUD CRUDPaciente = new PacienteCRUD();
//    Citas cita = new Citas();
//    CitasCRUD CRUDcita = new CitasCRUD() ;
//    Asignar_Cita_Doctor vistaAsignar = new Asignar_Cita_Doctor() ;
//    
//    
//    CtrlAsignarCita_Doctor asignarcita = new CtrlAsignarCita_Doctor(CRUDarea,CRUDPaciente,cita,CRUDcita,vistaAsignar);
//    asignarcita.iniciar();
//    vistaAsignar.setVisible(true);   

        
        Cancelar_Cita_Doctor cancelarcita = new Cancelar_Cita_Doctor();
        PacienteCRUD CRUDPaciente = new PacienteCRUD();
        Citas cita = new Citas() ;
        CitasCRUD CRUDcita = new CitasCRUD();
        
        CtrlCancelarCita_Doctor ctrlcancelar = new CtrlCancelarCita_Doctor(CRUDPaciente,cita,CRUDcita,cancelarcita);
        ctrlcancelar.iniciar();
        cancelarcita.setVisible(true);
        
        


        
    
  
    
    
    
  
  
        }
  
  
   }
