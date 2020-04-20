package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 
{
    public static void main(String[] args) 
    {
        Scanner texto=new Scanner(System.in);
        
        System.out.println("Introduce la nota del alumno:");
        int nota=texto.nextInt();
        
        if (nota >=0 && nota <=10)
        {
            if (nota < 5)
            {
                if (nota < 4)
                {
                    System.out.println("Deficiente");
                }
                else
                {
                    System.out.println("Insuficiente");
                }
            }
            else
            {
                if (nota < 7)
                {
                    if (nota < 6)
                    {
                        System.out.println("Suficiente");
                    }
                    else
                    {
                        System.out.println("Bien");
                    }
                }
                else
                {
                    if (nota < 9)
                    {
                        System.out.println("Notable");
                    }
                    else
                    {
                        System.out.println("Sobresaliente");
                    }
                }
            }
        }
        else
        {
            System.out.println("Error:La nota introducida es incorrecta");
        }
    }
}
