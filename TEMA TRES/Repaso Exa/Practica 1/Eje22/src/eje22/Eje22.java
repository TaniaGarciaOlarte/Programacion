/*22. Escribe un programa en el que pidamos al usuario un numero y nos 
muestre los numeros primos entre 1 y ese numero (incluido).*/

package eje22;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje22 
{
    public static void main(String[] args) 
    {
      try
      {
          int num=entrada();
          int numero=num;
          String linea="";
          
          do
          {
              linea+=comprobarprimo(numero);
              numero-=1;   
          }
          while (numero >=2);
          
          //Numero Uno 
            linea+="El numero " + numero + " NO es primo";
         
            showMessageDialog(null,"EL NUMERO INTRODUCIDO ES EL " + num + "\n" 
                + "EL RESULTADO ES: \n" + linea);
      }
      catch (Exception e)
      {
          showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
      }
    }
    
    public static int dato() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce un numero:"));
    }
    
    public static int entrada() throws Exception
    {
        boolean error;
        int num=0;
        
        do
        {
            try
            {
                num=dato();
                
                if (num < 1)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"NUMERO INCORRECTO (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
        return num;
    }
    
    public static String comprobarprimo(int numero) throws Exception
    {
        int divisor=numero;
        int resto=1;
        
        while (resto!=0 && divisor > 2)
        {
            divisor-=1;
            resto=numero%divisor;
        }
        
        if (resto==0)
            return "El numero " + numero + " NO es primo \n";
        else
            return "El numero " + numero + " SI es primo \n";
    }
}
