
package eje4;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje4 
{
    public static void main(String[] args) 
    {
        String entrada;
        try
        {
            String[] array={"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
            entrada=entradadatos(array);
            
            comprobacion(entrada,array);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getMessage());
        }
    } 
    
    public static String entradadatos(String[] array) throws Exception
    {
        String ent = null;
        boolean error;
        
        do{
            try
            {
                ent=showInputDialog("Introduce un mes:").toUpperCase();

                if (ent.isEmpty())
                    throw new CampoVacio();
                
                for (int i=0; i < ent.length();i++)
                {
                    if (Character.isDigit(ent.charAt(i)))
                        throw new EntradaIncorrecta();
                }
                
                error=true;
            }
            catch (EntradaIncorrecta ei)
            {
                showMessageDialog(null,"SOLO CARACTERES");
                error=false;
            }
            catch (CampoVacio cv)
            {
                showMessageDialog(null,"EL CAMPO NO SE PUEDE DEJAR VACIO INTRODUZCA UN CONTENIDO");
                error=false;
            }
        }
        while(!error);
        
      return ent;
    }
    
    public static void comprobacion(String entrada,String[] array) throws Exception
    {
        boolean error=false;
        
            for (int i=0;i<array.length;i++)
            {
                if (array[i].equals(entrada))
                {
                    error=true;
                }
            }
            
            if (error==true)
            {
              showMessageDialog(null,"El mes: " + entrada + " es CORRECTO");
            }
            else
            {
              showMessageDialog(null,"El mes: " + entrada + " es INCORRECTO");
            }
        }
    }

