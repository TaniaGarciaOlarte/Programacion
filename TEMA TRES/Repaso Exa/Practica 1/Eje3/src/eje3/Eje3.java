/*3. Introduce por teclado los valores correspondientes a la base y la altura
de un rectangulo e imprime su per ´ ´ımetro (2 x base + 2 x altura).*/

package eje3;

import java.text.NumberFormat;
import java.util.Locale;
import static javax.swing.JOptionPane.*;

public class Eje3 
{
    public static void main(String[] args) 
    {
        try
        {
            String resultado=comprobardatos();
            showMessageDialog(null,"El perimetro es: " + resultado);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"Problemas" + e.getMessage());
        }
    }
    
    public static double datos(String variable) throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce el valor de la " + variable + ":"));
    }
    
    public static String comprobardatos() throws Exception
    {
        boolean error;
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ROOT);
        double resultado=0;
        final int CONSTANTE=2;
        
        do{
            try{
                double base=datos("base");
                double altura=datos("altura");
                
                resultado=CONSTANTE*base + CONSTANTE*altura;
                error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return nf.format(resultado);
    }
}
