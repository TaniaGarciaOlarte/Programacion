
package eje19;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje19 {

    public static void main(String[] args) {
        try
        {
            String usuario = validarusuario();
            showMessageDialog(null,"El usuario de twitter introducido es: " + usuario);
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
    
    public static String validarusuario() throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce un usuario de twitter:");
                
                
                if (!comprobaremail(ent))
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"SOLO USUARIO DE TWITTER");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static boolean comprobaremail(String ent)
    {
        Pattern pt = Pattern.compile("^@[_A-Za-z0-9-]+$");
        Matcher m = pt.matcher(ent);
        return m.matches();
    }
    
}
