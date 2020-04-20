/*Realiza el diagrama de flujo que calcule la hipotenusa de un triangulo rectangulo teniendo como datos de entrada los dos catetos. 
(El Teorema de Pitagoras nos dice que para cualquier triangulo rectangulo, la suma de los cuadrados de los catetos es igual 
al cuadrado de la hipotenusa)

La formula es la raid cuadrada del cateto1 + la raiz cuadrada del 
cateto 2

    1ºForma --> Math.sqrt(cateto1^2+cateto2^2);
    2ºForma --> Math.sqrt(Math.pow(c1,2)+Math.pow(c2,2));*/

package eje7;

import java.text.NumberFormat;
import java.util.Locale;
import static javax.swing.JOptionPane.*;

public class Eje7 
{
    public static void main(String[] args) 
    {
        NumberFormat nf=NumberFormat.getNumberInstance(Locale.ROOT);
        try
        {
            int c1=entradauno();
            int c2=entradados();
            double resultado=operacion(c1,c2);
            showMessageDialog(null,"El resultado de la hipotenusa es: " + nf.format(resultado));
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getClass() + "" + e.getMessage());
        }
    }  
    
    public static int datos(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor del " + variable + " cateto:"));
    }
    
    public static int entradauno() throws Exception
    {
        boolean error;
        int c1 = 0;
        
        do{
            try
            {
                c1=datos("primer");
                error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
       
        return c1;
    }
    
     public static int entradados() throws Exception
    {
        boolean error;
        int c2 = 0;
        
        do{
            try
            {
                c2=datos("segundo");
                error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
       
        return c2;
    }
     
     public static double operacion(int c1,int c2) throws Exception
     {
        double resultado=Math.sqrt(Math.pow(c1,2)+ Math.pow(c2,2));
        return resultado;
     }
}

 