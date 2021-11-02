package modelo;

import java.time.LocalDate;

/**
 *
 * @author Maria Laura
 */
public class Paciente extends Usuario {
    
    private String id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String tipoSangre;
    private String nacionalidad;
    private String lugarResidencia;
    private String telefono;

    public Paciente(String pCedula, String pPassword,String id, String nombre, LocalDate fechaNacimiento, String tipoSangre, 
            String nacionalidad, String lugarResidencia, String telefono) {
      super(pCedula, pPassword);
      this.id = id;
      this.nombre = nombre;
      this.fechaNacimiento = fechaNacimiento;
      this.tipoSangre = tipoSangre;
      this.nacionalidad = nacionalidad;
      this.lugarResidencia = lugarResidencia;
      this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
  
}
