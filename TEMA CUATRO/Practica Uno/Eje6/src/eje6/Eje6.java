
package eje6;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.util.Arrays;

public class Eje6 
{
    public static void main(String[] args) 
    {
        try
        {
            //AVISO: La Ñ siempre al final si no produce problemas
             char[] arrayabc={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Ñ'};
             int arraycont[]=new int[27];
            
            String entrada=comprobarent();
            
            contarletras(entrada,arrayabc,arraycont);
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
    
    public static String comprobarent() throws Exception
    {
        boolean error;
        String ent=null;
        
        do
        {
            try
            {
                ent=showInputDialog(null,"Introduce el texto de entrada:").toUpperCase();
                
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
                showMessageDialog(null,"CAMPO INCORRECTO (SOLO LETRAS)");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static void contarletras(String entrada,char[] arrayabc,int[] arraycont) throws Exception
    {
        int y;
        String letra="";
        
        for (int x=0;x<entrada.length();x++)
        {
            y=Arrays.binarySearch(arrayabc,entrada.charAt(x));
            if (y !=-1)
                arraycont[y]+=1;
        }
        
        for (int z=0;z<arraycont.length;z++)
        {
            letra+= arrayabc[z] + " - " + arraycont[z] + "\n";
        }
        
        showMessageDialog(null,"Veces que se repite las letras en el siguiente texto : " + entrada + "\n"
                + letra);
    }
}
