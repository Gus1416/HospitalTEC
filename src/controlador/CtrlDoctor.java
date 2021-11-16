/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.AreaCRUD;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.DiagnosticoCRUD;
import modelo.Doctor;
import modelo.PacienteCRUD;
import modelo.TratamientoCRUD;
import controlador.CtrlInicioSesion;
import controlador.CtrlAsignarCita_Doctor;
import vista.AsignarCitaDoctor;
import vista.Atender_Cita_Doctor;
import vista.Cancelar_Cita_Doctor;
import vista.ModuloDoctor;

/**
 *
 * @author sebcor
 */
public class CtrlDoctor implements ActionListener {
    private ModuloDoctor vistaDoc;
    private Doctor doctor;

    public CtrlDoctor(ModuloDoctor pVistaDoc, Doctor pDoctor) {
        this.vistaDoc = pVistaDoc;
        this.doctor = pDoctor;
        this.vistaDoc.btnAsignarCita.addActionListener(this);
        this.vistaDoc.btnAtenderCita.addActionListener(this);
        this.vistaDoc.btnCancelarCita.addActionListener(this);
        this.vistaDoc.btnConsultasDoctor.addActionListener(this);
    }

    public void iniciar(){  
    vistaDoc.setTitle("Modulo Doctor");
    vistaDoc.setLocationRelativeTo(null);    
  }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
 
        if (e.getSource() == vistaDoc.btnAsignarCita){
            AsignarCitaDoctor asignar = new AsignarCitaDoctor();
            AreaCRUD CRUDarea = new AreaCRUD();
            PacienteCRUD CRUDPaciente = new PacienteCRUD();
            Citas cita = new Citas ();
            CitasCRUD CRUDcita = new CitasCRUD();
            
            
            CtrlAsignarCita_Doctor ctrlAsignacionCita = new CtrlAsignarCita_Doctor(CRUDarea,CRUDPaciente,
            cita, CRUDcita,asignar);
            ctrlAsignacionCita.iniciar();
            asignar.setVisible(true);
        }

        if (e.getSource() == vistaDoc.btnAtenderCita){
            Atender_Cita_Doctor atender = new Atender_Cita_Doctor();
            TratamientoCRUD CRUDTratamiento = new TratamientoCRUD();
            PacienteCRUD CRUDPaciente = new PacienteCRUD ();       
            DiagnosticoCRUD CRUDDiagnostico = new  DiagnosticoCRUD(); 
            CitasCRUD CRUDcita = new CitasCRUD();
            
            CtrlAtenderCita_Doctor ctrlAtenderCita = new CtrlAtenderCita_Doctor(CRUDTratamiento,CRUDPaciente,
            CRUDDiagnostico,atender,CRUDcita);
            ctrlAtenderCita.iniciar();
            atender.setVisible(true);
            
        }

        if (e.getSource() == vistaDoc.btnCancelarCita){
            Cancelar_Cita_Doctor cancelar = new Cancelar_Cita_Doctor();
            PacienteCRUD CRUDPaciente = new PacienteCRUD();
            Citas cita = new  Citas ();
            CitasCRUD CRUDcita = new CitasCRUD();
            CtrlCancelarCita_Doctor ctrlCancelarCita = new CtrlCancelarCita_Doctor(CRUDPaciente,cita,CRUDcita,cancelar); 
            ctrlCancelarCita.iniciar();
            cancelar.setVisible(true);
        }

   
    }
    


    
    
    
    
    
   }
