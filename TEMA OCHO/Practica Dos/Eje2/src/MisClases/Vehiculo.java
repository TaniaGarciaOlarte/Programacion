
package MisClases;

import java.util.ArrayList;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    
    private ArrayList<Multa> multas = new ArrayList();
    private Propietario p;

    public Vehiculo(String matricula, String marca, String modelo, String color, Propietario p) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.p = p;
    }

    public Vehiculo() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }
    
    public void setMulta(Multa m)
    {
        multas.add(m);
    }

    public Propietario getP() {
        return p;
    }

    public void setP(Propietario p) {
        this.p = p;
    }
 
    @Override
    public String toString()
    {
        String val = "";
        String texto = "";
        String cod;
        String desc;
        
        for (int x=0;x<multas.size();x++)
        {
           cod = multas.get(x).getCod();
           desc = multas.get(x).getDescripcion();
           
           val += "     - " + cod + " " + desc + "\n";
        }
        
        texto += "    Matricula: " + matricula + "\n"
                + val;
        
        
        return texto;
    }
}
