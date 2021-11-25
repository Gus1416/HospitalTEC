package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.ArrayList;
import modelo.ConsultasDocCRUD;
import vista.Consultas_Doc;
import vistasConsultaDoc.VIEWPacienteNombreD;
//import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Reportes;
import vistasConsultaDoc.VIEWCantCitaEspe;
import vistasConsultaDoc.VIEWCantCitaEstado;
import vistasConsultaDoc.VIEWCantCitaRangoFecha;
import vistasConsultaDoc.VIEWCantDiagNivel;
import vistasConsultaDoc.VIEWCantDiagPaciente;
import vistasConsultaDoc.VIEWCantTrataEspe;
import vistasConsultaDoc.VIEWCantTrataTipo;
import vistasConsultaDoc.VIEWCantTrataPaci;
import vistasConsultaDoc.VIEWCantTrataGeneral;
import vistasConsultaDoc.VIEWHospiPaciente;
import vistasConsultaDoc.VIEWPacienteNivel;
import vistasConsultaDoc.VIEWPacienteRangoFechas;
import vistasConsultaDoc.VIEWPacienteTratamientoNombre;
import vistasConsultaDoc.VIEWPacienteTratamientoRangoFechas;
import vistasConsultaDoc.VIEWPacienteTratamientoTipo;

/**
 * Controlador para las consutlas del doctor
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
  private VIEWPacienteTratamientoRangoFechas dataTrataRange;
  private VIEWCantCitaEspe dataCitaEspe;
  private VIEWCantCitaEstado dataCitaEstate;
  private VIEWCantCitaRangoFecha dataCitaDateR;
  private VIEWCantDiagNivel dataDiagNivel;
  private VIEWCantDiagPaciente dataDiagPaciente;
  private VIEWCantTrataEspe dataTrataEspe;
  private VIEWCantTrataTipo dataTratamiTipo;
  private VIEWCantTrataPaci dataTrataPaci;
  private VIEWCantTrataGeneral dataTrataGen;
  private VIEWHospiPaciente dataHospPaci;
  private Reportes report;

  /**
   * Constructor por defecto
   */
  public CtrlConsultasDoc() {
  }

  /**
   * Constructor con parámetros
   * 
   * @param vistaConsultaDoc
   * @param filas
   * @param dataNivel
   * @param CRUDConsultaDOC
   * @param dataNameD
   * @param dataRangeDateD
   * @param dataTrataName
   * @param dataTrataTipo
   * @param dataTrataRange
   * @param dataCitaEspe
   * @param dataCitaEstate
   * @param dataCitaDateR
   * @param dataDiagNivel
   * @param dataDiagPaciente
   * @param dataTrataEspe
   * @param dataTratamiTipo
   * @param dataTrataPaci
   * @param dataTrataGen
   * @param dataHospPaci
   * @param report 
   */
  public CtrlConsultasDoc(Consultas_Doc vistaConsultaDoc, ArrayList<Object[]> filas, VIEWPacienteNivel dataNivel,
          ConsultasDocCRUD CRUDConsultaDOC, VIEWPacienteNombreD dataNameD, VIEWPacienteRangoFechas dataRangeDateD,
          VIEWPacienteTratamientoNombre dataTrataName, VIEWPacienteTratamientoTipo dataTrataTipo,
          VIEWPacienteTratamientoRangoFechas dataTrataRange, VIEWCantCitaEspe dataCitaEspe, VIEWCantCitaEstado dataCitaEstate,
          VIEWCantCitaRangoFecha dataCitaDateR, VIEWCantDiagNivel dataDiagNivel, VIEWCantDiagPaciente dataDiagPaciente,
          VIEWCantTrataEspe dataTrataEspe, VIEWCantTrataTipo dataTratamiTipo, VIEWCantTrataPaci dataTrataPaci, VIEWCantTrataGeneral dataTrataGen,
          VIEWHospiPaciente dataHospPaci, Reportes report) {

    this.vistaConsultaDoc = vistaConsultaDoc;
    this.filas = filas;
    this.dataNivel = dataNivel;
    this.dataNameD = dataNameD;
    this.dataRangeDateD = dataRangeDateD;
    this.dataTrataName = dataTrataName;
    this.dataTrataTipo = dataTrataTipo;
    this.dataTrataRange = dataTrataRange;
    this.dataCitaEspe = dataCitaEspe;
    this.dataCitaEstate = dataCitaEstate;
    this.dataCitaDateR = dataCitaDateR;
    this.dataDiagNivel = dataDiagNivel;
    this.dataDiagPaciente = dataDiagPaciente;
    this.dataTrataEspe = dataTrataEspe;
    this.dataTratamiTipo = dataTratamiTipo;
    this.dataTrataPaci = dataTrataPaci;
    this.dataTrataGen = dataTrataGen;
    this.dataHospPaci = dataHospPaci;
    this.report = report;

    this.CRUDConsultaDOC = CRUDConsultaDOC;
    this.vistaConsultaDoc.btnSHOW.addActionListener(this);
    this.vistaConsultaDoc.btnCSV.addActionListener(this);
    this.vistaConsultaDoc.btnPDF.addActionListener(this);
    this.vistaConsultaDoc.btnHTML.addActionListener(this);
    this.dataNivel.btnConsuLvlPaci.addActionListener(this);
    this.dataNameD.btnConsuNombreD.addActionListener(this);
    this.dataRangeDateD.btnConsulDateRPacien.addActionListener(this);
    this.dataTrataName.btnConsuTrataName.addActionListener(this);
    this.dataTrataTipo.btnConsuTrataTipo.addActionListener(this);
    this.dataTrataRange.btnConsulDateRPacienT.addActionListener(this);
    this.dataCitaEspe.btnConsuCitaEspe.addActionListener(this);
    this.dataCitaEstate.btnConsuCitaEstate.addActionListener(this);
    this.dataCitaDateR.btnConsulDateRCita.addActionListener(this);
    this.dataDiagNivel.btnConsuDiagLvl.addActionListener(this);
    this.dataDiagPaciente.btnConsuPaciDiag.addActionListener(this);
    this.dataTrataEspe.btnConsuTrataEspe.addActionListener(this);
    this.dataTrataGen.btnConsuTrataGen.addActionListener(this);
    this.dataTratamiTipo.btnConsuTrataTipo.addActionListener(this);
    this.dataTrataPaci.btnConsultPaci.addActionListener(this);
    this.dataHospPaci.btnConsuHospi.addActionListener(this);

  }

  /**
   * Inicia la ventana
   */
  public void iniciar() {
    vistaConsultaDoc.setTitle("Hospital TEC");
    vistaConsultaDoc.setLocationRelativeTo(null);
  }

  /**
   * Tablas de la ventana.
   */
  public void TablePacienteNivel() {

    String ced = (String) this.dataNivel.TFCedNivel.getText();   // Esta seria la data de la tablilla de datos
    String lvl = (String) this.dataNivel.TFNivel.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Cedula que me llega: " + ced);
    System.out.println("Nivel que me llega: " + lvl);

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

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TablePacienteNombreD() {

    String ced = (String) this.dataNameD.TFCedNameD.getText();   // Esta seria la data de la tablilla de datos
    String name = (String) this.dataNameD.TFNombreD.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Cedula que me llega: " + ced);
    System.out.println("Nombre que me llega: " + name);

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

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TablePacienteDateRange() {

    String ced = (String) this.dataRangeDateD.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
    Date date1 = this.dataRangeDateD.FechaP1.getDate();
    Date date2 = this.dataRangeDateD.FechaP2.getDate();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Cedula que me llega: " + ced);
    System.out.println("Fecha1 que me llega: " + date1);
    System.out.println("Fecha2 que me llega: " + date2);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.PacienteDiagnosticoDateRange(ced, date1, date2); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cedula Paciente");
    modeloC.addColumn("Nivel");
    modeloC.addColumn("Observaciones");
    modeloC.addColumn("Tratamiento");
    modeloC.addColumn("Dosis");
    modeloC.addColumn("Tipo Tratamiento");
    modeloC.addColumn("Nombre Diagnostico");
    modeloC.addColumn("Fecha");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TablePacienteTratamientoNombre() {

    String ced = (String) this.dataTrataName.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
    String nombre = (String) this.dataTrataName.TFNameTrata.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Cedula que me llega: " + ced);
    System.out.println("Nombre del Tratamiento que me llega: " + nombre);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.PacienteTratamientoNombre(ced, nombre); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cedula Paciente");
    modeloC.addColumn("Nivel");
    modeloC.addColumn("Observaciones");
    modeloC.addColumn("Tratamiento");
    modeloC.addColumn("Dosis");
    modeloC.addColumn("Tipo Tratamiento");
    modeloC.addColumn("Nombre Diagnostico");
    modeloC.addColumn("Fecha");

      for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TablePacienteTratamientoTipo() {

    String ced = (String) this.dataTrataTipo.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
    String tipo = (String) this.dataTrataTipo.TFTipoTrata.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Cedula que me llega: " + ced);
    System.out.println("Tipo de Tratamiento que me llega: " + tipo);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.PacienteTratamientoTipo(ced, tipo); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cedula Paciente");
    modeloC.addColumn("Nivel");
    modeloC.addColumn("Observaciones");
    modeloC.addColumn("Tratamiento");
    modeloC.addColumn("Dosis");
    modeloC.addColumn("Tipo Tratamiento");
    modeloC.addColumn("Nombre Diagnostico");
    modeloC.addColumn("Fecha");
    modeloC.addColumn("Tipo");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TablePacienteTratamientoDateRange() {

    String ced = (String) this.dataTrataRange.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
    Date date1 = this.dataTrataRange.FechaPT1.getDate();
    Date date2 = this.dataTrataRange.FechaPT2.getDate();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Cedula que me llega: " + ced);
    System.out.println("Fecha1 que me llega: " + date1);
    System.out.println("Fecha2 que me llega: " + date2);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.PacienteDiagnosticoTrataDateRange(ced, date1, date2); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cedula Paciente");
    modeloC.addColumn("Nivel");
    modeloC.addColumn("Observaciones");
    modeloC.addColumn("Tratamiento");
    modeloC.addColumn("Dosis");
    modeloC.addColumn("Tipo Tratamiento");
    modeloC.addColumn("Nombre Diagnostico");
    modeloC.addColumn("Fecha");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableCitaEspecialidad() {

    // Esta seria la data de la tablilla de datos
    String especial = (String) this.dataCitaEspe.TFNombreEspe.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Especialidad que me llega: " + especial);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.CitaEspecialidad(especial); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad según especialidad");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableCitaEstado() {

    // Esta sería la data de la tablilla de datos
    String estado = (String) this.dataCitaEstate.TFEstadoCita.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Especialidad que me llega: " + estado);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.CitaEstado(estado); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad según estado");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableCitaRangoFecha() {

    // Esta sería la data de la tablilla de datos
    Date date1 = this.dataCitaDateR.FechaPC1.getDate();
    Date date2 = this.dataCitaDateR.FechaPC2.getDate();
    DefaultTableModel modeloC = new DefaultTableModel();

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.CitaRangoFechas(date1, date2); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad de citas según rango de fecha");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableDiagNivel() {

    // Esta sería la data de la tablilla de datos
    String nivel = (String) this.dataDiagNivel.TFNombreDiag.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Este es el nivel que me llega: " + nivel);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.DiagCantNivel(nivel); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad según nivel de diágnostico");

     for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableDiagPaciente() {

    // Esta sería la data de la tablilla de datos
    int paciente = Integer.parseInt(this.dataDiagPaciente.TFCedPaci.getText());
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Paciente que me llega: " + paciente);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.DiagCantPaciente(paciente); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad de diágnostico según paciente");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableTrataPaciente() {

    // Esta sería la data de la tablilla de datos
    int paciente = Integer.parseInt(this.dataTrataPaci.TFCedPaci.getText());
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Paciente que me llega: " + paciente);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.TrataCantPaciente(paciente); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad de tratamientos según paciente");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableTrataEspecialidad() {

    // Esta sería la data de la tablilla de datos
    String especialidad = (String) dataTrataEspe.TFNombreEspe.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Paciente que me llega: " + especialidad);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.TrataCantEspecialidad(especialidad);/// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad de especialidad según paciente");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableTrataTipo() {

    // Esta sería la data de la tablilla de datos
    String tipo = dataTratamiTipo.TFTipoTrata.getText();
    DefaultTableModel modeloC = new DefaultTableModel();

    System.out.println("Tipo de tratamiento que me llega: " + tipo);

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.TrataCantTipo(tipo); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad de tratamientos según tipo");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableTrataGen() {

    // Esta sería la data de la tablilla de datos
    DefaultTableModel modeloC = new DefaultTableModel();

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.TrataConteGen(); /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Cantidad Total de Tratamientos");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }
  }

  public void TableTrataHosp() {

    // Esta sería la data de la tablilla de datos
    int paciente = Integer.parseInt(this.dataHospPaci.TFCedPaci.getText());
    DefaultTableModel modeloC = new DefaultTableModel();

    this.vistaConsultaDoc.DocTable.setModel(modeloC);  // Montar en la tabla el modelo en null
    this.filas = CRUDConsultaDOC.HospiPaci(paciente);  /// Montarle al modelo el resultado de la consulta

    modeloC.addColumn("Numero Internado");
    modeloC.addColumn("Código Centro");
    modeloC.addColumn("Diágnostico");
    modeloC.addColumn("Fecha Inicio");
    modeloC.addColumn("Fecha Final");
    modeloC.addColumn("Servicio");
    modeloC.addColumn("Cedula Funcionario");
    modeloC.addColumn("Cedula Paciente");
//    modeloC.addColumn("Fecha Seguimiento");
//    modeloC.addColumn("Observacion");
//    modeloC.addColumn("Tratamiento");

    for (int i = 0; i < filas.size(); i++){
      modeloC.addRow(filas.get(i));
    }

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == vistaConsultaDoc.btnHTML)
    {

      // Consulta Hospitalización de Paciente
      if (vistaConsultaDoc.RADIOHOSP.isSelected()
              && vistaConsultaDoc.CBHospitalizacion.getSelectedItem().toString().equals("Detalle General de Paciente"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataHospPaci.TFCedPaci.getText());
        list = CRUDConsultaDOC.HospiPaci(paciente);
        report.exportarHTML(list, "HospiPaci");

      }

      //Conteo General de Tratamientos 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Conteo General"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list = CRUDConsultaDOC.TrataConteGen();
        report.exportarHTML(list, "Gen Trata");
      }

      //Cant de Tratamientos según Tipo 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Tipo"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String tipo = dataTratamiTipo.TFTipoTrata.getText();
        list = CRUDConsultaDOC.TrataCantTipo(tipo);
        report.exportarHTML(list, "Cant Trata Tipo");

      }

      //Cant Tratamientos según especialidad
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Especialidad"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String especialidad = (String) dataTrataEspe.TFNombreEspe.getText();
        list = CRUDConsultaDOC.TrataCantEspecialidad(especialidad);
        report.exportarHTML(list, "Cant Trata Espe");
      }

      //Cant Tratamientos según Paciente 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Paciente"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataTrataPaci.TFCedPaci.getText());
        list = CRUDConsultaDOC.TrataCantPaciente(paciente);
        report.exportarHTML(list, "Cant Trata Paci");
      }

      //Cant Diagnosticos según Paciente
      if (vistaConsultaDoc.RADIODIAG.isSelected()
              && vistaConsultaDoc.CBDiagnosticos.getSelectedItem().toString().equals("Cantidad según Paciente"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataDiagPaciente.TFCedPaci.getText());
        list = CRUDConsultaDOC.DiagCantPaciente(paciente);
        report.exportarHTML(list, "Cant Diag Paci");
      }

      //Cant Diagnosticos según Nivel 
      if (vistaConsultaDoc.RADIODIAG.isSelected()
              && vistaConsultaDoc.CBDiagnosticos.getSelectedItem().toString().equals("Cantidad según Nivel"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String nivel = (String) this.dataDiagNivel.TFNombreDiag.getText();
        list = CRUDConsultaDOC.DiagCantNivel(nivel);
        report.exportarHTML(list, "Cant Diag Nivel");
      }

      //Cantidad de citas según  Rango de Fechas 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        Date date1 = this.dataCitaDateR.FechaPC1.getDate();
        Date date2 = this.dataCitaDateR.FechaPC2.getDate();
        list = CRUDConsultaDOC.CitaRangoFechas(date1, date2);
        report.exportarHTML(list, "Cant Cita Rango");
      }

      //Cantidad de citas según Estado 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Estado"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String estado = (String) this.dataCitaEstate.TFEstadoCita.getText();
        list = CRUDConsultaDOC.CitaEstado(estado);
        report.exportarHTML(list, "Cant Citas Estado");
      }

      // Cantidad de citas según Especialidad 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Especialidad"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String especial = (String) this.dataCitaEspe.TFNombreEspe.getText();
        list = CRUDConsultaDOC.CitaEspecialidad(especial);
        report.exportarHTML(list, "Cant Citas Especialidad");
      }

      //Tratamientos de un paciente por rango de fechas 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataRange.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        Date date1 = this.dataTrataRange.FechaPT1.getDate();
        Date date2 = this.dataTrataRange.FechaPT2.getDate();
        list = CRUDConsultaDOC.PacienteDiagnosticoTrataDateRange(ced, date1, date2);
        report.exportarHTML(list, "Trata Paci Fechas");
      }

      //Tratamientos de un paciente por tipo de tratamiento
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Tipo"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataTipo.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        String tipo = (String) this.dataTrataTipo.TFTipoTrata.getText();
        list = CRUDConsultaDOC.PacienteTratamientoTipo(ced, tipo);
        report.exportarHTML(list, "Trata Paci Tipo");
      }

      // Tratamientos de un paciente según nombre de tratamiento
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Nombre"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataName.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        String nombre = (String) this.dataTrataName.TFNameTrata.getText();
        list = CRUDConsultaDOC.PacienteTratamientoNombre(ced, nombre);
        report.exportarHTML(list, "Trata Paci Nombre");
      }

      //Diagnostico de un paciente según Rango de fechas 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataRangeDateD.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        Date date1 = this.dataRangeDateD.FechaP1.getDate();
        Date date2 = this.dataRangeDateD.FechaP2.getDate();
        list = CRUDConsultaDOC.PacienteDiagnosticoDateRange(ced, date1, date2);
        report.exportarHTML(list, "Diag Paci FechaR");
      }

      // Diagnostico de Paciente según Nombre de Diagnóstico 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Nombre"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataNameD.TFCedNameD.getText();   // Esta seria la data de la tablilla de datos
        String name = (String) this.dataNameD.TFNombreD.getText();
        list = CRUDConsultaDOC.PacienteDiagnosticoNombreD(ced, name);
        report.exportarHTML(list, "Diag Nombre Paci");
      }

      // Diagnostico de Paciente según Nivel de diágnostico    
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Nivel"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataNivel.TFCedNivel.getText();   // Esta seria la data de la tablilla de datos
        String lvl = (String) this.dataNivel.TFNivel.getText();
        list = CRUDConsultaDOC.PacienteDiagnosticoNivel(ced, lvl);
        report.exportarHTML(list, "Diag Nivel Paci");
      }

    }

    if (e.getSource() == vistaConsultaDoc.btnPDF)
    {

      // Consulta Hospitalización de Paciente
      if (vistaConsultaDoc.RADIOHOSP.isSelected()
              && vistaConsultaDoc.CBHospitalizacion.getSelectedItem().toString().equals("Detalle General de Paciente"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataHospPaci.TFCedPaci.getText());
        list = CRUDConsultaDOC.HospiPaci(paciente);
        report.exportarPDF(list, "HospiPaci");

      }

      //Conteo General de Tratamientos 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Conteo General"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list = CRUDConsultaDOC.TrataConteGen();
        report.exportarPDF(list, "Gen Trata");
      }

      //Cant de Tratamientos según Tipo 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Tipo"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String tipo = dataTratamiTipo.TFTipoTrata.getText();
        list = CRUDConsultaDOC.TrataCantTipo(tipo);
        report.exportarPDF(list, "Cant Trata Tipo");

      }

      //Cant Tratamientos según especialidad
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Especialidad"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String especialidad = (String) dataTrataEspe.TFNombreEspe.getText();
        list = CRUDConsultaDOC.TrataCantEspecialidad(especialidad);
        report.exportarPDF(list, "Cant Trata Espe");
      }

      //Cant Tratamientos según Paciente 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Paciente"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataTrataPaci.TFCedPaci.getText());
        list = CRUDConsultaDOC.TrataCantPaciente(paciente);
        report.exportarPDF(list, "Cant Trata Paci");
      }

      //Cant Diagnosticos según Paciente
      if (vistaConsultaDoc.RADIODIAG.isSelected()
              && vistaConsultaDoc.CBDiagnosticos.getSelectedItem().toString().equals("Cantidad según Paciente"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataDiagPaciente.TFCedPaci.getText());
        list = CRUDConsultaDOC.DiagCantPaciente(paciente);
        report.exportarPDF(list, "Cant Diag Paci");
      }

      //Cant Diagnosticos según Nivel 
      if (vistaConsultaDoc.RADIODIAG.isSelected()
              && vistaConsultaDoc.CBDiagnosticos.getSelectedItem().toString().equals("Cantidad según Nivel"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String nivel = (String) this.dataDiagNivel.TFNombreDiag.getText();
        list = CRUDConsultaDOC.DiagCantNivel(nivel);
        report.exportarPDF(list, "Cant Diag Nivel");
      }

      //Cantidad de citas según  Rango de Fechas 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        Date date1 = this.dataCitaDateR.FechaPC1.getDate();
        Date date2 = this.dataCitaDateR.FechaPC2.getDate();
        list = CRUDConsultaDOC.CitaRangoFechas(date1, date2);
        report.exportarPDF(list, "Cant Cita Rango");
      }

      //Cantidad de citas según Estado 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Estado"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String estado = (String) this.dataCitaEstate.TFEstadoCita.getText();
        list = CRUDConsultaDOC.CitaEstado(estado);
        report.exportarPDF(list, "Cant Citas Estado");
      }

      // Cantidad de citas según Especialidad 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Especialidad"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String especial = (String) this.dataCitaEspe.TFNombreEspe.getText();
        list = CRUDConsultaDOC.CitaEspecialidad(especial);
        report.exportarPDF(list, "Cant Citas Especialidad");
      }

      //Tratamientos de un paciente por rango de fechas 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataRange.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        Date date1 = this.dataTrataRange.FechaPT1.getDate();
        Date date2 = this.dataTrataRange.FechaPT2.getDate();
        list = CRUDConsultaDOC.PacienteDiagnosticoTrataDateRange(ced, date1, date2);
        report.exportarPDF(list, "Trata Paci Fechas");
      }

      //Tratamientos de un paciente por tipo de tratamiento
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Tipo"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataTipo.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        String tipo = (String) this.dataTrataTipo.TFTipoTrata.getText();
        list = CRUDConsultaDOC.PacienteTratamientoTipo(ced, tipo);
        report.exportarPDF(list, "Trata Paci Tipo");
      }

      // Tratamientos de un paciente según nombre de tratamiento
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Nombre"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataName.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        String nombre = (String) this.dataTrataName.TFNameTrata.getText();
        list = CRUDConsultaDOC.PacienteTratamientoNombre(ced, nombre);
        report.exportarPDF(list, "Trata Paci Nombre");
      }

      //Diagnostico de un paciente según Rango de fechas 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataRangeDateD.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        Date date1 = this.dataRangeDateD.FechaP1.getDate();
        Date date2 = this.dataRangeDateD.FechaP2.getDate();
        list = CRUDConsultaDOC.PacienteDiagnosticoDateRange(ced, date1, date2);
        report.exportarPDF(list, "Diag Paci FechaR");
      }

      // Diagnostico de Paciente según Nombre de Diagnóstico 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Nombre"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataNameD.TFCedNameD.getText();   // Esta seria la data de la tablilla de datos
        String name = (String) this.dataNameD.TFNombreD.getText();
        list = CRUDConsultaDOC.PacienteDiagnosticoNombreD(ced, name);
        report.exportarPDF(list, "Diag Nombre Paci");
      }

      // Diagnostico de Paciente según Nivel de diágnostico    
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Nivel"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataNivel.TFCedNivel.getText();   // Esta seria la data de la tablilla de datos
        String lvl = (String) this.dataNivel.TFNivel.getText();
        list = CRUDConsultaDOC.PacienteDiagnosticoNivel(ced, lvl);
        report.exportarPDF(list, "Diag Nivel Paci");
      }

    }

    if (e.getSource() == vistaConsultaDoc.btnCSV)
    {

      //Reporte de hospitalizacion    
      if (vistaConsultaDoc.RADIOHOSP.isSelected()
              && vistaConsultaDoc.CBHospitalizacion.getSelectedItem().toString().equals("Detalle General de Paciente"))
      {

        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataHospPaci.TFCedPaci.getText());
        list = CRUDConsultaDOC.HospiPaci(paciente);

        report.exportarCSV("Hospi Paciente", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");

      }

      //Conteo General Tratamientos 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Conteo General"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list = CRUDConsultaDOC.TrataConteGen();
        report.exportarCSV("Tratamiento Count Gen", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");
      }

      //Cant de Tratamientos según Tipo 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Tipo"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String tipo = dataTratamiTipo.TFTipoTrata.getText();
        list = CRUDConsultaDOC.TrataCantTipo(tipo);
        report.exportarCSV("Tratamiento Count Type", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");

      }

      //Cant Tratamientos según especialidad
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Especialidad"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String especialidad = (String) dataTrataEspe.TFNombreEspe.getText();
        list = CRUDConsultaDOC.TrataCantEspecialidad(especialidad);
        report.exportarCSV("Tratamiento Count Espe", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");
      }

      //Cant Tratamientos según Paciente 
      if (vistaConsultaDoc.RADIOTRATA.isSelected()
              && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Paciente"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataTrataPaci.TFCedPaci.getText());
        list = CRUDConsultaDOC.TrataCantPaciente(paciente);
        report.exportarCSV("Tratamiento Count Paci", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");
      }

      //Cant Diagnosticos según Paciente
      if (vistaConsultaDoc.RADIODIAG.isSelected()
              && vistaConsultaDoc.CBDiagnosticos.getSelectedItem().toString().equals("Cantidad según Paciente"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        int paciente = Integer.parseInt(this.dataDiagPaciente.TFCedPaci.getText());
        list = CRUDConsultaDOC.DiagCantPaciente(paciente);
        report.exportarCSV("Diag Count Paci", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");
      }

      //Cant Diagnosticos según Nivel 
      if (vistaConsultaDoc.RADIODIAG.isSelected()
              && vistaConsultaDoc.CBDiagnosticos.getSelectedItem().toString().equals("Cantidad según Nivel"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String nivel = (String) this.dataDiagNivel.TFNombreDiag.getText();
        list = CRUDConsultaDOC.DiagCantNivel(nivel);
        report.exportarCSV("Diag Count Nivel", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");
      }

      //Cantidad de citas según  Rango de Fechas 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        Date date1 = this.dataCitaDateR.FechaPC1.getDate();
        Date date2 = this.dataCitaDateR.FechaPC2.getDate();
        list = CRUDConsultaDOC.CitaRangoFechas(date1, date2);
        report.exportarCSV("Citas Count Date Range", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");

      }

      //Cantidad de citas según Estado 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Estado"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String estado = (String) this.dataCitaEstate.TFEstadoCita.getText();
        list = CRUDConsultaDOC.CitaEstado(estado);
        report.exportarCSV("Citas Count Estate", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");
      }

      // Cantidad de citas según Especialidad 
      if (vistaConsultaDoc.CITASRADIO.isSelected()
              && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Especialidad"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String especial = (String) this.dataCitaEspe.TFNombreEspe.getText();
        list = CRUDConsultaDOC.CitaEspecialidad(especial);
        report.exportarCSV("Citas Count Espe", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");

      }

      //Tratamientos de un paciente por rango de fechas 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataRange.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        Date date1 = this.dataTrataRange.FechaPT1.getDate();
        Date date2 = this.dataTrataRange.FechaPT2.getDate();
        list = CRUDConsultaDOC.PacienteDiagnosticoTrataDateRange(ced, date1, date2);
        report.exportarCSV("Paciente Trata Date Range", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");

      }

      //Tratamientos de un paciente por tipo de tratamiento
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Tipo"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataTipo.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        String tipo = (String) this.dataTrataTipo.TFTipoTrata.getText();
        list = CRUDConsultaDOC.PacienteTratamientoTipo(ced, tipo);
        report.exportarCSV("Paciente Trata Type", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");

      }

      // Tratamientos de un paciente según nombre de tratamiento
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Nombre"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataTrataName.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        String nombre = (String) this.dataTrataName.TFNameTrata.getText();
        list = CRUDConsultaDOC.PacienteTratamientoNombre(ced, nombre);
        report.exportarCSV("Paciente Trata Nombre", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");
      }

      //Diagnostico de un paciente según Rango de fechas 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Rango de Fechas"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataRangeDateD.TFCedPaci.getText();   // Esta seria la data de la tablilla de datos
        Date date1 = this.dataRangeDateD.FechaP1.getDate();
        Date date2 = this.dataRangeDateD.FechaP2.getDate();
        list = CRUDConsultaDOC.PacienteDiagnosticoDateRange(ced, date1, date2);
        report.exportarCSV("Paciente Diag Data Range", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");
      }

      // Diagnostico de Paciente según Nombre de Diagnóstico 
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Nombre"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataNameD.TFCedNameD.getText();   // Esta seria la data de la tablilla de datos
        String name = (String) this.dataNameD.TFNombreD.getText();
        list = CRUDConsultaDOC.PacienteDiagnosticoNombreD(ced, name);
        report.exportarCSV("Paciente Diag Nombre", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");

      }

      // Diagnostico de Paciente según Nivel de diágnostico    
      if (vistaConsultaDoc.RADIOPACIENTE.isSelected()
              && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Diagnostico según Nivel"))
      {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        String ced = (String) this.dataNivel.TFCedNivel.getText();   // Esta seria la data de la tablilla de datos
        String lvl = (String) this.dataNivel.TFNivel.getText();
        list = CRUDConsultaDOC.PacienteDiagnosticoNivel(ced, lvl);
        report.exportarCSV("Paciente Diag Nivel", list);
        JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente");

      }

    }

    //-------------PACIENTE------------------------------ 
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
        TablePacienteNombreD();
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
            && vistaConsultaDoc.CBPaciente.getSelectedItem().toString().equals("Tratamiento según Rango de Fechas"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataTrataRange.setVisible(true);
      }
      if (e.getSource() == dataTrataRange.btnConsulDateRPacienT)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TablePacienteTratamientoDateRange();

      }

    }

    //-------------CITAS------------------------------ 
    //Cantidad de citas  según especialidad 
    if (vistaConsultaDoc.CITASRADIO.isSelected()
            && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Especialidad"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataCitaEspe.setVisible(true);
      }
      if (e.getSource() == dataCitaEspe.btnConsuCitaEspe)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableCitaEspecialidad();     //CAMBIAR 

      }

    }

    //Cantidad de citas  según estado
    if (vistaConsultaDoc.CITASRADIO.isSelected()
            && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Estado"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataCitaEstate.setVisible(true);
      }
      if (e.getSource() == dataCitaEstate.btnConsuCitaEstate)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableCitaEstado();  //CAMBIAR

      }

    }

    // Cantidad de citas según rango de fecha
    if (vistaConsultaDoc.CITASRADIO.isSelected()
            && vistaConsultaDoc.CBCitas.getSelectedItem().toString().equals("Cantidad según Rango de Fechas"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataCitaDateR.setVisible(true);
      }
      if (e.getSource() == dataCitaDateR.btnConsulDateRCita)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableCitaRangoFecha(); //CAMBIAR

      }

    }

    //----------------- DIAGNÓSTICOS----------------------- 
    // Cantidad de diagnosticos según Nivel
    ///Change
    if (vistaConsultaDoc.RADIODIAG.isSelected()
            && vistaConsultaDoc.CBDiagnosticos.getSelectedItem().toString().equals("Cantidad según Nivel"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataDiagNivel.setVisible(true);
      }
      if (e.getSource() == dataDiagNivel.btnConsuDiagLvl)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableDiagNivel(); //CAMBIAR

      }

    }

    // Cantidad de diagnosticos según Paciente
    if (vistaConsultaDoc.RADIODIAG.isSelected()
            && vistaConsultaDoc.CBDiagnosticos.getSelectedItem().toString().equals("Cantidad según Paciente"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataDiagPaciente.setVisible(true);
      }
      if (e.getSource() == dataDiagPaciente.btnConsuPaciDiag)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableDiagPaciente(); //CAMBIAR

      }

    }

    //----------------- TRATAMIENTOS----------------------- 
    //Cant Tratamientos según Paciente
    if (vistaConsultaDoc.RADIOTRATA.isSelected()
            && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Paciente"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataTrataPaci.setVisible(true);
      }
      if (e.getSource() == dataTrataPaci.btnConsultPaci)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableTrataPaciente();

      }

    }

    //Cant Tratamiento según  Especialidad
    if (vistaConsultaDoc.RADIOTRATA.isSelected()
            && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Especialidad"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataTrataEspe.setVisible(true);
      }
      if (e.getSource() == dataTrataEspe.btnConsuTrataEspe)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableTrataEspecialidad();

      }

    }

    //Cant Tratamiento según Tipo 
    if (vistaConsultaDoc.RADIOTRATA.isSelected()
            && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Según Tipo"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataTratamiTipo.setVisible(true);
      }
      if (e.getSource() == dataTratamiTipo.btnConsuTrataTipo)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableTrataTipo();

      }

    }

    //Cant Tratamiento General 
    if (vistaConsultaDoc.RADIOTRATA.isSelected()
            && vistaConsultaDoc.CBTratamientos.getSelectedItem().toString().equals("Conteo General"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataTrataGen.setVisible(true);
      }
      if (e.getSource() == dataTrataGen.btnConsuTrataGen)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableTrataGen();

      }

    }

    // Hospitalizacion 
    if (vistaConsultaDoc.RADIOHOSP.isSelected()
            && vistaConsultaDoc.CBHospitalizacion.getSelectedItem().toString().equals("Detalle General de Paciente"))
    {

      if (e.getSource() == vistaConsultaDoc.btnSHOW)
      {

        dataHospPaci.setVisible(true);
      }
      if (e.getSource() == dataHospPaci.btnConsuHospi)
      {
        vistaConsultaDoc.DocTable.clearSelection();
        TableTrataHosp();
      }

    }

  }

}
