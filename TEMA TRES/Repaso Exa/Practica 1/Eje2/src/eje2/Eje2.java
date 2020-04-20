/*2. Escribe un programa que muestre el resultado de multiplicar dos
numeros introducidos por teclado.*/

package eje2;

import java.text.NumberFormat;
import java.util.Locale;
import static javax.swing.JOptionPane.*;

public class Eje2 
{
    public static void main(String[] args) 
    {
       try
       {
            String resultado=comprobardatos();
            showMessageDialog(null,"El resultado de la multiplicacion es: " + resultado);
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
        return Double.parseDouble(showInputDialog("Introduce el " + variable + " numero:"));
    }
    
    public static String comprobardatos() throws Exception
    {
        boolean error;
        double resultado=0;
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ROOT);
        
            do{
                try
                {
                    double num1=datos("primer");
                    double num2=datos("segundo");

                    resultado=num1*num2;

                    error=true;
                }
                catch (NumberFormatException nfe)
                {
                    showMessageDialog(null,"DEBES INTRODUCIR NUMEROS");
                    error=false;
                }
            }
            while (!error);      
    return nf.format(resultado);
    }
}
