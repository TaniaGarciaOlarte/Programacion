
package MisClases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Artista {
    private String nombre;
    private LocalDate fechanacimiento;
    
    private ArrayList<Obra> obras = new ArrayList();
    private ArrayList<Pelicula> peliculas = new ArrayList();

    public Artista(String nombre, LocalDate fechanacimiento) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void setObras(ArrayList<Obra> obras) {
        this.obras = obras;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
    public void setObra(Obra o)
    {
        obras.add(o);
    }
    
    public void setPelicula(Pelicula p)
    {
        peliculas.add(p);
    }
    
    @Override
    public String toString()
    {
        return "\nNOMBRE: " + nombre + "\n"
                + "FECHA DE NACIMIENTO: " + fechanacimiento; 
    }
    
    public String toString2()
    {
        String cadenaObra = "";
        if (!obras.isEmpty())
            for(Obra o:obras)
                cadenaObra+=o.toString2();
        else
            cadenaObra = "NO HA CREADO NINGUNA OBRA";
        
        String cadenaPeli = "";
        if (!peliculas.isEmpty())
            for (Pelicula p:peliculas)
                cadenaPeli+=p.toString2();
        else
            cadenaPeli = "NO HA SALIDO EN NINGUNA PELICULA";
        
        return "\nNOMBRE: " + nombre + "\n"
                + "FECHA DE NACIMIENTO: " + fechanacimiento + "\n"
                + "PELICULAS: " + cadenaPeli + "\n"
                + "OBRAS: " + cadenaObra + "\n";
    }
}
