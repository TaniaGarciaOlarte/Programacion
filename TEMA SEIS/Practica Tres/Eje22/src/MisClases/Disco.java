
package MisClases;

public class Disco extends Obra{
    private String discografica;
    private int numerocanciones;

    public Disco(String discografica, int numerocanciones, String titulo, int añoedi) {
        super(titulo, añoedi);
        this.discografica = discografica;
        this.numerocanciones = numerocanciones;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public int getNumerocanciones() {
        return numerocanciones;
    }

    public void setNumerocanciones(int numerocanciones) {
        this.numerocanciones = numerocanciones;
    }
  
    @Override
    public String toString()
    {
        return super.toString() + "\nDISCOGRÁFICA: " + discografica + "\n"
                + "NUMERO DE CANCIONES: " + numerocanciones + "\n";
    }
}
