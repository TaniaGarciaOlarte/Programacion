/*3. Dada una cadena de caracteres y un caracter, verificar cuantas veces 
se repite el caracter en la cadena, por ejemplo: 
    Entrada: casa blanca ’a’
    Salida: El caracter ’a’ se repite 4 veces*/

package eje3;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje3 
{
    public static void main(String[] args) 
    {
       try
       {
           String cade=comprobarent();
           char letra=comprobarletra();
           
           comprobar(cade,letra);
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
    
    public static String entradas(String variable) throws Exception
    {
        return showInputDialog("Introduce " + variable).toUpperCase();
    }
    
    public static String comprobarent() throws Exception
    {
        boolean error;
        String ent=null;
        
        do
        {
            try
            {
                ent=entradas("el texto de entrada:");
                
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
                showMessageDialog(null,"CAMPO VACIO:DEBES INTRODUCIR CONTENIDO");
                error=false;
            }
            catch (CampoIncorrecto ci)
            {
                showMessageDialog(null,"CAMPO INCORRECTO:DEBES INTRODUCIR LETRAS");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static char comprobarletra() throws Exception
    {
        boolean error;
        char l=0;
        
        do
        {
            try
            {
                String letra=entradas("la letra a buscar:");
                
                if (letra.length()!=1)
                    throw new LongitudIncorrecta();
                
                if (Character.isDigit(letra.charAt(0)))
                    throw new LetraIncorrecta();
                
                l=letra.charAt(0);
                
                error=true;
                
            }
            catch (LongitudIncorrecta li)
            {
                showMessageDialog(null,"LONGITUD INCORRECTA: SOLO SE PUEDE INTRODUCIR UN CARACTER");
                error=false;
            }
            catch (LetraIncorrecta li)
            {
                showMessageDialog(null,"ERROR: DEBES INTRODUCIR UNA LETRA");
                error=false;
            }
        }
        while(!error);
        
        return l;
    }
    
    public static void comprobar(String cade,char letra) throws Exception
    {
        int contador=0;
        for (int x=0;x<cade.length();x++)
        {
            if (cade.charAt(x)==letra)
                contador++;
        }
        showMessageDialog(null,"El caracter " + letra + " se repite " + contador + " veces");
    }
}
