
package MisClases;

import java.util.ArrayList;
import java.util.Date;

public class Vuelo {
    private int numvuelo;
    private String horasalida;
    private String horallegada;
    private String lugarorigen;
    private String lugardestino;
    private Date fechasalida;
    private Date fecharegreso;
    private String tipovuelo;
    
    //Relacion entre vuelo y avion (*-1)
        private Avion avion;
    
    //Relacion entre vuelo y piloto (*-1)
        private Piloto piloto;
    
    //Relacion entre vuelo y asientos (1-*)
        private ArrayList<Asiento> asientos = new ArrayList();
    
    //Relacion entre vuelo y pasajero (*-1)
        private Pasajero pasajero;
    
    //Relacion entre vuelo y ciudad (*-1)
        private Ciudad ciudad;

    public Vuelo() {
    }

    public int getNumvuelo() {
        return numvuelo;
    }

    public void setNumvuelo(int numvuelo) {
        this.numvuelo = numvuelo;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }

    public String getLugarorigen() {
        return lugarorigen;
    }

    public void setLugarorigen(String lugarorigen) {
        this.lugarorigen = lugarorigen;
    }

    public String getLugardestino() {
        return lugardestino;
    }

    public void setLugardestino(String lugardestino) {
        this.lugardestino = lugardestino;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Date getFecharegreso() {
        return fecharegreso;
    }

    public void setFecharegreso(Date fecharegreso) {
        this.fecharegreso = fecharegreso;
    }

    public String getTipovuelo() {
        return tipovuelo;
    }

    public void setTipovuelo(String tipovuelo) {
        this.tipovuelo = tipovuelo;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
        
    public void reservar(){}
    public void modificar(){}
    public void eliminar(){}
    public Vuelo buscar(){return null;}
}
