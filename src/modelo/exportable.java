package modelo;

/**
 *
 * @author sebcor
 */

import java.util.ArrayList;

public interface exportable {
    
    
    public abstract void exportarPDF(String flag, ArrayList<Object[]> lista);
    
    public abstract void exportarCSV(String flag, ArrayList<Object[]> lista);
    
    public abstract void exportarHTML(ArrayList<Object[]> lista , String flag);
    
    
}