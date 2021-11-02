package modelo;

import java.time.LocalDate;

/**
 *
 * @author sebcor
 */
public class Funcionario extends Usuario {

  private String nombre;
  private String tipoFuncionario;
  private LocalDate fechaIngreso;
  private Area area;
  private CentroAtencion centro;
  
  public Funcionario(){}

  public Funcionario(String pCedula, String pPassword, String pNombre, String pTipoFuncionario, 
          LocalDate pFechaIngreso, Area pArea, CentroAtencion pCentro) {
    super(pCedula, pPassword);
    this.nombre = pNombre;
    this.fechaIngreso = pFechaIngreso;
    this.area = pArea;
    this.centro = pCentro;
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

  /**
   * @return the fechaIngreso
   */
  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  /**
   * @param FechaIngreso the fechaIngreso to set
   */
  public void setFechaIngreso(LocalDate FechaIngreso) {
    this.fechaIngreso = FechaIngreso;
  }

  /**
   * @return the area
   */
  public Area getArea() {
    return area;
  }

  /**
   * @param area the area to set
   */
  public void setArea(Area area) {
    this.area = area;
  }

  /**
   * @return the centro
   */
  public CentroAtencion getCentro() {
    return centro;
  }

  /**
   * @param centro the centro to set
   */
  public void setCentro(CentroAtencion centro) {
    this.centro = centro;
  }

  /**
   * @return the tipoFuncionario
   */
  public String getTipoFuncionario() {
    return tipoFuncionario;
  }

  /**
   * @param tipoFuncionario the tipoFuncionario to set
   */
  public void setTipoFuncionario(String tipoFuncionario) {
    this.tipoFuncionario = tipoFuncionario;
  }
}
