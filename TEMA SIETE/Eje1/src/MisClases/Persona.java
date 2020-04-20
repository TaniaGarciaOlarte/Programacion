
package MisClases;

import Enumeraciones.*;
import java.util.ArrayList;

public class Persona {
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    
    private ArrayList<Vehiculo> listavehiculos;

    public Persona() {
    }

    public Persona(String dni, String nombre, String apellidos, String direccion, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Vehiculo> getListavehiculos() {
        return listavehiculos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setListavehiculos(ArrayList<Vehiculo> listavehiculos) {
        this.listavehiculos = listavehiculos;
    }
    
    //EJE3
        public int getNumeroMotos()
        {
            //1ºForma
                int contador = 0;
                for (Vehiculo v:listavehiculos)
                    if (v instanceof Moto)
                        contador++;
                return contador;
            
            //2ºForma
                /*int contador = 0;
                contador = listavehiculos.stream().filter((v) -> (v instanceof Moto)).map((item) -> 1).reduce(contador, Integer::sum);
´               return contador;*/
        }
        
    //EJE4
        public boolean getMotoDucate()
        {
            //1ºForma
                return listavehiculos.stream().filter((v) -> (v instanceof Moto)).anyMatch((v) -> (((Moto) v).getMarca() == marcamoto.DUCATE));
                
            //2ºForma
                /*for(Vehiculo v:listavehiculos)
                    if (v instanceof Moto)
                    {
                        if ((Moto) v).getMarca() == marcamoto.DUCATE)
                            return true;
                    }
                return false;
                */
        }
}
