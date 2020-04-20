
package ejercicio8;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;
import Excepciones.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Ejercicio8 
{
    public static void main(String[] args) throws Exception
    {
      char dato =' ';
      do
      {
        try
        {
          dato = menu();
          
          
          switch (dato)
          {
              case 'a':
                  funcionedad();
                  break;
              case 'b':
                  suma();
                  break;
              case 'c':
                  contarvocal();
                  break;
          }
        }
        catch (DatoIncorrecto di)
        {
          showMessageDialog(null,"Debes introducir un dato de la 'a' a la 'd'");
        }
        catch(NumberFormatException e)
        {
          showMessageDialog(null,"Debes introducir un numero");
        }
        catch (NullPointerException npe)
        {
          showMessageDialog(null,"Debes introducir un dato");
        }
        catch(Exception e)
        {
          showMessageDialog(null,"Problemas " + e.getClass() + e.getMessage());
        }
      }
      while (dato !='d');
    } 
    
    public static char menu() throws Exception
    {
       char dato = showInputDialog("a) Calcular la edad de una persona \n"
                + "b) Sumar dos números \n"
                + "c) Contar cuantas vocales hay en una cadena \n"
                + "d) Salir \n\n"
                + "Selecciona una opción:").charAt(0);
       
       dato = Character.toLowerCase(dato);
       
       if (dato!='a' && dato!='b' && dato!='c' && dato!='d')
              throw new DatoIncorrecto();
       
       return dato;
    }
    
    public static String texto(String variable)
    {
        return showInputDialog(null,"Introduce la " + variable + " : ");
    }
    
    public static void funcionedad() throws Exception
    {
       try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fecha = LocalDate.parse(texto("fecha"),formatter);
            LocalDate fechaact = LocalDate.now();

            Period periodo= Period.between(fecha,fechaact);

            showMessageDialog(null,"La edad es: " + periodo.getYears());
       }
       catch (DateTimeParseException dtpe)
       {
           showMessageDialog(null,"La fecha introducida es incorrecta");
       }
    }
    
    public static int datonum() throws Exception
    {
        return Integer.parseInt(texto("variable de numero"));
    }
    
    public static void suma() throws Exception
    {
      int num1=datonum();
      int num2=datonum();
      
      int resultado=num1+num2;
      showMessageDialog(null,"El resultado de la suma es: " + resultado);
    }
    
    public static String comproEntrada() throws Exception
    {
        String cadena=texto("cadena").toUpperCase();

        for (int x=0;x<cadena.length();x++)
        {
            if (Character.isDigit(cadena.charAt(x)))
                throw new TextoFallido();
        } 
        
        return cadena;
    }
    
    public static void contarvocal() throws Exception
    {
        final String VOCALES="AEIOU";
        boolean correcto=false;
        int contador=0;
        String cad=null;
        
        do{
            try{
                cad=comproEntrada();
                correcto=true;
            }
            catch (TextoFallido tf)
            {
                showMessageDialog(null,"Solo se debe introducir texto");
            }    
        }
        while (!correcto);
        
         for (int x=0;x < cad.length();x++)
         {   
             for (int i=0;i<VOCALES.length();i++)
             {
                 if (cad.charAt(x)==VOCALES.charAt(i))
                     contador++;
             }            
         }
         showMessageDialog(null,"El numero de vocales es: " + contador);
    }
}
