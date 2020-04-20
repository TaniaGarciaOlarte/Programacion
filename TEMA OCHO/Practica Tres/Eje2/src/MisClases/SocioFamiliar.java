
package MisClases;

import java.util.ArrayList;

public class SocioFamiliar extends Socio{
    private ArrayList<Hijo> listahijos = new ArrayList();

    public SocioFamiliar(String nombre, String apellidos, String telefono, String correo) {
        super(nombre, apellidos, telefono, correo);
    }

    public ArrayList<Hijo> getListahijos() {
        return listahijos;
    }

    public void setListahijos(ArrayList<Hijo> listahijos) {
        this.listahijos = listahijos;
    }
    
    public void setHijo(Hijo h)
    {
        listahijos.add(h);
    }
}
