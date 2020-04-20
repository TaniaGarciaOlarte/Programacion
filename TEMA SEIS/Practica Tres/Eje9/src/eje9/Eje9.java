package eje9;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje9 {

   public static void main(String[] args) 
    {
        try
        {
            String num = validarnum();
            showMessageDialog(null,"El numero hexadecimal introducido es: " + num);
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
    
    public static String validarnum() throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce el numero hexadecimal:");
                Pattern pat = Pattern.compile("^[0-9A-F]+$");
                Matcher mat = pat.matcher(ent);
                
                if (!mat.matches())
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"EL NUMERO HEXADECIMAL ES INCORRECTO");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    } 
    
}
