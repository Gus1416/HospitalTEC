/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.ConsultasSecretarioCRUD;
import modelo.Doctor;
import modelo.Secretario;
import vista.AsignarCitaDoctor;
import vista.Atender_Cita_Doctor;
import vista.AuxVistasConsultas.Estado;
import vista.Cancelar_Cita_Doctor;
import vista.Consultas_Secretario;
import vista.ModuloSecretario;
import controlador.CtrlConsultasSecre;
import vista.AuxVistasConsultas.Especialidad;
import vista.AuxVistasConsultas.Rango_Fechas;
import vista.AuxVistasConsultas.Paciente;
import controlador.CtrlCancelarCita_Doctor;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.PacienteCRUD;

public class CtrlSecretario implements ActionListener {
    private ModuloSecretario vistaSecre;
    private Secretario secretario;
    private Consultas_Secretario vista_consulta;
   


    public CtrlSecretario(ModuloSecretario pvistaSecre, Secretario pSecretario) {
        this.vistaSecre= pvistaSecre;
        this.secretario = pSecretario;
        this.vista_consulta= vista_consulta;
      
        this.vistaSecre.btnAsignarCita.addActionListener(this);
        this.vistaSecre.btnCancelarCita.addActionListener(this);
        this.vistaSecre.btConsultas.addActionListener(this);
    
        
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
            PacienteCRUD CRUDPaciente = new PacienteCRUD();
            Citas cita = new  Citas ();
            CitasCRUD CRUDcita = new CitasCRUD();
            CtrlCancelarCita_Doctor ctrlCancelarCita = new CtrlCancelarCita_Doctor(CRUDPaciente,cita,CRUDcita,cancelar); 
            ctrlCancelarCita.iniciar();
            cancelar.setVisible(true);
        }

           if (e.getSource() == vistaSecre.btConsultas){
            Consultas_Secretario vista = new Consultas_Secretario();
            ConsultasSecretarioCRUD consultas= new ConsultasSecretarioCRUD();
            ArrayList<Object[]> filas = new ArrayList <Object[]>();
            Estado vistaAuxEstado = new Estado();
            Rango_Fechas vistaAuxFechas= new Rango_Fechas();
            Paciente vistaAuxPaciente = new Paciente();
            Especialidad vistaAuxEspecialidad= new  Especialidad();
            CtrlConsultasSecre ctrlconsultassecre= new CtrlConsultasSecre( vista,filas,consultas,vistaAuxEstado, vistaAuxFechas, vistaAuxPaciente, vistaAuxEspecialidad);
            vista.setVisible(true);
            ctrlconsultassecre.iniciar();
        }
   
    }
    


    
    
    
    
    
   }
