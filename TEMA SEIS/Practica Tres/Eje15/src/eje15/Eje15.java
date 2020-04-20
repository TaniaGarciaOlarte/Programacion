
package eje15;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje15 {

    public static void main(String[] args) 
    {
        try
        {
            int numdeci = valid();
            String num = validarnum(numdeci);
            showMessageDialog(null,"El numero real negativo introducido es: " + num);
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
    
    public static int valid()
    {
        boolean error;
        int ent = 0;
        
        do
        {
            try
            {
                ent = Integer.parseInt(showInputDialog("Introduce el numero de decimales:"));
                
                if (ent < 1)
                    throw new DatoIncorrecto();
                
                error = true;
            }
            catch (DatoIncorrecto di)
            {
                showMessageDialog(null,"MINIMO 1");
                error = false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error = false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static String validarnum(int deci) throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce el numero real negativo con " + deci + " decimales:");
                Pattern pat = Pattern.compile("^-[0-9]+[.,][0-9]{" + deci + "}$");
                Matcher mat = pat.matcher(ent);
                
                if (!mat.matches())
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"EL NUMERO REAL NEGATIVO INTRODUCIDO ES INCORRECTO");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }  
    
}
