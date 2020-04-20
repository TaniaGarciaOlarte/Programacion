package ejercicio3v2;

import java.util.Scanner;

public class Ejercicio3v2 
{
    public static void main(String[] args) 
    {
       Scanner teclado=new Scanner (System.in);
       
       System.out.println("Introduce la base: ");
       int base=teclado.nextInt();
       
       System.out.println("Introduce la altura: ");
       int altura=teclado.nextInt();
       
       int resultado=2*base + 2*altura;
       
       System.out.println("El resultado del perimetro es: " + resultado);
    }
    
}
