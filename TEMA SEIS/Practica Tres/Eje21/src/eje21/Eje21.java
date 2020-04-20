
package eje21;

import MisClases.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;

public class Eje21 {
    private static ArrayList<Alumno> alumnos = new ArrayList();
    
    public static void main(String[] args) 
    {
        try
        {
            do
            {
                entradadatos();
            }
            while(showConfirmDialog(null,"¿DESEAS INTRODUCIR MAS ALUMNOS?")==0);
            
            busquedacodigo();
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
    
    public static void entradadatos()
    {  
       //Introducir datos
            String codigo = obtenercodigo();
            String nombre = obtenerdato("NOMBRE","^[A-Za-z]+( [A-Za-z]+)*$");
         // uoof1 → ñ y u00dl → Ñ 
            String domicilio = obtenerdato("DOMICILIO","^C/[A-Za-z\\u00f1\\u00d1]+( [A-Za-z\\u00f1\\u00d1]+)*[ ][0-9]{1,2}[ ][0-9]{1,2}º[A-Z]$");
            String telefono = obtenerdato("TELEFONO","^(6|7)[0-9]{8}$");
            int edad = Integer.parseInt(obtenerdato("EDAD","^[0-9]{2}$"));
            char sexo = obtenerdato("SEXO","^[HMO]$").charAt(0);
            LocalDate fecha = obtenerfecha();
            String empart = obtenerdato("DIRECCION DE CORREO ELECTRONICO PERSONAL","^[-a-zA-z0-9_]+(.[-a-zA-Z0-9_]+)*@(gmail|hotmail)+.(com|es|org)$");
            String emcentro = obtenerdato("DIRECCION DE CORREO ELECTRONICO DEL CENTRO","^[A-Za-z]+.[A-Za-z]+@ikasle.egibide.org$");
            String pagweb = obtenerpagweb();
            String curso = obtenerdato("CURSO","^1(1[1-4][A-D]|[234][1-2][A-M])[ABD]$");
            String estado = obtenerdato("ESTADO CIVIL","^(casado|soltero|casada|soltera)$");
            
            Alumno a = new Alumno(codigo,nombre,domicilio,telefono,edad,sexo,fecha,empart,emcentro,pagweb,curso,estado);
            
            alumnos.add(a);       
    }
    
    public static String obtenercodigo()
    {
        boolean error;
        String cod = null;
        
        do
        {
            try
            {
                cod = obtenerdato("CODIGO","^[0-9]{5}$");
                
                int x;
                for (x=0;x<alumnos.size()&& !alumnos.get(x).getCodigo().equals(cod);x++){}
                if (x!=alumnos.size())
                    throw new CodiInt();
                
                error = true;
            }
            catch (CodiInt ci)
            {
                showMessageDialog(null,"Error:El codigo del alumno ya esta en el arraylist");
                error = false;
            }
        }
        while(!error);
        
        return cod;
    }
    
    public static String obtenerdato(String ent,String expre)
    {
        String dato = null;
        boolean error;
        
        do
        {
            try
            {
                dato = showInputDialog("Introduce el " + ent + " del alumno:");
                Pattern pt = Pattern.compile(expre);
                Matcher m = pt.matcher(dato);
                 if (!m.matches())
                     throw new DatoIncorr(ent);
                 
                 error = true;
            }
            catch (DatoIncorr di)
            {
                showMessageDialog(null,di.getErr());
                error = false;
            }
        }
        while(!error);
        
        return dato;
    }
    
    public static LocalDate obtenerfecha()
    {
        LocalDate fecha = null;
        boolean error;
        
        do
        {
            try
            {
                String f = showInputDialog("Introduce la FECHA DE NACIMIENTO del alumno");
                Pattern pt = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}");
                Matcher m = pt.matcher(f);
                
                if (!m.matches())
                    throw new DatoIncorr(f);
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fecha = LocalDate.parse(f,dtf);
                
                error = true;
            }
            catch (DatoIncorr di)
            {
                showMessageDialog(null,di.getErr());
                error = false;
            }
            catch (DateTimeException dte)
            {
                showMessageDialog(null,"La fecha de nacimiento no es valida");
                error = false;
            }
        }
        while(!error);
        
        return fecha;
    }
    
    public static String obtenerpagweb()
    {
        String pag = "";
        int respuesta = showConfirmDialog(null,"¿DESEAS INTRODUCIR LA PAGINA WEB?");
        
        while (respuesta == 0)
            {
                pag = obtenerdato("paginaweb","^www.[a-zA-Z]+.com$");
                respuesta = 1;
            }
        
        return pag;
    }
    
    public static void busquedacodigo()
    {
        do
        {
           String codigo = obtenerdato("CODIGO DE BUSQUEDA","^[0-9]{5}$");
        
           int x;
           for (x=0;x<alumnos.size() && !alumnos.get(x).getCodigo().equals(codigo);x++){}
           if (x == alumnos.size())
               showMessageDialog(null,"ALUMNO NO ENCONTRADO");
           else
             showMessageDialog(null,"INFORMACIÓN DEL ALUMNO: \n" + alumnos.get(x).toString()); 
        }
        while (showConfirmDialog(null,"¿DESEAS REALIZAR MAS BUSQUEDAS?")==0);
    }
}
