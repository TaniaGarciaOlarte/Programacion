
package ejercicio1;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;
import Excepciones.*;

public class Ejercicio1 
{
    final private static String vocales="AEIOU";
    
    public static void main(String[] args) 
    {
        /*Declarar constantes dentro de las funciones
        final String vocales="AEIOU";*/
        try{
            boolean correcto = false;
            do{
                try
                {
                    String entrada=comproEntrada();
                    
                    compararvocales(entrada);
                    correcto=true;
                }
                catch(TextoFallido tf)
                {
                    showMessageDialog(null,"Solo se pueden introducir letras");
                }
            }
            while(!correcto);
        }
        catch (Exception e)
            {
               showMessageDialog(null,"Problemas");
            }
    }
    
    public static String comproEntrada() throws Exception
    {
        String en=showInputDialog("Introduce la entrada por teclado:").toUpperCase();

        for (int x=0;x<en.length();x++)
        {
            if (Character.isDigit(en.charAt(x)))
                throw new TextoFallido();
        } 
        
        return en;
    }
      
     public static void compararvocales (String entrada) throws Exception
     {
         int contador=0;
         for (int x=0;x < entrada.length();x++)
         {   
             for (int i=0;i<vocales.length();i++)
             {
                 if (entrada.charAt(x)==vocales.charAt(i))
                     contador++;
             }            
         }
         showMessageDialog(null,"El numero de vocales es: " + contador);
     }
}   
