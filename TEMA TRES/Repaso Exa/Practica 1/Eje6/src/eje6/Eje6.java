/*6. Visualiza el area de la circunferencia que corresponde al radio intro- ´
ducido por teclado. (A = PI * R * R)*/

package eje6;

import static java.lang.Math.PI;
import java.text.NumberFormat;
import java.util.Locale;
import static javax.swing.JOptionPane.*;

public class Eje6 
{
    public static void main(String[] args) 
    {
        NumberFormat nf=NumberFormat.getNumberInstance(Locale.ROOT);
        try
        {
            double radio=radiod();
            double resultado=operacion(radio);
            showMessageDialog(null,"El resultado del area es: " + nf.format(resultado));
        }
        catch (Exception e)
        {
           showMessageDialog(null,"PROBLEMAS" + e.getClass() + "" + e.getMessage());
        }
    }
    
    public static double datos() throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce el valor de radio:"));
    }
    
    public static double radiod() throws Exception
    {
        boolean error;
        double rad = 0;
        do{
            try
            {
                rad=datos();
                error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
      return rad;
    }
    
    public static double operacion (double radio) throws Exception
    {
        double resultado=PI*radio*radio;
        
        return resultado;
    }
}
