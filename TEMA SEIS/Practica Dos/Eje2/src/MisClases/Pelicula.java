
package MisClases;

import java.util.ArrayList;

public class Pelicula 
{
    private String titulo;
    private char[] año;
    private float duracion;
    private String tipo;
    
    //RELACIÓN CON LA CLASE ESTUDIO
        private ArrayList<Estudio> listaEstudios;

    public Pelicula(String titulo, char[] año, float duracion, String tipo, ArrayList<Estudio> listaEstudios) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
        this.listaEstudios = listaEstudios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public char[] getAño() {
        return año;
    }

    public void setAño(char[] año) {
        this.año = año;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(ArrayList<Estudio> listaEstudios) {
        this.listaEstudios = listaEstudios;
    }
        
    //OTROS METODOS
        public void nuevaPelicula(){}
        public void modificaPelicula(){}
        public void despliegaPelicula(){}
        public void eliminaaPelicula(){}
        
}

