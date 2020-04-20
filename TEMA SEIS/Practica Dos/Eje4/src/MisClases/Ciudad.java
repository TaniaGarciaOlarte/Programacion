
package MisClases;

import java.util.ArrayList;

public class Ciudad {
    private String codigociudad;
    private String nombre;
    
    //Relacion entre ciudad y vuelos (1-*)
        private ArrayList<Vuelo> listaVuelos;

    public Ciudad() {
    }

    public String getCodigociudad() {
        return codigociudad;
    }

    public void setCodigociudad(String codigociudad) {
        this.codigociudad = codigociudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
    public void setVuelo(Vuelo v){
        if (listaVuelos == null)
            listaVuelos = new ArrayList();
        this.listaVuelos.add(v);
    }
    
    public void agregar_nuevo(){}
    
    public Ciudad obtener()
    {
        return null;
    }
}
