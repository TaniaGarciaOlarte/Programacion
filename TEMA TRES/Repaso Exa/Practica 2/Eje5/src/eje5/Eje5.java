/*5. Desarrolla una programa que nos permita jugar a Muertos y heridos con numeros de tres cifras. 
Generaremos automaticamente un numero e intentaremos adivinarlo teniendo como pista el numero de 
numeros que estan en la posicion adecuada (muertos) y el numero 
de numeros que estan pero no en la posicion adecuada (heridos). 
(charAt(posicion))*/

package eje5;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje5 
{
    public static void main(String[] args) 
    {
       try
       {
           String num=generarnum();
           jugar(num);
       }
       catch (NullPointerException npe)
       {
           showMessageDialog(null,"CANCELADO");
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS " + e.getClass() + " " + e.getMessage());
       }
    }  
    
    public static String generarnum() throws Exception
    {
        String num;
        boolean error=true;
        
        do
        {
            Integer n1=(int)(Math.random()*999)+1;
            
            num=Integer.toString(n1);
            //String num=String.valueOf(n1);
            
            if (num.charAt(0)==num.charAt(1) || num.charAt(0)==num.charAt(2) || num.charAt(1)==num.charAt(2))
                error=false;
        }
        while(!error);
        
        return num;
    }
    
    public static void jugar(String num) throws Exception
    {
        showMessageDialog(null,"¡A JUGAR!");
        
        boolean continuar=true;
        do
        {
            String numero=entrada();
            
            if (numero.equals(num))
            {
                showMessageDialog(null,"¡ENORABUENA HAS ACERTADO!");
                continuar=false;
            }
            else
            {
                String mensaje=buscarmuertos(numero,num) +  " " + buscarheridos(numero,num);
                showMessageDialog(null,mensaje);
            }
        }
        while(continuar);
    }
    
    public static String entrastring() throws Exception
    {
        return showInputDialog("Introduce un valor de TRES digitos:");
    }
    
    public static String entrada() throws Exception
    {
        boolean error;
        String numero=null;
        
        do
        {
            try
            {
                numero=entrastring();
                
                if (numero.length() !=3)
                    throw new NumeroIncorrecto();
                
                for (int x=0;x< numero.length();x++)
                {
                    if (!Character.isDigit(numero.charAt(x)))
                        throw new DatoIncorrecto();
                }
                
                if (numero.charAt(0)==numero.charAt(1) || numero.charAt(0)==numero.charAt(2) || numero.charAt(1)==numero.charAt(2))
                    throw new NumeroRepetido();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"NUMERO INCORRECTO (TRES DIGITOS)");
                error=false;
            }
            catch (DatoIncorrecto di)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
            catch (NumeroRepetido nr)
            {
                showMessageDialog(null,"NO SE PUEDEN REPETIR NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return numero;
    }
    
    public static String buscarmuertos(String numero,String num) throws Exception
    {
        int contador=0;
        
        for (int x=0;x<numero.length();x++)
        {
            if (num.charAt(x)==numero.charAt(x))
                contador++;
        }
        
        return "Hay " + contador + " muertos";
    }
    
    public static String buscarheridos(String numero,String num) throws Exception
    {
        int contador=0;
        
        for (int x=0;x<numero.length();x++)
        {
            int y;
            for (y=0;y<num.length() && numero.charAt(x) != num.charAt(y);y++){}
            
            if (y !=num.length() && x!=y)
                contador++;
        }
        
        /*if (numero.charAt(0) == num.charAt(1) || numero.charAt(0) == num.charAt(2))
            contador ++;
        if (numero.charAt(1) == num.charAt(0) || numero.charAt(1) == num.charAt(2))
            contador ++;
        if (numero.charAt(2) == num.charAt(0) || numero.charAt(2) == num.charAt(1))
            contador ++;*/
        
        return "Hay " + contador + " heridos";
    }
}
