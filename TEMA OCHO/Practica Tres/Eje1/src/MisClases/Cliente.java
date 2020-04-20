
package MisClases;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    
    private ArrayList<Producto> listaproductos = new ArrayList();

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaproductos() {
        return listaproductos;
    }

    public void setListaproductos(ArrayList<Producto> listaproductos) {
        this.listaproductos = listaproductos;
    }
    
    public void setProductos(Producto p)
    {
        listaproductos.add(p);
    }
}
