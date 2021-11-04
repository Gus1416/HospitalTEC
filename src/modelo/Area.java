package modelo;

/**
 *
 * @author Gustavo
 */
public class Area {
  private String nombreArea;
  private int iDArea;

    public Area(String nombreArea, int iDArea) {
        this.nombreArea = nombreArea;
        this.iDArea = iDArea;
    }
 
    public Area(){}

    public int getiDArea() {
        return iDArea;
    }
    
    public void setiDArea(int iDArea) {
        this.iDArea = iDArea;
    }
    
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
