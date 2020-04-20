package ejercicio18;

import java.util.Scanner;

public class Ejercicio18 
{
    public static void main(String[] args) 
    {
       Scanner texto=new Scanner(System.in);
       
       int num1=1,num2=1,contador=0;
       System.out.println("Ingrese la cantidad de numeros: ");
       int cantidad=texto.nextInt();
       
       do 
       {
           System.out.println(num1);
           int resultado=num1+num2;
           num1=num2;
           num2=resultado;
           contador++;
       }
       while (contador<cantidad);
    }
}
