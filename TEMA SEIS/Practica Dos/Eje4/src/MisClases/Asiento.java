
package MisClases;

public class Asiento {
    private int numeroasiento;
    private boolean estado;
    private String comportamiento;
    
    //Relacion entre asiento y pasajero(1-1)
        private Pasajero pasajeros;
    
    //Relación entre asiento y vuelo(*-1)
        private Vuelo vuelo;

    public Asiento() {
    }

    public int getNumeroasiento() {
        return numeroasiento;
    }

    public void setNumeroasiento(int numeroasiento) {
        this.numeroasiento = numeroasiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public Pasajero getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajero pasajeros) {
        this.pasajeros = pasajeros;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
        
    public void reservar(){}
    public void comprar(){}
    public boolean mostrar_disponibilidad(){return false;}
    public void desbloquear(){}
    
    
}
