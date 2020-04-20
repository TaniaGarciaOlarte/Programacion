/*5. Visualiza los grados Fahrenheit que corresponden a los grados 
cent´ıgrados que recibas como dato de entrada*/

package eje5;

import static javax.swing.JOptionPane.*;

public class Eje5 
{
    public static void main(String[] args)
    {
       try
       {
            int dato=comprobardato();
            int resultado=obtenere(dato);
            showMessageDialog(null,"El resultado de los grados Fahrenheit es: " + resultado);
       }
       catch (NullPointerException npe)
       {
           showMessageDialog(null,"CANCELADO");
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS" + e.getMessage());
       }
    }
    
    public static int dato() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce los grados:"));
    }
    
    public static int comprobardato() throws Exception
    {
        boolean error;
        int num = 0;
        
         do{
            try{
                num=dato();
    
                error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO SE PUEDEN INTRODUCIR NUMEROS");
                error=false;
            }
         }
         while (!error);
         
       return num;
    }
    
    public static int obtenere(int dato) throws Exception
    {
        final double CONS1=1.8;
        final int CONS2=32;
       
        int resultado=(int) (CONS1*dato+CONS2);
        
        return resultado;
    }
}
