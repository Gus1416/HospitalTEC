package modelo;

/**
 * Clase que contiene la información de los centros de atención.
 * 
 * @author Maria Laura
 * @version 15/11/2021
 */
public class CentroAtencion {
  //Atributos de la clase
  private int id;
  private String nombre;
  private String lugar;
  private int capacidadPacientes;
  private String tipo;

  /**
   * Constructor de la clase.
   * 
   * @param pNombre               el nombre del centro
   * @param pLugar                la ubicación del centro
   * @param pCapacidadPacientes   la capacidad de aforo del centro
   * @param pTipo                 el tipo de centro
   */
  public CentroAtencion(String pNombre, String pLugar, int pCapacidadPacientes, String pTipo) {
    this.nombre = pNombre;
    this.lugar = pLugar;
    this.capacidadPacientes = pCapacidadPacientes;
    this.tipo = pTipo;
  }

  /**
   * Constructor por defecto
   */
  CentroAtencion() {
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
