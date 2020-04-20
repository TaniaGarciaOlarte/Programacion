
package eje1;

import static javax.swing.JOptionPane.*;
import MisClases.*;
import Excepciones.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Eje1 
{
    private final static NumberFormat nf = NumberFormat.getNumberInstance(Locale.ROOT);
    
    public static void main(String[] args) 
    {
        try
        {
            double radio = entrada();
            
            Formulas r = new Formulas(radio);
   
            showMessageDialog(null,"RESULTADO DE LA PRIMERA FORMULA: " + nf.format(r.circunferencia()) + "\n"
                    + "RESULTADO DE LA SEGUNDA FORMULA: " + nf.format(r.area()) + "\n"
                            + "RESULTADO DE LA TERCERA FORMULA: " + nf.format(r.esfera()));
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS:" + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static double entrada() throws Exception
    {
        boolean error;
        double dato = 0;
        
        do
        {
            try
            {
                dato = Double.parseDouble(showInputDialog("Introduce el valor de radio:"));
                
                if (dato < 0.1)
                    throw new DatoIncorrecto();
                
                error=true;
            }
            catch (DatoIncorrecto di)
            {
                showMessageDialog(null,"ERROR: DATO INCORRECTO (MINIMO 0.1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);

        return dato;
    }
}
