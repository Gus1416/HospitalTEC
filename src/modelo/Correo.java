package modelo;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Clase que permite la conexión con Gmail para enviar el correo electrónico
 *
 * @author Gustavo
 * @version 09/10/2021
 */
public class Correo {
  //Propiedades para la conexión con Gmail
  private final String username = "gestorplanesestudio@gmail.com";
  private final String password = "GestorPlanesEstudio_52";
  private final String fromEmail = "gestorplanesestudio@gmail.com";
  private Properties prop;
  
  public Correo(){

    //Establecimiento de las propiedades
    this.prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS
    prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
  }

  /**
   * Constructor de la clase
   * 
   * @param pCorreo     la dirección de correo electrónico del destinatario
   * @param pPaciente
   * @param pCita
   * @return Un booleano que indica si el envío fue exitoso.
   */
  public boolean enviarEmailConfirmacion(String pCorreo, Paciente pPaciente, Citas pCita){
    String toEmail = pCorreo;

    //Creación de la sesión
    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });

    MimeMessage msg = new MimeMessage(session);
    
    try{
      msg.setFrom(new InternetAddress(fromEmail));
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
      msg.setSubject("Confirmación de Registro de Cita");

      Multipart emailContent = new MimeMultipart();

      //Cuerpo del correo
      MimeBodyPart textBodyPart = new MimeBodyPart(); 
      textBodyPart.setText(crearCuerpoConfirmacion(pPaciente, pCita));
        
      emailContent.addBodyPart(textBodyPart);

      msg.setContent(emailContent);

      Transport.send(msg);
      System.out.println("Sent message");
      return true;
      
    } catch (MessagingException e){
      System.err.println(e.getMessage());
      return false;
    }
  }
  
  public boolean enviarEmailCancelacion(String pCorreo, Paciente pPaciente, Citas pCita){
    String toEmail = pCorreo;

    //Creación de la sesión
    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    });

    MimeMessage msg = new MimeMessage(session);
    
    try{
      msg.setFrom(new InternetAddress(fromEmail));
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
      msg.setSubject("Cancelación de Cita");

      Multipart emailContent = new MimeMultipart();

      //Cuerpo del correo
      MimeBodyPart textBodyPart = new MimeBodyPart(); 
      textBodyPart.setText(crearCuerpoCancelacion(pPaciente, pCita));
        
      emailContent.addBodyPart(textBodyPart);

      msg.setContent(emailContent);

      Transport.send(msg);
      System.out.println("Sent message");
      return true;
      
    } catch (MessagingException e){
      System.err.println(e.getMessage());
      return false;
    }
  }
  
  private String crearCuerpoConfirmacion(Paciente pPaciente, Citas pCita){
    AreaCRUD areaCrud = new AreaCRUD();
    
    String cuerpo = "";
    cuerpo += "Se ha registrado una nueva cita médica en el sistema de HospitalTEC + \n";
    cuerpo += "\n";
    cuerpo += "Paciente: " + pPaciente.getNombre() + ", " + pPaciente.getCedula() + "\n";
    cuerpo += "Area: " +  areaCrud.buscarArea(pCita.getiDArea()).getNombreArea() + "\n";
    cuerpo += "Observación realizada por el solicitante: " + pCita.getObservacionAdicional() + "\n";
    cuerpo += "Fecha de la cita: " + pCita.getFechaCita().toString() + "\n";
    return cuerpo;
  }
  
  private String crearCuerpoCancelacion(Paciente pPaciente, Citas pCita){
    AreaCRUD areaCrud = new AreaCRUD();
    String cuerpo = "";
    cuerpo += "Se le informa que la siguiente cita ha sido cancelada: \n";
    cuerpo += "\n";
    cuerpo += "Paciente: " + pPaciente.getNombre() + ", " + pPaciente.getCedula() + "\n";
    cuerpo += "Area: " +  areaCrud.buscarArea(pCita.getiDArea()).getNombreArea() + "\n";
    cuerpo += "Observación realizada por el solicitante: " + pCita.getObservacionAdicional() + "\n";
    cuerpo += "Fecha de la cita: " + pCita.getFechaCita().toString() + "\n";
    return cuerpo;
  }
}
