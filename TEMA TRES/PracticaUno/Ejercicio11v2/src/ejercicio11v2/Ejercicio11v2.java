package ejercicio11v2;

import java.util.Scanner;

public class Ejercicio11v2 
{
    public static void main(String[] args) 
    {
     Scanner texto=new Scanner(System.in);
     
     System.out.println("Introduce el primer numero");
     int num1=texto.nextInt();
     
     System.out.println("Introduce el segundo numero");
     int num2=texto.nextInt();
     
     System.out.println("Introduce el tercer numero");
     int num3=texto.nextInt();
     
     if (num1 > num2 && num1 > num3)
     {
         System.out.println("El mayor es: " + num1);
     }
     else if (num2 > num3)
     {
         System.out.println("El mayor es: " + num2);
     }
     else
     {
         System.out.println("El mayor es: " + num3);
     }
     
     if (num1 < num2 && num1 < num3)
     {
         System.out.println("El menor es: " + num1);
     }
     else if (num2 < num3)
     {
         System.out.println("El menor es: " + num2);
     }
     else
     {
         System.out.println("El menor es: " + num3);
     }
    }
    
}
