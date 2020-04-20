
package MisClases;

import java.util.ArrayList;

public class Piloto {
    private String codigoPiloto;
    private String nombre;
    private String apellido;
    private Integer numeroDeLicencia;
    
    //Relacion entre piloto y vuelos (1-*)
        private ArrayList<Vuelo> listavuelos = new ArrayList();

    public Piloto() {
    }

    public String getCodigoPiloto() {
        return codigoPiloto;
    }

    public void setCodigoPiloto(String codigoPiloto) {
        this.codigoPiloto = codigoPiloto;
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

    public Integer getNumeroDeLicencia() {
        return numeroDeLicencia;
    }

    public void setNumeroDeLicencia(Integer numeroDeLicencia) {
        this.numeroDeLicencia = numeroDeLicencia;
    }

    public ArrayList<Vuelo> getListavuelos() {
        return listavuelos;
    }

    public void setListavuelos(ArrayList<Vuelo> listavuelos) {
        this.listavuelos = listavuelos;
    }
        
    public void agregar_nuevo(){}
    public void asignar_vuelo(){}
    public void cancelar_vuelo(){}
    public void modificar(){}
    public Piloto buscar(){return null;}
}
