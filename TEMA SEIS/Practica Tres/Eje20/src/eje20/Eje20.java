
package eje20;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje20 {

    public static void main(String[] args) {
        try
        {
            String isbn = validarisbn();
            showMessageDialog(null,"El ISBN introducido es: " + isbn);
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
    
    public static String validarisbn() throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce un ISBN:");
                
                
                if (!comprobarisbn(ent))
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"SOLO ISBN");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static boolean comprobarisbn(String ent)
    {
        Pattern pt = Pattern.compile("^(978|979)[0-9]{10}$");
        Matcher m = pt.matcher(ent);
        return m.matches();
    }
}
