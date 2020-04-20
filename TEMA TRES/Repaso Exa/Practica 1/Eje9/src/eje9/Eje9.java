/*9. Convertir una calificacion numerica que recibimos como dato de entrada (0 al 10) 
a muy deficiente, insuficiente, suficiente, bien, notableo sobresaliente.*/

package eje9;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje9 
{
    public static void main(String[] args) 
    {
        try
        {
            double nota=entradacalificacion();
            String resultado=comprobar(nota);
            showMessageDialog(null,"El alumno tiene una nota de " + resultado);
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
    public static double dato() throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce la nota:"));
    }
    
    public static double entradacalificacion() throws Exception
    {
        boolean error;
        double nota = 0;
        do
        {
            try
            {
                nota=dato();
                
                if (nota<0 || nota>10)
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
    
    public static String comprobar(double nota)throws Exception
    {
        if (nota<5)
            if (nota<4)
               return "MUY DEFICIENTE";
            else
               return "DEFICIENTE";
        else
            if (nota<7)
                if (nota<6)
                   return "SUFICIENTE";
                else
                   return "BIEN";
            else
              if (nota<9) 
                 return "NOTABLE";
              else
                  return "SOBRESALIENTE";
    }
}
