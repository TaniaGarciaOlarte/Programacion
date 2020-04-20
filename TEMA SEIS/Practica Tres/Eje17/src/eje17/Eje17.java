
package eje17;

import static javax.swing.JOptionPane.*;
import java.util.regex.*;

public class Eje17 {

    public static void main(String[] args) 
    {
        try
        {
            String nombre = validarnombre();
            showMessageDialog(null,"El nombre introducido es: " + nombre);
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
    
    public static String validarnombre() throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce un nombre:");
                
                
                if (!comprobarnombre(ent))
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"SOLO NOMBRES");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static boolean comprobarnombre(String ent)
    {
        Pattern pt = Pattern.compile("^([A-Za-z]+[ ]?){1,2}$");
        Matcher m = pt.matcher(ent);
        return m.matches();
    }
}
