package modelo;

import java.time.LocalDate;

/**
 *
 * @author sebcor
 */
public class Funcionario {
    
    private String iD;
    private String Nombre;
    private LocalDate FechaIngreso;
    private String Area;
  //  private CentroAtencion Centro;

    public Funcionario(String iD, String Nombre, LocalDate FechaIngreso, String Area) {
        this.iD = iD;
        this.Nombre = Nombre;
        this.FechaIngreso = FechaIngreso;
        this.Area = Area;
    }

    /**
     * @return the iD
     */
    public String getiD() {
        return iD;
    }

    /**
     * @param iD the iD to set
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the FechaIngreso
     */
    public LocalDate getFechaIngreso() {
        return FechaIngreso;
    }

    /**
     * @param FechaIngreso the FechaIngreso to set
     */
    public void setFechaIngreso(LocalDate FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    /**
     * @return the Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * @param Area the Area to set
     */
    public void setArea(String Area) {
        this.Area = Area;
    }
    
    
    
    
    
    
}
