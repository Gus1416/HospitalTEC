package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ArrayList;
import modelo.EnfermeroCRUD;
import modelo.Paciente;
import modelo.PacienteCRUD;
import vista.AplicarVacuna;

/**
 * Controlador para la aplicaciòn de vacunas
 * 
 * @author sebcor
 */
public class CtrlAplicarVacuna implements ActionListener {
   
    private  PacienteCRUD CRUDPaciente;
    private AplicarVacuna vistaVacuna;
    private EnfermeroCRUD CRUDEnfermero;

    /**
     * Constructor por defecto
     */
    public CtrlAplicarVacuna() {
    }
    
    /**
     * Constructro con parámetros 
     * 
     * @param CRUDPaciente cruds del paciente
     * @param vistaVacuna ventana de vacunas
     * @param CRUDEnfermero  cruds de enfermero
     */
    public CtrlAplicarVacuna(PacienteCRUD CRUDPaciente, AplicarVacuna vistaVacuna,EnfermeroCRUD CRUDEnfermero) {
        this.CRUDPaciente = CRUDPaciente;
        this.vistaVacuna = vistaVacuna;
        this.CRUDEnfermero= CRUDEnfermero;
        this.vistaVacuna.btnAplicarVac.addActionListener(this);
    }
    
    /**
     * ´Inicia la ventana
     */
    public void iniciar(){ 
        cargarPacientes();
        vistaVacuna.setTitle("Hospital TEC");
        vistaVacuna.setLocationRelativeTo(null);  
     }
    
    /**
     * Carga la lista de pacientes
     */
    public void cargarPacientes(){      // Llenar los CB de Pacientes
    ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
        for (int i = 0; i < pacientes.size(); i++) {
          vistaVacuna.CBPacientes.addItem(pacientes.get(i).getNombre());
        }
    }
    
    /**
     * Botones de la ventan
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String cedula=null;
        
        ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
        String ced= vistaVacuna.CBPacientes.getSelectedItem().toString();
        
        for (int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).getNombre().equals(ced)){
              cedula = pacientes.get(i).getCedula();
            }
            
        }
 
        Date fechaApl= vistaVacuna.FechaAplicacion.getDate(); // hay que convertirla a fecha e sql 
        java.sql.Date sqlDate = new java.sql.Date(fechaApl.getTime());
        String Nombre= vistaVacuna.TFNombreVacuna.getText();
        String Farmaceutica=vistaVacuna.TFFarmaceutica.getText();
        int NumeroLote=Integer.parseInt(vistaVacuna.TFNumeroLote.getText());
        
        
        
        if(e.getSource() == vistaVacuna.btnAplicarVac){
            CRUDEnfermero.AplicarVacuna(cedula, sqlDate, Nombre, Farmaceutica,NumeroLote);
            JOptionPane.showMessageDialog(null, "Vacuna aplicada");
        }       
    }  
}
