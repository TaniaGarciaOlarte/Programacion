
package MisClases;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private int unidades;
    private double precio;
    
    private ArrayList<Proveedor> listaproveedor = new ArrayList();

    public Producto(String nombre, int unidades, double precio) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Proveedor> getListaproveedor() {
        return listaproveedor;
    }

    public void setListaproveedor(ArrayList<Proveedor> listaproveedor) {
        this.listaproveedor = listaproveedor;
    }
    
    public void setProveedor(Proveedor p)
    {
        listaproveedor.add(p);
    }
    
    public double preciouni(int uni)
    {
        return uni * precio;
    }
    
    public void vuni(int unid)
    {
        unidades -= unid;
    }
    
    public void cuni(int u,double precioc)
    {
        setnpre(u,precioc);
        unidades += u;
    }
    
    public void setnpre(int u,double p)
    {
        precio = ((preciouni(unidades) + (u*p)) / (unidades + u));
    }
}
