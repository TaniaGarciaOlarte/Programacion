/*1.Escribe un programa que visualice por pantalla 
un mensaje introducido por teclado.*/

package eje1;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje1 
{
    public static void main(String[] args) 
    {
        try
        {
          String texto=comprobarentrada();
          showMessageDialog(null,"El texto introducido es: " + texto);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"Cancelado");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"Problemas" + e.getMessage());
        }
    } 
    
    public static String comprobarentrada() throws Exception
    {
        boolean error;
        String entrada="";
        
        do{
            try
            {
                entrada=showInputDialog("Introduce el texto a mostrar:");

                if (entrada.isEmpty())
                    throw new TextoVacio();

                for (int i=0;i<entrada.length();i++)
                {
                    if (Character.isDigit(entrada.charAt(i)))
                        throw new TextoInvalido();
                }
                
                error=true;
            }
            catch (TextoVacio tv)
            {
                showMessageDialog(null,"CAMPO VACIO: Debes introducir contenido");
                error=false;
            }
            catch (TextoInvalido ti)
            {
                showMessageDialog(null,"SOLO LETRAS: El contenido solo puede contener caracteres");
                error=false;
            }
        }
        while (!error);
      
        return entrada;
    }
}
