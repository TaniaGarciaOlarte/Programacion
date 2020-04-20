package MisClases;

import Enumeraciones.*;

public class Jugador {
    private String nombre;
    private Posicion puesto;
    private String dorsal;

    public Jugador(String nombre, Posicion puesto, String dorsal) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Posicion getPuesto() {
        return puesto;
    }

    public void setPuesto(Posicion puesto) {
        this.puesto = puesto;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }
}
