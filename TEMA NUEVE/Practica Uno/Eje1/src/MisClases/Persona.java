
package MisClases;

public class Persona {
    private String nombre;
    private String edad;
    private String profesion;
    private String telefono;

    public Persona(String nombre, String edad, String profesion, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.telefono = telefono;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString()
    {
        return "   -Nombre: " + nombre + "\n"
                + "   -Edad: " + edad + "\n"
                + "   -Profesion: " + profesion + "\n"
                + "   -Telefono: " + telefono;
    }
}
