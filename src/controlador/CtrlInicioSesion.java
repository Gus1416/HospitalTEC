package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ArrayList;
import modelo.Doctor;
import modelo.DoctorCRUD;
import modelo.Funcionario;
import modelo.FuncionarioCRUD;
import modelo.Hash;
import modelo.Usuario;
import modelo.UsuarioCRUD;
import vista.InicioSesion;
import vista.ModuloDoctor;

/**
 *
 * @author Gustavo
 */
public class CtrlInicioSesion implements ActionListener{
  private InicioSesion inicioSesion;
  private UsuarioCRUD usuarioCrud;
  private FuncionarioCRUD funcionarioCrud;
  private DoctorCRUD doctorCrud;
  
  private static ArrayList<Funcionario> tempUser= new ArrayList<Funcionario>();
  
  public CtrlInicioSesion(InicioSesion pInicioSesion){
    this.inicioSesion = pInicioSesion;
    this.usuarioCrud = new UsuarioCRUD();
    this.funcionarioCrud = new FuncionarioCRUD();
    this.doctorCrud = new DoctorCRUD();
    this.inicioSesion.btnIngresar.addActionListener(this);
  }
  
  public void iniciar(){
    this.inicioSesion.setTitle("Inicio de Sesión");
    this.inicioSesion.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == this.inicioSesion.btnIngresar){
      String cedula = this.inicioSesion.txtCedulaUsuario.getText();
      String password = Hash.sha1(this.inicioSesion.passContrasena.getText());
      Usuario usuario = new Usuario(cedula, password);
      
      if (usuarioCrud.login(usuario)){
        switch (usuario.getTipoUsuario()){
          
          case "Funcionario":
            Funcionario funcionario = funcionarioCrud.buscarFuncionario(usuario.getCedula());
            
            switch (funcionario.getTipoFuncionario()){
              case "Doctor":
                ModuloDoctor moduloDoctor = new ModuloDoctor();
                Doctor doctor = doctorCrud.buscarDoctor(usuario.getCedula());
                tempUser.add(doctor);
                CtrlDoctor ctrlDoctor = new CtrlDoctor(moduloDoctor, doctor);
                ctrlDoctor.iniciar();
                moduloDoctor.setVisible(true);
                break;
                
              case "Enfermero":
                System.out.println("Módulo de enfermeros");
                //Abre módulo de enfermeros
                break;
                
              case "Secretario":
                System.out.println("Módulo de secretarios");
                //Abre módulo de secretarios
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
