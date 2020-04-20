/*7. Crear un programa que reciba dos fechas y que devuelva la cantidad
de domingos comprendidos entre ambas fechas.*/

package eje7;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static javax.swing.JOptionPane.*;
import Excepciones.*;
import static java.time.DayOfWeek.*;


public class Eje7 
{
    public static void main(String[] args) 
    {
        boolean error;
        LocalDate fechauno = null,fechados = null;
        try
        {
            do
            {  
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
                    showMessageDialog(null,"LA FECHA DOS NO PUEDE SER MENOR A LA FECHA UNO");
                    error=false;
                }
            }
            while(!error);
                
            domingos(fechauno,fechados);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch(Exception e)
        {
            showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
        }
    } 
    
    public static String entrada(String variable) throws Exception
    {
        return showInputDialog("Introduce la " + variable + ":");
    }
    
    public static LocalDate comprobarfecha(String variable) throws Exception
    {
        boolean error;
        LocalDate fecha = null;
        String f;
        
        do
        {
            try
            {
                DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                f=entrada(variable);
                
                fecha=LocalDate.parse(f,dt);
             
                error=true;
            }
            catch (DateTimeException dte)
            {
                showMessageDialog(null,"ERROR:DEBES INTRODUCIR EL DATO EN EL SIGUIENTE FORMATO (dd/MM/yyyy)");
                error=false;
            }
        }
        while(!error);
        
        return fecha;
    }
    
    public static void domingos(LocalDate fechauno,LocalDate fechados) throws Exception
    {
       int contador=0;
       LocalDate f1=fechauno;
       
       do
       {
           if (fechauno.getDayOfWeek()==SUNDAY)
               contador++;
           
           fechauno=fechauno.plusDays(1);
       }
       while (fechauno.isBefore(fechados));
        
       showMessageDialog(null,"Entre la fecha uno " + f1 + " y la fecha dos " + fechados + " hay " + contador + " domingos");
    }
}
