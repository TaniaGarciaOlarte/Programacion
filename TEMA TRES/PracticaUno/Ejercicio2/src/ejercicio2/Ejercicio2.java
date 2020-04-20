
package ejercicio2;

public class Ejercicio2 
{
    public static void main(String[] args) 
    {
        //Formas de guardar los datos introducidos en este caso se convierte a int (numerico):
            //Primera forma de realizar
                int num1=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el primer numero:"));

            //Segunda forma de realizar
                String texto=javax.swing.JOptionPane.showInputDialog("Introduce el segundo numero: ");
                int num2=Integer.parseInt(texto);
             
            //Se realiza la operacion en este caso la multiplicacion
                int multi=num1*num2;
            
            //Visualiza el resultado
                javax.swing.JOptionPane.showMessageDialog(null,"El resultado de la multiplicacion es: " + multi);
    }
}
