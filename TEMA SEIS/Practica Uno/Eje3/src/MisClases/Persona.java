
package MisClases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona 
{
    private String nombre;
    private int dnacimiento;
    private int mnacimiento;
    private int anacimiento;
    private String direccion;
    private String codpostal;
    private String ciudad;

    public Persona(String nombre, int dnacimiento, int mnacimiento, int anacimiento, String direccion, String codpostal, String ciudad) {
        this.nombre = nombre;
        this.dnacimiento = dnacimiento;
        this.mnacimiento = mnacimiento;
        this.anacimiento = anacimiento;
        this.direccion = direccion;
        this.codpostal = codpostal;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDnacimiento() {
        return dnacimiento;
    }

    public void setDnacimiento(int dnacimiento) {
        this.dnacimiento = dnacimiento;
    }

    public int getMnacimiento() {
        return mnacimiento;
    }

    public void setMnacimiento(int mnacimiento) {
        this.mnacimiento = mnacimiento;
    }

    public int getAnacimiento() {
        return anacimiento;
    }

    public void setAnacimiento(int anacimiento) {
        this.anacimiento = anacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public int calcularedad()
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = condicionfecha();
        
        LocalDate fechaNac = LocalDate.parse(fecha, formato);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        return periodo.getYears();
    }
    
    public String condicionfecha()
    {
        String fecha;
        
        if (dnacimiento < 10)
            fecha="0" + dnacimiento + "/";
        else
            fecha = dnacimiento + "/";
        if (mnacimiento < 10)
            fecha+="0" + mnacimiento + "/";
        else
            fecha+= mnacimiento + "/";
        fecha+=anacimiento;
        
        return fecha;
    }
    
    public boolean esMayor()
    {
        return calcularedad()>=18;
    }
}
