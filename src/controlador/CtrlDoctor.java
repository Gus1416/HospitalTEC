/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Doctor;
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
            CtrlAsignarCitaDoctor ctrlAsignacionCita = new CtrlAsignarCitaDoctor(asignar);
            ctrlAsignacionCita.iniciar();
            asignar.setVisible(true);
        }

        if (e.getSource() == vistaDoc.btnAtenderCita){
            Atender_Cita_Doctor atender = new Atender_Cita_Doctor();
            atender.setVisible(true);
        }

        if (e.getSource() == vistaDoc.btnCancelarCita){
            Cancelar_Cita_Doctor cancelar = new Cancelar_Cita_Doctor();
            cancelar.setVisible(true);
        }

   
    }
    


    
    
    
    
    
   }
