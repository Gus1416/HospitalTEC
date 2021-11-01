package controlador;

import controlador.controladores_registros.CtrlRegistroDoctor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Inicio;
import vista.registros.RegistroDoctor;

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
    this.inicio.setLocationRelativeTo(null);     
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.inicio.btnRegistrarse){
      String[] botonesUsuario = {"Paciente", "Funcionario"};
      int opcion = JOptionPane.showOptionDialog(null, "Indique el tipo de usuario", 
              "Registro de usuarios", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
              null, botonesUsuario, botonesUsuario[0]);
      
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
      }
    }
  }
 
}
