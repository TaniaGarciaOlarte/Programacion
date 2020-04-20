package ejercicio7;

public class Ejercicio7 
{
    public static void main(String[] args) 
    {
      String ca1=javax.swing.JOptionPane.showInputDialog("Introduce el valor del cateto uno:");
      int cateto1=Integer.parseInt(ca1);
      
      String ca2=javax.swing.JOptionPane.showInputDialog("Introduce el valor del cateto dos:");
      int cateto2=Integer.parseInt(ca2);
      
      int hipo=(int) Math.sqrt(cateto1^2+cateto2^2);
      
      javax.swing.JOptionPane.showMessageDialog(null,"El resultado de la hipotenusa es: " + hipo);
      
    }  
}
