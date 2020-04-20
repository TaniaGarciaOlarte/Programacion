/*20. Crea un minijuego en el que el ordenador elija un numero aleatorio
comprendido entre 0 y 100 para que el usuario intente adivinarlo.
(numero = aleatorio(0,100))

Cada vez que el usuario haga un intento le daremos pistas de si el
numero que busca es mas alto o mas bajo que el que ha escrito, hasta 
que acierte o escriba la palabra FIN para terminar el juego.*/

package eje20;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje20 
{
    public static void main(String[] args) 
    {
        try
        {
           int numalt=(int) (Math.random()*100);
           int num = 0;
           boolean error;
           String comp = null,dato = null;
           
           do
           {
               do{
                   try
                   {
                        dato=entrada();
                        
                        if (dato.compareToIgnoreCase("fin")!=0)
                        {
                            num=comprobarnum(dato);
                            
                            dato=comprobar(num,numalt,dato,comp);
                        }
                        
                        error=true;
                   }
                   catch (NumeroIncorrecto nu)
                   {
                       showMessageDialog(null,"NUMERO INCORRECTO(DEL 0 AL 100)");
                       error=false;
                   }
                   catch (NumberFormatException nfe)
                   {
                       showMessageDialog(null,"SOLO NUMEROS");
                       error=false;
                   }
                 }
               while(!error);        
           }
           while(dato.compareToIgnoreCase("Fin")!=0);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static String entrada() throws Exception
    {
        return showInputDialog("Introduce un numero o fin para finalizar:");
    }
    
    public static int comprobarnum(String dato) throws Exception
    {
        int resp=Integer.parseInt(dato);
               
           if (resp<0 || resp>100)
               throw new NumeroIncorrecto();
               
        return resp;
    }
    
    public static String solu(int num,int numalt) throws Exception
    {
        if (num<numalt)
        {
           return "INTRODUCE UN NUMERO MAS ALTO";
        }
        else
        {
           return "INTRODUCE UN NUMERO MAS BAJO";
        }
    }
    
    public static String comprobar(int num,int numalt,String dato,String comp) throws Exception
    {
        if (num==numalt)
           {
             showMessageDialog(null,"¡ENORABUENA HAS ACERTADO EL NUMERO ALEATORIO!");
             dato="fin";
            }
         else
           {
            comp=solu(num,numalt); 
            showMessageDialog(null,comp);
           } 
        return dato;
    }
}
