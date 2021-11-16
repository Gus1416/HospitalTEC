package modelo;

/**
 *
 * @author Maria Laura
 */
public class Diagnostico {
  private int id;
  private String nombre;
  private ArrayList<Tratamiento> tratamientos;
  
  public Diagnostico(){}

  public Diagnostico(int pId, String pNombre) {
    this.id = pId;
    this.nombre = pNombre;
  }

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
