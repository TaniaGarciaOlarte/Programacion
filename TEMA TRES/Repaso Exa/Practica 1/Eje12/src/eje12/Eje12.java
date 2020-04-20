/*12. En una empresa de telefonıa se sigue la siguiente polıtica de facturacion:

    -Si el consumo mensual no sobrepasa los 300 minutos, se cobra 0.04
por minuto.
    -Si pasa de los 300 minutos pero no de los 500 se cobra 0.03 por cada
minuto.
    -Si pasa de los 500 minutos, se cobran los primeros 300 minutos a precio
normal (0.03) y los restantes a 0.02.
    -Si el consumo mensual, es superior a 800 minutos, se aplica la regla de
asignacion anterior y ademas que se le realiza un descuento de 1.25 % 
del total.

A partir de lo explicado disena un algoritmo que a partir de los minutos 
consumidos muestre el importe a pagar.*/

package eje12;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Eje12 
{
    public static void main(String[] args) 
    {
       NumberFormat nf=NumberFormat.getNumberInstance(Locale.ROOT);
       try
       {
           int consumo=entradadatos();
           double resultado=consulta(consumo);
           showMessageDialog(null,"El importe a pagar es: " + nf.format(resultado));
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS" + e.getClass() + " " + e.getMessage());
       }
    } 
    
    public static int datos() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el consumo del cliente:"));
    }
    
    public static int entradadatos() throws Exception
    {
        boolean error;
        int cons=0;
        
        do
        {
            try
            {
                cons=datos();
                
                if (cons<1)
                    throw new ConsuIncorrecto();
                
                error=true;
            }
            catch (ConsuIncorrecto ci)
            {
                showMessageDialog(null,"CONSUMO INCORRECTO (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
     return cons;
    }
    
    public static double consulta (int consumo) throws Exception
    {
        double result=0;
        double CON1=0.04;
        double CON2=0.03;
        double CON3=0.02;
        double DESCUENTO=1.25;
        
        if (consumo > 300)
        {
            if (consumo > 500)
            {
                result=300*CON2 + (consumo-300)*CON3;
                
                if (consumo > 800)
                    result-=(result*DESCUENTO)/100;
            }
            else
            {
                result=consumo*CON2;
            }
        }
        else
        {
            result=consumo*CON1;
        }
        
        return result;
    }
}
