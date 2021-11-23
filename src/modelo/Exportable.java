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

import java.util.ArrayList;

public interface Exportable {
    
    
    public abstract void exportarPDF(ArrayList<Object[]> pFilas, String pTipoReporte);
    
    public abstract void exportarCSV(String flag, ArrayList<Object[]> lista);
    
    public abstract void exportarHTML(ArrayList<Object[]> pFilas, String pTipoReporte);
    
    
}
