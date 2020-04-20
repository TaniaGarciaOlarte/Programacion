
package ejercicio6;

import java.time.LocalDate;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Ejercicio6 
{
    public static void main(String[] args) 
    {
       try{
                
           int dia=Integer.parseInt(texto("dia"));
           int mes=Integer.parseInt(texto("mes"));
           int año=Integer.parseInt(texto("año"));
           
           LocalDate fecha = LocalDate.of(año,mes,dia);
           
           estaciones(fecha);
                 
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
    
    public static void estaciones(LocalDate fecha) 
    {
        int m = fecha.getMonthValue();
        
        switch (m)
        {
            case 1:
            case 2:
            case 3:
                if (fecha.getDayOfMonth()>=21)
                {
                    showMessageDialog(null,"Primavera");
                }
                else
                {
                    showMessageDialog(null,"Invierno");
                }
                break;
            case 4:
            case 5:
            case 6:
                if (fecha.getDayOfMonth()>=21)
                {
                    showMessageDialog(null,"Verano");
                }
                else
                {
                    showMessageDialog(null,"Primavera");
                }
                break;
            case 7:
            case 8:
            case 9:
                if (fecha.getDayOfMonth()>=21)
                {
                    showMessageDialog(null,"Otoño");
                }
                else
                {
                    showMessageDialog(null,"Verano");
                }
                break;
            case 10:
            case 11:
            case 12:
                if (fecha.getDayOfMonth()>=21)
                {
                    showMessageDialog(null,"Invierno");
                }
                else
                {
                    showMessageDialog(null,"Otoño");
                }
                break;
        }  
    }

}
