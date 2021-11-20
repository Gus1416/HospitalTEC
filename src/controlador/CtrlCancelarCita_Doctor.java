/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import modelo.ArrayList;
import modelo.Citas;
import modelo.CitasCRUD;
import modelo.Paciente;
import modelo.PacienteCRUD;
import vista.Cancelar_Cita_Doctor;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import modelo.EstadoCita;

/**
 *
 * @author sebcor
 */
public class CtrlCancelarCita_Doctor implements ActionListener {
    private  PacienteCRUD CRUDPaciente;
    private Citas cita;
    private  CitasCRUD CRUDcita;
    private Cancelar_Cita_Doctor vistaCancelar;

    public static ArrayList<Citas> citas;
    public static Date firstDate;
    public static Date secondDate;
    public static Citas auxdate;
    
    public CtrlCancelarCita_Doctor(PacienteCRUD CRUDPaciente, Citas cita, CitasCRUD CRUDcita, Cancelar_Cita_Doctor vistaCancelar) {
        this.CRUDPaciente = CRUDPaciente;
        this.cita = cita;
        this.CRUDcita = CRUDcita;
        this.vistaCancelar = vistaCancelar;
        this.vistaCancelar.btnCancelar.addActionListener(this);
        this.vistaCancelar.btnVolver.addActionListener(this);
        this.vistaCancelar.btnCargar.addActionListener(this);
    }

    public CtrlCancelarCita_Doctor() {
    }
    
    
    
    public void iniciar(){ 
        cargarPacientes();
        vistaCancelar.setTitle("Gestor de Planes de Estudio");
        vistaCancelar.setLocationRelativeTo(null);  
     }
     
    public void cargarPacientes(){      // Llenar los CB de Pacientes
    ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
        for (int i = 0; i < pacientes.size(); i++) {
          vistaCancelar.CBPaciente.addItem(pacientes.get(i).getNombre());
        }
    }
    
        
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vistaCancelar.btnCargar){
            String nombrePaciente= vistaCancelar.CBPaciente.getSelectedItem().toString();
            ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
            int flag= 0;
            int counter=0;
            
                for (int i = 0; i < pacientes.size(); i++) {
                    if(pacientes.get(i).getNombre().equals(nombrePaciente)){
                    flag= 1;
                    counter++;
                    }   
                    System.out.println("valor flag" + flag);
                    System.out.println("Valor Counter" + counter);
                }    
                    
                if(flag == 1){
                    citas= CRUDcita.consultarCitas(pacientes.get(counter-1).getCedula());
                     for (int z = 0; z < citas.size(); z++) {  
                        vistaCancelar.CBCita.addItem(Integer.toString(citas.get(z).getiDCita()));
                     }
                }      
                
            }
        
     
        
        if(e.getSource() == vistaCancelar.btnCancelar){
            int IDCITA = Integer.parseInt((String) vistaCancelar.CBCita.getSelectedItem());

            for (int i = 0; i < citas.size(); i++) {
                if(citas.get(i).getiDCita() == IDCITA ){
                    auxdate= citas.get(i);
                    System.out.println("Lo encontre bro: " + citas.get(i).getAuxdate());
                }
              System.out.println("ID NO COINCIDE CON EL DE LA LISTA");  
            }
           
            /// VALIDAR LA FECHA DE LA CITA SEA UN DIA ANTES COMO MINIMO PARA CANCELARLA
            LocalDate hoy = LocalDate.now();
            Date  fechacita = auxdate.getAuxdate();
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Date today = Date.from(hoy.atStartOfDay(defaultZoneId).toInstant());
            auxdate.setEstado(EstadoCita.CANCELADA_POR_MÉDICO);
            
            long diffInMillies = Math.abs(fechacita.getTime() - today.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            
            System.out.println("Diferencia entre fechas: " +  diff);
            
            if(diff>= 1){
                if (CRUDcita.CancelarCita(auxdate)){
                JOptionPane.showMessageDialog(null, "Cita Cancelada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al cancelar la cita la cita");
            }
                
            }
                         
        }
        
        
        if (e.getSource() == vistaCancelar.btnVolver){
          vistaCancelar.setVisible(false);
        }
            
                        
      }
        
        
        

    

    
  }




                
        
        
        
    

