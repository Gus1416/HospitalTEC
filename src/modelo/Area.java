package modelo;

/**
 *
 * @author Gustavo
 */
public class Area {
  private String nombreArea;
  private int idArea;

  public Area() {
  }

  public Area(String pNombreArea, int pIdArea) {
    this.nombreArea = pNombreArea;
    this.idArea = pIdArea;
  }

  public int getIdArea() {
    return idArea;
  }

  public void setIdArea(int idArea) {
    this.idArea = idArea;
  }

  public Area(String pNombreArea) {
    this.nombreArea = pNombreArea;
  }

  /**
   * @return the nombreArea
   */
  public String getNombreArea() {
    return nombreArea;
  }

  /**
   * @param nombreArea the nombreArea to set
   */
  public void setNombreArea(String nombreArea) {
    this.nombreArea = nombreArea;
  }
}
