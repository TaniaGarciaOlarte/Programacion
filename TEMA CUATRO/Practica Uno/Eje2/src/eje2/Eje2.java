
package eje2;

import static javax.swing.JOptionPane.*;

public class Eje2 
{
    public static void main(String[] args) 
    {
        try
        {
           int numero=entradadato();
           int array[]=new int[numero];
           
           introducir_datos(array);
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getMessage());
        }
    }
    
    public static int entradadato() throws Exception
    {
        int num=0;
        boolean error;
            do
            {
                try
                {
                    num=Integer.parseInt(showInputDialog("Introduce el tamaño de la array:"));
                    error=true;
                }
                catch (NumberFormatException nfe)
                {
                    showMessageDialog(null,"SOLO NUMERO");
                    error=false;
                }
            }
            while (!error);
        return num;
    }
    
    public static void introducir_datos(int[] array) throws Exception
    {
        String linea = "";
        int suma = 0;
        
        for (int i=0;i<array.length;i++)
        {
            int numeroal=(int) (Math.random()*9);
            array[i]=numeroal;
            linea+= "\n" + "Posicion" + i + ": " + array[i] ;
            suma+=array[i];
        }
        
        showMessageDialog(null,"El valor de cada posicion es: " + linea + "\n" +
                "La suma de todos los valores es: " + suma);
    }
}
