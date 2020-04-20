package ejercicio5v2;

import java.util.Scanner;

public class Ejercicio5v2 
{
    public static void main(String[] args) 
    {
        Scanner texto=new Scanner(System.in);
        
        System.out.println("Introduce los grados centigrados: ");
        int grados=texto.nextInt();
        
        int fah=(int)(1.8*grados+32);
        
        System.out.println("El resultado es: " + fah);
    }
    
}
