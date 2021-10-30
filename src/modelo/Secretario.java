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
public class Secretario extends Funcionario {

    public Secretario(String iD, String Nombre, LocalDate FechaIngreso, String Area) {
        super(iD, Nombre, FechaIngreso, Area);
    }
    
    
}
