
package eje22;

import MisClases.*;
import java.util.ArrayList;
import java.util.regex.*;
import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.time.LocalDate;
import java.time.format.*;

public class Eje22 {
    private static ArrayList<Obra> obras = new ArrayList();
    private static ArrayList<Artista> artistas = new ArrayList();
    
    public static void main(String[] args) 
    {
        try
        {
            alta();
            mostrardatos();
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
    
    public static void alta() throws Exception
    {
        do
        {
            String titulo = obtenerdato("EL TITULO DE LA OBRA","^[a-z]+([ ][a-z]+)?");
            int añoedi = obteneraño();
            String tipo = obtenerdato("EL TIPO DE OBRA","^(libro|pelicula|disco)$");
            
            opciones(titulo,añoedi,tipo);
        }
        while(showConfirmDialog(null,"¿QUIERES AÑADIR MAS OBRAS?")==0);
    }
    
    public static String obtenerdato(String dato,String expre)
    {
        boolean error;
        String d = null;
        
        do
        {
            try
            {
                d = showInputDialog("introduce " + dato + ":").toLowerCase();
                
                Pattern pt = Pattern.compile(expre);
                Matcher m = pt.matcher(d);
                
                if (!m.matches())
                    throw new DatoNoValido(d);
                
                error = true;
            }
            catch (DatoNoValido dnv)
            {
                showMessageDialog(null,dnv.getCampo());
                error = false;
            }
        }
        while(!error);
        
        return d;
    }
    
    public static int obteneraño()
    {
        boolean error;
        String añoedi = "";
        
        do
        {
            try
            {
                añoedi = showInputDialog("TECLEA EL AÑO DE EDICIÓN DE LA OBRA");
                
                Pattern pt = Pattern.compile("^[0-9]{4}$");
                Matcher m = pt.matcher(añoedi);
                if (!m.matches())
                    throw new DatoNoValido("AÑO DE EDICIÓN");
                
                comprobardiferencia(añoedi);
                
                error = true;
           
            }
            catch (DatoNoValido dnv)
            {
                showMessageDialog(null,dnv.getCampo());
                error = false;
            }
        }
        while(!error);
        
        return Integer.parseInt(añoedi);
    }
    
    public static void comprobardiferencia(String añoedi) throws DatoNoValido
    {
        int añoa = LocalDate.now().getYear();
        int diferencia = añoa - Integer.parseInt(añoedi);
        
        if (diferencia > 100)
            throw new DatoNoValido("AÑO DE EDICIÓN");
    }
    
    public static void opciones(String titulo,int añoedi,String tipo) throws Exception
    {
        switch (tipo)
        {
            case "libro":
                datoslibro(titulo,añoedi);
                break;
            case "disco":
                datosdisco(titulo,añoedi);
                break;
            default:
                datospeli(titulo,añoedi);
        }
    }
    
    public static void datoslibro(String titulo,int añoedi) throws Exception
    {
        String editorial = obtenerdato("LA EDITORIAL DEL LIBRO","^[a-z]+([ ][a-z]+)?");
        int numeropaginas = Integer.parseInt(obtenerdato("NUMERO DE PAGINAS DEL LIBRO","^[1-9][0-9]{0,4}$"));
        
        Libro l = new Libro(editorial,numeropaginas,titulo,añoedi);
        añCreadores(l);
        
        obras.add(l);
    }
    
    public static void datosdisco(String titulo,int añoedi) throws Exception
    {
        String discografica = obtenerdato("LA DISCOGRAFICA DEL DISCO","^[a-z]+([ ][a-z]+)?");
        int numerocan = Integer.parseInt(obtenerdato("NUMERO DE CANCIONES DEL DISCO","^[1-9][0-9]*$"));
        
        Disco d = new Disco(discografica,numerocan,titulo,añoedi);
        añCreadores(d);
        
        obras.add(d);
    }
    
    public static void datospeli(String titulo,int añoedi) throws Exception
    {
        String productora = obtenerdato("LA PRODUCTORA DE LA PELI","^[a-z]+([ ][a-z]+)?");
        int duracion = Integer.parseInt(obtenerdato("LA DURACION DE LA PELI","^[1-9][0-9]*$"));
        
        Pelicula p = new Pelicula(productora,duracion,titulo,añoedi);
        añCreadores(p);
        añartista(p);
        
        obras.add(p);
    }
    
    public static void añCreadores(Obra o) throws Exception
    {        
        do
        {
            Artista a = datoscrea();
            
            a.setObra(o);
            o.setArtista(a);
        }
        while(showConfirmDialog(null,"¿DESEAS AÑADIR MAS ARTISTAS CREADORES?")==0);
    }
    
    public static void añartista(Pelicula p) throws Exception
    {
        do
        {
            Artista a = datoscrea();
            
            a.setPelicula(p);
        }
        while(showConfirmDialog(null,"¿HAY MAS ARTISTAS QUE INTERVIENEN?")==0);
    }
    
    public static Artista datoscrea() throws Exception
    {   
        String nombre = obtenerdato("EL NOMBRE DEL ARTISTA CREADOR","^[a-z]+([ ][a-z]+)?");
                
        Artista a = comprobarsino(nombre);
        
        return a;
    }
    
    public static Artista comprobarsino(String nombre) throws Exception
    {
        Artista a = null;
        
        int x;
        for (x = 0; x < artistas.size()&& artistas.get(x).getNombre().compareTo(nombre)!=0;x++){}
        if (x == artistas.size())
        {
            //ES NUEVO
                a = new Artista(nombre,obtenerfechanac());
                artistas.add(a);
        }
        else
        {   
            //YA EXISTE
                a = artistas.get(x);
        }
        
        return a;
    }
    
    public static LocalDate obtenerfechanac() throws Exception
    {
        LocalDate fecha = null;
        boolean error;
        
        do
        {
            try
            {
                String f = obtenerdato("LA FECHA DE NACIMIENTO DEL ARTISTA","^\\d{2}/\\d{2}/\\d{4}$");
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fecha = LocalDate.parse(f,dtf);
                
                error = true;
            }
            catch (DateTimeParseException dtpe)
            {
                showMessageDialog(null,"LA FECHA DE NACIMIENTO no es valida");
                error = false;
            }
        }
        while(!error);
        
        return fecha;
    }
    
    public static void mostrardatos()
    {
        //OBRAS
            for (Obra o:obras)
                //PELICULA
                    if (o instanceof Pelicula)
                    {
                        Pelicula p = (Pelicula) o;
                        showMessageDialog(null,p.toString());
                    }
                    else
                        //DISCO
                            if (o instanceof Disco)
                            {
                                Disco d = (Disco) o;
                                showMessageDialog(null,d.toString());
                            }
                            //LIBRO
                                else
                                {
                                    Libro l = (Libro) o;
                                    showMessageDialog(null,l.toString());
                                }
        
        //ARTISTA
            for (Artista a: artistas)
                showMessageDialog(null,a.toString2());
            
    }
}
