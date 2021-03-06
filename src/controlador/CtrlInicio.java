package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Inicio;
import vista.InicioSesion;

/**
 *
 * @author Gustavo
 */
public class CtrlInicio implements ActionListener {
  private Inicio inicio;
  
  public CtrlInicio(Inicio pInicio){
    this.inicio = pInicio;
    this.inicio.btnRegistrarse.addActionListener(this);
    this.inicio.btnIniciarSesion.addActionListener(this);
  }
  
  public void iniciar(){
    this.inicio.setTitle("Hospital TEC");
    this.inicio.setSize(600, 500);
    this.inicio.btnIniciarSesion.setBackground(Color.white);
    this.inicio.btnRegistrarse.setBackground(Color.white);
    this.inicio.btnRegistrarse.setEnabled(false);
    this.inicio.setLocationRelativeTo(null);     
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
//    if (e.getSource() == this.inicio.btnRegistrarse){
//      String[] botonesUsuario = {"Paciente", "Funcionario"};
//      int opcion = JOptionPane.showOptionDialog(null, "Indique el tipo de usuario", 
//              "Registro de usuarios", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
//              null, botonesUsuario, botonesUsuario[0]);
//      
//      if (opcion == 0){
//        RegistroPaciente registroPaciente = new RegistroPaciente();
//        CtrlRegistroPaciente ctrlRegistroPaciente = new CtrlRegistroPaciente(registroPaciente);
//        ctrlRegistroPaciente.iniciar();
//        registroPaciente.setVisible(true);
//      }
//      
//      if (opcion == 1){
//        String[] botonesFuncionario = {"Doctor", "Enfermero", "Secretario"};
//        int opcion2 = JOptionPane.showOptionDialog(null, "Indique el tipo de funcionario", 
//                "Registro de funcionario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
//                null, botonesFuncionario, botonesFuncionario[0]);
//        if (opcion2 == 0){
//          RegistroDoctor registroDoctor = new RegistroDoctor();
//          CtrlRegistroDoctor ctrlRegistroDoctor = new CtrlRegistroDoctor(registroDoctor);
//          ctrlRegistroDoctor.iniciar();
//          registroDoctor.setVisible(true);
//        }
//        if (opcion2 == 1){
//          RegistroEnfermero registroEnfermero = new RegistroEnfermero();
//          CtrlRegistroEnfermero ctrlRegistroEnfermero = new CtrlRegistroEnfermero(registroEnfermero);
//          ctrlRegistroEnfermero.iniciar();
//          registroEnfermero.setVisible(true);
//        }
//        if (opcion2 == 2){
//          RegistroSecretario registroSecretario = new RegistroSecretario();
//          CtrlRegistroSecretario ctrlRegistroSecretario = new CtrlRegistroSecretario(registroSecretario);
//          ctrlRegistroSecretario.iniciar();
//          registroSecretario.setVisible(true);
//        }
//      }
//    }
    
    if (e.getSource() == this.inicio.btnIniciarSesion){
      InicioSesion inicioSesion = new InicioSesion();
      CtrlInicioSesion ctrlInicioSesion = new CtrlInicioSesion(inicioSesion);
      ctrlInicioSesion.iniciar();
      inicioSesion.setVisible(true);
    }
  }
}
