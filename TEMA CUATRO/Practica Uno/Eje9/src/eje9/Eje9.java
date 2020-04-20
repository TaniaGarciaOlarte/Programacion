
package eje9;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.util.Arrays;

public class Eje9 
{
    private final static int[] codprod = {10,23,30,47,55,65,135,256,526,633};
    private static int[] unidades = new int [10];
    private static int posicion;
    
    public static void main(String[] args) 
    {
        try
        {
            do
            {
                entradadatos();
                posicion=0;
            }
            while (showConfirmDialog(null,"¿DESEAS CONTINUAR?")==0);
            
            ordenardatos();
            salidadatos();
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static void entradadatos () throws Exception
    {
        comprobarcodigo();
        int uni = comprobarunidades();
                
        unidades[posicion] += uni;
    }
    
    public static int entradaint(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable));
    }
    
    public static int comprobarcodigo () throws Exception
    {
        boolean error;
        int codigo=0;
        
        do
        {
            try
            {
              codigo = entradaint("codigo");
              busquedacodigo(codigo);

              error=true;
            }
            catch (CodigoIncorrecto ci)
            {
              String texto="LOS CODIGOS DE PRODUCTO SON: \n";
              
              for (int x=0;x<codprod.length;x++)
                  texto+=codprod[x] + "\n";
              
              showMessageDialog(null,texto);
              
              error=false;  
            }
            catch (NumberFormatException nfe)
            {
              showMessageDialog(null,"SOLO NUMEROS");
              error=false;  
            }
        }
        while (!error);
        
        return codigo;
    }
    
    public static void busquedacodigo(int codigo) throws Exception
    {
        int result = Arrays.binarySearch(codprod,codigo);
        
        if (result < 0)
            throw new CodigoIncorrecto();
        
        posicion=result;
    }
    
    public static int comprobarunidades() throws Exception
    {
        boolean error;
        int unidades=0;
        
        do
        {
            try
            {
                unidades=entradaint("unidades");
                
                if (unidades < 1)
                    throw new UnidadesIncorrectas();
                
                error=true;
            }
            catch (UnidadesIncorrectas ui)
            {
                showMessageDialog(null,"UNIDADES INCORRECTAS (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return unidades;
    }
    
    public static void ordenardatos() throws Exception
    {
        int auxiliar;

            for (int x = 0; x < unidades.length - 1; x++)
            {
                for (int y = x+1 ;y <unidades.length; y++)
                {
                        if (unidades[x] < unidades[y])
                        {
                          auxiliar = unidades[x];
                          unidades[x] = unidades[y];
                          unidades[y] = auxiliar;

                          auxiliar = codprod[x];
                          codprod[x] = codprod[y];
                          codprod[y] = auxiliar;                  
                        }
                }
             }
    }
    
    public static void salidadatos() throws Exception
    {
        int total=0;
        String texto = "PRODUCTO    UNIDADES VENDIDAS \n ------------------------------------------------\n";
        
        for (int x=0;x<codprod.length;x++)
        {
            texto += codprod[x] + "               " + unidades[x] + "\n";
            total += unidades[x];
        }
        
        showMessageDialog(null,texto + "\n EL TOTAL DE UNIDADES VENDIDAS HAN SIDO: " + total);
    }
}
