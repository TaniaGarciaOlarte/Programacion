package ejercicio6v2;

import static java.lang.Math.PI;
import java.util.Scanner;

public class Ejercicio6v2 
{
    public static void main(String[] args) 
    {
       Scanner texto=new Scanner(System.in);
       
       System.out.println("Introduce el valor de radio: ");
       int rad=texto.nextInt();
       
       int radio=(int)(PI*rad*rad);
       
       System.out.println("El resultado del radio es:" + radio);
    }
    
}
