package ejercicio14;

import java.util.Scanner;

public class Ejercicio14 
{
    public static void main(String[] args) 
    {
       Scanner texto=new Scanner(System.in);
       int resultado = 0;
       
       for (int i=0;i<10;i++)
       {
           System.out.println("Introduce el numero a sumar:");
           int num=texto.nextInt();
           
           resultado += num;
       }
       
       System.out.println("El resultado de la suma es: " + resultado);
    }
    
}
