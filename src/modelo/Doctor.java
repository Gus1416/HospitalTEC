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
public class Doctor extends Funcionario{
    
    
    private int idMedico;
    private ArrayList especialidad;

    public Doctor(int idMedico, ArrayList especialidad, String iD, String Nombre, LocalDate FechaIngreso, String Area) {
        super(iD, Nombre, FechaIngreso, Area);
        this.idMedico = idMedico;
        this.especialidad = especialidad;
    }
    
//    1. Cancelar cita de paciente
//    2. Asignar cita de paciente
//    3. Atender cita (Registrar diagnósticos y tratamientos).

    
    
    
}
