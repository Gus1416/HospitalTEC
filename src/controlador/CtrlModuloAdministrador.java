package controlador;

import controlador.controladores_registros.CtrlRegistroDoctor;
import controlador.controladores_registros.CtrlRegistroEnfermero;
import controlador.controladores_registros.CtrlRegistroPaciente;
import controlador.controladores_registros.CtrlRegistroSecretario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.ModuloAdministrador;
import vista.VistaCentrosAtencion;
import vista.registros.RegistroDoctor;
import vista.registros.RegistroEnfermero;
import vista.registros.RegistroPaciente;
import vista.registros.RegistroSecretario;

/**
 *
 * @author Gustavo
 */
public class CtrlModuloAdministrador implements ActionListener{
  public ModuloAdministrador moduloAdmin;
  
  public CtrlModuloAdministrador(ModuloAdministrador pModuloAdmin){
    this.moduloAdmin = pModuloAdmin;
    this.moduloAdmin.btnUsuarios.addActionListener(this);
    this.moduloAdmin.btnCentrosMedicos.addActionListener(this);
  }
  
  public void iniciar(){
    this.moduloAdmin.setTitle("Módulo de Administrador");
    this.moduloAdmin.setSize(650, 400);
    this.moduloAdmin.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.moduloAdmin.btnUsuarios){
      String[] botonesUsuario = {"Paciente", "Funcionario"};
      int opcion = JOptionPane.showOptionDialog(null, "Indique el tipo de usuario", 
              "Registro de usuarios", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
              null, botonesUsuario, botonesUsuario[0]);
      
      if (opcion == 0){
        RegistroPaciente registroPaciente = new RegistroPaciente();
        CtrlRegistroPaciente ctrlRegistroPaciente = new CtrlRegistroPaciente(registroPaciente);
        ctrlRegistroPaciente.iniciar();
        registroPaciente.setVisible(true);
      }
      
      if (opcion == 1){
        String[] botonesFuncionario = {"Doctor", "Enfermero", "Secretario"};
        int opcion2 = JOptionPane.showOptionDialog(null, "Indique el tipo de funcionario", 
                "Registro de funcionario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
                null, botonesFuncionario, botonesFuncionario[0]);
        if (opcion2 == 0){
          RegistroDoctor registroDoctor = new RegistroDoctor();
          CtrlRegistroDoctor ctrlRegistroDoctor = new CtrlRegistroDoctor(registroDoctor);
          ctrlRegistroDoctor.iniciar();
          registroDoctor.setVisible(true);
        }
        if (opcion2 == 1){
          RegistroEnfermero registroEnfermero = new RegistroEnfermero();
          CtrlRegistroEnfermero ctrlRegistroEnfermero = new CtrlRegistroEnfermero(registroEnfermero);
          ctrlRegistroEnfermero.iniciar();
          registroEnfermero.setVisible(true);
        }
        if (opcion2 == 2){
          RegistroSecretario registroSecretario = new RegistroSecretario();
          CtrlRegistroSecretario ctrlRegistroSecretario = new CtrlRegistroSecretario(registroSecretario);
          ctrlRegistroSecretario.iniciar();
          registroSecretario.setVisible(true);
        }
      }
    }
    
    if (e.getSource() == this.moduloAdmin.btnCentrosMedicos){
      VistaCentrosAtencion registroCentro = new VistaCentrosAtencion();
      CtrlVistaCentrosAtencion ctrlRegistroCentro = new CtrlVistaCentrosAtencion(registroCentro);
      ctrlRegistroCentro.iniciar();
      registroCentro.setVisible(true);
    }
  }
  
}
