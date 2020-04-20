
package eje1;

import java.util.Arrays;
import static javax.swing.JOptionPane.*;

public class Eje1 
{
    public static void main(String[] args) 
    {
        try{
            double[] array = new double [10];

            entrada(array);

        }
        catch (NumberFormatException nfe)
        {
            showMessageDialog(null,"SOLO NUMEROS");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS:" + e.getMessage());
        }
    }
    
    public static void entrada(double[] array) throws Exception
    {
        for (int i=0;i<array.length;i++)
         {
            array[i]=Double.parseDouble(showInputDialog("Introduce el valor de la posición " + i + " : "));
         }
        ordenm(array);
    }
    
    public static void ordenm(double[] array) throws Exception
    {
         Arrays.sort(array);
         showMessageDialog(null,"El minimo es: " + array[0] + " y el maximo es: " + array[array.length - 1]);
         
         /* VERSIÓN DEL FOR MEJORADO
         
            double cantidadMinima = 99;
            double cantidadMaxima = 0;
         
            for(double dato : arrayNumeros)
            {
                if (dato > cantidadMaxima)
                    cantidadMaxima = dato;
                if (dato < cantidadMinima)
                    cantidadMinima = dato;
            }
         */
    }
}
