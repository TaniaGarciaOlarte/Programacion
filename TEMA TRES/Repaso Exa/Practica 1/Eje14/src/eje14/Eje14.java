/*14. Escribe un programa que calcule la suma de 10 numeros. El programa 
ira pidiendo numeros al usuario y, cuando tenga 10, mostrara el 
resultado y terminara.*/

package eje14;

import static javax.swing.JOptionPane.*;

public class Eje14 
{
    public static void main(String[] args) 
    {
        int resultado=0;
        try
        {
            resultado=entrada();
            showMessageDialog(null,"El resultado de la suma de los 10 valores es: " + resultado);
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getClass() + " " + e.getMessage());
        }
    }  
    
    public static int dato(int variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de numero " + variable + " :"));
    } 
    
    public static int entrada() throws Exception
    {
        boolean error;
        int result=0,num=0;
        
        for(int x=1;x<=10;x++)
        {
            do
            {
                try
                {
                    num=dato(x);
                    result+=num;
                    
                    error=true;
                }
                catch (NumberFormatException nfe)
                {
                    showMessageDialog(null,"SOLO NUMEROS");
                    error=false;
                }
            }
            while(!error);
        }
    return result;
    }
}
