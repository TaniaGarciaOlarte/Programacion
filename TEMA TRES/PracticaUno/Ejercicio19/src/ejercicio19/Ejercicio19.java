package ejercicio19;

import java.util.Scanner;

public class Ejercicio19 
{
    public static void main(String[] args) 
    {
        Scanner texto=new Scanner(System.in);
        
        int primerImpar=1,suma=0,contador=1,num=0;
        System.out.println("Introduce el numero y te mostraré su cuadrado: ");
        num=texto.nextInt();
        
        do
        {
            suma += primerImpar;
            primerImpar += 2;
            contador++;
        }
        while (contador<=num);
        System.out.println("El cuadrado de " + num + " es: " + suma);
    } 
}
