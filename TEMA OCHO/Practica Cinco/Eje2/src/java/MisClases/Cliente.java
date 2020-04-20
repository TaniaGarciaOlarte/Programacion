
package MisClases;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String correo;
    private String telefono;
    
    //Relacion entre cliente y reserva
        private ArrayList<Reserva> listaReserva;

    public Cliente(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        listaReserva = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(ArrayList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }
    
    public void setReserva(Reserva r)
    {
        listaReserva.add(r);
    }
    
    @Override
        public String toString()
        {
            return "Nombre: " + nombre + "\n"
                    + "Correo electronico: " + correo + "\n"
                    + "Telefono: " + telefono + "\n";
        }
}
