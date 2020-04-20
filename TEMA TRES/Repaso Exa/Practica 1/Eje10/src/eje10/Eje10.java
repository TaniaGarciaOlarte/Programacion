/*10. Introducir por teclado un numero comprendido entre el 1 y el 7 e
imprimir el dıa de la semana al que hace referencia. Por ejemplo, si
introducen el 1 se visualizara Lunes.*/

package eje10;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje10 
{
    public static void main(String[] args) 
    {
       try
       {
           int dia=entradadia();
           String resultado=comprobar(dia);
           showMessageDialog(null,"El dia de la semana " + dia + " es: " + resultado);
           
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS" + e.getClass() + "" + e.getMessage());
       }
    }
    
    public static int dato() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el dia:"));
    }
    
    public static int entradadia() throws Exception
    {
        boolean error;
        int dia=0;
        
        do
        {
            try
            {
                dia=dato();
                
                if (dia <1 || dia >7)
                    throw new DiaIncorrecto();
                
                error=true;
            }
            catch (DiaIncorrecto di)
            {
                showMessageDialog(null,"DIA INCORRECTO (1 AL 7)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
        return dia;
    }
    
    public static String comprobar(int dia) throws Exception
    {
        String respuesta = null;
        
        switch (dia)
        {
            case 1:
                respuesta="LUNES";
                break;
            case 2:
                respuesta="MARTES";
                break;
            case 3:
                respuesta="MIERCOLES";
                break;
            case 4:
                respuesta="JUEVES";
                break;
            case 5:
                respuesta="VIERNES";
                break;
            case 6:
                respuesta="SABADO";
                break;
            default:
                respuesta="DOMINGO";
        }
        
        return respuesta;
    }
}
