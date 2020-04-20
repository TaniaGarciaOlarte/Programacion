
package ejercicio4;

public class Ejercicio4 
{
    public static void main(String[] args) 
    {
      String dato1=javax.swing.JOptionPane.showInputDialog("Introduce la primera diagonal: ");
      int d=Integer.parseInt(dato1);
      
      String dato2=javax.swing.JOptionPane.showInputDialog("Introduce la segunda diagonal: ");
      int D=Integer.parseInt(dato2);
      
      int area=D*d/2;
      
      javax.swing.JOptionPane.showMessageDialog(null,"El valor del area es: " + area);
    }
    
}
