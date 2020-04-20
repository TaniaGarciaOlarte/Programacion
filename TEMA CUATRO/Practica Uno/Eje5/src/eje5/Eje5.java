
package eje5;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje5 
{
    public static void main(String[] args) 
    {
        try
        {
            double [] array = new double[12];
            
            do
            {
                 int dia=comprobardia();
                 int mes=comprobarmes();
                 double litros=comprobarlitros();
                 
                 array[mes-1] +=litros;
            }
            while(showConfirmDialog(null,"¿DESEAS INTRODUCIR MAS LITROS?")==0);
            
            mensaje(array);
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS" + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static int entradaint(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable + ":"));
    }
    
    public static int comprobardia() throws Exception
    {
        boolean error;
        int dia=0;
        
        do
        {
            try
            {
                dia=entradaint("dia");
                
                if (dia<1 || dia>31)
                    throw new DiaIncorrecto();
                
                error=true;
            }
            catch (DiaIncorrecto di)
            {
                showMessageDialog(null,"DIA INCORRECTO (DEL 1 AL 31)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return dia;
    }
    
    public static int comprobarmes() throws Exception
    {
        boolean error;
        int mes=0;
                
        do
        {
            try
            {
                mes=entradaint("mes");
                
                if (mes<1 || mes >12)
                    throw new MesIncorrecto();
                
                error=true;
            }
            catch (MesIncorrecto mi)
            {
                showMessageDialog(null,"MES INCORRECTO (DEL 1 AL 12)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return mes;
    }
    
    public static double comprobarlitros() throws Exception
    {
        boolean error;
        double litros=0;
        
        do
        {
            try
            {
                litros=Double.parseDouble(showInputDialog("Introduce los litros mensuales:"));
                
                if (litros <1)
                    throw new LitrosIncorrectos();
                
                error=true;
            }
            catch(LitrosIncorrectos li)
            {
                showMessageDialog(null,"LITROS INCORRECTOS (MINIMO 1)");
                error=false;
            }
            catch(NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return litros;
    }
    
    public static void mensaje(double[] array) throws Exception
    {   
        String litrosint="";
        
        for (int x=0;x<array.length;x++)
            litrosint+= (x+1) + " - " + array[x] + "\n";
        
        showMessageDialog(null,"LITROS MENSUALES:\n" + litrosint);
    }
}
