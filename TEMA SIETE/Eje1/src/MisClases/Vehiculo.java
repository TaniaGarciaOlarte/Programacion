
package MisClases;

public class Vehiculo {  
    private String matricula;
    
    private Persona p;

    public Vehiculo(String matricula, Persona p) {
        this.matricula = matricula;
        this.p = p;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    } 
}
