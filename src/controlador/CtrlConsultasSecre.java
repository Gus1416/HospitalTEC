package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasSecretarioCRUD;
import vista.AuxVistasConsultas.Especialidad;
import vista.Consultas_Secretario;
import vista.AuxVistasConsultas.Estado;
import vista.AuxVistasConsultas.Rango_Fechas;
import vista.AuxVistasConsultas.Paciente;
import javax.swing.JOptionPane;
import modelo.ArrayList;
import modelo.Reportes;
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
    Reportes report;        
   
    
public CtrlConsultasSecre(Consultas_Secretario vista, ArrayList<Object[]>filas, ConsultasSecretarioCRUD consultas, Estado vistaAuxEstado, Rango_Fechas vistaAuxFechas, Paciente vistaAuxPaciente,  Especialidad vistaAuxEspecialidad, Reportes report){
    this.vista=vista;
    this.filas=filas;
    this.consultas=consultas;
    this.vistaAuxEstado=vistaAuxEstado;
    this.vistaAuxFechas= vistaAuxFechas;
    this.vistaAuxPaciente= vistaAuxPaciente;
    this.vistaAuxEspecialidad=vistaAuxEspecialidad;
    this.report=report; 
    this.vista.Cargar.addActionListener((ActionListener) this);
    this.vistaAuxEstado.cargarEstadoBtn.addActionListener(this);
    this.vistaAuxFechas.cargarEstadoBtn.addActionListener(this);
    this.vistaAuxPaciente.cargarCedulaBtn.addActionListener(this);
    this.vistaAuxEspecialidad.cargarbt.addActionListener(this);
    this.vista.btnCSV.addActionListener(this);
    this.vista.btnPDF.addActionListener(this);
    this.vista.btnHTML.addActionListener(this);
}
    

public void iniciar(){
    vista.setTitle("HospitalTec");
    vista.setLocationRelativeTo(null);
    
}
    public void citasTabla(){
        
   
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.Citas(); // Crear este m??todo 

    modeloR.addColumn("ID");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observaci??n");
    modeloR.addColumn("Estado");
    modeloR.addColumn("C??dula Paciente");

    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
    }
  }

    
    
 public void citasEstados(){
     
    String estado = (String) this.vistaAuxEstado.Estado.getText(); //datos que le entran
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.CitasEstado(estado); /// Crear este m??todo 

    modeloR.addColumn("ID_Cita");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observaci??n");
    modeloR.addColumn("Estado");
    modeloR.addColumn("C??dula Paciente");
     
    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
    }
 } 
     
 public void citasFechas(){
     
    String fecha1 = (String) this.vistaAuxFechas.fecha1_txt.getText();
    String fecha2 = (String) this.vistaAuxFechas.fecha2_txt.getText();//datos que le entran
    
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.CitasFechas(fecha1, fecha2); /// Crear este m??todo 

    modeloR.addColumn("ID_Cita");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observaci??n");
    modeloR.addColumn("Estado");
    modeloR.addColumn("C??dula Paciente");
     
    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
    }
 }
 
  public void citasPaciente(){
     
    String paciente = (String) this.vistaAuxPaciente.cedulatxt.getText(); //datos que le entran
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.CitasPaciente(paciente); /// Crear este m??todo 

    modeloR.addColumn("ID_Cita");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observaci??n");
    modeloR.addColumn("Estado");
    modeloR.addColumn("C??dula Paciente");
     
    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
        System.out.println(filas);
    }
 } 
  
   public void citasEspecialidad(){
     
    String especialidad = (String) this.vistaAuxEspecialidad.Especialidad.getText(); //datos que le entran
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.CitasEspecialidad(especialidad); /// Crear este m??todo 

    modeloR.addColumn("ID_Cita");
    modeloR.addColumn("ID_Area");
    modeloR.addColumn("Fecha y Hora");
    modeloR.addColumn("Observaci??n");
    modeloR.addColumn("Estado");
    modeloR.addColumn("C??dula Paciente");
     
    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
    }
 } 
   //Coloca los datos en la tabla
      public void hospitalizaciones(){
     
   
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.Hospitalizaciones();
  
    modeloR.addColumn("Numero Internado");
    modeloR.addColumn("C??digo del Centro");
    modeloR.addColumn("Id Diagn??stico");
    modeloR.addColumn("Fecha inicial");
    modeloR.addColumn("Fecha finalizaci??n");
    modeloR.addColumn("Servicio");
    modeloR.addColumn("C??dula del Funcionario");
    modeloR.addColumn("Cedula del Paciente");
    modeloR.addColumn("Fecha Seguimiento");
    modeloR.addColumn("Observacion");
    modeloR.addColumn("ID Tratamiento");

    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
    }
 } 
      public void hospitalizacionesFecha(){
     
    String fecha1 = (String) this.vistaAuxFechas.fecha1_txt.getText();
    String fecha2 = (String) this.vistaAuxFechas.fecha2_txt.getText();//datos que le entran
    
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.hospitalizacionFechas(fecha1, fecha2); /// Crear este m??todo 

    modeloR.addColumn("Numero Internado");
    modeloR.addColumn("C??digo del Centro");
    modeloR.addColumn("Id Diagn??stico");
    modeloR.addColumn("Fecha inicial");
    modeloR.addColumn("Fecha finalizaci??n");
    modeloR.addColumn("Servicio");
    modeloR.addColumn("C??dula del Funcionario");
    modeloR.addColumn("Cedula del Paciente");
    modeloR.addColumn("Fecha Seguimiento");
    modeloR.addColumn("Observacion");
    modeloR.addColumn("ID Tratamiento");
     
    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
    }
 }  
   public void hospitalizacionesEspecialidad(){
     
   
    String especialidad = (String) this.vistaAuxEspecialidad.Especialidad.getText();//datos que le entran
    
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.hospitalizacionEspecialidad(especialidad); /// Crear este m??todo 


    modeloR.addColumn("Numero Internado");
    modeloR.addColumn("C??digo del Centro");
    modeloR.addColumn("Id Diagn??stico");
    modeloR.addColumn("Especialidad");
    modeloR.addColumn("Fecha inicial");
    modeloR.addColumn("Fecha finalizaci??n");
    modeloR.addColumn("Servicio");
    modeloR.addColumn("C??dula del Funcionario");
    modeloR.addColumn("Cedula del Paciente");
    modeloR.addColumn("Fecha Seguimiento");
    modeloR.addColumn("Observacion");
    modeloR.addColumn("ID Tratamiento");

    
     
    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
    }
 } 
   
 public void hospitalizacionesPaciente(){
     
   
    String paciente = (String) this.vistaAuxPaciente.cedulatxt.getText();//datos que le entran
    
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vista.SecreTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = consultas.hospitalizacionPaciente(paciente); /// Crear este m??todo 


    modeloR.addColumn("Numero Internado");
    modeloR.addColumn("C??digo del Centro");
    modeloR.addColumn("Id Diagn??stico");

    modeloR.addColumn("Fecha inicial");
    modeloR.addColumn("Fecha finalizaci??n");
    modeloR.addColumn("Servicio");
    modeloR.addColumn("C??dula del Funcionario");
    modeloR.addColumn("Cedula del Paciente");
    modeloR.addColumn("Fecha Seguimiento");
    modeloR.addColumn("Observacion");
    modeloR.addColumn("ID Tratamiento");

    
     
    for (int i = 0; i < filas.size(); i++){
      modeloR.addRow(filas.get(i));
    }
 } 
@Override

 public void actionPerformed(ActionEvent e){
     
     // para generar CSV
     if (e.getSource()==vista.btnCSV){
         
         //CSV de citas
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Citas")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        list=consultas.Citas();

        report.exportarCSV("Citas General",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
             
        }
       if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Estado")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String estado= (this.vistaAuxEstado.Estado.getText());
        list=consultas.CitasEstado(estado);

        report.exportarCSV("Citas estado",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
       
       if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Rango de fechas")){
       ArrayList<Object[]> list= new ArrayList<Object[]>();
        String fecha1= (this.vistaAuxFechas.fecha1_txt.getText());
        String fecha2= (this.vistaAuxFechas.fecha2_txt.getText());
        
        list=consultas.CitasFechas(fecha1, fecha2);

        report.exportarCSV("Citas fecha",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
       
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Paciente")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
         String paciente= (this.vistaAuxPaciente.cedulatxt.getText());
    
        
          list=consultas.CitasPaciente(paciente);

        report.exportarCSV("Citas paciente",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
      
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Especialidad")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
         String especialidad= (this.vistaAuxEspecialidad.Especialidad.getText());
    
        
          list=consultas.CitasEspecialidad(especialidad);

        report.exportarCSV("Citas especialidad",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
      //CSV de hospitalizaciones      
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Hospitalizaciones")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
        
          list=consultas.Hospitalizaciones();

        report.exportarCSV("Hospitalizacion",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
        
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Rango de fechas")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String fecha1= (this.vistaAuxFechas.fecha1_txt.getText());
        String fecha2= (this.vistaAuxFechas.fecha2_txt.getText());
        
        list=consultas.hospitalizacionFechas(fecha1, fecha2);

        report.exportarCSV("Hospitalizacion fecha",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
     }
        
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Especialidad")){
      
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String especialidad= (this.vistaAuxEspecialidad.Especialidad.getText());
   
        
        list=consultas.hospitalizacionEspecialidad(especialidad);

        report.exportarCSV("Hospitalizacion especialidad",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
       
     }
      if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Paciente")){
          
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String paciente= (this.vistaAuxPaciente.cedulatxt.getText());
   
        
        list=consultas.hospitalizacionPaciente(paciente);

        report.exportarCSV("Hospitalizacion paciente",list);
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
      }
     }
     
     
     
     
     //PDF
     if (e.getSource()==vista.btnPDF){
      
         //PDF de citas
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Citas")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        list=consultas.Citas();

        report.exportarPDF(list, "Citas General");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
             
        }
       if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Estado")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String estado= (this.vistaAuxEstado.Estado.getText());
        list=consultas.CitasEstado(estado);

        report.exportarPDF(list, "Citas estado");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
       
       if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Rango de fechas")){
       ArrayList<Object[]> list= new ArrayList<Object[]>();
        String fecha1= (this.vistaAuxFechas.fecha1_txt.getText());
        String fecha2= (this.vistaAuxFechas.fecha2_txt.getText());
        
        list=consultas.CitasFechas(fecha1, fecha2);

        report.exportarPDF(list, "Citas fecha");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
       
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Paciente")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
         String paciente= (this.vistaAuxPaciente.cedulatxt.getText());
    
        
          list=consultas.CitasPaciente(paciente);

        report.exportarPDF(list, "Citas paciente");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
      
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Especialidad")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
         String especialidad= (this.vistaAuxEspecialidad.Especialidad.getText());
    
        
          list=consultas.CitasEspecialidad(especialidad);

        report.exportarPDF(list, "Citas especialidad");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
      //PDF de hospitalizaciones      
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Hospitalizaciones")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
        
          list=consultas.Hospitalizaciones();

        report.exportarPDF(list, "Hospitalizacion");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
        
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Rango de fechas")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String fecha1= (this.vistaAuxFechas.fecha1_txt.getText());
        String fecha2= (this.vistaAuxFechas.fecha2_txt.getText());
        
        list=consultas.hospitalizacionFechas(fecha1, fecha2);

        report.exportarPDF(list, "Hospitalizacion fecha");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
     }
        
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Especialidad")){
      
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String especialidad= (this.vistaAuxEspecialidad.Especialidad.getText());
   
        
        list=consultas.hospitalizacionEspecialidad(especialidad);

        report.exportarPDF(list, "Hospitalizacion especialidad");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
       
     }
      if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Paciente")){
          
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String paciente= (this.vistaAuxPaciente.cedulatxt.getText());
   
        
        list=consultas.hospitalizacionPaciente(paciente);

        report.exportarPDF(list, "Hospitalizacion paciente");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
      }
     }
      
      
      //HTML
      
      
       if (e.getSource()==vista.btnHTML){
      
         //PDF de citas
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Citas")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        list=consultas.Citas();

        report.exportarHTML(list, "Citas General");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
             
        }
         if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Estado")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String estado= (this.vistaAuxEstado.Estado.getText());
        list=consultas.CitasEstado(estado);

        report.exportarHTML(list,"Citas estado");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
       
       if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Rango de fechas")){
       ArrayList<Object[]> list= new ArrayList<Object[]>();
        String fecha1= (this.vistaAuxFechas.fecha1_txt.getText());
        String fecha2= (this.vistaAuxFechas.fecha2_txt.getText());
        
        list=consultas.CitasFechas(fecha1, fecha2);

        report.exportarHTML(list,"Citas fecha");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
       
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Paciente")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
         String paciente= (this.vistaAuxPaciente.cedulatxt.getText());
    
        
          list=consultas.CitasPaciente(paciente);

         report.exportarHTML(list,"Citas paciente");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
      
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Especialidad")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
         String especialidad= (this.vistaAuxEspecialidad.Especialidad.getText());
    
          list=consultas.CitasEspecialidad(especialidad);

        report.exportarHTML(list,"Citas especialidad");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
      //PDF de hospitalizaciones      
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Hospitalizaciones")){
         ArrayList<Object[]> list= new ArrayList<Object[]>();
        
          list=consultas.Hospitalizaciones();

        report.exportarHTML(list,"Hospitalizacion");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
        }
        
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Rango de fechas")){
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String fecha1= (this.vistaAuxFechas.fecha1_txt.getText());
        String fecha2= (this.vistaAuxFechas.fecha2_txt.getText());
        
        list=consultas.hospitalizacionFechas(fecha1, fecha2);

        report.exportarHTML(list,"Hospitalizacion fecha");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
     }
        
        if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Especialidad")){
      
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String especialidad= (this.vistaAuxEspecialidad.Especialidad.getText());
   
        
        list=consultas.hospitalizacionEspecialidad(especialidad);

        report.exportarHTML(list,"Hospitalizacion especialidad");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
       
     }
      if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Paciente")){
          
        ArrayList<Object[]> list= new ArrayList<Object[]>();
        String paciente= (this.vistaAuxPaciente.cedulatxt.getText());
   
        
        list=consultas.hospitalizacionPaciente(paciente);

        report.exportarHTML(list,"Hospitalizacion paciente");
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente");
      }
     }
     
     
     //---------------------------------------------------------------------------
     
     //Consultas citas en general
     if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Citas")){
         if (e.getSource()==vista.Cargar){
             vista.SecreTable.clearSelection();
             citasTabla();
         }
     }
     
     //Consulta cita seg??n estado
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Estado")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxEstado.setVisible(true);
            }
        
        if (e.getSource() == vistaAuxEstado.cargarEstadoBtn){
            vista.SecreTable.clearSelection();
            citasEstados();
           
             }
        }
       
        
 //Consulta cita seg??n fechas
       if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Rango de fechas")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxFechas.setVisible(true);
            }
    
        if (e.getSource() == vistaAuxFechas.cargarEstadoBtn){
            vista.SecreTable.clearSelection();
            citasFechas();
           
        }
  }
       
        
 //citas seg??n paciente
 
        if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Paciente")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxPaciente.setVisible(true);
            }
        
        if (e.getSource() == vistaAuxPaciente.cargarCedulaBtn){
            vista.SecreTable.clearSelection();
            citasPaciente();
           
        }
        }
 
 //citas seg??n especialidad
    if (vista.citasRadioButton.isSelected() && vista.citaComboBox.getSelectedItem().toString().equals("Especialidad")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxEspecialidad.setVisible(true);
            }
   
        if (e.getSource() == vistaAuxEspecialidad.cargarbt){
            vista.SecreTable.clearSelection();
            citasEspecialidad();
           
        }
    }
        
     // hospitalizaci??n general 
 if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Hospitalizaciones")){
         if (e.getSource()==vista.Cargar){
             vista.SecreTable.clearSelection();
             hospitalizaciones();
         }
     }
     
 
 
 // hospitalizaci??n seg??n fecha
  if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Rango de fechas")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxFechas.setVisible(true);
            }
    
        if (e.getSource() == vistaAuxFechas.cargarEstadoBtn){
            vista.SecreTable.clearSelection();
            hospitalizacionesFecha();
           
        }
  }
 
 //hospitalizaci??n por especialidad
  if (vista.hospitRadioButton.isSelected() && vista.hospitComboBox.getSelectedItem().toString().equals("Especialidad")){
     
           if (e.getSource()==vista.Cargar){
                vistaAuxEspecialidad.setVisible(true);
            }
    
        if (e.getSource() == vistaAuxEspecialidad.cargarbt){
            vista.SecreTable.clearSelection();
            hospitalizacionesEspecialidad();
           
        }
  }

  //hospitalizaci??n por paciente
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
 



