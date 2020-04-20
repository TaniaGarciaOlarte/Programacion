
package MisClases;

public class Empleado extends Persona{
    private double sueldoBruto;
    
    public Empleado(String nombre,int edad,double sueldo)
    {
        super(nombre,edad);
        this.sueldoBruto = sueldo;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
    
    @Override
    public String mostrar(){
       return "Nombre: " + this.getNombre() + "\n Edad: " + this.getEdad() + "\n Sueldo: " + this.getSueldoBruto();
    }
    
    public void calcularSalarioNeto(){}
}
