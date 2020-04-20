/*16. Calcula el promedio de edades de un grupo de estudiantes de los
cuales no se conoce la cantidad.*/

package eje16;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Eje16 
{
    public static void main(String[] args) 
    {
        int edad=0,contador=0;
        double resultado,sumaEdad=0;
        NumberFormat nf=NumberFormat.getNumberInstance(Locale.ROOT);
        
       try
       {
            do
            {
                edad=entrada();
                sumaEdad+=edad;
                contador++;
            }
            while(showConfirmDialog(null,"¿DESEAS CONTINUAR?")==0);
            
            resultado=comprobar(sumaEdad,contador);
            //resultado=sumaEdad/contador;
            
            showMessageDialog(null,"El promedio de las edades de los alumnos es: " + nf.format(resultado));
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
       }
    }
    
    public static int dato() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce la edad del alumno:"));
    }
    
    public static int entrada() throws Exception
    {
        boolean error;
        int edad=0;
        
        do
        {
            try
            {
                edad=dato();
                
                if (edad < 1)
                    throw new EdadIncorrecta();
                
                error=true;
            }
            catch (EdadIncorrecta ei)
            {
                showMessageDialog(null,"EDAD INCORRECTA (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return edad;
    }
    
    public static double comprobar(double sumaEdad,int contador) throws Exception
    {
        return sumaEdad/contador;
    }
}
