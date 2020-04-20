
package eje8;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Eje8 
{
    private static int [][] faltas = new int [5][30];
    private static int[] codalum = new int [5];
    
    public static void main(String[] args) 
    {            
        try
        {
            entradadatos();
        }
        catch (ArrayIndexOutOfBoundsException aiob)
        {   
            String linea="ERROR:YA HAS INTRODUCIDO 5 CODIGOS \n "
                    + "LOS CODIGOS DE ALUMNOS SON: \n";
            
            for (int x=0;x<codalum.length;x++)
            {
                linea+=codalum[x] + " ";
            }
            
            showMessageDialog(null,linea);
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
    
    public static void entradadatos() throws Exception
    {
        boolean error;
        int dia=0;
        
        do{
            int codigo=comprobarcodigo();
            
            do
            {
                try
                {
                    dia=comprobardias();
                    int año=comprobaraño();
                    
                    LocalDate fecha=LocalDate.of(año,11,dia);
                    
                    if (fecha.getDayOfWeek().compareTo(DayOfWeek.SUNDAY)==0 || fecha.getDayOfWeek().compareTo(DayOfWeek.SATURDAY)==0)
                        throw new DiaSIncorrecto();
                    
                    if (fecha.getDayOfMonth()==1)
                        throw new DiaFestivo();
                    
                    error=true;
                }
                catch (DiaSIncorrecto dsi)
                {
                    showMessageDialog(null,"EL DIA DE LA SEMANA ES INCORRECTO (DE LUNES A VIERNES)");
                    error=false;
                }
                catch (DiaFestivo df)
                {
                    showMessageDialog(null,"ERROR:EL DIA INTRODUCIDO ES FESTIVO");
                    error=false;
                }
            }
            while(!error);
            
            int falt=comprobarfaltas();
        
            contarfaltas(codigo,falt,dia);
            
        }
        while(showConfirmDialog(null,"¿DESEAS CONTINUAR?")==0);
        
        salidadatos();
    }
    
    public static int entint(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable + ":"));
    }
    
    public static int comprobarcodigo() throws Exception
    {
        boolean error;
        int codigo=0;
        do
        {
            try
            {
                codigo=entint("codigo alumno");
                
                if (codigo<1)
                    throw new CodigoIncorrecto();
                
                error=true;
            }
            catch (CodigoIncorrecto ci)
            {
                showMessageDialog(null,"CODIGO INCORRECTO:MINIMO 1");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return codigo;
    }
    
    public static int comprobardias() throws Exception
    {
        boolean error;
        int dia=0;
        
        do
        {
            try
            {
                dia=entint("dia");
                
                if (dia<1 || dia > 30)
                    throw new DiaIncorrecto();
                
                error=true;
            }
            catch (DiaIncorrecto di)
            {
                showMessageDialog(null,"EL DIA INTRODUCIDO ES INCORRECTO (DEL 1 AL 30)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
        return dia;
    }
    
    public static int comprobaraño() throws Exception
    {
        boolean error;
        int año=0;
        
        do
        {
            try
            {
                año=entint("año");
                
                if (año<1000)
                    throw new AñoIncorrecto();
                
                error=true;
            }
            catch (AñoIncorrecto di)
            {
                showMessageDialog(null,"EL AÑO INTRODUCIDO ES INCORRECTO (MINIMO 1000)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
        return año;
    }
    
    public static int comprobarfaltas() throws Exception
    {
        boolean error;
        int faltas=0;
        
        do
        {
            try
            {
                faltas=entint("faltas");
                
                if (faltas < 1)
                    throw new FaltasIncorrectas();
              
                error=true;
            }
            catch(FaltasIncorrectas fi)
            {
                showMessageDialog(null,"NUMERO DE FALTAS INCORRECTAS (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return faltas;
    }
    
    public static void contarfaltas(int codigo,int falt,int dia) throws Exception
    {
        int x=0;
        
        for(x=0; x<codalum.length && codalum[x]!=0 && codalum[x]!=codigo; x++){}
                        
            if (codalum[x]==0)
               codalum[x]=codigo;
            
            faltas[x][dia]= falt; 
    }
    
    public static void salidadatos() throws Exception
    {
        String linea="LISTA DE ALUMNOS CON SUS FALTAS: \n";
        
        for(int y=0; y<codalum.length && codalum[y]!=0; y++)
        {  
          int suma = 0;
          
          for(int x = 0; x < faltas[y].length; x++)
              suma += faltas[y][x];
          
          linea+= "El codigo " + codalum[y]+ " a faltado " +suma+ " horas \n";
        }
        
        showMessageDialog(null, linea);
    }
}
