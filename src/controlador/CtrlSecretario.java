/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Doctor;
import modelo.Secretario;
import vista.AsignarCitaDoctor;
import vista.Atender_Cita_Doctor;
import vista.Cancelar_Cita_Doctor;
import vista.ModuloSecretario;

/**
 *
 * @author sebcor
 */
public class CtrlSecretario implements ActionListener {
    private ModuloSecretario vistaSecre;
    private Secretario secretario;


    public CtrlSecretario(ModuloSecretario pvistaSecre, Secretario pSecretario) {
        this.vistaSecre= pvistaSecre;
        this.secretario = pSecretario;
        this.vistaSecre.btnAsignarCita.addActionListener(this);
        this.vistaSecre.btnCancelarCita.addActionListener(this);
    
        
    }

    public void iniciar(){  
    vistaSecre.setTitle("Modulo Secretario");
    vistaSecre.setLocationRelativeTo(null);    
  }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
 
        if (e.getSource() == vistaSecre.btnAsignarCita){
            AsignarCitaDoctor asignar = new AsignarCitaDoctor();
            CtrlAsignarCitaDoctor ctrlAsignacionCita = new CtrlAsignarCitaDoctor(asignar);
            ctrlAsignacionCita.iniciar();
            asignar.setVisible(true);
        }

      

        if (e.getSource() == vistaSecre.btnCancelarCita){
            Cancelar_Cita_Doctor cancelar = new Cancelar_Cita_Doctor();
            cancelar.setVisible(true);
        }

   
    }
    


    
    
    
    
    
   }
