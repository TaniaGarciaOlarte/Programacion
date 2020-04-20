
package MisClases;

import java.time.LocalDate;

public class Alumno {
    private String codigo;
    private String nombre;
    private String domicilio;
    private String telefono;
    private int edad;
    private char sexo;
    private LocalDate fechanac;
    private String direcper;
    private String direcent;
    private String pagweb;
    private String curso;
    private String estcivil;

    public Alumno() {
    }

    public Alumno(String codigo, String nombre, String domicilio, String telefono, int edad, char sexo, LocalDate fechanac, String direcper, String direcent, String pagweb, String curso, String estcivil) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.edad = edad;
        this.sexo = sexo;
        this.fechanac = fechanac;
        this.direcper = direcper;
        this.direcent = direcent;
        this.pagweb = pagweb;
        this.curso = curso;
        this.estcivil = estcivil;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public String getDirecper() {
        return direcper;
    }

    public void setDirecper(String direcper) {
        this.direcper = direcper;
    }

    public String getDirecent() {
        return direcent;
    }

    public void setDirecent(String direcent) {
        this.direcent = direcent;
    }

    public String getPagweb() {
        return pagweb;
    }

    public void setPagweb(String pagweb) {
        this.pagweb = pagweb;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEstcivil() {
        return estcivil;
    }

    public void setEstcivil(String estcivil) {
        this.estcivil = estcivil;
    }
    
    public String toString()
    {
        String datos = "   -Codigo: " + codigo 
                + "\n   -Nombre: " + nombre 
                + "\n   -Domicilio: " + domicilio 
                + "\n   -Telefono: " + telefono
                + "\n   -Edad: " + edad
                + "\n   -Sexo: " + sexo
                + "\n   -Fecha_Nacimiento: " + fechanac
                + "\n   -Direccion del Correo Personal: " + direcper
                + "\n   -Direccion del Correo del Centro: " + direcent
                + "\n   -Curso: " + curso
                + "\n   -Estado_Civil: " + estcivil;
        
        if (!pagweb.isEmpty())
            datos += "\n   -Pagina Web: " + pagweb;
                
        return datos;
    } 
}
