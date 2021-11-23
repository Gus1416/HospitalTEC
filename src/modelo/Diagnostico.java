package modelo;

/**
 * Clase que contiene la información de los diagnósticos.
 * 
 * @author Maria Laura
 * @version 15/11/2021
 */
public class Diagnostico {
  private int id;
  private String nombre;
  private ArrayList<Tratamiento> tratamientos;
  
  /**
   * Constructor de la clase.
   */
  public Diagnostico(){}

  /**
   * Constructor con parámetros.
   * 
   * @param pId el identificador del diagnóstico
   * @param pNombre  el nombre del diagnóstico
   */
  public Diagnostico(int pId, String pNombre) {
    this.id = pId;
    this.nombre = pNombre;
  }

  //Métodos accesores
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ArrayList<Tratamiento> getTratamientos() {
    return tratamientos;
  }

  public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
    this.tratamientos = tratamientos;
  }
}
