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
public class Reportes implements Exportable{
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Tratamiento Count Gen"))
    {

      String salidaArchivo = "TratamientosGenerales.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {

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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Tratamiento Count Type"))
    {

      String salidaArchivo = "TratamientosCantType.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Tratamiento Count Espe"))
    {

      String salidaArchivo = "TratamientosCantEspe.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Tratamiento Count Paci"))
    {

      String salidaArchivo = "TratamientosCantPaciente.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Diag Count Paci"))
    {

      String salidaArchivo = "DiagnosticosCantPaciente.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Diag Count Nivel"))
    {

      String salidaArchivo = "DiagnosticosCantNivel.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Citas Count Date Range"))
    {

      String salidaArchivo = "CitasCantDateRange.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Citas Count Estate"))
    {

      String salidaArchivo = "CitasCantEstado.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Citas Count Espe"))
    {

      String salidaArchivo = "CitasCantEspecialidad.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Trata Date Range"))
    {

      String salidaArchivo = "TrataPacienteDateRange.csv";
      boolean existe = new File(salidaArchivo).exists();

      if (existe)
      {
        File archivoConsulta = new File(salidaArchivo);
        archivoConsulta.delete();
      }

      try
      {
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Trata Type"))
    {

      String salidaArchivo = "TrataPacienteTipo.csv";
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Trata Nombre"))
    {

      String salidaArchivo = "TrataPacienteNombre.csv";
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Diag Data Range"))
    {

      String salidaArchivo = "DiagPacienteDateRange.csv";
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Diag Nombre"))
    {

      String salidaArchivo = "DiagPacienteNombre.csv";
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    if (flag.equals("Paciente Diag Nivel"))
    {

      String salidaArchivo = "DiagPacienteNivel.csv";
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    
    if (flag.equals("PacienteCitas"))
    {

      String salidaArchivo = "PacienteCitas.csv";
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
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    
    if (flag.equals("PacienteDiagnósticos"))
    {

      String salidaArchivo = "PacienteDiagnósticos.csv";
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
    
    if (flag.equals("PacienteTratamientos"))
    {

      String salidaArchivo = "PacienteTratamientos.csv";
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
      } catch (IOException e)
      {
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
  }
}
