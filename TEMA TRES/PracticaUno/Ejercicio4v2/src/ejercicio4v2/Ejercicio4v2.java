package ejercicio4v2;

import java.util.Scanner;

public class Ejercicio4v2 
{
    public static void main(String[] args) 
    {
        Scanner texto=new Scanner(System.in);
        
        System.out.println("Introduce la primera diagonal:");
        int d=texto.nextInt();
        
        System.out.println("Introduce la segunda diagonal:");
        int D=texto.nextInt();
        
        int area=D*d/2;
        
        System.out.println("El valor del area es: " + area);
    }
}
