/*6. Crear un programa que reciba una fecha y que devuelva el nombre
de la estacion en la que esta ubicado dicha fecha.*/

package eje6;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static javax.swing.JOptionPane.*;

public class Eje6 
{
    public static void main(String[] args) 
    {
        try
        {
            LocalDate fecha=comprobarfecha();
            estacion(fecha);
        }
        catch(Exception e)
        {
            showMessageDialog(null,"PROBLEMAS:" + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static String entrada() throws Exception
    {
        return showInputDialog("Intoduce una fecha:");
    }
    
    public static LocalDate comprobarfecha() throws Exception
    {
        boolean error;
        String f;
        LocalDate fecha = null;
        
        do
        {
            try
            {
                DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
                f=entrada();
                
                fecha=LocalDate.parse(f,df);
                
                error=true;
            }
            catch (DateTimeException dte)
            {
                showMessageDialog(null,"Introduce una fecha con el formato dd/MM/yyyy");
                error=false;
            }
        }
        while(!error);
        
        return fecha;
    }
    
    public static void estacion(LocalDate fecha) throws Exception
    {
        int fe=fecha.getYear();
        int dia=21;
        
        final LocalDate PRIMAVERA=LocalDate.of(fe,03,dia);
        final LocalDate VERANO=LocalDate.of(fe,06,dia);
        final LocalDate OTOÑO=LocalDate.of(fe,9,dia);
        
        if (fecha.isBefore(PRIMAVERA))
            showMessageDialog(null,"INVIERNO");
        else
            if (fecha.isBefore(VERANO))
                showMessageDialog(null,"PRIMAVERA");
            else
                if (fecha.isBefore(OTOÑO))
                    showMessageDialog(null,"VERANO");
                else
                    showMessageDialog(null,"OTOÑO");
    }
}
