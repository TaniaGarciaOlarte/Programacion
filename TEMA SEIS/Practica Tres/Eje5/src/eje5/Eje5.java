package eje5;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje5 {

    public static void main(String[] args) 
    {
        try
        {
            String ip = validarip();
            showMessageDialog(null,"La IP introducida es: " + ip);
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
    
    public static String validarip() throws Exception
    {
        boolean error;
        String ent = null;
        String vari = "[0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]";
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce la IP:");
                Pattern pat = Pattern.compile("^((" + vari + ")[.]){3}(" + vari + ")$");
                Matcher mat = pat.matcher(ent);
                
                if (!mat.matches())
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"LA IP INTRODUCIDA ES INCORRECTA");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
}
