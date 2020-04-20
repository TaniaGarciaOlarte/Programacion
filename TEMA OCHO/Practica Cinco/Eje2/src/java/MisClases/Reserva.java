
package MisClases;

import java.time.LocalDate;

public class Reserva {
    private LocalDate fecha;
    private String franjah;
    private int comensales;
    private String color;
    private String demandas;
    
    //Relacion entre reserva y cliente
        private Cliente c;

    public Reserva(LocalDate fecha, String franjah, int comensales, String color, String demandas) {
        this.fecha = fecha;
        this.franjah = franjah;
        this.comensales = comensales;
        this.color = color;
        this.demandas = demandas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getFranjah() {
        return franjah;
    }

    public void setFranjah(String franjah) {
        this.franjah = franjah;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDemandas() {
        return demandas;
    }

    public void setDemandas(String demandas) {
        this.demandas = demandas;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }  
    
    @Override
        public String toString()
        {
            return "Fecha Reserva: " + fecha + "\n"
                    + "Franja Horaria: " + franjah + "\n"
                    + "Comensales: " + comensales + "\n"
                    + "Color del Mantel: " + color + "\n"
                    + "Demandas: " + demandas + "\n";
        }
}
