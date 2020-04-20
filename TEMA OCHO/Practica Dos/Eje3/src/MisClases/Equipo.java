
package MisClases;

import java.util.*;

public class Equipo {
    private String nombre;
    private String escudo;
    
    private ArrayList<Jugador> listajugador = new ArrayList();

    public Equipo(String nombre, String escudo) {
        this.nombre = nombre;
        this.escudo = escudo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public ArrayList<Jugador> getListajugador() {
        return listajugador;
    }

    public void setListajugador(ArrayList<Jugador> listajugador) {
        this.listajugador = listajugador;
    }
    
    public void setjugador(Jugador j)
    {
        listajugador.add(j);
    }
}
