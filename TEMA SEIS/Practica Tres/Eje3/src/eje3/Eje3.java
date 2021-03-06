package eje3;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje3 {

    public static void main(String[] args) 
    {
        try
        {
            String num = validarnum();
            showMessageDialog(null,"El numero introducido es: " + num);
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
                ent = showInputDialog("Introduce un numero entero negativo:");
                Pattern pat = Pattern.compile("^-[0-9]+$");
                Matcher mat = pat.matcher(ent);
                
                if (!mat.matches())
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"SOLO NUMEROS ENTEROS NEGATIVOS");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
}
