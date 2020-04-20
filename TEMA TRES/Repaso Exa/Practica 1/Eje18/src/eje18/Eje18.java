/*18. Disenar un programa que calcule el nesimo termino de la serie de 
Fibonacci. La sucesion comienza con los numeros 1 y 1, y a partir de 
estos, cada termino es la suma de los dos anteriores. (1, 1, 2, 3, 5,8,13,
21,34, 55, 89, 144, 233, 377,...)*/

package eje18;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje18 
{
    public static void main(String[] args) 
    {
        try
        {
            int numero=entrada();
            serie(numero);
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
        }
    }   
    
    public static int dato() throws Exception
    {
        return Integer.parseInt(showInputDialog("Intoduce el numero de veces:"));
    }
    
    public static int entrada() throws Exception
    {
        boolean error;
        int numero=0;
        do
        {
            try
            {
                numero=dato();
                
                if (numero < 2)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"NUMERO INCORRECTO (A PARTIR DE 2)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return numero;
    }
    
    public static void serie(int numero) throws Exception
    {
        int num1=1,num2=1,num3;
        String linea=num1 + " " + num2 + " ";
        
        for (int x=2;x<numero;x++)
        {
            num3=num1+num2;
            linea=linea + num3 + " ";
            num1=num2;
            num2=num3;
        }
        
        showMessageDialog(null,linea);
    }
}
