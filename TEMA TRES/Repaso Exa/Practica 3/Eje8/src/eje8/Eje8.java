/*8. Desarrolla un proyecto que muestre en pantalla un menu con las 
siguientes opciones:

    a) Calcular la edad de una persona.
    b) Sumar dos numeros.
    c) Contar cuantas vocales hay en una cadena.
    d) Salir
    Selecciona una opcion:

  -Si nos seleccionan la opcion a, pediremos una fecha de nacimiento 
y restandosela al dıa de hoy, obtendremos la edad en anos de esa
persona.
  -Si nos seleccionan la opcion b, solicitaremos dos numeros y mostrare
mos el resultado de sumarlos.
  -Si nos seleccionan la opcion c, solicitaremos una cadena de caracteres 
y mostraremos en pantalla el numero de vocales que la componen.
  -Cuando nos seleccionen la opcion d el programa terminara.*/

package eje8;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Eje8 
{
    public static void main(String[] args) 
    {
       char letra;
       try
       {   
           do
           {
              letra=comprme();
              
              opemen(letra);
           }
           while(letra!='d');
       }
       catch (NullPointerException npe)
       {
           showMessageDialog(null,"CANCELADO");
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS" + e.getClass() + " " + e.getMessage());
       }
    }
    
    public static String menu() throws Exception
    {
        return showInputDialog("SELECCIONA UNA OPCIÓN: \n"
                + " a)Calcula la edad de una persona \n"
                + " b)Sumar dos numeros \n"
                + " c)Contar cuantas vocales hay en una cadena \n"
                + " d)Salir ").toLowerCase();
    }
    
    public static char comprme() throws Exception
    {
        boolean error;
        String l = null;
        char letra=0;
        
        do
        {
            try
            {
                l=menu();
                
                if(l.length()!=1)
                    throw new LongitudIncorrecta();
                
                if (Character.isDigit(l.charAt(0)))
                    throw new LetraIncorrecta();
                
                letra=l.charAt(0);
                
                if (letra!='a' && letra!='b' && letra!='c' && letra!='d')
                    throw new LetraErronea();
                
                error=true;
            }
            catch (LongitudIncorrecta li)
            {
                showMessageDialog(null,"LONGITUD INCORRECTA:DEBE SER SOLO UN CARACTER");
                error=false;
            }
            catch (LetraIncorrecta lin)
            {
                showMessageDialog(null,"SOLO LETRAS");
                error=false;
            }
            catch (LetraErronea le)
            {
                showMessageDialog(null,"LETRA ERRONEA SOLO PUEDE SER (A,B,C Y D)");
                error=false;
            }
        }
        while(!error);
        
        return letra;
    }
    
    public static void opemen(char letra) throws Exception
    {
        switch (letra)
        {
            case 'a':
                calcedad();
                break;
            case 'b':
                sumar();
                break;
            case 'c':
                contvoc();
                break;
        }
    }
    
    public static String entradas(String variable) throws Exception
    {
        return showInputDialog("Introduce el valor de " + variable).toLowerCase();
    }
    
    public static void calcedad() throws Exception
    {
        boolean error;
        
        do
        {
            try
            {
                DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String f=entradas("fecha:");

                LocalDate fecha=LocalDate.parse(f,df);
                LocalDate fechaact=LocalDate.now();
                
                Period periodo=Period.between(fecha, fechaact);
                
                showMessageDialog(null,"La edad es: " + periodo.getYears());
                
                error=true;

            }
            catch (DateTimeException dte)
            {
                showMessageDialog(null,"DEBES INTRODUCIR UNA FECHA EN EL FORMATO (dd/MM/yyyy)");
                error=false;
            }
        }
        while(!error);
    }
    
    public static double entradan(String variable) throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce el valor del valor del " + variable));
    }
    
    public static double comprobarn(String variable) throws Exception
    {
        boolean error;
        double num=0;
        
        do
        {
            try
            {
                num=entradan(variable);
                
                if (num < 1)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"NUMERO INCORRECTO (MINIMO 1)");
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
    
    public static void sumar() throws Exception 
    {
       NumberFormat nf=NumberFormat.getNumberInstance(Locale.ROOT);
        
       double num1=comprobarn("numero 1:");
       double num2=comprobarn("numero 2:");
       
       double result=num1+num2;
       
       showMessageDialog(null,"El resultado de la suma es : " + nf.format(result));
    }
    
    public static void contvoc() throws Exception
    {
        boolean error;
        
        do
        {
            try
            {
                String ent=entradas("la entrada de texto:");
                
                if(ent.isEmpty())
                    throw new CampoVacio();
                
                for (int x=0;x<ent.length();x++)
                {
                    if (Character.isDigit(ent.charAt(x)))
                        throw new CampoIncorrecto();
                }
                
                contarvocales(ent);
                
                error=true;
            }
            catch (CampoVacio cv)
            {
                showMessageDialog(null,"CAMPO VACIO:DEBE INTRODUCIR UN TEXTO");
                error=false;
            }
            catch (CampoIncorrecto ci)
            {
                showMessageDialog(null,"CAMPO INCORRECTO:DEBE INTRODUCIR SOLO LETRAS");
                error=false;
            }
        }
        while(!error);
    }
    
    public static void contarvocales(String ent) throws Exception
    {
        int contador=0;
        
        for(int x=0;x<ent.length();x++)
        {
            if (ent.charAt(x)=='a' || ent.charAt(x)=='e' || ent.charAt(x)=='i' || ent.charAt(x)=='o' || ent.charAt(x)=='u')
                contador++;
        }
        
        showMessageDialog(null,"La palabra " + ent + " tiene " + contador + " vocales ");
    }
}
