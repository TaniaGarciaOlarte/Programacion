/*4. Pide que te introduzcan por teclado los valores de las diagonales de
un rombo. Calcula y muestra su area ( ´ area ´ = D * d /2)*/

package eje4;

import java.text.NumberFormat;
import java.util.Locale;
import static javax.swing.JOptionPane.*;

public class Eje4 
{
    public static void main(String[] args) 
    {
        try{
            String resultado=comprobardatos();
            showMessageDialog(null,"El resultado de la area es: " + resultado);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getMessage());
        }
    }
    
    public static double datos(String variable) throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce el valor de la "  + variable + " diagonal:"));
    }
    
    public static String comprobardatos() throws Exception
    {
        final int CONSTANTE=2;
        boolean error;
        double resultado = 0;
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ROOT);
        
        do
        {
            try
            {
               double d1=datos("primera");
               double d2=datos("segunda");
               
               resultado=d1*d2/CONSTANTE;
               error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
      return nf.format(resultado);
    }
}
