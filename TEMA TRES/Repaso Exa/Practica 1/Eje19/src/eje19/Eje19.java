/*19. Escribe un programa que calcule el cuadrado de un numero haciendo
solo sumas. (El cuadrado de un numero n es la suma de los n primeros
numeros impares).*/

package eje19;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje19 
{
    public static void main(String[] args) 
    {
        try
        {
            int numero=entrada();
            comprobar(numero);
        }
        catch(Exception e)
        {
            showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
        }
    } 
    
    public static int dato() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el numero:"));
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
                
                if(numero<1)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"NUMERO INCORRECTO (A PARTIR DE 1)");
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
    
    public static void comprobar(int numero) throws Exception
    {
        String linea= " ";
        int numeroImpar=1,resultado=0;
        
        for (int x=0;x<numero;x++)
        {
           resultado+=numeroImpar;
           linea += numeroImpar + " ";
           numeroImpar+=2;
        }
        
        showMessageDialog(null,"El numero introducido: " + numero + "\n" + 
                "Numeros Impares: "  + linea + "\n" 
                + "Resultado: " + resultado);
    }
}
