package controlador;

import controlador.controladores_registros.CtrlRegistroDoctor;
import controlador.controladores_registros.CtrlRegistroEnfermero;
import controlador.controladores_registros.CtrlRegistroPaciente;
import controlador.controladores_registros.CtrlRegistroSecretario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.BitacoraCitas;
import vista.CatalogoDiagnosticos;
import vista.CatalogoTratamientos;
import vista.GestionAreas;
import vista.GestionTiposCentros;
import vista.ModuloAdministrador;
import vista.VistaCentrosAtencion;
import vista.registros.RegistroDoctor;
import vista.registros.RegistroEnfermero;
import vista.registros.RegistroPaciente;
import vista.registros.RegistroSecretario;

/**
 * Controlador para el módulo administrador.
 * 
 * @author Gustavo
 */
public class CtrlModuloAdministrador implements ActionListener{
  public ModuloAdministrador moduloAdmin;
  
  /**
   * Constructor de la clase.
   * 
   * @param pModuloAdmin  ventana del módulo de administrador
   */
  public CtrlModuloAdministrador(ModuloAdministrador pModuloAdmin){
    this.moduloAdmin = pModuloAdmin;
    this.moduloAdmin.btnUsuarios.addActionListener(this);
    this.moduloAdmin.btnCentrosMedicos.addActionListener(this);
    this.moduloAdmin.btnTratamientos.addActionListener(this);
    this.moduloAdmin.btnDiagnosticos.addActionListener(this);
    this.moduloAdmin.btnBitacoraCitas.addActionListener(this);
    this.moduloAdmin.btnAreas.addActionListener(this);
    this.moduloAdmin.btnTiposCentros.addActionListener(this);
  }
  
  /**
   * Inicia la ventana
   */
  public void iniciar(){
    this.moduloAdmin.setTitle("Módulo de Administrador");
    this.moduloAdmin.setSize(650, 400);
    this.moduloAdmin.setLocationRelativeTo(null);
  }

  /**
   * Botones de la ventana
   * 
   * @param e 
   */
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
    
    if (e.getSource() == this.moduloAdmin.btnTratamientos){
      CatalogoTratamientos tratamientos = new CatalogoTratamientos();
      CtrlTratamientos ctrlTratamientos = new CtrlTratamientos(tratamientos);
      ctrlTratamientos.iniciar();
      tratamientos.setVisible(true);
    }
    
    if (e.getSource() == this.moduloAdmin.btnDiagnosticos){
      CatalogoDiagnosticos diagnosticos = new CatalogoDiagnosticos();
      CtrlDiagnosticos ctrlDiagnosticos = new CtrlDiagnosticos(diagnosticos);
      ctrlDiagnosticos.iniciar();
      diagnosticos.setVisible(true);
    }
    
    if (e.getSource() == this.moduloAdmin.btnBitacoraCitas){
      BitacoraCitas bitacora = new BitacoraCitas();
      CtrlBitacoraCitas ctrlBitacora = new CtrlBitacoraCitas(bitacora);
      ctrlBitacora.iniciar();
      bitacora.setVisible(true);
    }
    
    if (e.getSource() == this.moduloAdmin.btnAreas){
      GestionAreas gestionAreas = new GestionAreas();
      CtrlGestionAreas ctrlGestionAreas = new CtrlGestionAreas(gestionAreas);
      ctrlGestionAreas.iniciar();
      gestionAreas.setVisible(true);
    }
    
    if (e.getSource() == this.moduloAdmin.btnTiposCentros){
      GestionTiposCentros gestionTipos = new GestionTiposCentros();
      CtrlGestionTiposCentros ctrlTipos = new CtrlGestionTiposCentros(gestionTipos);
      ctrlTipos.iniciar();
      gestionTipos.setVisible(true);
    }
  }
}
