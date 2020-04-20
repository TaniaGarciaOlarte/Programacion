/*13. Disena un programa que reciba a traves del teclado el peso, edad,
nombre, sexo y estatura de un grupo de 30 alumnos y, posteriormente,
muestre el numero de ninos y de ninas que son aptos para jugar al
baloncesto.

Los requisitos para poder jugar al baloncesto son los siguientes:

    -Los ninos deben tener una estatura mayor de 1.70 metros y pesar mas de 
70 kilos
    -Y las ninas deben medir mas de 1.60 metros y pesar mas de 60 kilos*/

package eje13;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje13 
{
    public static void main(String[] args) 
    {
        try
        {
            datos();
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
    
    public static double datoDouble(String variable) throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce el valor de " + variable + ":"));
    }
    
    public static int datoInt(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable + ":"));
    }
    
    public static String datoString(String variable) throws Exception
    {
        return showInputDialog("Introduce el valor de " + variable + ":");
    }
    
    public static void datos() throws Exception
    {
        int contadorchicas=0,contadorchicos=0;
        
               for(int x=0;x<30;x++)
               {
                    int peso=comprop();
                    int edad=comproe();
                    String nombre=comprobarn();
                    String sexo=comprobars();
                    double estatura=comproest();

                    if (sexo.equalsIgnoreCase("Femenino"))
                    {
                         contadorchicas+=contca(peso,estatura);
                    }
                    else
                    {
                         contadorchicos+=contco(peso,estatura);
                    }
               }
               
               showMessageDialog(null,"El numero de chicas aptas es: " + contadorchicas + "\n"
               + "El numero de chicos aptos es: " + contadorchicos);          
        }
    
     public static int comprop() throws Exception
     {
        boolean error;
        int peso=0;
        
        do
        {
            try
            {
                peso=datoInt("peso");
                
                if (peso < 1)
                    throw new PesoIncorrecto();
                
                error=true;
            }
            catch (PesoIncorrecto pi)
            {
                showMessageDialog(null,"PESO INCORRECTO (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return peso;
    }
    
    public static int comproe() throws Exception
    {
        boolean error;
        int edad=0;
        
        do
        {
            try
            {
                edad=datoInt("edad");
                
                if (edad <1)
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
    
    public static String comprobarn() throws Exception
    {
        boolean error;
        String nombre=null;
        
        do
        {
            try
            {
                nombre=datoString("nombre");
                
                for (int x=0;x<nombre.length();x++)
                {
                    if (Character.isDigit(nombre.charAt(x)))
                        throw new NombreIncorrecto();
                }
                    
                if (nombre.isEmpty())
                    throw new NombreVacio();
                
                error=true;
            }
            catch (NombreVacio nv)
            {
                showMessageDialog(null,"NOMBRE VACIO:DEBE INTRODUCIR CARACTERES");
                error=false;
            }
            catch (NombreIncorrecto ni)
            {
                showMessageDialog(null,"NOMBRE INCORRECTO:SOLO CARACTERES");
                error=false;
            }
        }
        while(!error);
        
        return nombre;
    }
    
    public static String comprobars() throws Exception
    {
        boolean error;
        String sexo=null;
        
        do
        {
            try
            {
                sexo=datoString("sexo");
                
                if (sexo.equalsIgnoreCase("Femenino")==false && sexo.equalsIgnoreCase("Masculino")==false)
                    throw new SexoIncorrecto();
                
                error=true;
            }
            catch(SexoIncorrecto sx)
            {
                showMessageDialog(null,"SEXO INCORRECTO (SOLO MASCULINO O FEMENINO)");
                error=false;
            }
        }
        while(!error);
        
        return sexo;
    }
    
    public static double comproest() throws Exception
    {
        boolean error;
        double estatura=0;
        
        do
        {
            try
            {
                estatura=datoDouble("estatura");
                
                if (estatura < 1)
                    throw new EstaturaIncorrecta();
                
                error=true;
            }
            catch (EstaturaIncorrecta ei)
            {
                showMessageDialog(null,"ESTATURA INCORRECTA (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return estatura;
    }
    
    public static int contca(int peso,double estatura) throws Exception
    {
        int contadorchicas=0;
        
        if (peso>60 && estatura >1.60)
            contadorchicas++;
        
        return contadorchicas;
    }
    
    public static int contco (int peso,double estatura) throws Exception
    {
        int contadorchicos=0;
        
        if (peso>70 && estatura >1.70)
            contadorchicos++;
        
        return contadorchicos;
    }    
}
