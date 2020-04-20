
package eje3;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje3 {

    public static void main(String[] args) 
    {
        int posicion=0;
        
        try{
            char[] array = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            int pos = entradatos(posicion,array);
            String linea="";
        
           while(pos!=-1)
           {
               linea+=array[pos];
               pos=entradatos(posicion,array);
           }
           
            showMessageDialog(null,"Cadena resultante: " + linea);
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getMessage());
        }    
    }
    
    public static int entradatos(int posicion,char[] array) throws Exception
    {
        boolean error;
        do
        {
            try{
                posicion=Integer.parseInt(showInputDialog("Inserta la posición:"));
                
                if (posicion<-1 || posicion>array.length -1)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch(NumeroIncorrecto ni)
            {
                showMessageDialog(null,"ERROR,INSERTE OTRO NUMERO");
                error=false;
            }
        }
        while(!error);
        
      return posicion; 
    }
    
    }

