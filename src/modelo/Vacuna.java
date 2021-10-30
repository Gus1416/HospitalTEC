/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Maria Laura
 */
public class Vacuna {
        
        private LocalDate fechaAplicacion;
        private String nombre;
        private String farmaceutica;
        private int numeroLote;

    public Vacuna(LocalDate fechaAplicacion, String nombre, String farmaceutica, int numeroLote) {
        this.fechaAplicacion = fechaAplicacion;
        this.nombre = nombre;
        this.farmaceutica = farmaceutica;
        this.numeroLote = numeroLote;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFarmaceutica() {
        return farmaceutica;
    }

    public void setFarmaceutica(String farmaceutica) {
        this.farmaceutica = farmaceutica;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }
        
        
    
  
}
