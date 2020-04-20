
package MisClases;

public class Pelicula extends Obra{
    private String productora;
    private int duracion;

    public Pelicula(String productora, int duracion, String titulo, int añoedi) {
        super(titulo, añoedi);
        this.productora = productora;
        this.duracion = duracion;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "\nPRODUCTORA: " + productora + "\n"
                + "DURACIÓN: " + duracion + "\n";
    }
    
    public String toString2()
    {
        return super.toString2() + "\nPRODUCTORA: " + productora + "\n"
                + "DURACIÓN: " + duracion + "\n";
    }
}
