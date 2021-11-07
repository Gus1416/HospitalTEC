/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sebcor
 */

public class Tratamiento {
    private String Nombre;
    private String Dosis;
    private int Id;

    public Tratamiento() {
    } 
    
    public Tratamiento(String Nombre, String Dosis) {
        this.Nombre = Nombre;
        this.Dosis = Dosis;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

        
    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Dosis
     */
    public String getDosis() {
        return Dosis;
    }

    /**
     * @param Dosis the Dosis to set
     */
    public void setDosis(String Dosis) {
        this.Dosis = Dosis;
    }
    
    
    
}
