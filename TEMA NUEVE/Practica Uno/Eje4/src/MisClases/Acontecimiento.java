
package MisClases;

import java.time.*;

public class Acontecimiento {
    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private LocalTime horai;
    private LocalTime horaf;
    private Integer aforo;

    public Acontecimiento() {
    }

    public Acontecimiento(String nombre, String lugar, LocalDate fecha, LocalTime horai, LocalTime horaf, Integer aforo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horai = horai;
        this.horaf = horaf;
        this.aforo = aforo;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHorai() {
        return horai;
    }

    public void setHorai(LocalTime horai) {
        this.horai = horai;
    }

    public LocalTime getHoraf() {
        return horaf;
    }

    public void setHoraf(LocalTime horaf) {
        this.horaf = horaf;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }
}
