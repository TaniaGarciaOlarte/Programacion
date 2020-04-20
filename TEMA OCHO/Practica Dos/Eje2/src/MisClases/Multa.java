
package MisClases;

public class Multa {
    private String cod;
    private String descripcion;

    public Multa(String cod, String descripcion) {
        this.cod = cod;
        this.descripcion = descripcion;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString()
    {
        return cod + " → " + descripcion + "\n";
    }
}
