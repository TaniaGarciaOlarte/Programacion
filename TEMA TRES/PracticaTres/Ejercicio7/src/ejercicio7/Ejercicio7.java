
package ejercicio7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import Excepciones.*;

public class Ejercicio7 
{
    public static void main(String[] args) 
    {
      try{
        boolean correcto = false;
        Calendar fechain = null,fechafin = null;
         do
         {
          try
          {
            fechain = Calendar.getInstance();
            fechafin = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            
            fechain.setTime(dateFormat.parse(texto("inicial")));
            fechafin.setTime(dateFormat.parse(texto("final")));
            
            if (fechafin.before(fechain))
            {
                throw new FechaIncorrecta();
            }
            
            correcto=true;
          }
          
          catch (FechaIncorrecta fi)
          {
              showMessageDialog(null,"La segunda fecha debe ser mayor a la primera");
          }
          catch (ParseException pe)
          {
              showMessageDialog(null,"Solo puedes introducir fechas");
          }
         }
         while (!correcto);
         
         int contadord=domingos (fechain,fechafin);
         showMessageDialog(null,"Entre las dos fechas hay: " + contadord + " domingos ");
         
        }  
      catch (NullPointerException npe)
      {
            showMessageDialog(null,"Cancelado");
      }
      catch (Exception e)
      {
          showMessageDialog(null,"Problemas");
      }
    }
    
    public static String texto(String variable)
    {
        return showInputDialog("Introduce la fecha " + variable + ":");
    }
    
    public static int domingos (Calendar fechain,Calendar fechafin)
    {
        int contador=0;
        do{
            if (fechain.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            {
                contador++;
            }
             fechain.add(Calendar.DAY_OF_MONTH,+1);
        }
        while (fechain.compareTo(fechafin)!=0);
     
        return contador;
    }
}
