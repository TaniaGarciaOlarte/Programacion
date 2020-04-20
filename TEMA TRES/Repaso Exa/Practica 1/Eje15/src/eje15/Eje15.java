/*15. Disena un programa que permita introducir las notas de cierta cantidad de 
alumnos y que luego muestre la cantidad de aprobados 
(notas mayores o iguales a 6.00).*/

package eje15;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje15 
{
    public static void main(String[] args) 
    {
        int cantidad=0;
        try
        {
            do
            {
                double nota=entradadato();
                cantidad+=comprobar(nota);
            }
            while(showConfirmDialog(null,"¿DESEAS CONTINUAR?")==0);
            
            showMessageDialog(null,"La cantidad de aprobados es: " + cantidad);
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static double dato() throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce la nota:"));
    }
    
    public static double entradadato() throws Exception
    {
        boolean error;
        double entrada=0;
        
        do
        {
            try
            {
                entrada=dato();
                
                if (entrada<0 || entrada > 10)
                    throw new NotaIncorrecta();
                
                error=true;
            }
            catch (NotaIncorrecta ni)
            {
                showMessageDialog(null,"NOTA INCORRECTA (DEL O AL 10)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
            
        }
        while(!error);
        
        return entrada;
    }
    
    public static int comprobar(double nota) throws Exception
    {
        int contador=0;
        
        if (nota > 6)
            contador++;
        
        return contador;
    }
}
