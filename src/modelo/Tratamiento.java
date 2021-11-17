package modelo;

/**
 *
 * @author sebcor
 */
public class Tratamiento {
  private int id;
  private String nombre;
  private int dosis;
  private String tipo;
  
  public Tratamiento(){}

  public Tratamiento(String pNombre, int pDosis, String pTipo) {
    this.nombre = pNombre;
    this.dosis = pDosis;
    this.tipo = pTipo;
  }

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

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param Nombre the nombre to set
   */
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
