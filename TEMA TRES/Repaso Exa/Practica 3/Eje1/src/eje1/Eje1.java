/*1. Dada una cadena de caracteres mostrar por pantalla la cantidad de
vocales que tiene. 
Ejemplo:
    Entrada: Hola tu
    Salida: La cantidad de vocales es 3*/

package eje1;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje1 
{
    public static void main(String[] args) 
    {
        try
        {
            String cade=comprobarcade();
            comprobar(cade);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static String entrada() throws Exception
    {
        return showInputDialog("Introduce la entrada de texto:").toLowerCase();
    }
    
    public static String comprobarcade() throws Exception
    {
        boolean error;
        String ent=null;
        do
        {
            try
            {
                ent=entrada();
                
                for (int x=0;x<ent.length();x++)
                {
                    if (Character.isDigit(ent.charAt(x)))
                        throw new EntradaInvalida();
                }
                
                if (ent.isEmpty())
                    throw new EntradaVacia();
                
                error=true;
            }
            catch (EntradaVacia ev)
            {
                showMessageDialog(null,"CAMPO VACIO: DEBES INTRODUCIR TEXTO");
                error=false;
            }
            catch (EntradaInvalida ei)
            {
                showMessageDialog(null,"SOLO CARACTERES");
                error=false;
            }
        }
        while (!error);
        
        return ent;
    }
    
    public static void comprobar(String cade) throws Exception
    {
        int contador=0;
        
        for (int x=0;x<cade.length();x++)
        {
            if (cade.charAt(x)=='a' || cade.charAt(x)=='e' || cade.charAt(x)=='i' || cade.charAt(x)=='o' || cade.charAt(x)=='u')
                contador++;
        }
        
        showMessageDialog(null,"La cantidad de vocales es " + contador);
    }
}
