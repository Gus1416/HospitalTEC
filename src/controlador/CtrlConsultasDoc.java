/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
//import modelo.ArrayList;
import modelo.ConsultasDocCRUD;
import vista.Consultas_Doc;
import vistasConsultaDoc.VIEWPacienteNombreD;
import java.util.ArrayList;
import java.util.Date;
import vistasConsultaDoc.VIEWPacienteNivel;
import vistasConsultaDoc.VIEWPacienteRangoFechas;
import vistasConsultaDoc.VIEWPacienteTratamientoNombre;
import vistasConsultaDoc.VIEWPacienteTratamientoTipo;

/**
 *
 * @author sebcor
 */
public class CtrlConsultasDoc implements ActionListener {
    private ConsultasDocCRUD CRUDConsultaDOC;
    private Consultas_Doc vistaConsultaDoc;
    private ArrayList<Object[]> filas;
    private VIEWPacienteNivel dataNivel;
    private VIEWPacienteNombreD dataNameD;
    private VIEWPacienteRangoFechas dataRangeDateD;
    private VIEWPacienteTratamientoNombre dataTrataName;
    private VIEWPacienteTratamientoTipo dataTrataTipo;


    public CtrlConsultasDoc() {
    }
    

    public CtrlConsultasDoc(Consultas_Doc vistaConsultaDoc, ArrayList<Object[]> filas, VIEWPacienteNivel dataNivel,
            ConsultasDocCRUD CRUDConsultaDOC, VIEWPacienteNombreD dataNameD,VIEWPacienteRangoFechas dataRangeDateD,
            VIEWPacienteTratamientoNombre dataTrataName, VIEWPacienteTratamientoTipo dataTrataTipo) {
        
        this.vistaConsultaDoc = vistaConsultaDoc;
        this.filas = filas;
        this.dataNivel = dataNivel;
        this.dataNameD = dataNameD;
        this.dataRangeDateD=dataRangeDateD;
        this.dataTrataName= dataTrataName;
        this.dataTrataTipo = dataTrataTipo;
        this.CRUDConsultaDOC = CRUDConsultaDOC;
        this.vistaConsultaDoc.btnSHOW.addActionListener(this);
        this.dataNivel.btnConsuLvlPaci.addActionListener(this);
        this.dataNameD.btnConsuNombreD.addActionListener(this);
        this.dataRangeDateD.btnConsulDateRPacien.addActionListener(this);
        this.dataTrataName.btnConsuTrataName.addActionListener(this);
        this.dataTrataTipo.btnConsuTrataTipo.addActionListener(this);
    }
    
    
    public void iniciar(){ 
        vistaConsultaDoc.setTitle("Hospital TEC");
        vistaConsultaDoc.setLocationRelativeTo(null);  
    }
    
   
    public void TablePacienteNivel() {

        String ced = (String) this.dataNivel.TFCedNivel.getText();   // Esta seria la data de la tablilla de datos
        String lvl = (String) this.dataNivel.TFNivel.getText();
        DefaultTableModel modeloC = new DefaultTableModel();
        
        System.out.println("Cedula que me llega: " +  ced);
        System.out.println("Nivel que me llega: " +  lvl);

        this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
        this.filas = CRUDConsultaDOC.PacienteDiagnosticoNivel(ced, lvl); /// Montarle al modelo el resultado de la consulta

        modeloC.addColumn("Cedula Paciente");
        modeloC.addColumn("Nivel");
        modeloC.addColumn("Observaciones");
        modeloC.addColumn("Tratamiento");
        modeloC.addColumn("Dosis");
        modeloC.addColumn("Tipo Tratamiento");
        modeloC.addColumn("Nombre Diagnostico");
        modeloC.addColumn("Fecha");

        for (Object[] fila : filas) {
            modeloC.addRow(fila);
        }
    }
    
    
    
    public void TablePacienteNombreD() {

        String ced = (String) this.dataNameD.TFCedNameD.getText();   // Esta seria la data de la tablilla de datos
        String name = (String) this.dataNameD.TFNombreD.getText();
        DefaultTableModel modeloC = new DefaultTableModel();
        
        System.out.println("Cedula que me llega: " +  ced);
        System.out.println("Nombre que me llega: " +  name);

        this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
        this.filas = CRUDConsultaDOC.PacienteDiagnosticoNombreD(ced, name); /// Montarle al modelo el resultado de la consulta

        modeloC.addColumn("Cedula Paciente");
        modeloC.addColumn("Nivel");
        modeloC.addColumn("Observaciones");
        modeloC.addColumn("Tratamiento");
        modeloC.addColumn("Dosis");
        modeloC.addColumn("Tipo Tratamiento");
        modeloC.addColumn("Nombre Diagnostico");
        modeloC.addColumn("Fecha");

        for (Object[] fila : filas) {
            modeloC.addRow(fila);
        }
    }
    
    
    public void TablePacienteDateRange() {

        String ced = (String) this.dataRangeDateD.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        Date date1 =  this.dataRangeDateD.FechaP1.getDate();
        Date date2 =  this.dataRangeDateD.FechaP2.getDate();
        DefaultTableModel modeloC = new DefaultTableModel();
        
        System.out.println("Cedula que me llega: " +  ced);
        System.out.println("Fecha1 que me llega: " +  date1);
        System.out.println("Fecha2 que me llega: " +  date2);

        this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
        this.filas = CRUDConsultaDOC.PacienteDiagnosticoDateRange(ced, date1,date2); /// Montarle al modelo el resultado de la consulta

        modeloC.addColumn("Cedula Paciente");
        modeloC.addColumn("Nivel");
        modeloC.addColumn("Observaciones");
        modeloC.addColumn("Tratamiento");
        modeloC.addColumn("Dosis");
        modeloC.addColumn("Tipo Tratamiento");
        modeloC.addColumn("Nombre Diagnostico");
        modeloC.addColumn("Fecha");

        for (Object[] fila : filas) {
            modeloC.addRow(fila);
        }
    }
    
    
    public void TablePacienteTratamientoNombre() {

        String ced = (String) this.dataTrataName.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        String nombre = (String) this.dataTrataName.TFNameTrata.getText();
        DefaultTableModel modeloC = new DefaultTableModel();
        
        System.out.println("Cedula que me llega: " +  ced);
        System.out.println("Nombre del Tratamiento que me llega: " +  nombre);

        this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
        this.filas = CRUDConsultaDOC.PacienteTratamientoNombre(ced,nombre); /// Montarle al modelo el resultado de la consulta

        modeloC.addColumn("Cedula Paciente");
        modeloC.addColumn("Nivel");
        modeloC.addColumn("Observaciones");
        modeloC.addColumn("Tratamiento");
        modeloC.addColumn("Dosis");
        modeloC.addColumn("Tipo Tratamiento");
        modeloC.addColumn("Nombre Diagnostico");
        modeloC.addColumn("Fecha");

        for (Object[] fila : filas) {
            modeloC.addRow(fila);
        }
    }
    
    
    public void TablePacienteTratamientoTipo() {

        String ced = (String) this.dataTrataTipo.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        String tipo = (String) this.dataTrataTipo.TFTipoTrata.getText();
        DefaultTableModel modeloC = new DefaultTableModel();
        
        System.out.println("Cedula que me llega: " +  ced);
        System.out.println("Tipo de Tratamiento que me llega: " +  tipo);

        this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
        this.filas = CRUDConsultaDOC.PacienteTratamientoTipo(ced,tipo); /// Montarle al modelo el resultado de la consulta

        modeloC.addColumn("Cedula Paciente");
        modeloC.addColumn("Nivel");
        modeloC.addColumn("Observaciones");
        modeloC.addColumn("Tratamiento");
        modeloC.addColumn("Dosis");
        modeloC.addColumn("Tipo Tratamiento");
        modeloC.addColumn("Nombre Diagnostico");
        modeloC.addColumn("Fecha");
        modeloC.addColumn("Tipo");


        for (Object[] fila : filas) {
            modeloC.addRow(fila);
        }
    }
    
  
    public void TablePacienteTratamientoDateRange() {

        String ced = (String) this.dataRangeDateD.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        Date date1 =  this.dataRangeDateD.FechaP1.getDate();
        Date date2 =  this.dataRangeDateD.FechaP2.getDate();
        DefaultTableModel modeloC = new DefaultTableModel();
        
        System.out.println("Cedula que me llega: " +  ced);
        System.out.println("Fecha1 que me llega: " +  date1);
        System.out.println("Fecha2 que me llega: " +  date2);

        this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
        this.filas = CRUDConsultaDOC.PacienteDiagnosticoDateRange(ced, date1,date2); /// Montarle al modelo el resultado de la consulta

        modeloC.addColumn("Cedula Paciente");
        modeloC.addColumn("Nivel");
        modeloC.addColumn("Observaciones");
        modeloC.addColumn("Tratamiento");
        modeloC.addColumn("Dosis");
        modeloC.addColumn("Tipo Tratamiento");
        modeloC.addColumn("Nombre Diagnostico");
        modeloC.addColumn("Fecha");

        for (Object[] fila : filas) {
            modeloC.addRow(fila);
        }
    }
    
    
    
    

    
    
    
    
    
    
    
    
  
    
    
  @Override
  public void actionPerformed(ActionEvent e) {

    // Diagnóstico de paciente según tipo de Nivel 
    if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
            && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Nivel"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataNivel.setVisible(true);
      }
      if (e.getSource() == dataNivel.btnConsuLvlPaci)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TablePacienteNivel();
      }
    }

    // Diagnóstico de paciente según Nombre de Diagnóstico
    if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
            && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Nombre"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataNameD.setVisible(true);
      }
      if (e.getSource() == dataNameD.btnConsuNombreD)
      {
        System.out.println("ESTOY ENTRANDO BRO");
        vistaConsultaDoc.DocTable.clearSelection();
        TablePacienteDateRange();
      }

    }

    // Diagnóstico de paciente según Rango de Fechas 
    if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
            && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Rango de Fechas"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataRangeDateD.setVisible(true);
      }
      if (e.getSource() == dataRangeDateD.btnConsulDateRPacien)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TablePacienteDateRange();
      }

    }

    // Diagnóstico de paciente según nombre de tratamiento 
    if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
            && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Nombre"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataTrataName.setVisible(true);
      }
      if (e.getSource() == dataTrataName.btnConsuTrataName)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TablePacienteTratamientoNombre();
      }

    }

    // Diagnóstico de paciente según tipo de tratamiento 
    if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
            && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Tipo"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataTrataTipo.setVisible(true);
      }
      if (e.getSource() == dataTrataTipo.btnConsuTrataTipo)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        System.out.println("Estoy llegando bien acá");
        TablePacienteTratamientoTipo();
      }

    }

    // Tratamientos de paciente según Rango de Fechas 
    if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
            && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Rango de Fechas"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataRangeDateD.setVisible(true);
      }
      if (e.getSource() == dataRangeDateD.btnConsulDateRPacien)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TablePacienteDateRange();
      }

    }

  }

}


   