
package MisClases;

import java.time.LocalDate;

public class Hijo {
    private String nombre;
    private LocalDate fechanac;

    public Hijo(String nombre, LocalDate fechanac) {
        this.nombre = nombre;
        this.fechanac = fechanac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }
    
    @Override
    public String toString()
    {
        return "Nombre: " + nombre + " Fecha_Nac: " + fechanac;
    }
}
