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
import controlador.controladores_registros.CtrlRegistroDoctor;
import java.util.ArrayList;
import modelo.CentroAtencionCRUD;
import modelo.ConsultasDocCRUD;
import modelo.DoctorCRUD;
import vista.AsignarCitaDoctor;
import vista.Atender_Cita_Doctor;
import vista.Cancelar_Cita_Doctor;
import vista.Consultas_Doc;
import vista.Hospitalizacion;
import vista.ModuloDoctor;
import vistasConsultaDoc.VIEWPacienteNivel;
import vistasConsultaDoc.VIEWPacienteNombreD;
import vistasConsultaDoc.VIEWPacienteRangoFechas;
import vistasConsultaDoc.VIEWPacienteTratamientoNombre;
import vistasConsultaDoc.VIEWPacienteTratamientoTipo;

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
            CtrlRegistroDoctor auxMed = new CtrlRegistroDoctor();
            
            
            CtrlAsignarCita_Doctor ctrlAsignacionCita = new CtrlAsignarCita_Doctor(CRUDarea,CRUDPaciente,
            cita, CRUDcita,asignar, auxMed);
            ctrlAsignacionCita.iniciar();
            asignar.setVisible(true);
        }

        if (e.getSource() == vistaDoc.btnAtenderCita){
            Atender_Cita_Doctor atender = new Atender_Cita_Doctor();
            TratamientoCRUD CRUDTratamiento = new TratamientoCRUD();
            PacienteCRUD CRUDPaciente = new PacienteCRUD ();       
            DiagnosticoCRUD CRUDDiagnostico = new  DiagnosticoCRUD(); 
            CitasCRUD CRUDcita = new CitasCRUD();
            Hospitalizacion internar = new Hospitalizacion(); 
            AreaCRUD areaCrud = new AreaCRUD();
            CentroAtencionCRUD centroCrud = new CentroAtencionCRUD();
            CtrlRegistroDoctor auxMedi = new CtrlRegistroDoctor ();
            DoctorCRUD doctorCrud = new DoctorCRUD();
            CtrlInicioSesion session = new CtrlInicioSesion ();
            
            CtrlAtenderCita_Doctor ctrlAtenderCita = new CtrlAtenderCita_Doctor(CRUDTratamiento,CRUDPaciente,
            CRUDDiagnostico,atender,CRUDcita,internar,areaCrud,centroCrud,auxMedi,doctorCrud,session);
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
        
        
        if (e.getSource() == vistaDoc.btnConsultasDoctor){
            
            Consultas_Doc vistaConsultaDoc = new Consultas_Doc();
            ArrayList<Object[]> filas = new ArrayList<Object[]> ();
            ConsultasDocCRUD CRUDConsultaDOC = new ConsultasDocCRUD();
            VIEWPacienteNivel dataNivel = new VIEWPacienteNivel();
            VIEWPacienteNombreD dataNombreD = new  VIEWPacienteNombreD();
            VIEWPacienteRangoFechas datarangoDateD = new VIEWPacienteRangoFechas();
            VIEWPacienteTratamientoNombre dataTrataName = new VIEWPacienteTratamientoNombre();
            VIEWPacienteTratamientoTipo dataTrataType = new VIEWPacienteTratamientoTipo();
            
            CtrlConsultasDoc ctrlconsultadoc = new CtrlConsultasDoc (vistaConsultaDoc,filas,
            dataNivel,CRUDConsultaDOC,dataNombreD,datarangoDateD,dataTrataName,dataTrataType);
            
            ctrlconsultadoc.iniciar();
            vistaConsultaDoc.setVisible(true);


        }
        
        
        
        
        
        

   
    }
    


    
    
    
    
    
   }
