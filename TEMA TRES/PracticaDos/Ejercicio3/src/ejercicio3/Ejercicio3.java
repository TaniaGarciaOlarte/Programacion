
package ejercicio3;

public class Ejercicio3 
{
    static int resultadosuma,resultadoresta;
    static String nl;
    public static void main(String[] args) 
    {
       nl=System.getProperty("line.separator");
      int num;
      
      do{
      num=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("MENU: "
              + nl + "1-.Sumar dos numeros"
              + nl + "2-.Restar dos numeros"
              + nl + "3-.Visualizar la tabla de multiplicar de un numero"
              + nl + "4-.Visualizar el cociente y el resto de una division"
              + nl + "5-.Salir del programa"));
      if (num >=1 && num <=5)
      {
          switch (num)
          {
              case 1:
                  resultadosuma=suma(num);
                  javax.swing.JOptionPane.showMessageDialog(null,"El resultado de la suma es: " + resultadosuma);
                  break;
              case 2:
                  resultadoresta=resta(num);
                  javax.swing.JOptionPane.showMessageDialog(null,"El resultado de la resta es: " + resultadoresta);
                  break;
              case 3:
                  
                  String tabla=multi(num);
                  javax.swing.JOptionPane.showMessageDialog(null,tabla);
                  break;
              case 4:
                  codirest();
                  break;
              case 5:
                  num=5;
          }
      }
      else
      {
          javax.swing.JOptionPane.showMessageDialog(null,"Error: El numero introducido es incorrecto");
      }
      
      }
      while(num!=5); 
      
    }
    
//Funcion suma
    public static int suma(int num)
    {
        int num1=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el primer numero:"));
        int num2=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el segundo numero:"));
                
        int resultsuma=num1+num2;
        return resultsuma;
    }
    
//Funcion resta
    public static int resta(int num)
    {
        int num1=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el primer numero:"));
        int num2=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el primer numero:"));
                
        int resultresta=num1-num2;
        return resultresta;
    }
    
//Funcion multi
    public static String multi(int num)
    {
        int numero=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero:"));
        String tabla=null;
        
        for (int i=1;i<=10;i++)
        {
           tabla=tabla + numero + "*" + i + "=" + numero*i + nl;
        }
    return tabla;
    }
    
//Funcion cociente y resto
    public static void codirest()
    {
        int num1=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el primer numero:"));
        int num2=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el primer numero:"));
        
        int resultcociente=num1/num2;
        int resultresto=num1%num2;
        
        javax.swing.JOptionPane.showMessageDialog(null,"El cociente es: " + resultcociente + " el resto es: " + resultresto);
    }
}

