package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Doctor;
import modelo.DoctorCRUD;
import modelo.Funcionario;
import modelo.FuncionarioCRUD;
import modelo.Hash;
import modelo.Paciente;
import modelo.PacienteCRUD;
import modelo.Secretario;
import modelo.SecretarioCRUD;
import modelo.Usuario;
import modelo.UsuarioCRUD;
import vista.InicioSesion;
import vista.ModuloAdministrador;
import vista.ModuloDoctor;
import vista.ModuloPaciente;
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
  private SecretarioCRUD secretarioCrud;
  private PacienteCRUD pacienteCrud;
  public static String cedula;

  public CtrlInicioSesion() {
    }
  

  
  public CtrlInicioSesion(InicioSesion pInicioSesion){
    this.inicioSesion = pInicioSesion;
    this.usuarioCrud = new UsuarioCRUD();
    this.funcionarioCrud = new FuncionarioCRUD();
    this.doctorCrud = new DoctorCRUD();
    this.secretarioCrud = new SecretarioCRUD();
    this.pacienteCrud = new PacienteCRUD();
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
                moduloDoctor.setVisible(true);
                break;
                
              case "Enfermero":
                
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
            ModuloPaciente moduloPaciente = new ModuloPaciente();
            Paciente paciente = pacienteCrud.buscarPaciente(cedula);
            CtrlPaciente ctrlPaciente = new CtrlPaciente(moduloPaciente, paciente);
            ctrlPaciente.iniciar();
            moduloPaciente.setVisible(true);
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
