/*4. Crear un programa que calcule la diferencia en dıas entre dos fechas
dadas por el usuario como cadenas con el formato dd/mm/yy.*/

package eje4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import static javax.swing.JOptionPane.*; 
import Excepciones.*;

public class Eje4 
{
    public static void main(String[] args) 
    {
       boolean error;
       LocalDate fechauno = null,fechados = null;
       try
       {   
           do{
             try
              {
                    fechauno=comprobarfecha("fecha uno");
                    fechados=comprobarfecha("fecha dos");
                    
                    if (fechados.isBefore(fechauno))
                        throw new FechaIncorrecta();
                    
                    error=true;
              }
             catch (FechaIncorrecta fi)
              {
                  showMessageDialog(null,"LA FECHA UNO DEBE SER ANTERIOR A LA FECHA DOS");
                  error=false;
              }
           }
           while(!error);
           
           diferencia(fechauno,fechados);
       }
       catch (NullPointerException npe)
       {
           showMessageDialog(null,"CANCELADO");
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS:" + e.getClass() + " " + e.getMessage());
       }
    } 
    
    public static String entrada(String variable) throws Exception
    {
        return showInputDialog(null,"Introduce la " + variable + " :");
    }
    
    public static LocalDate comprobarfecha(String variable) throws Exception
    {
        boolean error;
        LocalDate f = null;
        
        do
        {
            try
            {
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String d=entrada(variable);
                
                f=LocalDate.parse(d,formatter);
                
                error=true;
            }
            catch (DateTimeException dte)
            {
                showMessageDialog(null,"Introduce una fecha con el formato dd/MM/yy");
                error=false;
            }
        }
        while(!error);
        
        return f;
    }
    
    public static void diferencia (LocalDate fechauno,LocalDate fechados) throws Exception
    {
        Period periodo=Period.between(fechauno, fechados);
        
        showMessageDialog(null,"La diferencia es de " + periodo.getDays() + " dias " + periodo.getMonths() + " meses " + periodo.getYears() + " años " );
    }
}
