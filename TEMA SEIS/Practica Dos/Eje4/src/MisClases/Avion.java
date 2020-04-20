
package MisClases;

import java.util.ArrayList;

public class Avion {
    private String aerolinea;
    private String codavion;
    private int numasientos;
    private String comportamiento;
    
    //Relación entre avion y vuelo (1-*)
        private ArrayList<Vuelo> listavuelos;

    public Avion() {
        //Añadir elemento a elemento
            this.listavuelos = new ArrayList();
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodavion() {
        return codavion;
    }

    public void setCodavion(String codavion) {
        this.codavion = codavion;
    }

    public int getNumasientos() {
        return numasientos;
    }

    public void setNumasientos(int numasientos) {
        this.numasientos = numasientos;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public ArrayList<Vuelo> getListavuelos() {
        return listavuelos;
    }

    public void setListavuelos(ArrayList<Vuelo> listavuelos) {
        this.listavuelos = listavuelos;
    }
        
    public void setVuelo (Vuelo v)
    {
        this.listavuelos.add(v);
    }
    
    public void asignar_vuelo(){}
    public Avion obtener(){return null;}
    public void cancelar_vuelo(){}
}
