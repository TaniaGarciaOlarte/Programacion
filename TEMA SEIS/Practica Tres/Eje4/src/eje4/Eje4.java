package eje4;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje4 {
    
    public static void main(String[] args) 
    {
        try
        {
            String dni = validardni();
            showMessageDialog(null,"El dni introducido es: " + dni);
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
    
    public static String validardni() throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce el dni:");
                Pattern pat = Pattern.compile("^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$");
                Matcher mat = pat.matcher(ent);
                
                if (!mat.matches())
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"EL DNI INTRODUCIDO ES INCORRECTO");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
}
