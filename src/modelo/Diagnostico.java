/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Maria Laura
 */
public class Diagnostico {
   private String nombre;
   private String nivel;
   private ArrayList observaciones;

    public Diagnostico(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        
    }
            
            
            
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public ArrayList getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(ArrayList observaciones) {
        this.observaciones = observaciones;
    }

    
}
