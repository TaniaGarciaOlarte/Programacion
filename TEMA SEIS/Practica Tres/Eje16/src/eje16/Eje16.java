
package eje16;

import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje16 {

     public static void main(String[] args) 
    {
        try
        {
            String fecha = validarfecha();
            showMessageDialog(null,"La fecha introducida es: " + fecha);
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
    
    public static String validarfecha() throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce un fecha:");
                
                
                if (!comprobarfecha(ent))
                    throw new EntErr();
                
                error=true;
            }
            catch (EntErr ee)
            {
                showMessageDialog(null,"SOLO FECHAS");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static boolean comprobarfecha (String ent)
    {
        //Fechas de 31 dias
            String expresion = "^([1-9]|[0-2][0-9]|3[0-1])[/]([0]?[13578]|10|12)[/][12][0-9]{3}$";
            Pattern p = Pattern.compile(expresion);
            Matcher m = p.matcher(ent);
            
        if (!m.matches())
        {
            //Fechas de 30 dias
                expresion = "^([1-9]|[0-2][0-9]|30)[/]([0]?[469]|11)[/][12][0-9]{3}$";
                p = Pattern.compile(expresion);
                m = p.matcher(ent);
            
            if (!m.matches())
            {
                //Fechas de 29 dias
                    expresion = "^([1-9]|[0-2][0-9])[/][0]?2[/][12][0-9]{3}$";
                    p = Pattern.compile(expresion);
                    m = p.matcher(ent);
                    return m.matches();
            }
            else
                return true;
        }
        else
            return true;
    }
}
