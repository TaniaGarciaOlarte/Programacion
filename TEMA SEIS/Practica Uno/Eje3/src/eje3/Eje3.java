
package eje3;

import java.time.LocalDate;
import static javax.swing.JOptionPane.*;
import Excepciones.*;
import MisClases.*;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Eje3 
{
    private static ArrayList<Persona> person = new ArrayList();
    private static String texto = "";
    
    public static void main(String[] args) 
    {
        try
        {
            do
            {
                entdatos();
            }
            while(showConfirmDialog(null,"¿DESEAS INTRODUCIR MAS PERSONAS?")==0);
            
            mostrarresult();
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
    
    public static void entdatos() throws Exception
    {
        String nombre = comprobarString("NOMBRE:").toUpperCase();
        
        int dia,mes,año;
        do
        {
            dia = comprobardia("DIA:");
            mes = comprobarmes("MES:");
            año = comprobaraño("AÑO:");
        }
        while(validarfecha(dia,mes,año)==false);
        
        String direccion = comprobarString("DIRECCION:");
        String codpos = comprobarcodigo("CODIGO POSTAL:");
        String ciudad = comprobarString("CIUDAD:");
        
        Persona a = new Persona(nombre,dia,mes,año,direccion,codpos,ciudad);
        person.add(a);
    }
    
    public static String entrString(String variable) throws Exception
    {
        return showInputDialog("Introduce el valor de " + variable);
    }
    
    public static String comprobarString(String variable) throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = entrString(variable);
                
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
                showMessageDialog(null,"ERROR:CAMPO VACIO");
                error=false;
            }
            catch (EntIncorrecto ei)
            {
                showMessageDialog(null,"ERROR:SOLO LETRAS");
                error=false;
            }
        }
        while(!error);
        
        return ent;
    } 
    
    public static int entint(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable));
    }
    
    public static int comprobardia(String variable) throws Exception
    {
        boolean error;
        int dia = 0;
        
        do
        {
            try
            {
                dia = entint(variable);
                
                if (dia <1 || dia>31)
                    throw new DiaIncorrecto();
                
                error=true;
            }
            catch (DiaIncorrecto di)
            {
                showMessageDialog(null,"ERORR:DIA INCORRECTO (DEL 1 AL 31)");
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
    
    public static int comprobarmes(String variable) throws Exception
    {
        boolean error;
        int mes = 0;
        
        do
        {
            try
            {
                mes = entint(variable);
                
                if (mes <1 || mes>12)
                    throw new MesIncorrecto();
                
                error=true;
            }
            catch (MesIncorrecto di)
            {
                showMessageDialog(null,"ERORR:MES INCORRECTO (DEL 1 AL 12)");
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
    
    public static int comprobaraño(String variable) throws Exception
    {
        boolean error;
        int año = 0;
        
        do
        {
            try
            {
                año = entint(variable);
                
                if (año<1000 || año>LocalDate.now().getYear())
                    throw new AñoIncorrecto();
                
                error=true;
            }
            catch (AñoIncorrecto di)
            {
                showMessageDialog(null,"ERORR:AÑO INCORRECTO (DEL AÑO 1000 AL " + LocalDate.now().getYear()+")");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return año;
    }
    
    public static boolean validarfecha(int dia,int mes,int año) throws Exception
    {
        try
        {
            LocalDate fecha = LocalDate.of(año,mes, dia);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            formato.format(fecha);
            
            return true;
        }
        catch (DateTimeException dte)
        {
            showMessageDialog(null,"LA FECHA INTRODUCIDA ES INCORRECTA");
            return false;
        }
    }
    
    public static String comprobarcodigo(String variable) throws Exception
    {
        boolean error;
        String cod = null;
        
        do
        {
            try
            {
                cod = entrString(variable);
                
                if (cod.length()!=5)
                    throw new CodIncorrecto();
                
                for (int x=0;x<cod.length();x++)
                {
                   if (!Character.isDigit(cod.charAt(x)))
                       throw new CodIncorrecto();
                }
                error=true;
            }
            catch (CodIncorrecto ci)
            {
                showMessageDialog(null,"ERROR:CODIGO POSTAL INCORRECTO(5 DIGITOS Y SOLO NUMEROS)");
                error=false;
            }
        }
        while(!error);
        
        return cod;
    }
    
    public static void mostrarresult() throws Exception
    {
        //PERSONA QUE TIENE LA MAYOR EDAD
            pqme();
        //PERSONAS QUE VIVEN EN ELCHE
            pqe();
        //PERSONAS MAYORES DE EDAD
            pme();
            
        showMessageDialog(null,texto);    
    }
    
    public static void pqme() throws Exception
    {
        int max = 0;
        String posicion="";
        
        for (int x=0;x<person.size();x++)
            {
                int edad = person.get(x).calcularedad();
                
                if (edad > max)
                {
                   posicion = person.get(x).getNombre();
                   max = edad;
                }
            }
        
        texto += "LA PERSONA QUE MAS EDAD TIENE ES: \n"
                + posicion + " Y TIENE " + max + " AÑOS" + "\n";
    }
    
    public static void pqe() throws Exception
    {
        String nombres = "";
            for (int x=0;x<person.size();x++)
            {
                if (person.get(x).getCiudad().compareToIgnoreCase("Elche")==0)
                {
                   nombres += " - " + person.get(x).getNombre() + "\n";
                }
            }
            
            if (nombres.compareTo("")!=0)
                texto += "PERSONAS QUE VIVEN EN ELCHE: \n"
                        + nombres + "\n";
            else
                texto += "NO HAY PERSONAS QUE VIVAN EN ELCHE  \n";
    }
    
    public static void pme() throws Exception
    {
        String mayoredad = "";
        
        for (int x=0;x<person.size();x++)
            {
                if (person.get(x).esMayor())
                {
                   mayoredad += " - " + person.get(x).getNombre() + "\n";
                }
            }
        
        if (mayoredad.compareTo("")!=0)
            texto += "PERSONAS QUE SON MAYORES DE EDAD: \n"
                    + mayoredad + "\n";
        else
            texto += "NO HAY PERSONAS MAYORES DE EDAD:\n\n";
    }
    
    
}
