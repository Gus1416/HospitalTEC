package modelo;

/**
 * Clase que contiene la información de los tratamientos.
 * 
 * @author Sebastián
 * @version  15/11/2021
 */
public class Tratamiento {
  private int id;
  private String nombre;
  private int dosis;
  private String tipo;
  
  /**
   * Constructor por defecto
   */
  public Tratamiento(){}

  /**
   * Constructor con parámetros.
   * 
   * @param pNombre el nombre del tratamiento
   * @param pDosis la cantidad de dosis del tratamiento
   * @param pTipo el tipo de tratamiento
   */
  public Tratamiento(String pNombre, int pDosis, String pTipo) {
    this.nombre = pNombre;
    this.dosis = pDosis;
    this.tipo = pTipo;
  }

  //Métodos accesores
  
  public void setId(int id) {
    this.id = id;
  }
  
  public int getId() {
    return id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String Nombre) {
    this.nombre = Nombre;
  }

  public int getDosis() {
    return dosis;
  }

  public void setDosis(int dosis) {
    this.dosis = dosis;
  }
}
