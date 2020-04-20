package ejercicio13;

import java.util.Scanner;

public class Ejercicio13 
{
    public static void main(String[] args) 
    {
        Scanner texto=new Scanner(System.in);
        int contadorchicas=0,contadorchicos=0;
        
       for (int i=1;i<=3;i++)
       {
            System.out.println("Introduce el peso: ");
            int peso=texto.nextInt();
            
            System.out.println("Introduce la edad: ");
            int edad=texto.nextInt();
            
            System.out.println("Introduce el nombre: ");
            String nombre=texto.nextLine();
            texto.nextLine();
            
            System.out.println("Introduce el sexo: ");
            String sexo=texto.nextLine();   
            
            System.out.println("Introduce la estatura: ");
            double estatura=texto.nextDouble(); 
            
            if (sexo.compareTo("femenino")==0)
            {
                if (estatura > 1.60 && peso > 60)
                {
                     contadorchicas++;
                }
            }
            else
            {
                if (sexo.compareTo("masculino")==0) 
                {
                    if (estatura > 1.70 && peso > 70)
                    {
                        contadorchicos++;
                    }
                }
            }
        }
       
        System.out.println ("El numero de chicas aptas es: " + contadorchicas);
        System.out.println ("El numero de chicos aptos es: " + contadorchicos);
    }
}
