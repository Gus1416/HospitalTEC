package modelo;

/**
 *
 * @author Gustavo
 */
public interface Exportable {
  
  public abstract void exportarPDF(ArrayList<Object[]> pFilas, String pTipoReporte);
  
  public abstract void exportarCSV();
  
  public abstract void exportarHTML();
}
