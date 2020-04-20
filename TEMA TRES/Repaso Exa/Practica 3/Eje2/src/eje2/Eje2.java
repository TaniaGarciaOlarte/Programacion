/*2. Dada una cadena de caracteres invertir la misma y mostrar por pantalla. 
Ejemplo:
    Entrada: casa blanca
    Salida: acnalb asac*/

package eje2;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje2 
{
    public static void main(String[] args) 
    {
       try
       {
           String cade=comprobarent();
           comprobar(cade);
       }
       catch (NullPointerException npe)
       {
           showMessageDialog(null,"CANCELADO");
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
       }
    }  
    
    public static String entrada() throws Exception
    {
        return showInputDialog("Introduce la entrada del texto:");
    }
    
    public static String comprobarent() throws Exception
    {
        boolean error;
        String ent=null;
        do
        {
            try
            {
                ent=entrada();
                
                if (ent.isEmpty())
                    throw new CampoVacio();
                
                for (int x=0;x<ent.length();x++)
                {
                    if (Character.isDigit(ent.charAt(x)))
                        throw new CampoIncorrecto();
                }
                
                error=true;
            }
            catch (CampoVacio cv)
            {
                showMessageDialog(null,"CAMPO VACIO DEBES INTRODUCIR UN TEXTO");
                error=false;
            }
            catch (CampoIncorrecto ci)
            {
                showMessageDialog(null,"CAMPO INCORRECTO SOLO LETRAS");
                error=false;
            }
        }
        while (!error);
        
        return ent;
    }
    
    public static void comprobar (String cade) throws Exception
    {
        String linea="";
        
        for (int x=cade.length()-1;x>=0;x--)
        {
            linea+=cade.charAt(x);
        }
        
        /*StringBuilder cadenaInvertida = new StringBuilder(cade);
            showMessageDialog(null, " La cadena invertida es " + cadenaInvertida.reverse());
        */
        
        showMessageDialog(null,linea);
    }
}
