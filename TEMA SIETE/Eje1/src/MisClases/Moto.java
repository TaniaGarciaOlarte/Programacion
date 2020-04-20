
package MisClases;

import Enumeraciones.*;

public class Moto extends Vehiculo{
    private marcamoto marca;

    public Moto(marcamoto marca, String matricula, Persona p) {
        super(matricula, p);
        this.marca = marca;
    }

    public marcamoto getMarca() {
        return marca;
    }

    public void setMarca(marcamoto marca) {
        this.marca = marca;
    }
}
