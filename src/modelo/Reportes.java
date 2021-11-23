package modelo;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
 * @author Maria Laura
 */
public class Reportes implements exportable {
      private PdfPTable tabla;

 @Override   
  public void exportarCSV(String flag, ArrayList<Object[]> lista) {
        
      
        //Reporte Hospitalización General de Paciente

        if(flag.equals("Citas General")){

          String salidaArchivo="citas.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
          }
          catch(IOException e){
              e.printStackTrace();
          }
        }
  
        if(flag.equals("Citas estado")){
              System.out.println("a");

          String salidaArchivo="citas_estados.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
        if(flag.equals("Citas fecha")){
              System.out.println("a");

          String salidaArchivo="citas_fechas.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
          if(flag.equals("Citas paciente")){
              

          String salidaArchivo="citas_paciente.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
          
        if(flag.equals("Citas especialidad")){
              

          String salidaArchivo="citas_especialidad.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }   
          
        if(flag.equals("Hospitalizacion")){
              

          String salidaArchivo="hospitalizacion.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
               for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              
              }
             // salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }   
             
      if(flag.equals("Hospitalizacion fecha")){
              

          String salidaArchivo="hospitalizacion_fecha.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              
              }
             // salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
          
          
      }   
       if(flag.equals("Hospitalizacion especialidad")){
              

          String salidaArchivo="hospitalizacion_especialidad.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
               for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              
              }
             // salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
          
          
       }
             
    if(flag.equals("Hospitalizacion paciente")){
              

          String salidaArchivo="hospitalizacion_paciente.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              
              }
             // salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
          
          
      }   
                    
          
  }
  @Override
  public void exportarPDF(String pTipoReporte,ArrayList<Object[]> pFilas) {
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
        
        case "Citas General":
          this.tabla= new PdfPTable(6);
          tabla.setWidthPercentage(100);
            
          PdfPCell idCita = new PdfPCell(new Phrase("Número de Cita"));
          PdfPCell area = new PdfPCell(new Phrase("ID del Área"));
          PdfPCell fecha = new PdfPCell(new Phrase("Fecha y hora"));
          PdfPCell observacion = new PdfPCell(new Phrase("Observación"));
          PdfPCell estado = new PdfPCell(new Phrase("Estado Actual"));
          PdfPCell paciente = new PdfPCell(new Phrase("Cedula del paciente"));
          
        
    
      tabla.setWidthPercentage(100);
          
          tabla.addCell(idCita);
          tabla.addCell(area);
          tabla.addCell(fecha);                   
          tabla.addCell(observacion);
          tabla.addCell(estado);
          tabla.addCell(paciente);
          break;

        case "Citas estado":
           this.tabla= new PdfPTable(6);
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
           this.tabla= new PdfPTable(6);
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
            
           this.tabla= new PdfPTable(6);
          tabla.setWidthPercentage(100);
          PdfPCell idCita3= new PdfPCell(new Phrase("Número de Cita"));
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
              
          this.tabla= new PdfPTable(6);
          tabla.setWidthPercentage(100);
          
          PdfPCell idCita4= new PdfPCell(new Phrase("Número de Cita"));
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
              
           this.tabla= new PdfPTable(11);
          tabla.setWidthPercentage(100);
          
          PdfPCell idInternado= new PdfPCell(new Phrase("Número de internado"));
          PdfPCell idCentro = new PdfPCell(new Phrase("Código del Centro"));
          PdfPCell idDiagnostico = new PdfPCell(new Phrase("Codigo del diagnóstico"));
          PdfPCell fechai = new PdfPCell(new Phrase("Fecha Inicial"));
          PdfPCell fechaf= new PdfPCell(new Phrase("Fecha finalización"));
          PdfPCell servicio = new PdfPCell(new Phrase("Servicio"));
          PdfPCell idFuncionario= new PdfPCell(new Phrase("Cédula del funcionario"));
          PdfPCell idPaciente= new PdfPCell(new Phrase("Cedula del paciente"));
          PdfPCell fechas= new PdfPCell(new Phrase("Fecha de seguimiento"));
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
          this.tabla= new PdfPTable(11);
          tabla.setWidthPercentage(100);
          PdfPCell idInternado1= new PdfPCell(new Phrase("Número de internado"));
          PdfPCell idCentro1 = new PdfPCell(new Phrase("Código del Centro"));
          PdfPCell idDiagnostico1 = new PdfPCell(new Phrase("Codigo del diagnóstico"));
          PdfPCell fechai1 = new PdfPCell(new Phrase("Fecha Inicial"));
          PdfPCell fechaf1= new PdfPCell(new Phrase("Fecha finalización"));
          PdfPCell servicio1 = new PdfPCell(new Phrase("Servicio"));
          PdfPCell idFuncionario1= new PdfPCell(new Phrase("Cédula del funcionario"));
          PdfPCell idPaciente1= new PdfPCell(new Phrase("Cedula del paciente"));
          PdfPCell fechas1= new PdfPCell(new Phrase("Fecha de seguimiento"));
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
          this.tabla= new PdfPTable(12);
          tabla.setWidthPercentage(100);
          
          PdfPCell idInternado2= new PdfPCell(new Phrase("Número de internado"));
          PdfPCell idCentro2 = new PdfPCell(new Phrase("Código del Centro"));
          PdfPCell idDiagnostico2 = new PdfPCell(new Phrase("Codigo del diagnóstico"));
          PdfPCell especialidad2 = new PdfPCell(new Phrase("Especialidad"));
          PdfPCell fechai2 = new PdfPCell(new Phrase("Fecha Inicial"));
          PdfPCell fechaf2= new PdfPCell(new Phrase("Fecha finalización"));
          PdfPCell servicio2= new PdfPCell(new Phrase("Servicio"));
          PdfPCell idFuncionario2= new PdfPCell(new Phrase("Cédula del funcionario"));
          PdfPCell idPaciente2= new PdfPCell(new Phrase("Cedula del paciente"));
          PdfPCell fechas2= new PdfPCell(new Phrase("Fecha de seguimiento"));
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
          this.tabla= new PdfPTable(11);
          tabla.setWidthPercentage(100);
          
          PdfPCell idInternado3= new PdfPCell(new Phrase("Número de internado"));
          PdfPCell idCentro3= new PdfPCell(new Phrase("Código del Centro"));
          PdfPCell idDiagnostico3 = new PdfPCell(new Phrase("Codigo del diagnóstico"));
          PdfPCell especialidad3 = new PdfPCell(new Phrase("Especialidad"));
          PdfPCell fechai3 = new PdfPCell(new Phrase("Fecha Inicial"));
          PdfPCell fechaf3= new PdfPCell(new Phrase("Fecha finalización"));
          PdfPCell servicio3= new PdfPCell(new Phrase("Servicio"));
          PdfPCell idFuncionario3= new PdfPCell(new Phrase("Cédula del funcionario"));
          PdfPCell idPaciente3= new PdfPCell(new Phrase("Cedula del paciente"));
          PdfPCell fechas3= new PdfPCell(new Phrase("Fecha de seguimiento"));
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


 public void exportarHTML(ArrayList<Object[]> pFilas, String pTipoReporte) {
    String html2 = style("table, th, td { border: 1px solid black; }"
            + "\ntbody tr:nth-child(odd) { background-color: #06FCD3 }"
            + "\nth, td { padding: 10px }").render();
    
    if (pTipoReporte.equals("Citas General")){
      
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
                
    
          
      File archivo = new File("CitasEstado.html");
      System.out.println(html2);
      try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(html2);
        bw.close();
      } catch (IOException e){
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
 if (pTipoReporte.equals("Citas paciente")){
      
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
                
    
          
      File archivo = new File("CitasPaciente.html");
      System.out.println(html2);
      try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(html2);
        bw.close();
      } catch (IOException e){
        System.out.println(e);
      }
  
  
  
    }
 
 if (pTipoReporte.equals("Citas especialidad")){
      
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
      } catch (IOException e){
        System.out.println(e);
      }
  
  
  
    }

 if (pTipoReporte.equals("Hospitalizacion")){
      
      for (int i = 0; i != pFilas.size(); i++) {
        html2 += table().with(tr().with(
                th().withText("Hospitalización")),
                tr().with(td().withText("Número de internado " + pFilas.get(i)[0])),
                tr().with(td().withText("Código del centro"+ pFilas.get(i)[1])),
                tr().with(td().withText("Código del diagnóstico"  + pFilas.get(i)[2])),
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
      try{
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
                tr().with(td().withText("Código del centro"+ pFilas.get(i)[1])),
                tr().with(td().withText("Código del diagnóstico"  + pFilas.get(i)[2])),
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
      
      for (int i = 0; i != pFilas.size(); i++) {
        html2 += table().with(tr().with(
                 th().withText("Hospitalización")),
                tr().with(td().withText("Número de internado " + pFilas.get(i)[0])),
                tr().with(td().withText("Código del centro"+ pFilas.get(i)[1])),
                tr().with(td().withText("Código del diagnóstico"  + pFilas.get(i)[2])),
                tr().with(td().withText("Especialidad"  + pFilas.get(i)[3])),
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
      } catch (IOException e){
        System.out.println(e);
      }
  
  
  
    
 }
 
 
  if (pTipoReporte.equals("Hospitalizacion paciente")){
      
      for (int i = 0; i != pFilas.size(); i++) {
        html2 += table().with(tr().with(
                 th().withText("Hospitalización")),
                tr().with(td().withText("Número de internado " + pFilas.get(i)[0])),
                tr().with(td().withText("Código del centro"+ pFilas.get(i)[1])),
                tr().with(td().withText("Código del diagnóstico"  + pFilas.get(i)[2])),
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
                
    
          
      File archivo = new File("HospitalizacionPaciente.html");
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 