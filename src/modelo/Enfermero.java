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
public class Enfermero extends Funcionario {
    private boolean personalCargo;
    private boolean experienciaCapacitaciones;

    public Enfermero(boolean personalCargo, boolean experienciaCapacitaciones, String iD, String Nombre, LocalDate FechaIngreso, String Area) {
        super(iD, Nombre, FechaIngreso, Area);
        this.personalCargo = personalCargo;
        this.experienciaCapacitaciones = experienciaCapacitaciones;
    }

    public boolean isPersonalCargo() {
        return personalCargo;
    }

    public void setPersonalCargo(boolean personalCargo) {
        this.personalCargo = personalCargo;
    }

    public boolean isExperienciaCapacitaciones() {
        return experienciaCapacitaciones;
    }

    public void setExperienciaCapacitaciones(boolean experienciaCapacitaciones) {
        this.experienciaCapacitaciones = experienciaCapacitaciones;
    }

    

    

    }
    

