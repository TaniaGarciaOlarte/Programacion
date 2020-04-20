/*9. Convertir una calificacion numerica que recibimos como dato de entrada (0 al 10) 
a muy deficiente, insuficiente, suficiente, bien, notable o sobresaliente.*/

package eje9v2;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje9v2 
{
     public static void main(String[] args) 
    {
        try
        {
            int nota=entradacalificacion();
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
    public static int dato() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce la nota:"));
    }
    
    public static int entradacalificacion() throws Exception
    {
        boolean error;
        int nota = 0;
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
    
    public static String comprobar(int nota)throws Exception
    {
       String respuesta;
       switch (nota)
       {
           case 0:case 1:case 2:case 3:
               respuesta="MUY DEFICIENTE";
               break;
           case 4:
               respuesta="BIEN";
               break;
           case 5:
               respuesta="SUFICIENTE";
               break;
           case 6:
               respuesta="BIEN";
               break;
           case 7:case 8:
               respuesta="NOTABLE";
               break;
           default:
               respuesta="SOBRESALIENTE";
       }
       return respuesta;
    } 
}
