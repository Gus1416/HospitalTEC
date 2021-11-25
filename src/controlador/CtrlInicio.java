package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Inicio;
import vista.InicioSesion;

/**
 * Ventana de inicio
 * 
 * @author Gustavo
 */
public class CtrlInicio implements ActionListener {
  private Inicio inicio;
  
  /**
   * Constructor de la clase
   * 
   * @param pInicio ventana de inicio
   */
  public CtrlInicio(Inicio pInicio){
    this.inicio = pInicio;
    this.inicio.btnIniciarSesion.addActionListener(this);
  }
  
  /**
   * Inicia la ventana
   */
  public void iniciar(){
    this.inicio.setTitle("Hospital TEC");
    this.inicio.setSize(600, 500);
    this.inicio.btnIniciarSesion.setBackground(Color.white);
    this.inicio.setLocationRelativeTo(null);     
  }
  
  /**
   * Botones de la ventana
   * 
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == this.inicio.btnIniciarSesion){
      InicioSesion inicioSesion = new InicioSesion();
      CtrlInicioSesion ctrlInicioSesion = new CtrlInicioSesion(inicioSesion);
      ctrlInicioSesion.iniciar();
      inicioSesion.setVisible(true);
    }
  }
}
