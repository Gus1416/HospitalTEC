package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Doctor;
import modelo.DoctorCRUD;
import modelo.EnfermeroCRUD;
import modelo.Funcionario;
import modelo.FuncionarioCRUD;
import modelo.Hash;
import modelo.Secretario;
import modelo.SecretarioCRUD;
import modelo.Usuario;
import modelo.UsuarioCRUD;
import vista.InicioSesion;
import vista.ModuloAdministrador;
import vista.ModuloDoctor;
import vista.ModuloSecretario;

/**
 *
 * @author Gustavo
 */
public class CtrlInicioSesion implements ActionListener{
  private InicioSesion inicioSesion;
  private UsuarioCRUD usuarioCrud;
  private FuncionarioCRUD funcionarioCrud;
  private DoctorCRUD doctorCrud;
  private EnfermeroCRUD enfermeroCrud;
  private SecretarioCRUD secretarioCrud;
  public static String cedula;

  public CtrlInicioSesion() {
    }
  

  
  public CtrlInicioSesion(InicioSesion pInicioSesion){
    this.inicioSesion = pInicioSesion;
    this.usuarioCrud = new UsuarioCRUD();
    this.funcionarioCrud = new FuncionarioCRUD();
    this.doctorCrud = new DoctorCRUD();
    this.secretarioCrud = new SecretarioCRUD();
    this.enfermeroCrud= new EnfermeroCRUD();
    this.inicioSesion.btnIngresar.addActionListener(this);
  }
  
  public void iniciar(){
    this.inicioSesion.setTitle("Inicio de Sesión");
    this.inicioSesion.setLocationRelativeTo(null);
  }

    public String getCedula() {
        return cedula;
    }

  
  
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == this.inicioSesion.btnIngresar){
      cedula = this.inicioSesion.txtCedulaUsuario.getText();
      String password = Hash.sha1(this.inicioSesion.passContrasena.getText());
      Usuario usuario = new Usuario(cedula, password);
      
      if (usuarioCrud.login(usuario)){
        switch (usuario.getTipoUsuario()){
          
          case "Funcionario":
            Funcionario funcionario = funcionarioCrud.buscarFuncionario(usuario.getCedula());
            
            switch (funcionario.getTipoFuncionario()){
              case "Administrador":
                ModuloAdministrador moduloAdmin = new ModuloAdministrador();
                CtrlModuloAdministrador ctrlModuloAdmin = new CtrlModuloAdministrador(moduloAdmin);
                ctrlModuloAdmin.iniciar();
                moduloAdmin.setVisible(true);
                break;
                
              case "Doctor":
                ModuloDoctor moduloDoctor = new ModuloDoctor();
                Doctor doctor = doctorCrud.buscarDoctor(usuario.getCedula());
                CtrlDoctor ctrlDoctor = new CtrlDoctor(moduloDoctor, doctor);
                ctrlDoctor.iniciar();
                moduloDoctor.btnAplicarVacuna.setVisible(false);
                moduloDoctor.setVisible(true);
                break;
                
              case "Enfermero":
                ModuloDoctor moduloEnfermero = new ModuloDoctor();
                Doctor enfermero = enfermeroCrud.buscarEnfermero(usuario.getCedula());
                CtrlDoctor ctrlEnfermero = new CtrlDoctor(moduloEnfermero, enfermero);
                ctrlEnfermero.iniciar();
                moduloEnfermero.btnAplicarVacuna.setVisible(true);
                moduloEnfermero.setVisible(true); 
                  
                  
                break;
                
              case "Secretario":
                ModuloSecretario moduloSecretario = new ModuloSecretario();
                Secretario secretario = secretarioCrud.buscarSecretario(cedula);
                CtrlSecretario ctrlSecretario = new CtrlSecretario(moduloSecretario, secretario);
                ctrlSecretario.iniciar();
                moduloSecretario.setVisible(true);
                break;
                
              default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error con este funcionario");
                break;
            }
          break;
            
          case "Paciente":
            System.out.println("Módulo de pacientes");
            //Abre módulo de pacientes
            break;
            
          default:
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error con este usuario");
            break;
        }
        this.inicioSesion.dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Cédula o contraseña incorrecta");
        limpiar();
      }
    }
  }
  
  private void limpiar(){
    this.inicioSesion.txtCedulaUsuario.setText("");
    this.inicioSesion.passContrasena.setText("");
  }
}
