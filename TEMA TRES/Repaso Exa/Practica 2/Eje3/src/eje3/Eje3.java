/*3. Mostrar al usuario el siguiente menu:
    1.- Sumar dos numeros 
    2.- Restar dos numeros 
    3.-Visualizar la tabla de multiplicar de un numero 
    4.- Visualizar el cociente y el resto de una division 
    5.-Salir del programa
Elige una opcion:

-Cuando tengamos el resultado de la operacion elegida, lo visualizamos en pantalla 
y volveremos a mostrar el menu hasta que seleccione la opcion de salir.*/

package eje3;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje3 
{
    public static void main(String[] args) 
    {
       int num=0;
       try
       {   
           do
           {
             num=menu();
             comprobarswitch(num);
           }
           while (num!=5);
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
       }
    }
    
    public static int entrada() throws Exception
    {
        return Integer.parseInt(showInputDialog("1-.SUMAR DOS NÚMEROS \n"
                + "2-.RESTAR DOS NUMEROS \n"
                + "3-.VISUALIZAR LA TABLA DE MULTIPLICAR DE UN NUMERO \n"
                + "4-.VISUALIZAR EL COCIENTE Y EL RESTO DE UNA DIVISION \n"
                + "5-.SALIR DEL PROGRAMA \n"
                + "ELIGE UNA OPCIÓN:"));
    }
    
    public static int menu () throws Exception
    {
       boolean error;
       int num=0;
       
       do
       {
           try
           {
               num=entrada();
               
               if (num < 1 || num > 5)
                   throw new NumeroIncorrecto();
               
               error=true;
           }
           catch (NumeroIncorrecto ni)
           {
               showMessageDialog(null,"NUMERO INCORRECTO (DEL 1 AL 5)");
               error=false;
           }
           catch (NumberFormatException nfe)
           {
               showMessageDialog(null,"SOLO NUMEROS");
               error=false;
           }
       }
       while (!error);
       
       return num;
    }
    
    public static void comprobarswitch(int num) throws Exception
    {
        switch (num)
        {
            case 1:
                sumarnum();
                break;
            case 2:
                restarnum();
                break;
            case 3:
                tablamult();
                break;
            case 4:
                coefiyrest();
                break;
        }
    }
    
    public static int entrada(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable));
    }
    
    public static int comprobarnum(String variable) throws Exception
    {
        boolean error;
        int vari=0;
        
        do
        {
            try
            {
                vari=entrada(variable);
                
                if (vari < 1)
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
        while (!error);
        
        return vari;
    }
    
    public static void sumarnum() throws Exception
    {
        int num1=comprobarnum("numero 1:");
        int num2=comprobarnum("numero 2:");
        
        int result=num1+num2;
        
        showMessageDialog(null,"El resultado de la suma es: " + result);
    }
    
    public static void restarnum() throws Exception
    {
        int num1=comprobarnum("numero 1:");
        int num2=comprobarnum("numero 2:");
        
        int result=num1-num2;
        
        showMessageDialog(null,"El resultado de la resta es: " + result);
    }
    
    public static void tablamult() throws Exception
    {
        String tabla="";
        
        int num=comprobarnum("numero:");
        
        for (int x=1;x<=10;x++)
        {
            tabla+=num + " x " + x + " = " + num*x + "\n";
        }
        
        showMessageDialog(null,"TABLA DE MULTIPLICAR: \n"
                + tabla);
    }
    
    public static void coefiyrest() throws Exception
    {
        int num1=comprobarnum("numero 1:");
        int num2=comprobarnum("numero 2:");
        
        int coefi=num1/num2;
        int resto=num1%num2;
        
        showMessageDialog(null,"El coeficiente de la division es: " + coefi + "\n"
                + "El resto de la division es: " + resto);
    }
}
