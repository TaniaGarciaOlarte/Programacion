
package ejercicio5;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Ejercicio5 
{
    final private static int POSTERIOR = 100;
    
    public static void main(String[] args) throws ParseException 
    {
       try{
                
           int dia=Integer.parseInt(texto("dia"));
           int mes=Integer.parseInt(texto("mes"));
           int año=Integer.parseInt(texto("año"));
           
           LocalDate fecha = LocalDate.of(año,mes,dia);
           
           LocalDate fechafin=fecha.plusDays(POSTERIOR);
           
           showMessageDialog(null,fechafin.getDayOfWeek()+ ", " + fechafin.getDayOfMonth() + " de " + fechafin.getMonth() + " de " + fechafin.getYear());
                 
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
        return showInputDialog("Introduce el " + variable + ": ");
    }
}
