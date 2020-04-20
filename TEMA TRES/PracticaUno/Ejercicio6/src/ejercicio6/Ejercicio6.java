package ejercicio6;

import static java.lang.Math.PI;

public class Ejercicio6 
{
    public static void main(String[] args) 
    {
       String rad=javax.swing.JOptionPane.showInputDialog("Introduce el radio: ");
       int radi=Integer.parseInt(rad);
       
       int radio=(int)(PI*radi*radi);
       
       javax.swing.JOptionPane.showMessageDialog(null,"El resultado del area es: " + radio);
    }
    
}
