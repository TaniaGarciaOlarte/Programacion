
package MisClases;

import static java.lang.Math.PI;

public class Formulas 
{
    private double radio;

    public Formulas(double radio) {
        this.radio = radio;
    }
    

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double circunferencia ()
    {
        double circu = (double) (2 * PI * radio);
        return circu;
    }
    
    public double area()
    {
        double are = (double) (PI*radio*radio);
        return are;
    }
    
    public double esfera()
    {
        double esf = (double) (4*PI*radio*radio*radio/3);
        return esf;
    }
}
