package modelo;

/**
 *
 * @author Maria Laura
 */
public class CentroAtencion {
  private int id;
  private String nombre;
  private String lugar;
  private int capacidadPacientes;
  private String tipo;

  public CentroAtencion(int pId, String pNombre, String pLugar, int pCapacidadPacientes, String pTipo) {
    this.id = pId;
    this.nombre = pNombre;
    this.lugar = pLugar;
    this.capacidadPacientes = pCapacidadPacientes;
    this.tipo = pTipo;
  }

  CentroAtencion() {
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

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }

  public int getCapacidadPacientes() {
    return capacidadPacientes;
  }

  public void setCapacidadPacientes(int capacidadPacientes) {
    this.capacidadPacientes = capacidadPacientes;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
