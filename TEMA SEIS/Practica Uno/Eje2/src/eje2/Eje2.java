
package eje2;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import MisClases.*;
import java.util.ArrayList;

public class Eje2 {

    private static ArrayList<Alumno> alumn = new ArrayList();
    
    public static void main(String[] args) 
    {
       try
       {
           do
           {
                entradadatos();    
           }
           while(showConfirmDialog(null,"¿DESEAS INTRODUCIR MAS ALUMNOS?")==0);
           
           buscarcodigo();
       }
       catch (NullPointerException npe)
       {
           showMessageDialog(null,"CANCELADO");
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS:" + e.getClass() + " " + e.getMessage());
       }
    }
    
    public static void entradadatos() throws Exception
    {
        String codigo = null;
        boolean error;
        do{
            try
            {
                codigo = comprobarcodigo("CODIGO:");
                int x;
                for (x = 0;x<alumn.size() && alumn.get(x).getCodigo().equals(codigo)==false;x++){}
                if (x != alumn.size())
                    throw new CodIncorr();
                
                error=true;
            }
            catch (CodIncorr cinc)
            {
                showMessageDialog(null,"ERROR:EL CODIGO QUE HAS INTRODUCIDO YA EXISTE");
                error=false;
            }
        }
        while(!error);
        
        String nombre = comprobarstring("NOMBRE:");
        String domicilio = comprobarstring("DOMICILIO:");
        String telefono = comprobartelefono("TELEFONO:");
        
        Alumno a = new Alumno(codigo,nombre,domicilio,telefono);
        alumn.add(a);
    }
    
    public static String entradaString(String variable) throws Exception
    {
        return showInputDialog("Introduce el valor de " + variable);
    }
    
    public static String comprobarcodigo(String variable) throws Exception
    {
        boolean error;
        String cod = null;
        
        do
        {
            try
            {
                cod = entradaString(variable);
                
                if (cod.isEmpty())
                    throw new CodIncor();
                
                for (int x=0;x<cod.length();x++)
                {
                    if (!Character.isDigit(cod.charAt(x)))
                        throw new CodIncorrecto();
                }

                error=true;
            }
            catch (CodIncor cin)
            {
                showMessageDialog(null,"ERROR:CAMPO VACIO");
                error=false;
            }
            catch (CodIncorrecto ci)
            {
                showMessageDialog(null,"ERROR: SOLO NUMEROS");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return cod;
    }
    
    public static String comprobarstring(String variable) throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = entradaString(variable);
                
                if (ent.isEmpty())
                    throw new EntVacio();
                
                for (int x=0;x<ent.length();x++)
                {
                    if (Character.isDigit(ent.charAt(x)))
                        throw new EntIncorrecto();
                }
                
                error=true;
            }
            catch (EntVacio ev)
            {
                showMessageDialog(null,"ERROR: EL CAMPO ESTA VACIO");
                error=false;
            }
            catch (EntIncorrecto ei)
            {
                showMessageDialog(null,"ERROR: SOLO LETRAS");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }
    
    public static String comprobartelefono(String variable) throws Exception
    {
        boolean error;
        String telef = null;
        
        do
        {
            try
            {
                telef = entradaString(variable);
                
                if(telef.length() !=9)
                    throw new TelefIncorrecto();
                
                if (telef.charAt(0) !='6' && telef.charAt(0) !='7' && telef.charAt(0) !='9')
                    throw new TelefIncorrecto();
                
                for (int x=0;x<telef.length();x++)
                {
                    if (!Character.isDigit(telef.charAt(x)))
                        throw new TelefIncorrecto();
                }
                
                error=true;
            }
            catch (TelefIncorrecto tli)
            {
                showMessageDialog(null,"ERROR: EL NUMERO DE TELEFONO ESTA MAL INTRODUCIDO (9 DIGITOS QUE EMPIECEN POR 6,7 U 9 Y SOLO NUMEROS)");
                error=false;
            }
        }
        while(!error);
        
        return telef;
    }
    
    public static void buscarcodigo() throws Exception
    {
        String cod = comprobarcodigo("CODIGO A BUSCAR:");
        
        int x;
        for (x = 0;x<alumn.size() && alumn.get(x).getCodigo().equals(cod)==false;x++){}
        if (x == alumn.size())
            showMessageDialog(null,"ALUMNO NO ENCONTRADO");
        else
            showMessageDialog(null,alumn.get(x));
    }
}
