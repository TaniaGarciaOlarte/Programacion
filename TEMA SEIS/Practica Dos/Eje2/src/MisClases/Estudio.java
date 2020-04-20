
package MisClases;

import java.util.ArrayList;
import java.util.Date;

public class Estudio 
{
    private String nombre;
    private String ciudad;
    private String direccion;
    private String dirweb;
    private Date fechafundacion;
    private String pais;
    private ArrayList<String> telefonos;

    //RELACIÓN ENTRE PELICULAS Y ESTUDIOS (N A N)
         private ArrayList<Pelicula> listaPeliculas;
    
    public Estudio(){}
    
    public Estudio(String nombre, String ciudad, String direccion, String dirweb, Date fechafundacion, String pais, ArrayList<String> telefonos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dirweb = dirweb;
        this.fechafundacion = fechafundacion;
        this.pais = pais;
        this.telefonos = telefonos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDirweb() {
        return dirweb;
    }

    public void setDirweb(String dirweb) {
        this.dirweb = dirweb;
    }

    public Date getFechafundacion() {
        return fechafundacion;
    }

    public void setFechafundacion(Date fechafundacion) {
        this.fechafundacion = fechafundacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }
    
    public void setPelicula(Pelicula p)
    {
        listaPeliculas.add(p);
    }
    
    //OTROS METODOS
        private void nuevoEstudio(){}
        private void modificaEstudio(){}
        private void cierraEstudio(){}
        public Estudio[] despliegueEstudio(){return null;}
}

