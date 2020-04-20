package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 
{
    public static void main(String[] args) 
    {
       Scanner texto=new Scanner(System.in);
       
       System.out.println("Introduce un numero de la semana: ");
       int semana=texto.nextInt();
       
       switch(semana)
       {
           case 1:
               System.out.println("Lunes");
             break;
           case 2:
               System.out.println("Martes");
             break;
           case 3:
               System.out.println("Miercoles");
             break;
           case 4:
               System.out.println("Jueves");
             break;
           case 5:
               System.out.println("Viernes");
             break;
           case 6:
               System.out.println("Sabado");
             break;
           case 7:
               System.out.println("Domingo");
             break;
           default:
               System.out.println("Error:El numero del dia de la semana esta mal introducido");
       }
    } 
}
