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
public class CentroAtencion {
    private int id;
    private String nombre;
    private String lugar;
    private int capacidadPacientes;
    private String tipo;

    public CentroAtencion(int id, String nombre, String lugar, int capacidadPacientes, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.lugar = lugar;
        this.capacidadPacientes = capacidadPacientes;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCapacidadPacientes() {
        return capacidadPacientes;
    }

    public void setCapacidadPacientes(int capacidadPacientes) {
        this.capacidadPacientes = capacidadPacientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 

}
