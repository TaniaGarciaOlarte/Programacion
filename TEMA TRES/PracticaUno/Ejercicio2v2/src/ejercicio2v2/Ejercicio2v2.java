package ejercicio2v2;

import java.util.Scanner;

public class Ejercicio2v2 
{
    public static void main(String[] args) 
    {
       Scanner multi=new Scanner(System.in);
       
       System.out.println("Introduce el primer numero:");
       int num1=multi.nextInt();
       
       System.out.println("Introduce el segundo numero:");
       int num2=multi.nextInt();
       
       int mul=num1*num2;
       
       System.out.print("El resultado de la multiplicacion es: " + mul + "\n");    
    }
}
