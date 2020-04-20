
package MisClases;

import java.util.ArrayList;

public class Cliente {
    private String dni;
    private String nombreapellidos;
    private String clave;
    
    private ArrayList<Cuenta> listaCuentas = new ArrayList();

    public Cliente(String dni, String nombreapellidos, String clave) {
        this.dni = dni;
        this.nombreapellidos = nombreapellidos;
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreapellidos() {
        return nombreapellidos;
    }

    public void setNombreapellidos(String nombreapellidos) {
        this.nombreapellidos = nombreapellidos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
    
    public int getNumeroCuentas()
    {
        return listaCuentas.size();
    }
    
    public Cuenta getCuenta(int x)
    {
        return listaCuentas.get(x);
    }
}
