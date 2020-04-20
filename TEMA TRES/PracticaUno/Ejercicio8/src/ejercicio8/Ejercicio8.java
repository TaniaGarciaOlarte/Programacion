package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 
{
    public static void main(String[] args) 
    {
      Scanner texto=new Scanner(System.in);
      
      System.out.println("Introduce la nota del alumno:");
      int nota=texto.nextInt();
      
       if (nota >= 5 && nota <=10)
       {
           System.out.println("Aprobado");
       }
       else if ( nota<5 && nota > 0)
       {
           System.out.println("Suspenso");
       }
       else
       {
           System.out.println("Error:La nota introducida es erronea");
       }
    }
}
