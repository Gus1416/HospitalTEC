package modelo;

/**
 * Interface para la exportación de reportes en diferentes formatos.
 * 
 * @author Gustavo
 * @version 21/11/2021
 */
public interface Exportable {
  
  /**
   * Exporta el reporte a formato PDF.
   * 
   * @param pFilas las filas que componen la tabla del reporte
   * @param pTipoReporte el tipo de reporte que se está exportando
   */
  public abstract void exportarPDF(ArrayList<Object[]> pFilas, String pTipoReporte);
  
  /**
   * Exporta el reporte a formato CSV.
   * 
   * @param flag el tipo de reporte que se está exportando
   * @param lista las filas que componen la tabla del reporte
   */
  public abstract void exportarCSV(String flag, ArrayList<Object[]> lista);
  
  /**
   * Exporta el reporte a formato HTML.
   * 
   * @param pFilas las filas que componen la tabla del reporte
   * @param pTipoReporte el tipo de reporte que se está exportando
   */
  public abstract void exportarHTML(ArrayList<Object[]> pFilas, String pTipoReporte);
}