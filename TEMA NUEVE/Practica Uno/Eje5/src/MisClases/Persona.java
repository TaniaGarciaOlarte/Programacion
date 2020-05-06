
package MisClases;

import java.util.ArrayList;

public class Persona {
    private String dni;
    private String nombre;
    private String papellido;
    private String sapellido;
    private String telefono;
    
    private ArrayList<Acontecimiento> listaacontecimiento = new ArrayList();

    public Persona() {
    }

    public Persona(String dni, String nombre, String papellido, String sapellido, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.papellido = papellido;
        this.sapellido = sapellido;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Acontecimiento> getListaacontecimiento() {
        return listaacontecimiento;
    }

    public void setListaacontecimiento(ArrayList<Acontecimiento> listaacontecimiento) {
        this.listaacontecimiento = listaacontecimiento;
    }
    
    public void setAcontecimiento(Acontecimiento a)
    {
        listaacontecimiento.add(a);
    }
}
