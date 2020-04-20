package ejercicio5;

public class Ejercicio5 
{
    public static void main(String[] args) 
    {
      String texto=javax.swing.JOptionPane.showInputDialog("Introduce los grados centigrados: ");
      int grados=Integer.parseInt(texto);
      
      int fah=(int)(1.8 * grados + 32);
      
      javax.swing.JOptionPane.showMessageDialog(null,"El resultado es: " + fah);
    }
}
