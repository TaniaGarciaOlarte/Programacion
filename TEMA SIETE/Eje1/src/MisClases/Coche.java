
package MisClases;

import Enumeraciones.*;

public class Coche extends Vehiculo{

    private marcacoche marca;

    public Coche(marcacoche marca, String matricula, Persona p) {
        super(matricula, p);
        this.marca = marca;
    }

    public marcacoche getMarca() {
        return marca;
    }

    public void setMarca(marcacoche marca) {
        this.marca = marca;
    }
}
