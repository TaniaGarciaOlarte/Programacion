
package MisClases;

public class Cliente extends Persona{
    private String telefono;

    public Cliente(String telefono, String nombre, int edad) {
        super(nombre, edad);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String mostrar(){
        return "Nombre: " + this.getNombre() + "\n Edad: " + this.getEdad() + "\n Telefono: " + this.getTelefono();
    }
}
