
package Clases;

public class Productos {
    private String nombre;
    private int unidades;
    private double precio;

    public Productos(String nombre, int unidades, double precio) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
    }

    public Productos() {
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
    
    public double preciouni(int uni)
    {
        return uni*precio;
    }
    
    public double preciou(double pre)
    {  
        precio = pre/unidades;
                
        return precio;
    }
}
