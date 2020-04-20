package ejercicio3;

import java.io.IOException;

public class Ejercicio3 
{
    public static void main(String[] args) throws IOException 
    {
        String tbase=javax.swing.JOptionPane.showInputDialog("Introduce la base: ");
        int base=Integer.parseInt(tbase);
        
        String taltura=javax.swing.JOptionPane.showInputDialog("Introduce la altura: ");
        int altura=Integer.parseInt(taltura);
        
        int resultado=2*base + 2*altura;
        
        javax.swing.JOptionPane.showMessageDialog(null, "El resultado del perimetro es : " + resultado);
    }
}
