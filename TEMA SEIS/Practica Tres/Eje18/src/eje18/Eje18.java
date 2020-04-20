
package eje18;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje18 {

    public static void main(String[] args) {
        try
        {
            String email = validaremail();
            showMessageDialog(null,"El email introducido es: " + email);
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
    
    public static String validaremail() throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce un email:");
                
                
                if (!comprobaremail(ent))
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"SOLO EMAIL");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static boolean comprobaremail(String ent)
    {
        Pattern pt = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z]+(.[a-z]+)*(.[com|es|org])$");
        Matcher m = pt.matcher(ent);
        return m.matches();
    }
}
    
