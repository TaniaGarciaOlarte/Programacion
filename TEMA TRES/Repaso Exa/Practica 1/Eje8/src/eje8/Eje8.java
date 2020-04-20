/*8. Convierte una calificacion numerica que recibes como dato de entrada 
(0 al 10) a un aprobado (mayor o igual que 5) o suspenso (menor que
5) y muestralo en pantalla.*/

package eje8;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje8 
{
    public static void main(String[] args) 
    {
        try
        {
            double nota=entradanota();
            String resultado=comprobacion(nota);
            
            showMessageDialog(null,"El alumno esta: " + resultado);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getClass() + "" + e.getMessage());
        }
    }
    
    public static double datos() throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce la nota:"));
    }
    
    public static double entradanota() throws Exception
    {
        boolean error;
        double nota = 0;
        do
        {
            try
            {
                nota=datos();
                
                if (nota<0|| nota>10)
                    throw new NotaIncorrecta();
                    
                 error=true;
            }
            catch (NotaIncorrecta ni)
            {
                showMessageDialog(null,"NOTA INCORRECTA (0 AL 10)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
       
        return nota;
    }
    
    public static String comprobacion (double nota) throws Exception
    {
        if (nota >=5)
        {
            return "APROBADO";
        }
        else
        {
            return "SUSPENDIDO";
        }
    }
}
