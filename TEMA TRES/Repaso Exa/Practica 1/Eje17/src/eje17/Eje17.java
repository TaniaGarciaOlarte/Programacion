/*17. Disena un programa que obtenga la calificacion mayor y la calificacion
menor, de un grupo de 40 estudiantes, ademas de los nombres de dichos alumnos.*/

package eje17;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje17 
{
    static double minimo=11,maximo=-1;
    static String nombremin,nombremax;
    
    public static void main(String[] args) 
    {
        try
        {
           for (int x=1;x<=40;x++)
           {
                double nota=entnota();
                String nombre=entnombre();
                comprobar(nota,nombre);
           }
           showMessageDialog(null,"La nota minima es la de: " + nombremin + " con la nota: " + minimo 
        + "\n" + "La nota maxima es la de: " + nombremax + " con la nota: " + maximo);
        }
            catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getClass() + " " + e.getMessage());
        }
    } 
    
    public static double daton() throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce la nota:"));
    }
    
    public static String datonombre() throws Exception
    {
        return showInputDialog("Introduce el nombre:");
    }
    
    public static double entnota() throws Exception
    {
        boolean error;
        double nota=0;
        
        do
        {
            try
            {
                nota=daton();
                
                if (nota<0 || nota >10)
                    throw new NotaIncorrecta();
                
                error=true;
            }
            catch (NotaIncorrecta ni)
            {
                showMessageDialog(null,"NOTA INCORRECTA (DEL O AL 10)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
        return nota;
    }
    
    public static String entnombre() throws Exception
    {
        boolean error;
        String nombre=null;
        
        do
        {
            try
            {
                nombre=datonombre();
                
                if (nombre.isEmpty())
                    throw new NombreVacio();
                
                for (int x=0;x<nombre.length();x++)
                {
                    if (Character.isDigit(nombre.charAt(x)))
                        throw new NombreIncorrecto();
                }
                
                error=true;
            }
            catch (NombreIncorrecto ni)
            {
                showMessageDialog(null,"NOMBRE INCORRECTO:SOLO CARACTERES");
                error=false;
            }
            catch (NombreVacio nv)
            {
                showMessageDialog(null,"NOMBRE VACIO:DEBE TENER CONTENIDO");
                error=false;
            }
        }
        while(!error);
        
        return nombre;
    }
    
    public static void comprobar(double nota,String nombre) throws Exception
    {    
        if (nota<minimo)
        {
            nombremin=nombre;
            minimo=nota;
        }
        if (nota>maximo)
        {
            nombremax=nombre;
            maximo=nota;
        }
    }
}
