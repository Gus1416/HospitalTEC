package controlador;

import static controlador.CtrlCancelarCita_Doctor.citas;
import controlador.controladores_registros.CtrlRegistroDoctor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.AreaCRUD;
import modelo.ArrayList;
import modelo.CentroAtencion;
import modelo.CentroAtencionCRUD;
import modelo.CitasCRUD;
import modelo.Diagnostico;
import modelo.DiagnosticoCRUD;
import modelo.Doctor;
import modelo.DoctorCRUD;
import modelo.HospitalizacionP;
import modelo.Paciente;
import modelo.PacienteCRUD;
import modelo.Tratamiento;
import modelo.TratamientoCRUD;
import vista.Atender_Cita_Doctor;
import vista.Hospitalizacion;

/**
 *
 * @author sebcor
 */
public class CtrlAtenderCita_Doctor implements ActionListener {

<<<<<<< HEAD
    private PacienteCRUD CRUDPaciente;
    private DiagnosticoCRUD CRUDDiagnostico;
    private TratamientoCRUD CRUDTratamiento;
    private Atender_Cita_Doctor vistatender;
    private CitasCRUD CRUDcita;
    private Hospitalizacion internar;
    private AreaCRUD areaCrud;
    private CentroAtencionCRUD centroCrud;
    private  CtrlRegistroDoctor auxMed;
    private DoctorCRUD doctorCrud;
    private CtrlInicioSesion session;
    
    
    

    public CtrlAtenderCita_Doctor(TratamientoCRUD CRUDTratamiento, PacienteCRUD CRUDPaciente, DiagnosticoCRUD CRUDDiagnostico, Atender_Cita_Doctor vistatender, 
            CitasCRUD CRUDcita,Hospitalizacion internar,AreaCRUD areaCrud,CentroAtencionCRUD centroCrud,CtrlRegistroDoctor auxMed,
            DoctorCRUD doctorCrud,CtrlInicioSesion session) {
        this.CRUDTratamiento = CRUDTratamiento;
        this.CRUDPaciente = CRUDPaciente;
        this.CRUDDiagnostico = CRUDDiagnostico;
        this.CRUDcita = CRUDcita;
        this.internar = internar;
        this.areaCrud= areaCrud;
        this.centroCrud= centroCrud;
        this.auxMed= auxMed;
        this.doctorCrud=doctorCrud;
        this.session= session;
        
        this.vistatender = vistatender;
        this.vistatender.btnCargar.addActionListener(this);
        this.vistatender.btnCargarTrata.addActionListener(this);
        this.vistatender.btnAsignarTrata.addActionListener(this);
        this.vistatender.btnFinalizar.addActionListener(this);
        this.vistatender.btnHospitalizar.addActionListener(this);
        this.internar.btnRegHosp.addActionListener(this);
=======
  private PacienteCRUD CRUDPaciente;
  private DiagnosticoCRUD CRUDDiagnostico;
  private TratamientoCRUD CRUDTratamiento;
  private Atender_Cita_Doctor vistatender;
  private CitasCRUD CRUDcita;
  private Hospitalizacion internar;
  private AreaCRUD areaCrud;
  private CentroAtencionCRUD centroCrud;
  private CtrlRegistroDoctor auxMed;
  private DoctorCRUD doctorCrud;
  private CtrlInicioSesion session;

  public CtrlAtenderCita_Doctor(TratamientoCRUD CRUDTratamiento, PacienteCRUD CRUDPaciente, DiagnosticoCRUD CRUDDiagnostico, Atender_Cita_Doctor vistatender,
          CitasCRUD CRUDcita, Hospitalizacion internar, AreaCRUD areaCrud, CentroAtencionCRUD centroCrud, CtrlRegistroDoctor auxMed,
          DoctorCRUD doctorCrud, CtrlInicioSesion session) {
    this.CRUDTratamiento = CRUDTratamiento;
    this.CRUDPaciente = CRUDPaciente;
    this.CRUDDiagnostico = CRUDDiagnostico;
    this.CRUDcita = CRUDcita;
    this.internar = internar;
    this.areaCrud = areaCrud;
    this.centroCrud = centroCrud;
    this.auxMed = auxMed;
    this.doctorCrud = doctorCrud;
    this.session = session;

    this.vistatender = vistatender;
    this.vistatender.btnCargar.addActionListener(this);
    this.vistatender.btnCargarTrata.addActionListener(this);
    this.vistatender.btnAsignarTrata.addActionListener(this);
    this.vistatender.btnFinalizar.addActionListener(this);
    this.vistatender.btnHospitalizar.addActionListener(this);
  }

  public void iniciar() {
    cargarPacientes();
    //cargarDiagnosticos();
    vistatender.setTitle("Gestor de Planes de Estudio");
    vistatender.setLocationRelativeTo(null);
  }

  public void cargarPacientes() {      // Llenar los CB de Pacientes
    ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
    for (int i = 0; i < pacientes.size(); i++)
    {
      vistatender.CBPaciente.addItem(pacientes.get(i).getNombre());
>>>>>>> c1ff3732658b5519f7530fd3fe3a817142dcd973
    }
  }

  public void cargarDiagnosticos() {      // Llenar los CB de Pacientes
    ArrayList<Diagnostico> diagnosticos = CRUDDiagnostico.consultarDiagnosticos();
    for (int i = 0; i < diagnosticos.size(); i++)
    {
      vistatender.CBDiagnosticos.addItem(diagnosticos.get(i).getNombre());
    }
  }

  public void DiagnosticosPaciente() {      // Llenar los CB de Pacientes
    ArrayList<Diagnostico> diagnosticosT = CRUDDiagnostico.consultarDiagnosticoPaciente(internar.TFIdentificacion.getText());
    System.out.println("ALOOOOO");
    for (int i = 0; i < diagnosticosT.size(); i++)
    {
      System.out.println("Este es el size de la lista de diagnosticos: " + diagnosticosT.size());
      this.internar.CBDiagnoPaciente.addItem(diagnosticosT.get(i).getNombre());
    }
  }

  public void cargarTratamientos(String Nombre) {      // Llenar los CB de Pacientes
    vistatender.CBTratamiento.removeAllItems();
    ArrayList<Tratamiento> tratamientos = CRUDTratamiento.consultarTratamientos(Nombre);
    for (int i = 0; i < tratamientos.size(); i++)
    {
      vistatender.CBTratamiento.addItem(tratamientos.get(i).getNombre());
    }
  }

  private void cargarAreas() {
    ArrayList<Area> areas = areaCrud.consultarAreas();
    for (int i = 0; i < areas.size(); i++)
    {
      this.internar.CBServicioMed.addItem(areas.get(i).getNombreArea());  //CHANGE
    }
  }

  private void cargarCentros() {
    ArrayList<CentroAtencion> centros = centroCrud.consultarCentros();
    for (int i = 0; i < centros.size(); i++)
    {
      this.internar.CBCentroAtencion.addItem(centros.get(i).getNombre());  // CHANGE 
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == vistatender.btnCargar)
    {
      String nombrePaciente = vistatender.CBPaciente.getSelectedItem().toString();
      ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
      int flag = 0;
      int counter = 0;

      for (int i = 0; i < pacientes.size(); i++)
      {
        if (pacientes.get(i).getNombre().equals(nombrePaciente))
        {
          flag = 1;
          counter++;
        }
        System.out.println("valor flag" + flag);
        System.out.println("Valor Counter" + counter);
      }

      if (flag == 1)
      {
        citas = CRUDcita.consultarCitas(pacientes.get(counter - 1).getCedula());
        for (int z = 0; z < citas.size(); z++)
        {
          vistatender.CBCitas.addItem(Integer.toString(citas.get(z).getiDCita()));

        }
        cargarDiagnosticos();

      }

    }

    if (e.getSource() == vistatender.btnCargarTrata)
    {
      cargarTratamientos(vistatender.CBDiagnosticos.getSelectedItem().toString());
    }

    if (e.getSource() == vistatender.btnAsignarTrata)
    {
      String nombrePaciente = vistatender.CBPaciente.getSelectedItem().toString();
      int IDCITA = Integer.parseInt(vistatender.CBCitas.getSelectedItem().toString());
      String nombreDiagnostico = vistatender.CBDiagnosticos.getSelectedItem().toString();
      String lvl = vistatender.CBNiveles.getSelectedItem().toString();
      String Observacion = vistatender.TFObservaciones.getText();
      String Tratamiento = vistatender.CBTratamiento.getSelectedItem().toString();
      int DOSIS = Integer.parseInt(vistatender.TFDosis.getText());
      String TipoTratamiento = vistatender.CBTipoTratamiento.getSelectedItem().toString();

      if (CRUDTratamiento.registrarAtencion(nombrePaciente, IDCITA, nombreDiagnostico,
              lvl, Observacion, Tratamiento, DOSIS, TipoTratamiento))
      {
        JOptionPane.showMessageDialog(null, "Tratamiento y diagnostico registrados correctamente");

        //limpiar();
      } else
      {
        JOptionPane.showMessageDialog(null, "Error al registrar los datos");
        //limpiar();
      }
    }

    if (e.getSource() == vistatender.btnFinalizar)
    {
      vistatender.setVisible(false);

    }

<<<<<<< HEAD
        if (e.getSource() == vistatender.btnAsignarTrata) {
            String nombrePaciente = vistatender.CBPaciente.getSelectedItem().toString();
            int IDCITA = Integer.parseInt(vistatender.CBCitas.getSelectedItem().toString());
            String nombreDiagnostico = vistatender.CBDiagnosticos.getSelectedItem().toString();
            String lvl = vistatender.CBNiveles.getSelectedItem().toString();
            String Observacion = vistatender.TFObservaciones.getText();
            String Tratamiento = vistatender.CBTratamiento.getSelectedItem().toString();
            int DOSIS = Integer.parseInt(vistatender.TFDosis.getText());
            String TipoTratamiento = vistatender.CBTipoTratamiento.getSelectedItem().toString();

            if (CRUDTratamiento.registrarAtencion(nombrePaciente, IDCITA, nombreDiagnostico,
                    lvl, Observacion, Tratamiento, DOSIS, TipoTratamiento)) {
                JOptionPane.showMessageDialog(null, "Tratamiento y diagnostico registrados correctamente");
                
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar los datos");
                //limpiar();
            }
        }
        
        if (e.getSource() == vistatender.btnFinalizar){
            vistatender.setVisible(false);
            
        }
        

        
        if (e.getSource() == vistatender.btnHospitalizar){
            
            ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
            for (int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).getNombre().equals(vistatender.CBPaciente.getSelectedItem().toString()) == true){
                internar.TFIdentificacion.setText(pacientes.get(i).getCedula()); 
                }
            }
            
            cargarAreas();
            cargarCentros();
            DiagnosticosPaciente();

            
            internar.TFNombrePaciente.setText(vistatender.CBPaciente.getSelectedItem().toString());
                    
            
            
            
            Doctor auxDoc=doctorCrud.buscarDoctor(session.getCedula());
            System.out.println("Esta es la CEDULA DEL DOC QUE ME LLEGA: " + session.getCedula() );
      
            // validar la posibilidad de que la lista tenga 2 elementos 
            auxMed.getAuxFuncionario().add(auxDoc);
            System.out.println(auxMed.getAuxFuncionario().get(0).getNombre());
            internar.TFDoctor.setText(auxMed.getAuxFuncionario().get(0).getNombre());

            internar.setVisible(true);
            
=======
    if (e.getSource() == vistatender.btnHospitalizar)
    {
>>>>>>> c1ff3732658b5519f7530fd3fe3a817142dcd973

      ArrayList<Paciente> pacientes = CRUDPaciente.consultarPacientes();
      for (int i = 0; i < pacientes.size(); i++)
      {
        if (pacientes.get(i).getNombre().equals(vistatender.CBPaciente.getSelectedItem().toString()) == true)
        {
          internar.TFIdentificacion.setText(pacientes.get(i).getCedula());
        }
<<<<<<< HEAD
        
        if (e.getSource() == internar.btnRegHosp){
            
            String CENTRO =internar.CBCentroAtencion.getSelectedItem().toString() ;
            String IDPACI= internar.TFIdentificacion.getText();
            String NAMEPACI= internar.TFNombrePaciente.getText() ;
            String DIAGNO= internar.CBDiagnoPaciente.getSelectedItem().toString();
            String SERVHOSP=internar.CBServicioMed.getSelectedItem().toString() ;
            String NAMEFUNC =internar.TFDoctor.getText(); 
            Date FechaInicial=internar.FechaInicialH.getDate() ;
            Date FechaFinal=internar.FechaFinalH.getDate() ;
            
            HospitalizacionP newhosp = new HospitalizacionP(CENTRO,IDPACI,NAMEPACI,DIAGNO,SERVHOSP,NAMEFUNC,FechaInicial,FechaFinal);
            
            if(CRUDPaciente.registrarHospitalizacion(newhosp)){
                JOptionPane.showMessageDialog(null, "Hospitalización registrada correctamente");
                
            }
            else{
               JOptionPane.showMessageDialog(null, "Error al registrar hospitalización"); 
            }
            
            
            
            
        }
        
       
        
        
        
        
        
        
        
            
            
    }
        
        
=======
      }

      cargarAreas();
      cargarCentros();
      DiagnosticosPaciente();
>>>>>>> c1ff3732658b5519f7530fd3fe3a817142dcd973

      internar.TFNombrePaciente.setText(vistatender.CBPaciente.getSelectedItem().toString());

      Doctor auxDoc = doctorCrud.buscarDoctor(session.getCedula());
      System.out.println("Esta es la CEDULA DEL DOC QUE ME LLEGA: " + session.getCedula());

      // validar la posibilidad de que la lista tenga 2 elementos 
      auxMed.getAuxFuncionario().add(auxDoc);
      System.out.println(auxMed.getAuxFuncionario().get(0).getNombre());
      internar.TFDoctor.setText(auxMed.getAuxFuncionario().get(0).getNombre());

      internar.setVisible(true);
    }
  }
}
