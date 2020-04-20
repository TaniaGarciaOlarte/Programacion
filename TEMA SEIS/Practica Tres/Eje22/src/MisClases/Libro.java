
package MisClases;

public class Libro extends Obra{
    private String editorial;
    private int numpag;

    public Libro(String editorial, int numpag, String titulo, int añoedi) {
        super(titulo, añoedi);
        this.editorial = editorial;
        this.numpag = numpag;
    }

    public String getEditorial() {
        return editorial; 
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumpag() {
        return numpag;
    }

    public void setNumpag(int numpag) {
        this.numpag = numpag;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "\nEDITORIAL: " + editorial + "\n"
                + "NUMERO DE PAGINAS: " + numpag + "\n"; 
    }
}
