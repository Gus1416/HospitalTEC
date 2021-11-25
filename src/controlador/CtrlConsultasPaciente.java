package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Area;
import modelo.AreaCRUD;
import modelo.ArrayList;
import modelo.ConsultasPacienteCRUD;
import modelo.Diagnostico;
import modelo.DiagnosticoCRUD;
import modelo.EstadoCita;
import modelo.Paciente;
import modelo.Reportes;
import modelo.Tratamiento;
import modelo.TratamientoCRUD;
import vista.ConsultasPaciente;
import vista.consultas_paciente.VIEWCitasEspecialidad;
import vista.consultas_paciente.VIEWCitasEstado;
import vista.consultas_paciente.VIEWCitasRangoFechas;
import vista.consultas_paciente.VIEWDiagnosticosNivel;
import vista.consultas_paciente.VIEWDiagnosticosNombre;
import vista.consultas_paciente.VIEWDiagnosticosRangoFechas;
import vista.consultas_paciente.VIEWTratamientosNombre;
import vista.consultas_paciente.VIEWTratamientosRangoFechas;
import vista.consultas_paciente.VIEWTratamientosTipo;

/**
 * Controlador para las consultas del paciente.
 * 
 * @author Gustavo
 */
public class CtrlConsultasPaciente implements ActionListener{
  private ConsultasPaciente consultas;
  private Paciente paciente;
  private VIEWCitasRangoFechas citasRangoFechas;
  private VIEWCitasEstado citasEstado;
  private VIEWCitasEspecialidad citasEspecialidad;
  private VIEWDiagnosticosRangoFechas diagnosticosRangoFechas;
  private VIEWDiagnosticosNivel diagnosticosNivel;
  private VIEWDiagnosticosNombre diagnosticosNombre;
  private VIEWTratamientosRangoFechas tratamientosRangoFechas;
  private VIEWTratamientosTipo tratamientosTipo;
  private VIEWTratamientosNombre tratamientosNombre;
  private ConsultasPacienteCRUD consultasCrud;
  private AreaCRUD areaCrud;
  private ArrayList<Object[]> filas = new ArrayList<Object[]>();
  
  /**
   * Constructor de la clase.
   * 
   * @param pConsultas ventana de consulta
   * @param pPaciente  objeto paciente
   */
  public CtrlConsultasPaciente(ConsultasPaciente pConsultas, Paciente pPaciente){
    this.consultas = pConsultas;
    this.paciente = pPaciente;
    
    this.citasRangoFechas = new VIEWCitasRangoFechas();
    this.citasEstado = new VIEWCitasEstado();
    this.citasEspecialidad = new VIEWCitasEspecialidad();
    this.diagnosticosRangoFechas = new VIEWDiagnosticosRangoFechas();
    this.diagnosticosNivel = new VIEWDiagnosticosNivel();
    this.diagnosticosNombre = new VIEWDiagnosticosNombre();
    this.tratamientosRangoFechas = new VIEWTratamientosRangoFechas();
    this.tratamientosTipo = new VIEWTratamientosTipo();
    this.tratamientosNombre = new VIEWTratamientosNombre();
    
    this.citasRangoFechas.btnConsultarCitasRangoFecha.addActionListener(this);
    this.citasEstado.btnConsultarCitasEstado.addActionListener(this);
    this.citasEspecialidad.btnConsultarCitasEspecialidad.addActionListener(this);
    this.diagnosticosRangoFechas.btnConsultarEspecialidadesRangoFecha.addActionListener(this);
    this.diagnosticosNivel.btnConsultarDiagnosticosNivel.addActionListener(this);
    this.diagnosticosNombre.btnConsultarDiagnosticosNombre.addActionListener(this);
    this.tratamientosRangoFechas.btnConsultarTratamientosRangoFecha.addActionListener(this);
    this.tratamientosTipo.btnConsultarTratamientosTipo.addActionListener(this);
    this.tratamientosNombre.btnConsultarTratamientosNombre.addActionListener(this);
    
    this.consultas.btnMostrar.addActionListener(this);
    
    this.consultas.btnExportarPDF.addActionListener(this);
    this.consultas.btnExportarCSV.addActionListener(this);
    this.consultas.btnExportarHTML.addActionListener(this);
    
    this.consultasCrud = new ConsultasPacienteCRUD();
    this.areaCrud = new AreaCRUD();
  }
  
  /**
   * Inicia la ventana
   */
  public void iniciar(){
    this.consultas.setTitle("Consultas");
    this.consultas.setLocationRelativeTo(null);
  }
  
  /**
   * Muestra las citas por rango de fechas
   */
  private void mostrarCitasRangoFechas(){
    Date fecha1 = this.citasRangoFechas.FechaP1.getDate();
    Date fecha2 = this.citasRangoFechas.FechaP2.getDate();
    this.filas = this.consultasCrud.pacienteCitasFechas(this.paciente.getCedula(), fecha1, fecha2);
    crearTablaCitas(filas);
  }
  
  /**
   * Muestra las citas por estado
   */
  private void mostrarCitasEstado(){
    String estado = (String)this.citasEstado.cbEstadosCita.getSelectedItem();
    ArrayList<Object[]> filas;
    switch (estado){
      case "Registrada" ->{
        this.filas = this.consultasCrud.pacienteCitasEstado(this.paciente.getCedula(), EstadoCita.REGISTRADA.toString());
        crearTablaCitas(this.filas);
      }
      case "Cancelada por paciente" -> {
        this.filas = this.consultasCrud.pacienteCitasEstado(this.paciente.getCedula(), EstadoCita.CANCELADA_POR_PACIENTE.toString());
        crearTablaCitas(this.filas);
      }
      case "Cancelada por médico" ->{
        this.filas = this.consultasCrud.pacienteCitasEstado(this.paciente.getCedula(), EstadoCita.CANCELADA_POR_MÉDICO.toString());
        crearTablaCitas(this.filas);
      }
      case "Asignada" ->{
        this.filas = this.consultasCrud.pacienteCitasEstado(this.paciente.getCedula(), EstadoCita.ASIGNADA.toString());
        crearTablaCitas(this.filas);
      }
      case "Realizada" ->{
        this.filas = this.consultasCrud.pacienteCitasEstado(this.paciente.getCedula(), EstadoCita.REALIZADA.toString());
        crearTablaCitas(this.filas);
      }
      default -> {}
    }
  }
  
  /**
   * Muesta las citas por especialidad
   */
  private void mostrarCitasEspecialidad(){
    String area = (String)this.citasEspecialidad.cbEspecialidades.getSelectedItem();
    int idArea = this.areaCrud.buscarArea(area).getIdArea();
    this.filas = this.consultasCrud.pacienteCitasEspecialidad(this.paciente.getCedula(), idArea);
    crearTablaCitas(filas);
  }
  
  /**
   * Muestra los diagnòsticos por fechas
   */
  private void mostrarDiagnosticosRangoFechas(){
    Date fecha1 = this.diagnosticosRangoFechas.FechaP1.getDate();
    Date fecha2 = this.diagnosticosRangoFechas.FechaP2.getDate();
    this.filas = this.consultasCrud.pacienteDiagnosticosFechas(
            this.paciente.getCedula(), fecha1, fecha2);
    crearTablaDiagnosticos(filas);
  }
  
  /**
   * Muestra los diagnòsticos por nivel
   */
  private void mostrarDiagnosticosNivel(){
    String nivel = (String)this.diagnosticosNivel.cbDiagnosticoNivel.getSelectedItem();
    this.filas = this.consultasCrud.pacienteDiagnosticoNivel(this.paciente.getCedula(), nivel);
    crearTablaDiagnosticos(filas);
  }
  
  /**
   * Muestra los diagnòsticos por nombre
   */
  private void mostrarDiagnosticosNombre(){
    String nombreDiagnostico = (String)this.diagnosticosNombre.cbDiagnosticoNombre.getSelectedItem();
    this.filas = this.consultasCrud.pacienteDiagnosticoNombre(this.paciente.getCedula(), nombreDiagnostico);
    crearTablaDiagnosticos(filas);
  }
  
  /**
   * Muestra los tratamientos por fechas
   */
  private void mostrarTratamientosRangoFechas(){
    Date fecha1 = this.tratamientosRangoFechas.FechaP1.getDate();
    Date fecha2 = this.tratamientosRangoFechas.FechaP2.getDate();
    this.filas = this.consultasCrud.pacienteTratamientosFechas(this.paciente.getCedula(), fecha1, fecha2);
    crearTablaTratamientos(filas);
  }
  
  /**
   * Muestra los tratamientos por tipo
   */
  private void mostrarTratamientosTipo(){
    String tipo = (String)this.tratamientosTipo.cbTratamientoTipo.getSelectedItem();
    this.filas = this.consultasCrud.pacienteTratamientosTipo(this.paciente.getCedula(), tipo);
    crearTablaTratamientos(filas);
  }
  
  /**
   * Muestra los tratamientos por nombre
   */
  private void mostrarTratamientosNombre(){
    String nombre = (String)this.tratamientosNombre.cbTratamientoNombre.getSelectedItem();
    this.filas = this.consultasCrud.pacienteTratamientosNombre(this.paciente.getCedula(), nombre);
    crearTablaTratamientos(filas);
  }
  
  /**
   * Muestra las hospitalizaciones
   */
  private void mostrarHospitalizaciones(){
    this.filas = this.consultasCrud.pacienteHospitalizaciones(this.paciente.getCedula());
    crearTablaHospitalizaciones(filas);
  }
  
  /**
   * Creaciòn de tablas
   * 
   * @param pFilas  filas de la tabla
   */
  private void crearTablaCitas(ArrayList<Object[]> pFilas){
    DefaultTableModel modelo = new DefaultTableModel();
    this.consultas.tbConsultasPaciente.setModel(modelo);
    
    modelo.addColumn("Número de Cita");
    modelo.addColumn("Especialidad");
    modelo.addColumn("Fecha");
    modelo.addColumn("Observación");
    modelo.addColumn("Estado Actual");
    
    for (int i = 0; i < pFilas.size(); i++){
      modelo.addRow(pFilas.get(i));
    }
  }
  
  private void crearTablaDiagnosticos(ArrayList<Object[]> pFilas){
    DefaultTableModel modelo = new DefaultTableModel();
    this.consultas.tbConsultasPaciente.setModel(modelo);
    
    modelo.addColumn("Número de Cita");
    modelo.addColumn("Diagnóstico");
    modelo.addColumn("Nivel");
    modelo.addColumn("Observación");
    modelo.addColumn("Fecha");
    
    for (int i = 0; i < pFilas.size(); i++){
      modelo.addRow(pFilas.get(i));
    }
  }
  
  private void crearTablaTratamientos(ArrayList<Object[]> pFilas){
    DefaultTableModel modelo = new DefaultTableModel();
    this.consultas.tbConsultasPaciente.setModel(modelo);
    
    modelo.addColumn("Número de Cita");
    modelo.addColumn("Tratamiento");
    modelo.addColumn("Tipo de Tratamiento");
    modelo.addColumn("Dosis");
    modelo.addColumn("Fecha");
    
    for (int i = 0; i < pFilas.size(); i++){
      modelo.addRow(pFilas.get(i));
    }
  }
  
  private void crearTablaHospitalizaciones(ArrayList<Object[]> pFilas){
    DefaultTableModel modelo = new DefaultTableModel();
    this.consultas.tbConsultasPaciente.setModel(modelo);
    
    modelo.addColumn("Número de Internado");
    modelo.addColumn("Centro de Atención");
    modelo.addColumn("Diagnostico");
    modelo.addColumn("Fecha de Inicio");
    modelo.addColumn("Fecha de Fin");
    modelo.addColumn("Servicio");
    modelo.addColumn("Funcionario");
    modelo.addColumn("Fecha de Seguimiento");
    
    for (int i = 0; i < pFilas.size(); i++){
      modelo.addRow(pFilas.get(i));
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
    if (this.consultas.rbCitas.isSelected() && this.consultas.cbCitas.getSelectedItem().equals("Rango de Fechas")){
      
      if (e.getSource() == this.consultas.btnMostrar){
        this.citasRangoFechas.setLocationRelativeTo(null);
        this.citasRangoFechas.setVisible(true);
      }
      
      if (e.getSource() == this.citasRangoFechas.btnConsultarCitasRangoFecha){
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarCitasRangoFechas();
        this.citasRangoFechas.setVisible(false);
      }
    }
    
    if (this.consultas.rbCitas.isSelected() && this.consultas.cbCitas.getSelectedItem().equals("Estado de Cita")){
      
      if (e.getSource() == this.consultas.btnMostrar){
        this.citasEstado.setLocationRelativeTo(null);
        this.citasEstado.setVisible(true);
      }
      
      if (e.getSource() == this.citasEstado.btnConsultarCitasEstado){
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarCitasEstado();
        this.citasEstado.setVisible(false);
      }
    }
    
    if (this.consultas.rbCitas.isSelected() && this.consultas.cbCitas.getSelectedItem().equals("Especialidad")){
      
      if (e.getSource() == this.consultas.btnMostrar){
        cargarEspecialidades();
        this.citasEspecialidad.setLocationRelativeTo(null);
        this.citasEspecialidad.setVisible(true);
      }
      
      if (e.getSource() == this.citasEspecialidad.btnConsultarCitasEspecialidad){
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarCitasEspecialidad();
        this.citasEspecialidad.setVisible(false);
      }
    }
    
    if (this.consultas.rbDiagnosticos.isSelected() && this.consultas.cbDiagnosticos.getSelectedItem().equals("Rango de Fechas")){
      
      if (e.getSource() == this.consultas.btnMostrar){
        this.diagnosticosRangoFechas.setLocationRelativeTo(null);
        this.diagnosticosRangoFechas.setVisible(true);
      }
      
      if (e.getSource() == this.diagnosticosRangoFechas.btnConsultarEspecialidadesRangoFecha){
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarDiagnosticosRangoFechas();
        this.diagnosticosRangoFechas.setVisible(false);
      }
    }
    
    if (this.consultas.rbDiagnosticos.isSelected() && this.consultas.cbDiagnosticos.getSelectedItem().equals("Nivel de Diagnóstico")){
      
      if (e.getSource() == this.consultas.btnMostrar){
        this.diagnosticosNivel.setLocationRelativeTo(null);
        this.diagnosticosNivel.setVisible(true);
      }
      
      if (e.getSource() == this.diagnosticosNivel.btnConsultarDiagnosticosNivel){
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarDiagnosticosNivel();
        this.diagnosticosNivel.setVisible(false);
      }
    }
    
    if (this.consultas.rbDiagnosticos.isSelected() && this.consultas.cbDiagnosticos.getSelectedItem().equals("Nombre de Diagnóstico")){
      
      if (e.getSource() == this.consultas.btnMostrar){
        cargarDiagnosticos();
        this.diagnosticosNombre.setLocationRelativeTo(null);
        this.diagnosticosNombre.setVisible(true);
      }
  
      if (e.getSource() == this.diagnosticosNombre.btnConsultarDiagnosticosNombre){
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarDiagnosticosNombre();
        this.diagnosticosNombre.setVisible(false);
      }
    }
    
    if (this.consultas.rbTratamientos.isSelected() && this.consultas.cbTratamientos.getSelectedItem().equals("Rango de Fechas")){
      
      if (e.getSource() == this.consultas.btnMostrar){
        this.tratamientosRangoFechas.setLocationRelativeTo(null);
        this.tratamientosRangoFechas.setVisible(true);
      }
      
      if (e.getSource() == this.tratamientosRangoFechas.btnConsultarTratamientosRangoFecha){
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarTratamientosRangoFechas();
        this.tratamientosRangoFechas.setVisible(false);
      }
    }
    
    if (this.consultas.rbTratamientos.isSelected() && this.consultas.cbTratamientos.getSelectedItem().equals("Tipo de Tratamiento")){
      
      if (e.getSource() == this.consultas.btnMostrar){
        this.tratamientosTipo.setLocationRelativeTo(null);
        this.tratamientosTipo.setVisible(true);
      }
      
      if (e.getSource() == this.tratamientosTipo.btnConsultarTratamientosTipo){
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarTratamientosTipo();
        this.tratamientosTipo.setVisible(false);
      }
    }
    
    if (this.consultas.rbTratamientos.isSelected() && this.consultas.cbTratamientos.getSelectedItem().equals("Nombre de Tratamiento")){
     
      if (e.getSource() == this.consultas.btnMostrar){
        cargarTratamientos();
        this.tratamientosNombre.setLocationRelativeTo(null);
        this.tratamientosNombre.setVisible(true);
      }

      if (e.getSource() == this.tratamientosNombre.btnConsultarTratamientosNombre) {
        this.consultas.tbConsultasPaciente.clearSelection();
        mostrarTratamientosNombre();
        this.tratamientosNombre.setVisible(false);
      }
    }
    
    if (this.consultas.rbHospitalizacion.isSelected()){
      
      if (e.getSource() == this.consultas.btnMostrar){
        mostrarHospitalizaciones();
      }
    }
    
    //Exportar reportes a PDF
    
    if (this.consultas.rbCitas.isSelected() && e.getSource() == this.consultas.btnExportarPDF){
      Reportes reportes = new Reportes();
      reportes.exportarPDF(this.filas, "PacienteCitas");
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
    
    if (this.consultas.rbDiagnosticos.isSelected() && e.getSource() == this.consultas.btnExportarPDF){
      Reportes reportes = new Reportes();
      reportes.exportarPDF(this.filas, "PacienteDiagnósticos");
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
    
    if (this.consultas.rbTratamientos.isSelected() && e.getSource() == this.consultas.btnExportarPDF){
      Reportes reportes = new Reportes();
      reportes.exportarPDF(this.filas, "PacienteTratamientos");
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
    
    if (this.consultas.rbHospitalizacion.isSelected() && e.getSource() == this.consultas.btnExportarPDF){
      Reportes reportes = new Reportes();
      reportes.exportarPDF(this.filas, "PacienteHospitalizaciones");
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
    
    //Exportar reportes a CSV
    
    if (this.consultas.rbCitas.isSelected() && e.getSource() == this.consultas.btnExportarCSV){
      Reportes reportes = new Reportes();
      reportes.exportarCSV("PacienteCitas", this.filas);
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
    
    if (this.consultas.rbDiagnosticos.isSelected() && e.getSource() == this.consultas.btnExportarCSV){
      Reportes reportes = new Reportes();
      reportes.exportarCSV("PacienteDiagnósticos", this.filas);
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
    
    if (this.consultas.rbTratamientos.isSelected() && e.getSource() == this.consultas.btnExportarCSV){
      Reportes reportes = new Reportes();
      reportes.exportarCSV("PacienteTratamientos", this.filas);
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
    
    if (this.consultas.rbHospitalizacion.isSelected() && e.getSource() == this.consultas.btnExportarCSV){
      Reportes reportes = new Reportes();
      reportes.exportarCSV("PacienteHospitalizaciones", this.filas);
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
    
    //Exportar reportes a HTML
    if (this.consultas.rbCitas.isSelected() && e.getSource() == this.consultas.btnExportarHTML){
      Reportes reportes = new Reportes();
      reportes.exportarHTML(filas, "PacienteCitas");
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }

    if (this.consultas.rbDiagnosticos.isSelected() && e.getSource() == this.consultas.btnExportarHTML){
      Reportes reportes = new Reportes();
      reportes.exportarHTML(filas, "PacienteDiagnósticos");
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }

    if (this.consultas.rbTratamientos.isSelected() && e.getSource() == this.consultas.btnExportarHTML){
      Reportes reportes = new Reportes();
      reportes.exportarHTML(filas, "PacienteTratamientos");
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }

    if (this.consultas.rbHospitalizacion.isSelected() && e.getSource() == this.consultas.btnExportarHTML){
      Reportes reportes = new Reportes();
      reportes.exportarHTML(filas, "PacienteHospitalizaciones");
      JOptionPane.showMessageDialog(null, "El reporte ha sido exportado");
    }
  }
  
  private void cargarEspecialidades(){
    ArrayList<Area> areas = this.areaCrud.consultarAreas();
    this.citasEspecialidad.cbEspecialidades.removeAllItems();
    for (int i = 0; i < areas.size(); i++){
      this.citasEspecialidad.cbEspecialidades.addItem(areas.get(i).getNombreArea());
    }
  }
  
  private void cargarDiagnosticos(){
    DiagnosticoCRUD diagnosticoCrud = new DiagnosticoCRUD();
    ArrayList<Diagnostico> diagnosticos = diagnosticoCrud.consultarDiagnosticos();
    this.diagnosticosNombre.cbDiagnosticoNombre.removeAllItems();
    for (int i = 0; i < diagnosticos.size(); i++){
      this.diagnosticosNombre.cbDiagnosticoNombre.addItem(diagnosticos.get(i).getNombre());
    }
  }
  
  private void cargarTratamientos(){
    TratamientoCRUD tratamientoCrud = new TratamientoCRUD();
    ArrayList<Tratamiento> tratamientos = tratamientoCrud.consultarTratamientos();
    this.tratamientosNombre.cbTratamientoNombre.removeAllItems();
    for (int i = 0; i < tratamientos.size(); i++){
      this.tratamientosNombre.cbTratamientoNombre.addItem(tratamientos.get(i).getNombre());
    }
  }
}
