package ejercicio7v2;

import java.util.Scanner;

public class Ejercicio7v2 
{
    public static void main(String[] args) 
    {
        Scanner texto=new Scanner (System.in);
        
        System.out.println("Introduce el valor del cateto uno: ");
        int cateto1=texto.nextInt();
        
        System.out.println("Introduce el valor del cateto dos: ");
        int cateto2=texto.nextInt();
        
        int hipo=(int) Math.sqrt(cateto1^2+cateto2^2);
        
        System.out.println("El valor de la hipotenusa es: " + hipo);
    }
}
