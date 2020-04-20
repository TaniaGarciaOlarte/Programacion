package ejercicio16;

import java.util.Scanner;

public class Ejercicio16 
{
    public static void main(String[] args) 
    {
       Scanner texto=new Scanner(System.in);
       double result=0,contador=0,resultado=0;;
       String respuesta;
       
       do 
       {
           System.out.println("Introduce la edad de los estudiantes:");
           int edad=texto.nextInt();
           texto.nextLine();
           
           resultado += edad;
           contador++;
           
           System.out.println("¿Deseas continuar?");
           respuesta=texto.nextLine();
       }
       while (respuesta.compareTo("si")==0);  
       result=resultado/contador;
       System.out.println("El promedio de los alumnos es: " + result);
    }
    
}
