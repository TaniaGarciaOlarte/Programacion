
package ejercicio3;

//import Excepciones.*;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;
import Excepciones.*;

public class Ejercicio3 
{
    public static void main(String[] args) throws Exception
    {
       boolean correcto=false;
       char caracter = 0;
       String entrada = null;
       
       do
        {
          try{
             entrada=compararnombre();
            
            do{
                try{
                   caracter=comprobarcaracter(); 
                   correcto=true;
                }
                catch (CaracterIncorrecto ci)
                {
                  showMessageDialog(null,"Mas caracteres de los permitidos");
                }
                catch (CaracterFallido cf)
                {
                  showMessageDialog(null,"El caracter debe contener una letra");
                }
            }
            while(!correcto);
            
          correcto=true;
          } 
          catch (TextoFallido tf)
          {
              showMessageDialog(null,"Solo letras");
          }   
        }
        while(!correcto);
       
        numeroveces(caracter,entrada);
    } 
    
   public static String compararnombre() throws Exception
    {
        String en=showInputDialog("Introduce la entrada por teclado:");
        for (int x=0;x<en.length();x++)
         {
           if (Character.isDigit(en.charAt(x)))
              throw new TextoFallido();
         } 
        return en;
    }
    
   public static char comprobarcaracter() throws Exception
   {
        String c=showInputDialog("Introduce el caracter:");
    
        if (c.length()!=1)
            throw new CaracterIncorrecto();
        else
            if (Character.isDigit(c.charAt(0)))
                throw new CaracterFallido();
        char caracter=c.charAt(0);
    
        return caracter;
   }
   
   public static void numeroveces(char caracter,String entrada)
   {
       int contador=0;
       for (int x=0;x<entrada.length();x++)
       {
           if (entrada.charAt(x)==caracter)
           {
               contador++;
           }
       }
       showMessageDialog(null,"El caracter '" + caracter + "' se repite " + contador + " veces");
   }
}
