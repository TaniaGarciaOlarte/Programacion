/*21. Haz un programa que pida al usuario un numero y diga si ese numero 
es primo o no.*/

package eje21;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje21 
{
    public static void main(String[] args) 
    {
       try
       {
          int num=comprobarnum();
          comprobar1y2(num);
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
       }
    }
    
    public static int dato() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el numero:"));
    }
    
    public static int comprobarnum() throws Exception
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
                showMessageDialog(null,"NUMERO INCORRECTO (A PARTIR DEL 1)");
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
    
    public static void comprobar1y2(int num) throws Exception
    {
        switch (num)
        {
            case 1: 
                showMessageDialog(null,"El numero " + num + " NO es primo");
                break;
            case 2:
                showMessageDialog(null,"El numero " + num + " SI es primo");
                break;
            default:
                comprobar(num);
        }
    }
    
    public static void comprobar(int num) throws Exception
    {
        int divisor=num;
        int resto;
        
        do
        {
            divisor-=1;
            resto=num%divisor;
        }
        while (resto != 0 && divisor > 2);
        
        if (resto==0)
        {
             showMessageDialog(null,"El numero " + num + " NO es primo");
        }
        else
        {
             showMessageDialog(null,"El numero " + num + " SI es primo");
        }
    }
}
