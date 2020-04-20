package ejercicio17;

import java.util.Scanner;

public class Ejercicio17 
{
    public static void main(String[] args) 
    {
       Scanner texto=new Scanner(System.in);
       int min=11;
       int max=-1;
       int contador=0;
       String nombremin = null,nombremax = null,nombre;
      
       for (int i=0;i < 3;i++)
       {
           System.out.println("Introduce el nombre del alumno: ");
           nombre=texto.nextLine();
           
           System.out.println("Introduce la nota del alumno: ");
           int nota=texto.nextInt();
           texto.nextLine();
           
           if (nota>max)
           {
               max=nota;
               nombremax=nombre;
           }
           else if (nota < min)
           {
               min=nota;
               nombremin=nombre;
           }
           contador++;
       }
       System.out.println("El alumno que ha obtenido la nota maxima es: " + nombremax + " con la nota: " + max);
       System.out.println("El alumno que ha obtenido la nota minimo es: " + nombremin + " con la nota: " + min);
    }  
}
