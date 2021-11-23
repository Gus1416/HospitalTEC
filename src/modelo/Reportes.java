package modelo;

import com.csvreader.CsvWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static j2html.TagCreator.style;
import static j2html.TagCreator.table;
import static j2html.TagCreator.td;
import static j2html.TagCreator.th;
import static j2html.TagCreator.tr;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gustavo
 */
public class Reportes implements exportable{
  private PdfPTable tabla;

  @Override
  public void exportarPDF(ArrayList<Object[]> pFilas, String pTipoReporte) {
    Document documento = new Document();
    Paragraph titulo = new Paragraph("Reportes");
    
    try{
      FileOutputStream archivo = new FileOutputStream("reportes.pdf");
      PdfWriter.getInstance(documento, archivo);
      documento.open();
      titulo.setAlignment(1);
      documento.add(titulo);
      documento.add(Chunk.NEWLINE);
      documento.add(new Paragraph("Reportes de " + pTipoReporte));
      documento.add(Chunk.NEWLINE);
      
      switch (pTipoReporte){
        
        //En cada case se escibren los encabezados de la tabla
        
        case "PacienteCitas":
          this.tabla = new PdfPTable(5);
          this.tabla.setWidthPercentage(100);
          PdfPCell idCita = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell especialidad = new PdfPCell(new Phrase("Especialidad"));
          PdfPCell fecha = new PdfPCell(new Phrase("Fecha"));
          PdfPCell observacion = new PdfPCell(new Phrase("Observación"));
          PdfPCell estado = new PdfPCell(new Phrase("Estado Actual"));

          tabla.addCell(idCita);
          tabla.addCell(especialidad);
          tabla.addCell(fecha);
          tabla.addCell(observacion);
          tabla.addCell(estado);
          break;

        case "PacienteDiagnósticos":
          this.tabla = new PdfPTable(5);
          this.tabla.setWidthPercentage(100);
          PdfPCell idCitaDiagnostico = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell diagnostico = new PdfPCell(new Phrase("Diagnóstico"));
          PdfPCell nivel = new PdfPCell(new Phrase("Nivel"));
          PdfPCell observacionDiagnostico = new PdfPCell(new Phrase("Observación"));
          PdfPCell fechaDiagnostico = new PdfPCell(new Phrase("Fecha"));

          tabla.addCell(idCitaDiagnostico);
          tabla.addCell(diagnostico);
          tabla.addCell(nivel);
          tabla.addCell(observacionDiagnostico);
          tabla.addCell(fechaDiagnostico);
          break;

        case "PacienteTratamientos":
          this.tabla = new PdfPTable(5);
          this.tabla.setWidthPercentage(100);
          PdfPCell idCitaTratamiento = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell tratamiento = new PdfPCell(new Phrase("Tratamiento"));
          PdfPCell tipo = new PdfPCell(new Phrase("Tipo de Tratamiento"));
          PdfPCell dosis = new PdfPCell(new Phrase("Dosis"));
          PdfPCell fechaTratamiento = new PdfPCell(new Phrase("Fecha"));

          tabla.addCell(idCitaTratamiento);
          tabla.addCell(tratamiento);
          tabla.addCell(tipo);
          tabla.addCell(dosis);
          tabla.addCell(fechaTratamiento);
          break;

        case "PacienteHospitalizaciones":
          this.tabla = new PdfPTable(10);
          this.tabla.setWidthPercentage(100);
          
          PdfPCell numeroInternado = new PdfPCell(new Phrase("Número de Internado"));
          PdfPCell centroAtencion = new PdfPCell(new Phrase("Centro de Atención"));
          PdfPCell diagnosticoHospitalizacion = new PdfPCell(new Phrase("Diagnostico"));
          PdfPCell fechaInicio = new PdfPCell(new Phrase("Fecha de Inicio"));
          PdfPCell fechaFin = new PdfPCell(new Phrase("Fecha de Fin"));
          PdfPCell Servicio = new PdfPCell(new Phrase("Servicio"));
          PdfPCell funcionario = new PdfPCell(new Phrase("Funcionario"));
          PdfPCell fechaSeguimiento = new PdfPCell(new Phrase("Fecha de Seguimiento"));
          PdfPCell observacionHospitalizacion = new PdfPCell(new Phrase("Observacion"));
          PdfPCell tratamientoHospitalizacion = new PdfPCell(new Phrase("Tratamiento"));

          tabla.addCell(numeroInternado);
          tabla.addCell(centroAtencion);
          tabla.addCell(fechaSeguimiento);
          tabla.addCell(fechaInicio);
          tabla.addCell(fechaFin);
          tabla.addCell(Servicio);
          tabla.addCell(funcionario);
          tabla.addCell(diagnosticoHospitalizacion);
          tabla.addCell(observacionHospitalizacion);
          tabla.addCell(tratamientoHospitalizacion);
          break;

        case "Citas General":
          this.tabla = new PdfPTable(6);
          tabla.setWidthPercentage(100);

          PdfPCell idCitaGeneral = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell areaGeneral = new PdfPCell(new Phrase("ID del Área"));
          PdfPCell fechaGeneral = new PdfPCell(new Phrase("Fecha y hora"));
          PdfPCell observacionGeneral = new PdfPCell(new Phrase("Observación"));
          PdfPCell estadoGeneral = new PdfPCell(new Phrase("Estado Actual"));
          PdfPCell pacienteGeneral = new PdfPCell(new Phrase("Cedula del paciente"));

          tabla.addCell(idCitaGeneral);
          tabla.addCell(areaGeneral);
          tabla.addCell(fechaGeneral);
          tabla.addCell(observacionGeneral);
          tabla.addCell(estadoGeneral);
          tabla.addCell(pacienteGeneral);
          break;

        case "Citas estado":
          this.tabla = new PdfPTable(6);
          tabla.setWidthPercentage(100);
          PdfPCell idCita1 = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell area1 = new PdfPCell(new Phrase("ID del Área"));
          PdfPCell fecha1 = new PdfPCell(new Phrase("Fecha y hora"));
          PdfPCell observacion1 = new PdfPCell(new Phrase("Observación"));
          PdfPCell estado1 = new PdfPCell(new Phrase("Estado Actual"));
          PdfPCell paciente1 = new PdfPCell(new Phrase("Cedula del paciente"));

          tabla.addCell(idCita1);
          tabla.addCell(area1);
          tabla.addCell(fecha1);
          tabla.addCell(observacion1);
          tabla.addCell(estado1);
          tabla.addCell(paciente1);
          break;

        case "Citas fecha":
          this.tabla = new PdfPTable(6);
          tabla.setWidthPercentage(100);
          PdfPCell idCita2 = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell area2 = new PdfPCell(new Phrase("ID del Área"));
          PdfPCell fecha2 = new PdfPCell(new Phrase("Fecha y hora"));
          PdfPCell observacion2 = new PdfPCell(new Phrase("Observación"));
          PdfPCell estado2 = new PdfPCell(new Phrase("Estado Actual"));
          PdfPCell paciente2 = new PdfPCell(new Phrase("Cedula del paciente"));

          tabla.addCell(idCita2);
          tabla.addCell(area2);
          tabla.addCell(fecha2);
          tabla.addCell(observacion2);
          tabla.addCell(estado2);
          tabla.addCell(paciente2);
          break;

        case "Citas paciente":

          this.tabla = new PdfPTable(6);
          tabla.setWidthPercentage(100);
          PdfPCell idCita3 = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell area3 = new PdfPCell(new Phrase("ID del Área"));
          PdfPCell fecha3 = new PdfPCell(new Phrase("Fecha y hora"));
          PdfPCell observacion3 = new PdfPCell(new Phrase("Observación"));
          PdfPCell estado3 = new PdfPCell(new Phrase("Estado Actual"));
          PdfPCell paciente3 = new PdfPCell(new Phrase("Cedula del paciente"));

          tabla.addCell(idCita3);
          tabla.addCell(area3);
          tabla.addCell(fecha3);
          tabla.addCell(observacion3);
          tabla.addCell(estado3);
          tabla.addCell(paciente3);
          break;

        case "Citas especialidad":

          this.tabla = new PdfPTable(6);
          tabla.setWidthPercentage(100);

          PdfPCell idCita4 = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell area4 = new PdfPCell(new Phrase("ID del Área"));
          PdfPCell fecha4 = new PdfPCell(new Phrase("Fecha y hora"));
          PdfPCell observacion4 = new PdfPCell(new Phrase("Observación"));
          PdfPCell estado4 = new PdfPCell(new Phrase("Estado Actual"));
          PdfPCell paciente4 = new PdfPCell(new Phrase("Cedula del paciente"));

          tabla.addCell(idCita4);
          tabla.addCell(area4);
          tabla.addCell(fecha4);
          tabla.addCell(observacion4);
          tabla.addCell(estado4);
          tabla.addCell(paciente4);
          break;

        //Hospitalizaciones
        case "Hospitalizacion":

          this.tabla = new PdfPTable(11);
          tabla.setWidthPercentage(100);

          PdfPCell idInternado = new PdfPCell(new Phrase("Número de internado"));
          PdfPCell idCentro = new PdfPCell(new Phrase("Código del Centro"));
          PdfPCell idDiagnostico = new PdfPCell(new Phrase("Codigo del diagnóstico"));
          PdfPCell fechai = new PdfPCell(new Phrase("Fecha Inicial"));
          PdfPCell fechaf = new PdfPCell(new Phrase("Fecha finalización"));
          PdfPCell servicio = new PdfPCell(new Phrase("Servicio"));
          PdfPCell idFuncionario = new PdfPCell(new Phrase("Cédula del funcionario"));
          PdfPCell idPaciente = new PdfPCell(new Phrase("Cedula del paciente"));
          PdfPCell fechas = new PdfPCell(new Phrase("Fecha de seguimiento"));
          PdfPCell obv = new PdfPCell(new Phrase("Observación"));
          PdfPCell idTrat = new PdfPCell(new Phrase("Código del tratamiento"));

          tabla.addCell(idInternado);
          tabla.addCell(idCentro);
          tabla.addCell(idDiagnostico);
          tabla.addCell(fechai);
          tabla.addCell(fechaf);
          tabla.addCell(servicio);
          tabla.addCell(idFuncionario);
          tabla.addCell(idPaciente);
          tabla.addCell(fechas);
          tabla.addCell(obv);
          tabla.addCell(idTrat);
          break;
          
        case "Hospitalizacion fecha":
          
          this.tabla = new PdfPTable(11);
          tabla.setWidthPercentage(100);
          
          PdfPCell idInternado1 = new PdfPCell(new Phrase("Número de internado"));
          PdfPCell idCentro1 = new PdfPCell(new Phrase("Código del Centro"));
          PdfPCell idDiagnostico1 = new PdfPCell(new Phrase("Codigo del diagnóstico"));
          PdfPCell fechai1 = new PdfPCell(new Phrase("Fecha Inicial"));
          PdfPCell fechaf1 = new PdfPCell(new Phrase("Fecha finalización"));
          PdfPCell servicio1 = new PdfPCell(new Phrase("Servicio"));
          PdfPCell idFuncionario1 = new PdfPCell(new Phrase("Cédula del funcionario"));
          PdfPCell idPaciente1 = new PdfPCell(new Phrase("Cedula del paciente"));
          PdfPCell fechas1 = new PdfPCell(new Phrase("Fecha de seguimiento"));
          PdfPCell obv1 = new PdfPCell(new Phrase("Observación"));
          PdfPCell idTrat1 = new PdfPCell(new Phrase("Código del tratamiento"));

          tabla.addCell(idInternado1);
          tabla.addCell(idCentro1);
          tabla.addCell(idDiagnostico1);
          tabla.addCell(fechai1);
          tabla.addCell(fechaf1);
          tabla.addCell(servicio1);
          tabla.addCell(idFuncionario1);
          tabla.addCell(idPaciente1);
          tabla.addCell(fechas1);
          tabla.addCell(obv1);
          tabla.addCell(idTrat1);
          break;

        case "Hospitalizacion especialidad":
          
          this.tabla = new PdfPTable(12);
          tabla.setWidthPercentage(100);

          PdfPCell idInternado2 = new PdfPCell(new Phrase("Número de internado"));
          PdfPCell idCentro2 = new PdfPCell(new Phrase("Código del Centro"));
          PdfPCell idDiagnostico2 = new PdfPCell(new Phrase("Codigo del diagnóstico"));
          PdfPCell especialidad2 = new PdfPCell(new Phrase("Especialidad"));
          PdfPCell fechai2 = new PdfPCell(new Phrase("Fecha Inicial"));
          PdfPCell fechaf2 = new PdfPCell(new Phrase("Fecha finalización"));
          PdfPCell servicio2 = new PdfPCell(new Phrase("Servicio"));
          PdfPCell idFuncionario2 = new PdfPCell(new Phrase("Cédula del funcionario"));
          PdfPCell idPaciente2 = new PdfPCell(new Phrase("Cedula del paciente"));
          PdfPCell fechas2 = new PdfPCell(new Phrase("Fecha de seguimiento"));
          PdfPCell obv2 = new PdfPCell(new Phrase("Observación"));
          PdfPCell idTrat2 = new PdfPCell(new Phrase("Código del tratamiento"));

          tabla.addCell(idInternado2);
          tabla.addCell(idCentro2);
          tabla.addCell(idDiagnostico2);
          tabla.addCell(especialidad2);
          tabla.addCell(fechai2);
          tabla.addCell(fechaf2);
          tabla.addCell(servicio2);
          tabla.addCell(idFuncionario2);
          tabla.addCell(idPaciente2);
          tabla.addCell(fechas2);
          tabla.addCell(obv2);
          tabla.addCell(idTrat2);
          break;

        case "Hospitalizacion paciente":
          
          this.tabla = new PdfPTable(11);
          tabla.setWidthPercentage(100);

          PdfPCell idInternado3 = new PdfPCell(new Phrase("Número de internado"));
          PdfPCell idCentro3 = new PdfPCell(new Phrase("Código del Centro"));
          PdfPCell idDiagnostico3 = new PdfPCell(new Phrase("Codigo del diagnóstico"));
          PdfPCell especialidad3 = new PdfPCell(new Phrase("Especialidad"));
          PdfPCell fechai3 = new PdfPCell(new Phrase("Fecha Inicial"));
          PdfPCell fechaf3 = new PdfPCell(new Phrase("Fecha finalización"));
          PdfPCell servicio3 = new PdfPCell(new Phrase("Servicio"));
          PdfPCell idFuncionario3 = new PdfPCell(new Phrase("Cédula del funcionario"));
          PdfPCell idPaciente3 = new PdfPCell(new Phrase("Cedula del paciente"));
          PdfPCell fechas3 = new PdfPCell(new Phrase("Fecha de seguimiento"));
          PdfPCell obv3 = new PdfPCell(new Phrase("Observación"));
          PdfPCell idTrat3 = new PdfPCell(new Phrase("Código del tratamiento"));

          tabla.addCell(idInternado3);
          tabla.addCell(idCentro3);
          tabla.addCell(idDiagnostico3);
          tabla.addCell(especialidad3);
          tabla.addCell(fechai3);
          tabla.addCell(fechaf3);
          tabla.addCell(servicio3);
          tabla.addCell(idFuncionario3);
          tabla.addCell(idPaciente3);
          tabla.addCell(fechas3);
          tabla.addCell(obv3);
          tabla.addCell(idTrat3);
          break;
          
         case "HospiPaci":
          this.tabla = new PdfPTable(11);
          this.tabla.setWidthPercentage(90);  
          
          
          PdfPCell numInternado= new PdfPCell(new Phrase("Número de Internado"));
          PdfPCell codCentro = new PdfPCell(new Phrase("Código Centro"));
          PdfPCell idDiag = new PdfPCell(new Phrase("ID Diagnóstico"));
          PdfPCell fechaInicio1 = new PdfPCell(new Phrase("Fecha Inicio"));
          PdfPCell fechaFinal = new PdfPCell(new Phrase("Fecha Final"));
          PdfPCell servicio11 = new PdfPCell(new Phrase("Servicio"));
          PdfPCell cedFuncionario = new PdfPCell(new Phrase("Cedula Funcionario"));
          PdfPCell cedPaciente = new PdfPCell(new Phrase("Cedula Paciente"));
          PdfPCell fechaRevi = new PdfPCell(new Phrase("Fecha Revisión"));
          PdfPCell observacion11 = new PdfPCell(new Phrase("Observación"));
          PdfPCell tratamiento11 = new PdfPCell(new Phrase("Tratamiento"));
          
          tabla.addCell(numInternado);
          tabla.addCell(codCentro);
          tabla.addCell(idDiag);                   
          tabla.addCell(fechaInicio1);
          tabla.addCell(fechaFinal);
          tabla.addCell(servicio11);
          tabla.addCell(cedFuncionario);
          tabla.addCell(cedPaciente);
          tabla.addCell(fechaRevi);
          tabla.addCell(observacion11);
          tabla.addCell(tratamiento11);
          break;
          
          case "Gen Trata":
          this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);      
          PdfPCell CantTrata = new PdfPCell(new Phrase("Cantidad Total Tratamientos"));
          tabla.addCell(CantTrata);

          break;
          
         
        case "Cant Trata Tipo":
          this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);    
          PdfPCell CantTrataTipo= new PdfPCell(new Phrase("Cantidad Total Tratamientos por Tipo"));
          tabla.addCell(CantTrataTipo);
          break;

          
          
        case "Cant Trata Espe":
           this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);   
          PdfPCell CantTrataEspe= new PdfPCell(new Phrase("Cantidad Total Tratamientos por Especialidad"));
          tabla.addCell(CantTrataEspe);
          break;
          
          
        case "Cant Trata Paci":
          this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);    
          PdfPCell CantTrataPaci= new PdfPCell(new Phrase("Cantidad Total Tratamientos de Paciente"));
          tabla.addCell(CantTrataPaci);
          break; 
          
        
        case "Cant Diag Paci":
          this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);    
          PdfPCell CantDiagPaciente= new PdfPCell(new Phrase("Cantidad Total de Diagnosticos de Paciente"));
          tabla.addCell(CantDiagPaciente);
          break;  
          
          
        case "Cant Diag Nivel":
          this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);  
          PdfPCell CantDiagNivel= new PdfPCell(new Phrase("Cantidad Total Diagnosticos por Nivel"));
          tabla.addCell(CantDiagNivel);
          break; 
          
        case "Cant Cita Rango":
          this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);  
          PdfPCell CantCitaRango= new PdfPCell(new Phrase("Cantidad Total Cita por Rango"));
          tabla.addCell(CantCitaRango);
          break;   
          
          
        case "Cant Citas Estado":
          this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);  
          PdfPCell CantCitaEstado= new PdfPCell(new Phrase("Cantidad Total Cita por Estado"));
          tabla.addCell(CantCitaEstado);
          break;   
          
          
        case "Cant Citas Especialidad":
          this.tabla = new PdfPTable(1);
          this.tabla.setWidthPercentage(90);    
          PdfPCell CantCitaEspecialidad= new PdfPCell(new Phrase("Cantidad Total Cita por Especialidad"));
          tabla.addCell(CantCitaEspecialidad);
          break;
          
        
        case "Trata Paci Fechas":
          this.tabla = new PdfPTable(8);
          this.tabla.setWidthPercentage(90);    
            
          PdfPCell cedPaciente1 = new PdfPCell(new Phrase("Cedula Paciente"));
          PdfPCell nivel1 = new PdfPCell(new Phrase("Nivel"));
          PdfPCell observaciones1 = new PdfPCell(new Phrase("Observaciones"));
          PdfPCell tratamiento1 = new PdfPCell(new Phrase("Tratamiento"));
          PdfPCell dosis1 = new PdfPCell(new Phrase("Dosis"));
          PdfPCell tipo1 = new PdfPCell(new Phrase("Tipo Tratamiento"));
          PdfPCell nombreDiag1 = new PdfPCell(new Phrase("Nombre Diagnostico"));
          PdfPCell fecha11 = new PdfPCell(new Phrase("Fecha"));
         
          
          tabla.addCell(cedPaciente1);
          tabla.addCell(nivel1);
          tabla.addCell(observaciones1);
          tabla.addCell(tratamiento1);
          tabla.addCell(dosis1);
          tabla.addCell(tipo1);
          tabla.addCell(nombreDiag1);
          tabla.addCell(fecha11);
          break;   
          
        
        case "Trata Paci Tipo":
          this.tabla = new PdfPTable(8);
          this.tabla.setWidthPercentage(90);    
            
          PdfPCell cedPaciente2 = new PdfPCell(new Phrase("Cedula Paciente"));
          PdfPCell nivel2 = new PdfPCell(new Phrase("Nivel"));
          PdfPCell observaciones2 = new PdfPCell(new Phrase("Observaciones"));
          PdfPCell tratamiento2 = new PdfPCell(new Phrase("Tratamiento"));
          PdfPCell dosis2 = new PdfPCell(new Phrase("Dosis"));
          PdfPCell tipo2 = new PdfPCell(new Phrase("Tipo Tratamiento"));
          PdfPCell nombreDiag2 = new PdfPCell(new Phrase("Nombre Diagnostico"));

          
          tabla.addCell(cedPaciente2);
          tabla.addCell(nivel2);
          tabla.addCell(observaciones2);
          tabla.addCell(tratamiento2);
          tabla.addCell(dosis2);
          tabla.addCell(tipo2);
          tabla.addCell(nombreDiag2);

          break;
          
          
        case "Trata Paci Nombre":
          this.tabla = new PdfPTable(8);
          this.tabla.setWidthPercentage(90);    
            
          PdfPCell cedPaciente3 = new PdfPCell(new Phrase("Cedula Paciente"));
          PdfPCell nivel3 = new PdfPCell(new Phrase("Nivel"));
          PdfPCell observaciones3 = new PdfPCell(new Phrase("Observaciones"));
          PdfPCell tratamiento3 = new PdfPCell(new Phrase("Tratamiento"));
          PdfPCell dosis3 = new PdfPCell(new Phrase("Dosis"));
          PdfPCell tipo3 = new PdfPCell(new Phrase("Tipo Tratamiento"));
          PdfPCell nombreDiag3 = new PdfPCell(new Phrase("Nombre Diagnostico"));

          
          tabla.addCell(cedPaciente3);
          tabla.addCell(nivel3);
          tabla.addCell(observaciones3);
          tabla.addCell(tratamiento3);
          tabla.addCell(dosis3);
          tabla.addCell(tipo3);
          tabla.addCell(nombreDiag3);
          break;
          
          
        case "Diag Paci FechaR":
          this.tabla = new PdfPTable(8);
          this.tabla.setWidthPercentage(90);    
            
          PdfPCell cedPaciente4 = new PdfPCell(new Phrase("Cedula Paciente"));
          PdfPCell nivel4 = new PdfPCell(new Phrase("Nivel"));
          PdfPCell observaciones4 = new PdfPCell(new Phrase("Observaciones"));
          PdfPCell tratamiento4 = new PdfPCell(new Phrase("Tratamiento"));
          PdfPCell dosis4 = new PdfPCell(new Phrase("Dosis"));
          PdfPCell tipo4 = new PdfPCell(new Phrase("Tipo Tratamiento"));
          PdfPCell nombreDiag4 = new PdfPCell(new Phrase("Nombre Diagnostico"));
          PdfPCell fecha41 = new PdfPCell(new Phrase("Fecha Definida"));
          
          tabla.addCell(cedPaciente4);
          tabla.addCell(nivel4);
          tabla.addCell(observaciones4);
          tabla.addCell(tratamiento4);
          tabla.addCell(dosis4);
          tabla.addCell(tipo4);
          tabla.addCell(nombreDiag4);
          tabla.addCell(fecha41);
          break;
          
        
         case "Diag Nombre Paci":
          this.tabla = new PdfPTable(8);
          this.tabla.setWidthPercentage(90);     
            
          PdfPCell cedPaciente5 = new PdfPCell(new Phrase("Cedula Paciente"));
          PdfPCell nivel5 = new PdfPCell(new Phrase("Nivel"));
          PdfPCell observaciones5 = new PdfPCell(new Phrase("Observaciones"));
          PdfPCell tratamiento5 = new PdfPCell(new Phrase("Tratamiento"));
          PdfPCell dosis5 = new PdfPCell(new Phrase("Dosis"));
          PdfPCell tipo5 = new PdfPCell(new Phrase("Tipo Tratamiento"));
          PdfPCell nombreDiag5 = new PdfPCell(new Phrase("Nombre Diagnostico"));
          PdfPCell fecha5 = new PdfPCell(new Phrase("Fecha Definida"));
          
          tabla.addCell(cedPaciente5);
          tabla.addCell(nivel5);
          tabla.addCell(observaciones5);
          tabla.addCell(tratamiento5);
          tabla.addCell(dosis5);
          tabla.addCell(tipo5);
          tabla.addCell(nombreDiag5);
          tabla.addCell(fecha5);
          break;
          
        
        case "Diag Nivel Paci":
            
          this.tabla = new PdfPTable(8);
          this.tabla.setWidthPercentage(90);    
            
          PdfPCell cedPaciente6 = new PdfPCell(new Phrase("Cedula Paciente"));
          PdfPCell nivel6 = new PdfPCell(new Phrase("Nivel"));
          PdfPCell observaciones6 = new PdfPCell(new Phrase("Observaciones"));
          PdfPCell tratamiento6 = new PdfPCell(new Phrase("Tratamiento"));
          PdfPCell dosis6 = new PdfPCell(new Phrase("Dosis"));
          PdfPCell tipo6 = new PdfPCell(new Phrase("Tipo Tratamiento"));
          PdfPCell nombreDiag6 = new PdfPCell(new Phrase("Nombre Diagnostico"));
          PdfPCell fecha6 = new PdfPCell(new Phrase("Fecha Definida"));
          
          tabla.addCell(cedPaciente6);
          tabla.addCell(nivel6);
          tabla.addCell(observaciones6);
          tabla.addCell(tratamiento6);
          tabla.addCell(dosis6);
          tabla.addCell(tipo6);
          tabla.addCell(nombreDiag6);
          tabla.addCell(fecha6);
          break;  
          
        default:
          break;
      }
      
         //Se escribe la tabla        
      for (int i = 0; i < pFilas.size(); i++){
        for (int z = 0; z < pFilas.get(i).length; z++){
          tabla.addCell(pFilas.get(i)[z].toString());
        }
      }

      documento.add(tabla);
      documento.close();
      
    } catch (FileNotFoundException | DocumentException e){
      System.err.println(e.getMessage());
    } 
  }

  @Override
  public void exportarCSV(String flag, ArrayList<Object[]> lista) {
    //Reporte Hospitalización General de Paciente

    if (flag.equals("Hospi Paciente")){

      String salidaArchivo = "Hospi.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Numero Internado");
        salidaCSV.write("Código Centro");
        salidaCSV.write("Id Diagnóstico");
        salidaCSV.write("Fecha Inicio");
        salidaCSV.write("Fecha Final");
        salidaCSV.write("Servicio");
        salidaCSV.write("Cedula Funcionario");
        salidaCSV.write("Cedula Paciente");
        salidaCSV.write("Fecha Revisión");
        salidaCSV.write("Observación");
        salidaCSV.write("Tratamiento");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Tratamiento Count Gen")){

      String salidaArchivo = "TratamientosGenerales.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {

        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
        salidaCSV.write("Cantidad Total de Tratamientos");
        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Tratamiento Count Type")){

      String salidaArchivo = "TratamientosCantType.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Cantidad Total de Tratamientos según Tipo");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Tratamiento Count Espe")) {

      String salidaArchivo = "TratamientosCantEspe.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe) {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');


        salidaCSV.write("Cantidad Total de Tratamientos según Especialidad");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Tratamiento Count Paci")){

      String salidaArchivo = "TratamientosCantPaciente.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe) {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Cantidad Total de Tratamientos asignados a Paciente");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Diag Count Paci")) {

      String salidaArchivo = "DiagnosticosCantPaciente.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Cantidad Total de Diagnosticos asignados a Paciente");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Diag Count Nivel")) {

      String salidaArchivo = "DiagnosticosCantNivel.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Cantidad Total de Diagnosticos por Nivel");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Citas Count Date Range")) {

      String salidaArchivo = "CitasCantDateRange.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Cantidad Total de Citas en rango de fechas");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Citas Count Estate")) {

      String salidaArchivo = "CitasCantEstado.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe) {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Cantidad Total de Citas por estado");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Citas Count Espe")) {

      String salidaArchivo = "CitasCantEspecialidad.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe) {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Cantidad Total de Citas por especialidad");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Trata Date Range")){

      String salidaArchivo = "TrataPacienteDateRange.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Cedula Paciente");
        salidaCSV.write("Nivel");
        salidaCSV.write("Observaciones");
        salidaCSV.write("Tratamiento");
        salidaCSV.write("Dosis");
        salidaCSV.write("Tipo Tratamiento");
        salidaCSV.write("Nombre Diagnostico");
        salidaCSV.write("Fecha");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
       for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Trata Type")) {

      String salidaArchivo = "TrataPacienteTipo.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe) {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Cedula Paciente");
        salidaCSV.write("Nivel");
        salidaCSV.write("Observaciones");
        salidaCSV.write("Tratamiento");
        salidaCSV.write("Dosis");
        salidaCSV.write("Tipo Tratamiento");
        salidaCSV.write("Nombre Diagnostico");
        salidaCSV.write("Fecha");
        salidaCSV.write("Tipo");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Trata Nombre")){

      String salidaArchivo = "TrataPacienteNombre.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Cedula Paciente");
        salidaCSV.write("Nivel");
        salidaCSV.write("Observaciones");
        salidaCSV.write("Tratamiento");
        salidaCSV.write("Dosis");
        salidaCSV.write("Tipo Tratamiento");
        salidaCSV.write("Nombre Diagnostico");
        salidaCSV.write("Fecha");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Diag Data Range")) {

      String salidaArchivo = "DiagPacienteDateRange.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe) {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Cedula Paciente");
        salidaCSV.write("Nivel");
        salidaCSV.write("Observaciones");
        salidaCSV.write("Tratamiento");
        salidaCSV.write("Dosis");
        salidaCSV.write("Tipo Tratamiento");
        salidaCSV.write("Nombre Diagnostico");
        salidaCSV.write("Fecha"); //escribe el nombre de las columnas.

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Diag Nombre")){

      String salidaArchivo = "DiagPacienteNombre.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Cedula Paciente");
        salidaCSV.write("Nivel");
        salidaCSV.write("Observaciones");
        salidaCSV.write("Tratamiento");
        salidaCSV.write("Dosis");
        salidaCSV.write("Tipo Tratamiento");
        salidaCSV.write("Nombre Diagnostico");
        salidaCSV.write("Fecha");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Diag Nivel")){

      String salidaArchivo = "DiagPacienteNivel.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Cedula Paciente");
        salidaCSV.write("Nivel");
        salidaCSV.write("Observaciones");
        salidaCSV.write("Tratamiento");
        salidaCSV.write("Dosis");
        salidaCSV.write("Tipo Tratamiento");
        salidaCSV.write("Nombre Diagnostico");
        salidaCSV.write("Fecha");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
    
    if (flag.equals("PacienteCitas")){

      String salidaArchivo = "PacienteCitas.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Número de Cita");
        salidaCSV.write("Especialidad");
        salidaCSV.write("Fecha");
        salidaCSV.write("Observación");
        salidaCSV.write("Estado Actual");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
    
    if (flag.equals("PacienteDiagnósticos")) {

      String salidaArchivo = "PacienteDiagnósticos.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Número de Cita");
        salidaCSV.write("Diagnóstico");
        salidaCSV.write("Nivel");
        salidaCSV.write("Observación");
        salidaCSV.write("Fecha");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    
    if (flag.equals("PacienteTratamientos")){

      String salidaArchivo = "PacienteTratamientos.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Número de Cita");
        salidaCSV.write("Tratamiento");
        salidaCSV.write("Tipo de Tratamiento");
        salidaCSV.write("Dosis");
        salidaCSV.write("Fecha");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        //salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
    
    if (flag.equals("PacienteHospitalizaciones")){
      String salidaArchivo = "PacienteHospitalizaciones.csv";
      boolean existe = new File(salidaArchivo).exists();
      
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        salidaCSV.write("Número de Internado");
        salidaCSV.write("Centro de Atención");
        salidaCSV.write("Diagnóstico");
        salidaCSV.write("Fecha de Inicio");
        salidaCSV.write("Fecha de Fin");
        salidaCSV.write("Servicio");
        salidaCSV.write("Funcionario");
        salidaCSV.write("Fecha de Seguimiento");
        salidaCSV.write("Observación");
        salidaCSV.write("Tratamiento");

        salidaCSV.endRecord();

        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    if (flag.equals("Citas General")){

      String salidaArchivo = "citas.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("ID");
        salidaCSV.write("ID_Area");
        salidaCSV.write("Fecha y Hora");
        salidaCSV.write("Observación");
        salidaCSV.write("Estado");
        salidaCSV.write("Cédula Paciente");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++) {
          for (int i = 0; i < lista.get(z).length; i++) {
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();

        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Citas estado")){

      String salidaArchivo = "citas_estados.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe) {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("ID");
        salidaCSV.write("ID_Area");
        salidaCSV.write("Fecha y Hora");
        salidaCSV.write("Observación");
        salidaCSV.write("Estado");
        salidaCSV.write("Cédula Paciente");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++)
        {
          for (int i = 0; i < lista.get(z).length; i++)
          {
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();

        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    if (flag.equals("Citas fecha"))
    {
      System.out.println("a");

      String salidaArchivo = "citas_fechas.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("ID");
        salidaCSV.write("ID_Area");
        salidaCSV.write("Fecha y Hora");
        salidaCSV.write("Observación");
        salidaCSV.write("Estado");
        salidaCSV.write("Cédula Paciente");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++)
        {
          for (int i = 0; i < lista.get(z).length; i++)
          {
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();

        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
    
    if (flag.equals("Citas paciente")){

      String salidaArchivo = "citas_paciente.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("ID");
        salidaCSV.write("ID_Area");
        salidaCSV.write("Fecha y Hora");
        salidaCSV.write("Observación");
        salidaCSV.write("Estado");
        salidaCSV.write("Cédula Paciente");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++)
        {
          for (int i = 0; i < lista.get(z).length; i++)
          {
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();

        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Citas especialidad"))
    {

      String salidaArchivo = "citas_especialidad.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("ID");
        salidaCSV.write("ID_Area");
        salidaCSV.write("Fecha y Hora");
        salidaCSV.write("Observación");
        salidaCSV.write("Estado");
        salidaCSV.write("Cédula Paciente");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++) {
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();
        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Hospitalizacion")){

      String salidaArchivo = "hospitalizacion.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Numero Internado");
        salidaCSV.write("Código del Centro");
        salidaCSV.write("Id Diagnóstico");

        salidaCSV.write("Fecha inicial");
        salidaCSV.write("Fecha finalización");
        salidaCSV.write("Servicio");
        salidaCSV.write("Cédula del Funcionario");
        salidaCSV.write("Cedula del Paciente");
        salidaCSV.write("Fecha Seguimiento");
        salidaCSV.write("Observacion");
        salidaCSV.write("ID Tratamiento");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++) {
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();

        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Hospitalizacion fecha")){

      String salidaArchivo = "hospitalizacion_fecha.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Numero Internado");
        salidaCSV.write("Código del Centro");
        salidaCSV.write("Id Diagnóstico");

        salidaCSV.write("Fecha inicial");
        salidaCSV.write("Fecha finalización");
        salidaCSV.write("Servicio");
        salidaCSV.write("Cédula del Funcionario");
        salidaCSV.write("Cedula del Paciente");
        salidaCSV.write("Fecha Seguimiento");
        salidaCSV.write("Observacion");
        salidaCSV.write("ID Tratamiento");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();

        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }

    }
    if (flag.equals("Hospitalizacion especialidad")){

      String salidaArchivo = "hospitalizacion_especialidad.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe){
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try{
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Numero Internado");
        salidaCSV.write("Código del Centro");
        salidaCSV.write("Id Diagnóstico");

        salidaCSV.write("Fecha inicial");
        salidaCSV.write("Fecha finalización");
        salidaCSV.write("Servicio");
        salidaCSV.write("Cédula del Funcionario");
        salidaCSV.write("Cedula del Paciente");
        salidaCSV.write("Fecha Seguimiento");
        salidaCSV.write("Observacion");
        salidaCSV.write("ID Tratamiento");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++) {
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();

        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }

    if (flag.equals("Hospitalizacion paciente")){

      String salidaArchivo = "hospitalizacion_paciente.csv";
      boolean existe = new File(salidaArchivo).exists();

      //si existe el archivo entonces lo borra.
      if (existe) {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try {
        //crea el archivo.
        CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

        //escribe el nombre de las columnas.
        salidaCSV.write("Numero Internado");
        salidaCSV.write("Código del Centro");
        salidaCSV.write("Id Diagnóstico");

        salidaCSV.write("Fecha inicial");
        salidaCSV.write("Fecha finalización");
        salidaCSV.write("Servicio");
        salidaCSV.write("Cédula del Funcionario");
        salidaCSV.write("Cedula del Paciente");
        salidaCSV.write("Fecha Seguimiento");
        salidaCSV.write("Observacion");
        salidaCSV.write("ID Tratamiento");

        salidaCSV.endRecord();// termina la escritura.

        //se recorre la lista y lo escribe en el archivo csv.
        for (int z = 0; z < lista.size(); z++){
          for (int i = 0; i < lista.get(z).length; i++){
            salidaCSV.write(lista.get(z)[i].toString());
          }
          salidaCSV.endRecord();

        }
        // salidaCSV.endRecord();// termina la escritura.

        salidaCSV.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

@Override
  public void exportarHTML(ArrayList<Object[]> pFilas, String pTipoReporte) {
    String html2 = style("table, th, td { border: 1px solid black; }"
            + "\ntbody tr:nth-child(odd) { background-color: #06FCD3 }"
            + "\nth, td { padding: 10px }").render();
    
    if (pTipoReporte.equals("PacienteCitas")){
      
      for (int i = 0; i != pFilas.size(); i++) {
        html2 += table().with(tr().with(
                th().withText("Cita")),
                tr().with(td().withText("Número de Cita: " + pFilas.get(i)[0])),
                tr().with(td().withText("Especialidad: " + pFilas.get(i)[1])),
                tr().with(td().withText("Fecha: " + pFilas.get(i)[2])),
                tr().with(td().withText("Observación: " + pFilas.get(i)[3])),
                tr().with(td().withText("Estado: " + pFilas.get(i)[4])),
                tr().with(td().withText(" "))
        ).render();
        
      }
      File archivo = new File("PacienteCitas.html");
      System.out.println(html2);
      try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(html2);
        bw.close();
      } catch (IOException e){
        System.out.println(e);
      }
    }
    
    if (pTipoReporte.equals("PacienteDiagnósticos")){
      
      for (int i = 0; i != pFilas.size(); i++) {
        html2 += table().with(tr().with(
                th().withText("Diagnóstico")),
                tr().with(td().withText("Número de Cita: " + pFilas.get(i)[0])),
                tr().with(td().withText("Diagnóstico: " + pFilas.get(i)[1])),
                tr().with(td().withText("Nivel: " + pFilas.get(i)[2])),
                tr().with(td().withText("Observación: " + pFilas.get(i)[3])),
                tr().with(td().withText("Fecha: " + pFilas.get(i)[4])),
                tr().with(td().withText(" "))
        ).render();
        
      }
      File archivo = new File("PacienteDiagnósticos.html");
      System.out.println(html2);
      try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(html2);
        bw.close();
      } catch (IOException e){
        System.out.println(e);
      }
    }
    
    if (pTipoReporte.equals("PacienteTratamientos")){
      
      for (int i = 0; i != pFilas.size(); i++) {
        html2 += table().with(tr().with(
                th().withText("Tratamiento")),
                tr().with(td().withText("Número de Cita: " + pFilas.get(i)[0])),
                tr().with(td().withText("Tratamiento: " + pFilas.get(i)[1])),
                tr().with(td().withText("Tipo de Tratamiento: " + pFilas.get(i)[2])),
                tr().with(td().withText("Dosis: " + pFilas.get(i)[3])),
                tr().with(td().withText("Fecha: " + pFilas.get(i)[4])),
                tr().with(td().withText(" "))
        ).render();
        
      }
      File archivo = new File("PacienteTratamientos.html");
      System.out.println(html2);
      try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(html2);
        bw.close();
      } catch (IOException e){
        System.out.println(e);
      }
    }
    
    if (pTipoReporte.equals("PacienteHospitalizaciones")){
      
      for (int i = 0; i != pFilas.size(); i++) {
        html2 += table().with(tr().with(
                th().withText("Hospitalizaciones")),
                tr().with(td().withText("Número de Internado: " + pFilas.get(i)[0])),
                tr().with(td().withText("Centro de Atención: " + pFilas.get(i)[1])),
                tr().with(td().withText("Diagnóstico: " + pFilas.get(i)[2])),
                tr().with(td().withText("Fecha de Inicio: " + pFilas.get(i)[3])),
                tr().with(td().withText("Fecha de Fin: " + pFilas.get(i)[4])),
                tr().with(td().withText("Servicio: " + pFilas.get(i)[5])),
                tr().with(td().withText("Funcionario: " + pFilas.get(i)[6])),
                tr().with(td().withText("Fecha de Seguimiento: " + pFilas.get(i)[7])),
                tr().with(td().withText("Observación: " + pFilas.get(i)[8])),
                tr().with(td().withText("Tratamiento: " + pFilas.get(i)[9])),
                tr().with(td().withText(" "))
        ).render();
      }

      if (pTipoReporte.equals("Citas General")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Cita")),
                  tr().with(td().withText("Número de Cita: " + pFilas.get(i)[0])),
                  tr().with(td().withText("ID del área" + pFilas.get(i)[1])),
                  tr().with(td().withText("Fecha y hora : " + pFilas.get(i)[2])),
                  tr().with(td().withText("Observación: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Estado: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Cedula del paciente: " + pFilas.get(i)[5])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("Citas.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Citas estado")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Cita")),
                  tr().with(td().withText("Número de Cita: " + pFilas.get(i)[0])),
                  tr().with(td().withText("ID del área" + pFilas.get(i)[1])),
                  tr().with(td().withText("Fecha y hora : " + pFilas.get(i)[2])),
                  tr().with(td().withText("Observación: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Estado: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Cedula del paciente: " + pFilas.get(i)[5])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("CitasEstado.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Citas fecha")){

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Cita")),
                  tr().with(td().withText("Número de Cita: " + pFilas.get(i)[0])),
                  tr().with(td().withText("ID del área" + pFilas.get(i)[1])),
                  tr().with(td().withText("Fecha y hora : " + pFilas.get(i)[2])),
                  tr().with(td().withText("Observación: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Estado: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Cedula del paciente: " + pFilas.get(i)[5])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("CitasFecha.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }

      }
      if (pTipoReporte.equals("Citas paciente"))
      {

        for (int i = 0; i != pFilas.size(); i++)
        {
          html2 += table().with(tr().with(
                  th().withText("Cita")),
                  tr().with(td().withText("Número de Cita: " + pFilas.get(i)[0])),
                  tr().with(td().withText("ID del área" + pFilas.get(i)[1])),
                  tr().with(td().withText("Fecha y hora : " + pFilas.get(i)[2])),
                  tr().with(td().withText("Observación: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Estado: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Cedula del paciente: " + pFilas.get(i)[5])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("CitasPaciente.html");
        System.out.println(html2);
        try {
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Citas especialidad")) {

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Cita")),
                  tr().with(td().withText("Número de Cita: " + pFilas.get(i)[0])),
                  tr().with(td().withText("ID del área" + pFilas.get(i)[1])),
                  tr().with(td().withText("Fecha y hora : " + pFilas.get(i)[2])),
                  tr().with(td().withText("Observación: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Estado: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Cedula del paciente: " + pFilas.get(i)[5])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("CitasEspecialidad.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Hospitalizacion")){

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Hospitalización")),
                  tr().with(td().withText("Número de internado " + pFilas.get(i)[0])),
                  tr().with(td().withText("Código del centro" + pFilas.get(i)[1])),
                  tr().with(td().withText("Código del diagnóstico" + pFilas.get(i)[2])),
                  tr().with(td().withText("Fecha inicio: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Fecha finalización: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Servicio: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Cédula del funcionario: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Cédula del paciente: " + pFilas.get(i)[7])),
                  tr().with(td().withText("Fecha seguimiento: " + pFilas.get(i)[8])),
                  tr().with(td().withText("Observación " + pFilas.get(i)[9])),
                  tr().with(td().withText("Código del tratamiento " + pFilas.get(i)[10])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("Hospitalizacion.html");
        System.out.println(html2);
        try {
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Hospitalizacion fecha")){

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Hospitalización")),
                  tr().with(td().withText("Número de internado " + pFilas.get(i)[0])),
                  tr().with(td().withText("Código del centro" + pFilas.get(i)[1])),
                  tr().with(td().withText("Código del diagnóstico" + pFilas.get(i)[2])),
                  tr().with(td().withText("Fecha inicio: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Fecha finalización: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Servicio: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Cédula del funcionario: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Cédula del paciente: " + pFilas.get(i)[7])),
                  tr().with(td().withText("Fecha seguimiento: " + pFilas.get(i)[8])),
                  tr().with(td().withText("Observación " + pFilas.get(i)[9])),
                  tr().with(td().withText("Código del tratamiento " + pFilas.get(i)[10])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("HospitalizacionFecha.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Hospitalizacion especialidad")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Hospitalización")),
                  tr().with(td().withText("Número de internado " + pFilas.get(i)[0])),
                  tr().with(td().withText("Código del centro" + pFilas.get(i)[1])),
                  tr().with(td().withText("Código del diagnóstico" + pFilas.get(i)[2])),
                  tr().with(td().withText("Especialidad" + pFilas.get(i)[3])),
                  tr().with(td().withText("Fecha inicio: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Fecha finalización: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Servicio: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Cédula del funcionario: " + pFilas.get(i)[7])),
                  tr().with(td().withText("Cédula del paciente: " + pFilas.get(i)[8])),
                  tr().with(td().withText("Fecha seguimiento: " + pFilas.get(i)[9])),
                  tr().with(td().withText("Observación " + pFilas.get(i)[10])),
                  tr().with(td().withText("Código del tratamiento " + pFilas.get(i)[11])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("HospitalizacionEspecialidad.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Hospitalizacion paciente")) {

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Hospitalización")),
                  tr().with(td().withText("Número de internado " + pFilas.get(i)[0])),
                  tr().with(td().withText("Código del centro" + pFilas.get(i)[1])),
                  tr().with(td().withText("Código del diagnóstico" + pFilas.get(i)[2])),
                  tr().with(td().withText("Fecha inicio: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Fecha finalización: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Servicio: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Cédula del funcionario: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Cédula del paciente: " + pFilas.get(i)[7])),
                  tr().with(td().withText("Fecha seguimiento: " + pFilas.get(i)[8])),
                  tr().with(td().withText("Observación " + pFilas.get(i)[9])),
                  tr().with(td().withText("Código del tratamiento " + pFilas.get(i)[10])),
                  tr().with(td().withText(" "))
          ).render();
        }

        File archivo = new File("PacienteHospitalizaciones.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }
      
      if (pTipoReporte.equals("HospiPaci")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Hospitalización Paciente")),
                  tr().with(td().withText("Número Internado: " + pFilas.get(i)[0])),
                  tr().with(td().withText("Código Centro: " + pFilas.get(i)[1])),
                  tr().with(td().withText("Id Diagnóstico: " + pFilas.get(i)[2])),
                  tr().with(td().withText("Fecha Inicio: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Fecha Final: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Servicio: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Cedula Funcionario: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Cedula Paciente: " + pFilas.get(i)[7])),
                  tr().with(td().withText("Fecha Revisión: " + pFilas.get(i)[8])),
                  tr().with(td().withText("Observación: " + pFilas.get(i)[9])),
                  tr().with(td().withText("Tratamiento: " + pFilas.get(i)[10])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("HospiPaci.html");
        System.out.println(html2);
        try {
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Gen Trata")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Cantidad de Tratamientos Generales")),
                  tr().with(td().withText("Cantidad Total de Tratamientos: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("GenTrata.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e)
        {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Cant Trata Tipo")){

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Cantidad Total de Tratamientos Según Tipo")),
                  tr().with(td().withText("Cantidad Total de Tratamientos:  " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("CantTrataTipo.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Cant Trata Espe")){

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Cantidad Total de Tratamientos según Especialidad")),
                  tr().with(td().withText("Cantidad Total de Tratamientos: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("CantTrataEspe.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Cant Trata Paci")) {

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Cantidad Total de Tratamientos según Paciente")),
                  tr().with(td().withText("Cantidad Total de Tratamientos: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("CantTrataPaci.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Cant Diag Paci")) {

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Cantidad Total de Diagnosticos asignados a Paciente")),
                  tr().with(td().withText("Cantidad Total de Diagnosticos: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("CantDiagPaci.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Cant Diag Nivel")) {

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Cantidad Total de Diagnosticos asignados según Nivel")),
                  tr().with(td().withText("Cantidad Total de Diagnosticos: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("CantDiagNivel.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Cant Cita Rango")){

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Cantidad Total de Citas en rango de fechas")),
                  tr().with(td().withText("Cantidad Total de Citas: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("CantCitaRango.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Cant Citas Especialidad")) {

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Cantidad Total de Citas por Especialidad")),
                  tr().with(td().withText("Cantidad Total de Citas: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("CantCitasEspecialidad.html");
        System.out.println(html2);
        try {
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Cant Citas Estado")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Cantidad Total de Citas por Estado")),
                  tr().with(td().withText("Cantidad Total de Citas: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("CantCitasEstado.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Trata Paci Fechas")) {

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Tratamientos asignados a Paciente por Tipo de Tratamiento")),
                  tr().with(td().withText("Cedula Paciente: " + pFilas.get(i)[0])),
                  tr().with(td().withText("Nivel: " + pFilas.get(i)[1])),
                  tr().with(td().withText("Observaciones: " + pFilas.get(i)[2])),
                  tr().with(td().withText("Tratamiento: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Dosis: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Tipo Tratamiento: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Nombre Diágnostico: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Fecha: " + pFilas.get(i)[7])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("TrataPaciFechas.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Trata Paci Tipo")){

        for (int i = 0; i != pFilas.size(); i++) {
          html2 += table().with(tr().with(
                  th().withText("Tratamientos asignados a Paciente por Tipo de Tratamiento")),
                  tr().with(td().withText("Cedula Paciente: " + pFilas.get(i)[0])),
                  tr().with(td().withText("Nivel: " + pFilas.get(i)[1])),
                  tr().with(td().withText("Observaciones: " + pFilas.get(i)[2])),
                  tr().with(td().withText("Tratamiento: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Dosis: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Tipo Tratamiento: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Nombre Diágnostico: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Fecha: " + pFilas.get(i)[7])),
                  tr().with(td().withText("Tipo: " + pFilas.get(i)[8])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("TrataPaciTipo.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Trata Paci Nombre")) {

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Tratamientos de Paciente por Nombre de Tratamiento")),
                  tr().with(td().withText("Cedula Paciente: " + pFilas.get(i)[0])),
                  tr().with(td().withText("Nivel: " + pFilas.get(i)[1])),
                  tr().with(td().withText("Observaciones: " + pFilas.get(i)[2])),
                  tr().with(td().withText("Tratamiento: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Dosis: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Tipo Tratamiento: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Nombre Diágnostico: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Fecha: " + pFilas.get(i)[0])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("TrataPaciNombre.html");
        System.out.println(html2);
        try {
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Diag Paci FechaR")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Tratamientos de Paciente por Tipo")),
                  tr().with(td().withText("Cedula Paciente: " + pFilas.get(i)[0])),
                  tr().with(td().withText("Nivel: " + pFilas.get(i)[1])),
                  tr().with(td().withText("Observaciones: " + pFilas.get(i)[2])),
                  tr().with(td().withText("Tratamiento: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Dosis: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Tipo Tratamiento: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Nombre Diágnostico: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Fecha: " + pFilas.get(i)[7])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("DiagPaciFechaR.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Diag Nombre Paci")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Tratamientos de Paciente por Tipo")),
                  tr().with(td().withText("Cedula Paciente: " + pFilas.get(i)[0])),
                  tr().with(td().withText("Nivel: " + pFilas.get(i)[1])),
                  tr().with(td().withText("Observaciones: " + pFilas.get(i)[2])),
                  tr().with(td().withText("Tratamiento: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Dosis: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Tipo Tratamiento: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Nombre Diágnostico: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Fecha: " + pFilas.get(i)[7])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("DiagNombrePaci.html");
        System.out.println(html2);
        try{
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }

      if (pTipoReporte.equals("Diag Nivel Paci")){

        for (int i = 0; i != pFilas.size(); i++){
          html2 += table().with(tr().with(
                  th().withText("Tratamientos de Paciente por Tipo")),
                  tr().with(td().withText("Cedula Paciente: " + pFilas.get(i)[0])),
                  tr().with(td().withText("Nivel: " + pFilas.get(i)[1])),
                  tr().with(td().withText("Observaciones: " + pFilas.get(i)[2])),
                  tr().with(td().withText("Tratamiento: " + pFilas.get(i)[3])),
                  tr().with(td().withText("Dosis: " + pFilas.get(i)[4])),
                  tr().with(td().withText("Tipo Tratamiento: " + pFilas.get(i)[5])),
                  tr().with(td().withText("Nombre Diágnostico: " + pFilas.get(i)[6])),
                  tr().with(td().withText("Fecha: " + pFilas.get(i)[7])),
                  tr().with(td().withText(" "))
          ).render();

        }
        File archivo = new File("DiagNivelPaci.html");
        System.out.println(html2);
        try {
          BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
          bw.write(html2);
          bw.close();
        } catch (IOException e){
          System.out.println(e);
        }
      }
    }
  }
}
