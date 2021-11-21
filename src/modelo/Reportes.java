package modelo;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Gustavo
 */
public class Reportes implements Exportable{

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
      PdfPTable tabla = new PdfPTable(5);
      tabla.setWidthPercentage(100);
      
      switch (pTipoReporte){
        
        case "Citas":
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

        case "Diagnósticos":
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

        case "Tratamientos":
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
          
        case "Hospitalizaciones":
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

        default:
          break;
      }
                     
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
  public void exportarCSV() {
    
  }

  @Override
  public void exportarHTML() {
    
  }
}
