/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author sebcor
 */


public class Citas {
    private int iDCita;
    private String especialidad;
    private LocalDate fechaCita;
    private String observacionAdicional; 
    private EstadoCita Estado;

    public Citas(int iDCita, String especialidad, LocalDate fechaCita, String observacionAdicional, String iD, String Nombre, LocalDate FechaIngreso, String Area) {

        this.iDCita = iDCita;
        this.especialidad = especialidad;
        this.fechaCita = fechaCita;
        this.observacionAdicional = observacionAdicional;
    }

  
    public int getiDCita() {
        return iDCita;
    }

    public void setiDCita(int iDCita) {
        this.iDCita = iDCita;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getObservacionAdicional() {
        return observacionAdicional;
    }

    public void setObservacionAdicional(String observacionAdicional) {
        this.observacionAdicional = observacionAdicional;
    }

    public EstadoCita getEstado() {
        return Estado;
    }

    public void setEstado(EstadoCita Estado) {
        this.Estado = Estado;
    }
    
    
    
}
