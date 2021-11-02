package modelo;

/**
 *
 * @author Gustavo
 */
public class Area {
  private String nombreArea;
  
  public Area(){}
  
  public Area(String pNombreArea){
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
