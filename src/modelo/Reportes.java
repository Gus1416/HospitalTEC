/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
//-----------------------------------
import com.csvreader.CsvWriter;
import com.itextpdf.text.PageSize;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author sebcor
 */
public class Reportes implements Exportable {
    private  PdfPTable tabla;
       
                
    public void exportarCSV(String flag, ArrayList<Object[]> lista) {
        
        
        //Reporte Hospitalización General de Paciente

        if(flag.equals("Hospi Paciente")){

          String salidaArchivo="Hospi.csv";
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
      
      
      if(flag.equals("Tratamiento Count Gen")){
          
         String salidaArchivo="TratamientosGenerales.csv";
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
              salidaCSV.write("Cantidad Total de Tratamientos");

              salidaCSV.endRecord();// termina la escritura.

              //se recorre la lista y lo escribe en el archivo csv.
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              
              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Tratamiento Count Type")){
          
         String salidaArchivo="TratamientosCantType.csv";
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
              salidaCSV.write("Cantidad Total de Tratamientos según Tipo");

              salidaCSV.endRecord();// termina la escritura.

              //se recorre la lista y lo escribe en el archivo csv.
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Tratamiento Count Espe")){
          
         String salidaArchivo="TratamientosCantEspe.csv";
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
              salidaCSV.write("Cantidad Total de Tratamientos según Especialidad");

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
      
      
      if(flag.equals("Tratamiento Count Paci")){
          
         String salidaArchivo="TratamientosCantPaciente.csv";
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
              salidaCSV.write("Cantidad Total de Tratamientos asignados a Paciente");

              salidaCSV.endRecord();// termina la escritura.

              //se recorre la lista y lo escribe en el archivo csv.
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Diag Count Paci")){
          
         String salidaArchivo="DiagnosticosCantPaciente.csv";
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
              salidaCSV.write("Cantidad Total de Diagnosticos asignados a Paciente");

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
      
      
      if(flag.equals("Diag Count Nivel")){
          
         String salidaArchivo="DiagnosticosCantNivel.csv";
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
              salidaCSV.write("Cantidad Total de Diagnosticos por Nivel");

              salidaCSV.endRecord();// termina la escritura.

              //se recorre la lista y lo escribe en el archivo csv.
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Citas Count Date Range")){
          
         String salidaArchivo="CitasCantDateRange.csv";
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
              salidaCSV.write("Cantidad Total de Citas en rango de fechas");

              salidaCSV.endRecord();// termina la escritura.

              //se recorre la lista y lo escribe en el archivo csv.
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Citas Count Estate")){
          
         String salidaArchivo="CitasCantEstado.csv";
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
              salidaCSV.write("Cantidad Total de Citas por estado");

              salidaCSV.endRecord();// termina la escritura.

              //se recorre la lista y lo escribe en el archivo csv.
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Citas Count Espe")){
          
         String salidaArchivo="CitasCantEspecialidad.csv";
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
              salidaCSV.write("Cantidad Total de Citas por especialidad");

              salidaCSV.endRecord();// termina la escritura.

              //se recorre la lista y lo escribe en el archivo csv.
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      
      
      
      
      if(flag.equals("Paciente Trata Date Range")){
          
         String salidaArchivo="TrataPacienteDateRange.csv";
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
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Paciente Trata Type")){
          
         String salidaArchivo="TrataPacienteTipo.csv";
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
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Paciente Trata Nombre")){
          
         String salidaArchivo="TrataPacienteNombre.csv";
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
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      if(flag.equals("Paciente Diag Data Range")){
          
         String salidaArchivo="DiagPacienteDateRange.csv";
          boolean existe= new File(salidaArchivo).exists();

          //si existe el archivo entonces lo borra.
          if (existe){
              File archivoConsulta=new File(salidaArchivo);
              archivoConsulta.delete();
          }

          try{
              //crea el archivo.
              CsvWriter salidaCSV= new CsvWriter(new FileWriter(salidaArchivo,true), ',');

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
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      
      if(flag.equals("Paciente Diag Nombre")){
          
         String salidaArchivo="DiagPacienteNombre.csv";
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
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }
      
      
      
      if(flag.equals("Paciente Diag Nivel")){
          
         String salidaArchivo="DiagPacienteNivel.csv";
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
              for (int z = 0; z < lista.size(); z++) {
                  for (int i = 0; i < lista.get(z).length; i++) {
                      salidaCSV.write(lista.get(z)[i].toString());
                  }
                  salidaCSV.endRecord();
              }
              //salidaCSV.endRecord();// termina la escritura.

              salidaCSV.close();
          }
          catch(IOException e){
              e.printStackTrace();
          }
      }

    }
    
    
    
    
    
    public void exportarHTML(ArrayList<Object[]> pFilas, String pTipoReporte) {
    String html2 = style("table, th, td { border: 1px solid black; }"
            + "\ntbody tr:nth-child(odd) { background-color: #06FCD3 }"
            + "\nth, td { padding: 10px }").render();
    
            if (pTipoReporte.equals("HospiPaci")){

              for (int i = 0; i != pFilas.size(); i++) {
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
              try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(html2);
                bw.close();
              } catch (IOException e){
                System.out.println(e);
              }
            }




            if (pTipoReporte.equals("Gen Trata")){

              for (int i = 0; i != pFilas.size(); i++) {
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
              } catch (IOException e){
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
              } catch (IOException e){
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
              } catch (IOException e){
                System.out.println(e);
              }
            }


            if (pTipoReporte.equals("Cant Trata Paci")){

              for (int i = 0; i != pFilas.size(); i++) {
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


            if (pTipoReporte.equals("Cant Diag Paci")){

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
              } catch (IOException e){
                System.out.println(e);
              }
            }


            if (pTipoReporte.equals("Cant Diag Nivel")){

              for (int i = 0; i != pFilas.size(); i++) {
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
              } catch (IOException e){
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
              } catch (IOException e){
                System.out.println(e);
              }
            } 


            if (pTipoReporte.equals("Cant Citas Especialidad")){

              for (int i = 0; i != pFilas.size(); i++) {
                html2 += table().with(tr().with(
                        th().withText("Cantidad Total de Citas por Especialidad")),
                        tr().with(td().withText("Cantidad Total de Citas: " + pFilas.get(i)[0])),
                        tr().with(td().withText(" "))
                ).render();

              }
              File archivo = new File("CantCitasEspecialidad.html");
              System.out.println(html2);
              try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(html2);
                bw.close();
              } catch (IOException e){
                System.out.println(e);
              }
            }


            if (pTipoReporte.equals("Cant Citas Estado")){

              for (int i = 0; i != pFilas.size(); i++) {
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


            if (pTipoReporte.equals("Trata Paci Fechas")){

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
                        tr().with(td().withText(" "))
                ).render();

              }
              File archivo = new File("TrataPaciFechas.html");
              System.out.println(html2);
              try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(html2);
                bw.close();
              } catch (IOException e){
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



            if (pTipoReporte.equals("Trata Paci Nombre")){

              for (int i = 0; i != pFilas.size(); i++) {
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
              try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(html2);
                bw.close();
              } catch (IOException e){
                System.out.println(e);
              }
            }



            if (pTipoReporte.equals("Diag Paci FechaR")){

              for (int i = 0; i != pFilas.size(); i++) {
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
              } catch (IOException e){
                System.out.println(e);
              }
            }



            if (pTipoReporte.equals("Diag Nombre Paci")){

              for (int i = 0; i != pFilas.size(); i++) {
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

              for (int i = 0; i != pFilas.size(); i++) {
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
              try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(html2);
                bw.close();
              } catch (IOException e){
                System.out.println(e);
              }
            }


    
    }
    
    

    
    
    @Override
    public void exportarPDF(ArrayList<Object[]> pFilas, String pTipoReporte) {
    
    Document documento = new Document() {};
    Paragraph titulo = new Paragraph("Reportes");
    
    try{
      FileOutputStream archivo = new FileOutputStream("reportes.pdf");
      PdfWriter.getInstance(documento, archivo);
      documento.setPageSize(PageSize.A4.rotate());
      documento.open();
      titulo.setAlignment(1);
      documento.add(titulo);
      documento.add(Chunk.NEWLINE);
      documento.add(new Paragraph("Reportes de " + pTipoReporte));
      documento.add(Chunk.NEWLINE);
      
      switch (pTipoReporte){
        
        //En cada case se escibren los encabezados de la tabla
        
        case "HospiPaci":
          this.tabla = new PdfPTable(11);
          this.tabla.setWidthPercentage(90);  
          
          
          PdfPCell numInternado= new PdfPCell(new Phrase("Número de Internado"));
          PdfPCell codCentro = new PdfPCell(new Phrase("Código Centro"));
          PdfPCell idDiag = new PdfPCell(new Phrase("ID Diagnóstico"));
          PdfPCell fechaInicio = new PdfPCell(new Phrase("Fecha Inicio"));
          PdfPCell fechaFinal = new PdfPCell(new Phrase("Fecha Final"));
          PdfPCell servicio = new PdfPCell(new Phrase("Servicio"));
          PdfPCell cedFuncionario = new PdfPCell(new Phrase("Cedula Funcionario"));
          PdfPCell cedPaciente = new PdfPCell(new Phrase("Cedula Paciente"));
          PdfPCell fechaRevi = new PdfPCell(new Phrase("Fecha Revisión"));
          PdfPCell observacion = new PdfPCell(new Phrase("Observación"));
          PdfPCell tratamiento = new PdfPCell(new Phrase("Tratamiento"));
          
          tabla.addCell(numInternado);
          tabla.addCell(codCentro);
          tabla.addCell(idDiag);                   
          tabla.addCell(fechaInicio);
          tabla.addCell(fechaFinal);
          tabla.addCell(servicio);
          tabla.addCell(cedFuncionario);
          tabla.addCell(cedPaciente);
          tabla.addCell(fechaRevi);
          tabla.addCell(observacion);
          tabla.addCell(tratamiento);
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
          PdfPCell fecha1 = new PdfPCell(new Phrase("Fecha"));
         
          
          tabla.addCell(cedPaciente1);
          tabla.addCell(nivel1);
          tabla.addCell(observaciones1);
          tabla.addCell(tratamiento1);
          tabla.addCell(dosis1);
          tabla.addCell(tipo1);
          tabla.addCell(nombreDiag1);
          tabla.addCell(fecha1);
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
          PdfPCell fecha4 = new PdfPCell(new Phrase("Fecha Definida"));
          
          tabla.addCell(cedPaciente4);
          tabla.addCell(nivel4);
          tabla.addCell(observaciones4);
          tabla.addCell(tratamiento4);
          tabla.addCell(dosis4);
          tabla.addCell(tipo4);
          tabla.addCell(nombreDiag4);
          tabla.addCell(fecha4);
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
    

          
  
    
    
    
    
    
    
    
    
  }

    

