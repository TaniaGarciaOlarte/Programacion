
package MisClases;

import java.util.ArrayList;

public class Obra {
    private String titulo;
    private int añoedi;
    
    private ArrayList<Artista> artistas = new ArrayList();

    public Obra(String titulo, int añoedi) {
        this.titulo = titulo;
        this.añoedi = añoedi;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoedi() {
        return añoedi;
    }

    public void setAñoedi(int añoedi) {
        this.añoedi = añoedi;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }
    
    public void setArtista(Artista a)
    {
        artistas.add(a);
    }
    
    @Override
    public String toString()
    {
        String cadena = "";
        for (Artista a:artistas)
        {
            cadena += a.toString();
        }
        
        return "\nTITULO: " + titulo + "\n"
                + "AÑO DE EDICIÓN: " + añoedi + "\n"
                + "ARTISTAS: " + cadena + "\n";
    }
    
    public String toString2()
    {
        return "\nTITULO: " + titulo + "\n"
                + "AÑO DE EDICIÓN: " + añoedi + "\n";
    }
}
