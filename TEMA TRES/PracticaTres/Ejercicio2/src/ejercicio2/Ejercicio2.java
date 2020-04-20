
package ejercicio2;
import Excepciones.*;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;

public class Ejercicio2 
{
    static String entradainvertida="";
    
    public static void main(String[] args) 
    {
        try
        {
            boolean correcto = false;
                do{
                    try
                    {
                        String entrada=comproEntrada();

                        invertirtexto(entrada);
                        correcto=true;
                    }
                    catch (TextoFallido tf)
                    {
                        showMessageDialog(null,"Solo se puede introducir texto");
                    }
                }  
                while (!correcto);
        }
        catch (Exception e)
        {
               showMessageDialog(null,"Problemas");
        }
    }
    
    public static String comproEntrada() throws Exception
    {
        String en=showInputDialog("Introduce la entrada por teclado:");

        for (int x=0;x<en.length();x++)
        {
            if (Character.isDigit(en.charAt(x)))
                throw new TextoFallido();
        } 
        return en;
    }
    
    public static void invertirtexto(String entrada)
    {
        for (int i=entrada.length()-1;i>=0;i--)
        {
            entradainvertida += entrada.charAt(i);
        }
        showMessageDialog(null,entradainvertida);
    }
}
