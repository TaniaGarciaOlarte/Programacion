/*4. Desarrolla una programa en el que el usuario nos proporcione el
nombre de los alumnos de un curso y sus notas en seis asignaturas
distintas. 
    -El programa terminara cuando como nombre nos tecleen la palabra FIN
    -Nuestro programa debe visualizar el nombre de cada uno de los alumnos y su nota media
    -Al final, cuando nos tecleen fin, mostraremos la nota media del conjunto de alumnos*/

package eje4;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Eje4 
{
    public static void main(String[] args) 
    {
        int contador=0;
        double suma=0;
        NumberFormat nf=NumberFormat.getNumberInstance(Locale.ROOT);
        
        try
        {
           String nombre=comprobarnombre();
            
           while (!nombre.equalsIgnoreCase("Fin"))
             {
               double nota=0;
               nota=notaent();
               showMessageDialog(null,"NOMBRE: " + nombre + " NOTA MEDIA: " + nf.format(nota));
               contador++;
               suma+=nota;
               nombre=comprobarnombre();
             }

             double result=suma/contador;
             showMessageDialog(null,"El promedio de los alumnos es: " + nf.format(result));
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
    
    public static String entrada() throws Exception
    {
        return showInputDialog("Introduce el nombre del alumno:");
    }
    
    public static String comprobarnombre() throws Exception
    {
        boolean error;
        String nombre=null;
        
        do
        {
            try
            {
                nombre=entrada();
                
                if (nombre.isEmpty())
                    throw new CampoVacio();
                
                for (int x=0;x<nombre.length();x++)
                {
                    if (Character.isDigit(nombre.charAt(x)))
                        throw new NombreIncorrecto();
                }
                
                error=true;
            }
            catch (CampoVacio cv)
            {
                showMessageDialog(null,"CAMPO VACIO:DEBES INTRODUCIR CARACTERES");
                error=false;
            }
            catch (NombreIncorrecto ni)
            {
                showMessageDialog(null,"NOMBRE INCORRECTO: SOLO LETRAS");
                error=false;
            }
        }
        while (!error);
        
        return nombre;
    }
    
    public static double notaent() throws Exception
    {
        double suma=0;
        int x;
        int contador=0;
        
        for (x=1;x<=6;x++)
        {
            suma+=entrada(x);
            contador++;
        }
        
        double result=suma/contador;
        return result;
    }
    
    public static double entradain(int x) throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce la nota numero " + x + ":"));
    }
    
    public static double entrada(int x) throws Exception
    {
        boolean error;
        double num=0;
        
        do
        {
            try
            {
                num=entradain(x);
                
                if (num <0 || num >10)
                    throw new NotaIncorrecta();
                
                error=true;
            }
            catch (NotaIncorrecta ni)
            {
                showMessageDialog(null,"NOTA INCORRECTA (DEL 0 AL 10)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return num;
    }
}
