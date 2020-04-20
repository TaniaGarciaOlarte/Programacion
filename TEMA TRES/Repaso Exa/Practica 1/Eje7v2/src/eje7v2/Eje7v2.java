
package eje7v2;

import java.text.NumberFormat;
import java.util.Locale;
import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje7v2 {

    public static void main(String[] args) 
    {
        try
        {
            int cat1=comprentrada("cateto1:");
            int cat2=comprentrada("cateto2:");
            
            operacion(cat1,cat2);
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS:" + e.getClass() + " " + e.getMessage());
        }
    } 
    
    public static int entrada(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable));
    }
    
    public static int comprentrada(String variable) throws Exception
    {
        boolean error;
        int vari=0;
        
        do
        {
            try
            {
                vari=entrada(variable);
                
                if (vari < 1)
                    throw new DatoIncorrecto();
                
                error=true;
            }
            catch (DatoIncorrecto di)
            {
                showMessageDialog(null,"DATO INCORRECTO");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
        return vari;
    }
    
    public static void operacion (int cat1,int cat2) throws Exception
    {
        NumberFormat nf=NumberFormat.getNumberInstance(Locale.ROOT);
        
        double result=0;
        
        result=Math.sqrt(Math.pow(cat1,2) + Math.pow(cat2,2));
        
        showMessageDialog(null,"El resultado es: " + nf.format(result));
    }
}
