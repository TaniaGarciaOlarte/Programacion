
package MisClases;

import java.util.ArrayList;

public class Pasajero {
    private String cedula;
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;
    
    //Relación entre pasajero y vuelo (1-*)
        private ArrayList<Vuelo> listavuelo;
        
    //Relación entre pasajero y asiento (1-1)
        private Asiento asiento;

    public Pasajero() {
        this.listavuelo = new ArrayList();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Vuelo> getListavuelo() {
        return listavuelo;
    }

    public void setListavuelo(ArrayList<Vuelo> listavuelo) {
        this.listavuelo = listavuelo;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
    public void setVuelo (Vuelo v)
    {
        this.listavuelo.add(v);
    }
    
    public void agregar_nuevo(){}
    public void modificar(){}
    public void asignar_vuelo(){}
    public Pasajero buscar(){return null;}
}
