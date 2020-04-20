package ejercicio4;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import Excepciones.*;


public class Ejercicio4 
{
    public static void main(String[] args) 
    {
      try{
      String nombre = null;
      double resultadoc=0,resultado=0,resultadototal=0;
      int contador=0;
      
      do
      {
        nombre=comprobarnombre(nombre);
        
        if (nombre.compareToIgnoreCase("fin")!=0)
        {
            resultado=notamedia(resultado);
        }
        
        resultadoc+=resultado;
        contador++; 
      }
      while (!nombre.equalsIgnoreCase("fin"));
      
      resultadototal=resultadoc/contador;
      showMessageDialog(null,"La media del conjunto de alumnos es: " + resultadototal);
      
    }
      catch(Exception e)
      {
          showMessageDialog(null,"Problemas");
      }
    }
    
    public static String comprobarnombre(String nombre) throws Exception
    {
        try
        {
            nombre=showInputDialog("Introduce el nombre del alumno:");
      
        if (!nombre.matches(".*[a-z].*")) 
            throw new NombreFallido();
        }
        
        catch (NombreFallido e)
        {
          showMessageDialog(null,"Error solo se pueden introducir letras");
        }
        return nombre;
    }
    
    public static double notamedia(double resultado) throws Exception
    {
        double nota = 0,resultadosuma=0;
        for (int i=1;i<=6;i++)
        {
            try{
             nota=Double.parseDouble(showInputDialog("Introduce la nota:"));
            
            if (nota<0 || nota>10)
            {
                throw new NotaIncorrecta();
            }
            else
            {
                resultadosuma+=nota;
                resultado=resultadosuma/i;
            }
            
        }
            catch (NotaIncorrecta e)
        {
            showMessageDialog(null,"Error la nota introducida es incorrecta");
        }
        }
        showMessageDialog(null,"La nota media del alumno es:" + resultado);
        
     return resultado;
    }
}
