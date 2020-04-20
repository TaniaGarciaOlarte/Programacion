package eje6;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje6 {

    public static void main(String[] args) 
    {
        try
        {
            String matri = validarmatricula();
            showMessageDialog(null,"La matricula introducida es: " + matri);
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
    
    public static String validarmatricula() throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce la Matricula:");
                Pattern pat = Pattern.compile("^[0-9]{4}[A-Z]{3}$");
                Matcher mat = pat.matcher(ent);
                
                if (!mat.matches())
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"LA MATRICULA INTRODUCIDA ES INCORRECTA");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
}
