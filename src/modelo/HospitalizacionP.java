/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author sebcor
 */
public class HospitalizacionP {
    
    private String CentroAtencion;
    private String Identificacion;
    private String NombrePaciente; 
    private String Diagnostico;
    private String Servicio;
    private String Funcionario;
    private Date FechaInicio;
    private Date FechaFinal; 

    public HospitalizacionP(String CentroAtencion, String Identificacion, String NombrePaciente, String Diagnostico, String Servicio, String Funcionario, Date FechaInicio, Date FechaFinal) {
        this.CentroAtencion = CentroAtencion;
        this.Identificacion = Identificacion;
        this.NombrePaciente = NombrePaciente;
        this.Diagnostico = Diagnostico;
        this.Servicio = Servicio;
        this.Funcionario = Funcionario;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
    }


    /**
     * @return the CentroAtencion
     */
    public String getCentroAtencion() {
        return CentroAtencion;
    }

    /**
     * @param CentroAtencion the CentroAtencion to set
     */
    public void setCentroAtencion(String CentroAtencion) {
        this.CentroAtencion = CentroAtencion;
    }

    /**
     * @return the Identificacion
     */
    public String getIdentificacion() {
        return Identificacion;
    }

    /**
     * @param Identificacion the Identificacion to set
     */
    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    /**
     * @return the NombrePaciente
     */
    public String getNombrePaciente() {
        return NombrePaciente;
    }

    /**
     * @param NombrePaciente the NombrePaciente to set
     */
    public void setNombrePaciente(String NombrePaciente) {
        this.NombrePaciente = NombrePaciente;
    }

    /**
     * @return the Diagnostico
     */
    public String getDiagnostico() {
        return Diagnostico;
    }

    /**
     * @param Diagnostico the Diagnostico to set
     */
    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    /**
     * @return the Servicio
     */
    public String getServicio() {
        return Servicio;
    }

    /**
     * @param Servicio the Servicio to set
     */
    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    /**
     * @return the Funcionario
     */
    public String getFuncionario() {
        return Funcionario;
    }

    /**
     * @param Funcionario the Funcionario to set
     */
    public void setFuncionario(String Funcionario) {
        this.Funcionario = Funcionario;
    }

    /**
     * @return the FechaInicio
     */
    public Date getFechaInicio() {
        return FechaInicio;
    }

    /**
     * @param FechaInicio the FechaInicio to set
     */
    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    /**
     * @return the FechaFinal
     */
    public Date getFechaFinal() {
        return FechaFinal;
    }

    /**
     * @param FechaFinal the FechaFinal to set
     */
    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }
    
    
    
    
    
    
}
