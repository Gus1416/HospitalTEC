package modelo;

/**
 *
 * @author Gustavo
 */
public interface Exportable {
  
  public abstract void exportarPDF(ArrayList<Object[]> pFilas, String pTipoReporte);
  
  public abstract void exportarCSV(String flag, ArrayList<Object[]> lista);
  
  public abstract void exportarHTML(ArrayList<Object[]> pFilas, String pTipoReporte);
}
