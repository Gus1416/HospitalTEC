package modelo;

/**
 * Clase que contiene la información de las Áreas o Especialidades.
 * 
 * @author Gustavo
 * @version 18/11/2021
 */
public class Area {
  private String nombreArea;
  private int idArea;

  /**
   * Constructor por defecto.
   */
  public Area() {
  }

  /**
   * Constructor de la clase con parámetros.
   * 
   * @param pNombreArea el nombre del área
   * @param pIdArea     el identificador del área
   */
  public Area(String pNombreArea, int pIdArea) {
    this.nombreArea = pNombreArea;
    this.idArea = pIdArea;
  }

  //Métodos accesores
  
  public int getIdArea() {
    return idArea;
  }

  public void setIdArea(int idArea) {
    this.idArea = idArea;
  }

  public Area(String pNombreArea) {
    this.nombreArea = pNombreArea;
  }

  public String getNombreArea() {
    return nombreArea;
  }

  public void setNombreArea(String nombreArea) {
    this.nombreArea = nombreArea;
  }
}
