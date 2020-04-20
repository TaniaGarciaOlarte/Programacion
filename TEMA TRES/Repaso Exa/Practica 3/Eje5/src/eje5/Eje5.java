/*5. Crear un programa que recoja una fecha introducida por el usuario
como 3 campos numericos (dıa, mes, ano) y devuelva la fecha 100 dıas
posterior mostrada con el formato: Viernes, 16 de noviembre de 2018.*/

package eje5;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.time.LocalDate;

public class Eje5 
{
    public static void main(String[] args) 
    {
        try
        {
            int dia=comprobardia("dia");
            int mes=comprobarmes("mes");
            int año=comprobaraño("año");
            
            LocalDate fecha=plus(dia,mes,año);
            
            fechaesp(fecha);
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
    
    public static int entrada(String variable) throws Exception
    {
       return Integer.parseInt(showInputDialog("Introduce el " + variable + " : "));
    }
    
    public static int comprobardia(String variable) throws Exception
    {
        boolean error;
        int dia=0;
        
        do
        {
            try
            {
                dia=entrada(variable);
                
                if (dia<1 || dia > 31)
                    throw new DiaIncorrecto();
                
                error=true;
            }
            catch(DiaIncorrecto di)
            {
                showMessageDialog(null,"EL DIA INTRODUCIDO ES INCORRECTO (DEL 1 AL 31)");
                error=false;
            }
            catch(NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return dia;
    }
    
    public static int comprobarmes(String variable) throws Exception
    {
        boolean error;
        int mes=0;
        
        do
        {
            try
            {
                mes=entrada(variable);
                
                if(mes<1 || mes>12)
                    throw new MesIncorrecto(); 
                        
                error=true;
            }
            catch (MesIncorrecto mi)
            {
                showMessageDialog(null,"EL MES INTRODUCIDO ES INCORRECTO (DEL 1 AL 12)");
                error=false;
            }
            catch(NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return mes;
    }
    
    public static int comprobaraño(String variable) throws Exception
    {
        boolean error;
        int año=0;
        
        do
        {
            try
            {
                año=entrada(variable);
                
                if(año<1000)
                    throw new AñoIncorrecto(); 
                        
                error=true;
            }
            catch (AñoIncorrecto mi)
            {
                showMessageDialog(null,"EL AÑO INTRODUCIDO ES INCORRECTO (A PARTIR DE 1000)");
                error=false;
            }
            catch(NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return año;
    }
    
    public static LocalDate plus(int dia,int mes,int año) throws Exception
    {
        final int PLUS=100;
        
        LocalDate fecha=LocalDate.of(año,mes,dia);
        fecha=fecha.plusDays(PLUS);
        
        return fecha;
    }
    
    public static void fechaesp(LocalDate fecha) throws Exception
    {     
      String semana=diasemana(fecha);
      String mes=diames(fecha);
       
      showMessageDialog(null,semana + "," + fecha.getDayOfMonth() + " de " + mes + " de " + fecha.getYear());
    }
    
    public static String diasemana(LocalDate fecha) throws Exception
    {
        String dias=null;
        
        switch (fecha.getDayOfWeek())
        {
           case MONDAY:
              dias = "LUNES";
              break;
           case TUESDAY:
              dias = "MARTES";
              break;
           case WEDNESDAY:
              dias = "MIERCOLES";
              break;
           case THURSDAY:
              dias = "JUEVES";
              break;
           case FRIDAY:
              dias = "VIERNES";
              break;
           case SATURDAY:
              dias = "SABADO";
              break;
           default:
              dias = "DOMINGO";
              break;
        }
        return dias;
    }
    
    public static String diames (LocalDate fecha) throws Exception
    {
        String mes=null;
        
        switch (fecha.getMonthValue())
        {
            case 1:
                mes="ENERO";
                break;
            case 2:
                mes="FEBRERO";
                break;
            case 3:
                mes="MARZO";
                break;
            case 4:
                mes="ABRIL";
                break;
            case 5:
                mes="MAYO";
                break;
            case 6:
                mes="JUNIO";
                break;
            case 7:
                mes="JULIO";
                break;
            case 8:
                mes="AGOSTO";
                break;
            case 9:
                mes="SEPTIEMBRE";
                break;
            case 10:
                mes="OCTUBRE";
                break;
            case 11:
                mes="NOVIEMBRE";
                break;
            default:
                mes="DICIEMBRE";
        }
        return mes;
    }
    
    
   
}
