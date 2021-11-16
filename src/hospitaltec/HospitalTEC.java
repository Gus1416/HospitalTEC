/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitaltec;


import controlador.CtrlAsignarCita_Doctor;
import controlador.CtrlAtenderCita_Doctor;
import controlador.CtrlCancelarCita_Doctor;
import controlador.CtrlDoctor;
import controlador.CtrlInicio;
import modelo.AreaCRUD;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.DiagnosticoCRUD;
import modelo.PacienteCRUD;
import modelo.TratamientoCRUD;
import vista.AsignarCitaDoctor;
import vista.Atender_Cita_Doctor;
import vista.Cancelar_Cita_Doctor;

import controlador.CtrlInicio;

import vista.Inicio;

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

    Inicio inicio = new Inicio();
    CtrlInicio ctrlInicio = new CtrlInicio(inicio);
    ctrlInicio.iniciar();
    inicio.setVisible(true);

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
//        Cancelar_Cita_Doctor cancelarcita = new Cancelar_Cita_Doctor();
//        PacienteCRUD CRUDPaciente = new PacienteCRUD();
//        Citas cita = new Citas() ;
//        CitasCRUD CRUDcita = new CitasCRUD();
//        
//        CtrlCancelarCita_Doctor ctrlcancelar = new CtrlCancelarCita_Doctor(CRUDPaciente,cita,CRUDcita,cancelarcita);
//        ctrlcancelar.iniciar();
//        cancelarcita.setVisible(true);



//        CitasCRUD CRUDcita = new CitasCRUD();
//        TratamientoCRUD CRUDtratamiento = new TratamientoCRUD();
//        PacienteCRUD CRUDPaciente = new PacienteCRUD();
//        DiagnosticoCRUD CRUDDiagnostico = new DiagnosticoCRUD();
//        Atender_Cita_Doctor Vistatender = new Atender_Cita_Doctor();
//
//        CtrlAtenderCita_Doctor atendercita = new CtrlAtenderCita_Doctor(CRUDtratamiento, CRUDPaciente, CRUDDiagnostico, Vistatender, CRUDcita);
//        atendercita.iniciar();
//        Vistatender.setVisible(true);

}

}

        
//      /*  Cancelar_Cita_Doctor cancelarcita = new Cancelar_Cita_Doctor();
//        PacienteCRUD CRUDPaciente = new PacienteCRUD();
//        Citas cita = new Citas() ;
//        CitasCRUD CRUDcita = new CitasCRUD();
//        
//        CtrlCancelarCita_Doctor ctrlcancelar = new CtrlCancelarCita_Doctor(CRUDPaciente,cita,CRUDcita,cancelarcita);
//        ctrlcancelar.iniciar();
//        cancelarcita.setVisible(true);*/
//        }
   

