package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Inicio;

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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
