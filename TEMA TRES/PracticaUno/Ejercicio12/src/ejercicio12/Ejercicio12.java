package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 
{
    public static void main(String[] args) 
    {
      Scanner texto=new Scanner(System.in);
      
      System.out.println("Introduce el consumo mensual: ");
      int consumo=texto.nextInt();
      
      if (consumo <=300)
      {
          int resultado = (int)(consumo*0.04);
          System.out.println("Tines que pagar: " + resultado);
      }
      else if (consumo > 300 && consumo <=500)
      {
          int resultado = (int)(consumo*0.03);
          System.out.println("Tines que pagar: " + resultado);
      }
      else if (consumo > 500 && consumo <800)
      {
          int resultado = (int)(300*0.03 + (consumo - 300)*0.02);
          System.out.println("Tines que pagar: " + resultado);
      }
      else
      {
          int resultado = (int)((300*0.03 + (consumo - 300)*0.02)*1.25/100);
          System.out.println("Tines que pagar: " + resultado);
      }
    }  
}
