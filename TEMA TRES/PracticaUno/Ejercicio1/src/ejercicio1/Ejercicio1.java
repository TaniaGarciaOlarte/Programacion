package ejercicio1;
import java.util.Scanner;
public class Ejercicio1 
{
    public static void main(String[] args) 
    {
       String text;
       Scanner texto=new Scanner(System.in);
       
       System.out.print("Introduce el texto a visualizar:");
       text=texto.nextLine();
       
       System.out.print("El texto introducido por el usuario es: " + text + "\n");
    }
}
