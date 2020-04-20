package ejercicio15;

import java.util.Scanner;

public class Ejercicio15 
{
    public static void main(String[] args) 
    {
       Scanner texto=new Scanner(System.in);
       int contador=0;
       String respuesta;
       
       do
       {
           System.out.println("Introuce la nota del alumno: ");
           int nota=texto.nextInt();
           texto.nextLine();
           
           if (nota >= 6 && nota <= 10)
           {
              contador++;
           }
           else if (nota > 10)
           {
               System.out.println("Error:La nota introducida es incorrecta");
           }
           
           System.out.println("¿Deseas continuar?");
           respuesta=texto.nextLine();
           
                   
       }
       while (respuesta.compareTo("si")==0);
       
       System.out.println("Los alumnos aprobados son: " + contador);
    }  
}
