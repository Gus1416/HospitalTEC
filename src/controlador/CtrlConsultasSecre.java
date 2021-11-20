/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasSecretarioCRUD;
import java.util.ArrayList;
import vista.AuxVistasConsultas.Especialidad;
import vista.Consultas_Secretario;
import vista.AuxVistasConsultas.Estado;
import vista.AuxVistasConsultas.Rango_Fechas;
import vista.AuxVistasConsultas.Paciente;

/**
 *
 * @author Maria Laura
 */
public class CtrlConsultasSecre implements ActionListener {
    ConsultasSecretarioCRUD consultas;
    Consultas_Secretario  vista;
    ArrayList<Object[]> filas;
    Estado vistaAuxEstado;
    Rango_Fechas vistaAuxFechas;
    Paciente vistaAuxPaciente;
    Especialidad vistaAuxEspecialidad;
            
    
public CtrlConsultasSecre(Consultas_Secretario vista, ArrayList<Object[]>filas, ConsultasSecretarioCRUD consultas, Estado vistaAuxEstado, Rango_Fechas vistaAuxFechas, Paciente vistaAuxPaciente,  Especialidad vistaAuxEspecialidad){
    this.vista=vista;
    this.filas=filas;
    this.consultas=consultas;
    this.vistaAuxEstado=vistaAuxEstado;
    this.vistaAuxFechas= vistaAuxFechas;
    this.vistaAuxPaciente= vistaAuxPaciente;
    this.vistaAuxEspecialidad=vistaAuxEspecialidad;
    this.vista.Cargar.addActionListener((ActionListener) this);
    this.vistaAuxEstado.cargarEstadoBtn.addActionListener(this);
    this.vistaAuxFechas.cargarEstadoBtn.addActionListener(this);
    this.vistaAuxPaciente.cargarCedulaBtn.addActionListener(this);
    this.vistaAuxEspecialidad.cargarbt.addActionListener(this);
    
    
}
    

public void iniciar(){
    vista.setTitle("HospitalTec");
    vista.setLocationRelativeTo(null);
    
}
    public void citasTabla(){
        
   
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.Citas(); /// Crear este método 

    modeloR.addColumn("ID");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observación");
    modeloR.addColumn("Estado");
    modeloR.addColumn("Cédula Paciente");

    for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
  }

    
    
 public void citasEstados(){
     
    String estado = (String) this.vistaAuxEstado.Estado.getText(); //datos que le entran
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.CitasEstado(estado); /// Crear este método 

    modeloR.addColumn("ID_Cita");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observación");
    modeloR.addColumn("Estado");
    modeloR.addColumn("Cédula Paciente");
     
      for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
 } 
     
 public void citasFechas(){
     
    String fecha1 = (String) this.vistaAuxFechas.fecha1_txt.getText();
    String fecha2 = (String) this.vistaAuxFechas.fecha2_txt.getText();//datos que le entran
    
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.CitasFechas(fecha1, fecha2); /// Crear este método 

    modeloR.addColumn("ID_Cita");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observación");
    modeloR.addColumn("Estado");
    modeloR.addColumn("Cédula Paciente");
     
      for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
 }
 
  public void citasPaciente(){
     
    String paciente = (String) this.vistaAuxPaciente.cedulatxt.getText(); //datos que le entran
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.CitasPaciente(paciente); /// Crear este método 

    modeloR.addColumn("ID_Cita");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observación");
    modeloR.addColumn("Estado");
    modeloR.addColumn("Cédula Paciente");
     
      for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
 } 
  
   public void citasEspecialidad(){
     
    String especialidad = (String) this.vistaAuxEspecialidad.Especialidad.getText(); //datos que le entran
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.CitasEspecialidad(especialidad); /// Crear este método 

    modeloR.addColumn("ID_Cita");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observación");
    modeloR.addColumn("Estado");
    modeloR.addColumn("Cédula Paciente");
     
      for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
 } 
   //Coloca los datos en la tabla
      public void hospitalizaciones(){
     
   
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.Hospitalizaciones();
  
    modeloR.addColumn("Numero Internado");
    modeloR.addColumn("Código del Centro");
    modeloR.addColumn("Id Diagnóstico");
    modeloR.addColumn("Fecha inicial");
    modeloR.addColumn("Fecha finalización");
    modeloR.addColumn("Servicio");
    modeloR.addColumn("Cédula del Funcionario");
    modeloR.addColumn("Cedula del Paciente");
    modeloR.addColumn("Fecha Seguimiento");
    modeloR.addColumn("Observacion");
    modeloR.addColumn("ID Tratamiento");
    
    
    
    
    
     
      for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
 } 
      public void hospitalizacionesFecha(){
     
    String fecha1 = (String) this.vistaAuxFechas.fecha1_txt.getText();
    String fecha2 = (String) this.vistaAuxFechas.fecha2_txt.getText();//datos que le entran
    
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.hospitalizacionFechas(fecha1, fecha2); /// Crear este método 

    modeloR.addColumn("Numero Internado");
    modeloR.addColumn("Código del Centro");
    modeloR.addColumn("Id Diagnóstico");
    modeloR.addColumn("Fecha inicial");
    modeloR.addColumn("Fecha finalización");
    modeloR.addColumn("Servicio");
    modeloR.addColumn("Cédula del Funcionario");
    modeloR.addColumn("Cedula del Paciente");
    modeloR.addColumn("Fecha Seguimiento");
    modeloR.addColumn("Observacion");
    modeloR.addColumn("ID Tratamiento");
     
      for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
 }  
   public void hospitalizacionesEspecialidad(){
     
   
    String especialidad = (String) this.vistaAuxEspecialidad.Especialidad.getText();//datos que le entran
    
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.hospitalizacionEspecialidad(especialidad); /// Crear este método 


    modeloR.addColumn("Numero Internado");
    modeloR.addColumn("Código del Centro");
    modeloR.addColumn("Id Diagnóstico");
    modeloR.addColumn("Especialidad");
    modeloR.addColumn("Fecha inicial");
    modeloR.addColumn("Fecha finalización");
    modeloR.addColumn("Servicio");
    modeloR.addColumn("Cédula del Funcionario");
    modeloR.addColumn("Cedula del Paciente");
    modeloR.addColumn("Fecha Seguimiento");
    modeloR.addColumn("Observacion");
    modeloR.addColumn("ID Tratamiento");

    
     
      for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
 } 
   
 public void hospitalizacionesPaciente(){
     
   
    String paciente = (String) this.vistaAuxPaciente.cedulatxt.getText();//datos que le entran
    
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.hospitalizacionPaciente(paciente); /// Crear este método 


    modeloR.addColumn("Numero Internado");
    modeloR.addColumn("Código del Centro");
    modeloR.addColumn("Id Diagnóstico");

    modeloR.addColumn("Fecha inicial");
    modeloR.addColumn("Fecha finalización");
    modeloR.addColumn("Servicio");
    modeloR.addColumn("Cédula del Funcionario");
    modeloR.addColumn("Cedula del Paciente");
    modeloR.addColumn("Fecha Seguimiento");
    modeloR.addColumn("Observacion");
    modeloR.addColumn("ID Tratamiento");

    
     
      for (Object[] fila : filas){
      modeloR.addRow(fila);
        System.out.println(filas);
    }
 } 
@Override

 public void actionPerformed(ActionEvent e){
     //Consultas citas en general
     if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Citas")){
         if (e.getSource()==vista.Cargar){
             vista.SecreTable.clearSelection();
             citasTabla();
         }
     }
     
     //Consulta cita según estado
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Estado")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxEstado.setVisible(true);
            }
        
        if (e.getSource() == vistaAuxEstado.cargarEstadoBtn){
            vista.SecreTable.clearSelection();
            citasEstados();
           
             }
        }
       
        
 //Consulta cita según fechas
       if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Rango de fechas")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxFechas.setVisible(true);
            }
    
        if (e.getSource() == vistaAuxFechas.cargarEstadoBtn){
            vista.SecreTable.clearSelection();
            citasFechas();
           
        }
  }
       
        
 //citas según paciente
 
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Paciente")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxPaciente.setVisible(true);
            }
        
        if (e.getSource() == vistaAuxPaciente.cargarCedulaBtn){
            vista.SecreTable.clearSelection();
            citasPaciente();
           
        }
        }
 
 //citas según especialidad
    if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Especialidad")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxEspecialidad.setVisible(true);
            }
   
        if (e.getSource() == vistaAuxEspecialidad.cargarbt){
            vista.SecreTable.clearSelection();
            citasEspecialidad();
           
        }
    }
        
     // hospitalización general 
 if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Hospitalizaciones")){
         if (e.getSource()==vista.Cargar){
             vista.SecreTable.clearSelection();
             hospitalizaciones();
         }
     }
     
 
 
 // hospitalización según fecha
  if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Rango de fechas")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxFechas.setVisible(true);
            }
    
        if (e.getSource() == vistaAuxFechas.cargarEstadoBtn){
            vista.SecreTable.clearSelection();
            hospitalizacionesFecha();
           
        }
  }
 
 //hospitalización por especialidad
  if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Especialidad")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxEspecialidad.setVisible(true);
            }
    
        if (e.getSource() == vistaAuxEspecialidad.cargarbt){
            vista.SecreTable.clearSelection();
            hospitalizacionesEspecialidad();
           
        }
  }

  //hospitalización por paciente
  if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Paciente")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxPaciente.setVisible(true);
            }
    
        if (e.getSource() == vistaAuxPaciente.cargarCedulaBtn){
            vista.SecreTable.clearSelection();
            hospitalizacionesPaciente();
           
        }
  }
      }
 }


