
package MisClases;

import Enumeraciones.*;

public class Camion extends Vehiculo{
    private marcacamion marca;

    public Camion(marcacamion marca, String matricula, Persona p) {
        super(matricula, p);
        this.marca = marca;
    }

    public marcacamion getMarca() {
        return marca;
    }

    public void setMarca(marcacamion marca) {
        this.marca = marca;
    }
}
