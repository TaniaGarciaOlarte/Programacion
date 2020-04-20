
package MisClases;

import java.time.LocalDate;

public class Movimiento {
    private LocalDate fecha;
    private String descri;
    private double importe;

    public Movimiento(LocalDate fecha, String descri, double importe) {
        this.fecha = fecha;
        this.descri = descri;
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    @Override
    public String toString()
    {
        return fecha + " " + descri + " " + importe;
    }
    
}
