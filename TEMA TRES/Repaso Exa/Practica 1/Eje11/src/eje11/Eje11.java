/*11. Crear un diagrama de flujo que pida tres numeros y muestre cual es 
el mayor y cual es el menor.*/

package eje11;

import static javax.swing.JOptionPane.*;

public class Eje11 
{
    public static void main(String[] args) 
    {
        try
        {
            entradadatos();
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static int datos(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor del " + variable + " numero:"));
    }
    
    public static void entradadatos() throws Exception
    {
        boolean error;
        
        do
        {
          try
          {
              int num1=datos("primer");
              int num2=datos("segundo");
              int num3=datos("tercer");
              
              comprobar(num1,num2,num3);
              
              error=true;
          }
          catch (NumberFormatException nfe)
          {
              showMessageDialog(null,"SOLO NUMEROS");
              error=false;
          }
        }
        while (!error);
    }
    
    public static void comprobar (int num1,int num2,int num3) throws Exception
    {
        if (num1>num2 && num1>num3)
        {
            showMessageDialog(null,"El numero " + num1 + " es el mayor");
            if (num2<num3)
                showMessageDialog(null,"El numero " + num2 + " es el menor");
            else
                showMessageDialog(null,"El numero " + num3 + " es el menor");
        }
        else
        {
            if (num2>num3)
            {
                showMessageDialog(null,"El numero " + num2 + " es el mayor");
                if (num1<num3)
                    showMessageDialog(null,"El numero " + num1 + " es el menor");
                else
                    showMessageDialog(null,"El numero " + num3 + " es el menor");
            }
            else
            {
                showMessageDialog(null,"El numero " + num3 + " es el mayor");
                if (num1<num2)
                    showMessageDialog(null,"El numero " + num1 + " es el menor");
                else
                    showMessageDialog(null,"El numero " + num2 + " es el menor");
            }
        }
    }
}
