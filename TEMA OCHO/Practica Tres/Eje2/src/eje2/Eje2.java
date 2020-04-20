
package eje2;

import MisClases.*;
import Ventanas.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.*;

public class Eje2 {

    public static ArrayList<Hijo> listahijos = new ArrayList();
    public static ArrayList<Socio> listasocios;
    public static VP v;
    public static Socio s;
    public static VBorrar vb;
    public static SocioFamiliar sf;
    public static SocioIndividual sc;
    
    public static void main(String[] args) {
        listasocios = new ArrayList();
        v = new VP();
        v.setVisible(true);
    }
    
    public static boolean expreregular(String dato,String expre)
    {
        Pattern pt = Pattern.compile(expre);
        Matcher m = pt.matcher(dato);
        if (!m.matches())
            return false;
        return true;
    }
    
    public static void crearlista()
    {
        listahijos = new ArrayList();
    }
    
    public static void abrirborrar()
    {
        vb = new VBorrar(v,true);
        vb.setVisible(true);
    }
    
    public static int comprobarhijo()
    {
        return listahijos.size();
    }
    
    public static boolean comprobarsiexiste(String nombre,String apellidos)
    {
        int y;
        for (y=0; y<listasocios.size() && !listasocios.get(y).getNombre().equals(nombre);y++){}
        if (y == listasocios.size())
           return false;
        else
        {
            int x;
            for (x=0; x<listasocios.size() && !listasocios.get(x).getApellidos().equals(apellidos);x++){}
            if (x == listasocios.size())
                return false;
            return true;
        }
    }
    
    public static void añadirsocioindi(String nombre,String apellidos,String telefono,String correo)
    {
        sc = new SocioIndividual(nombre,apellidos,telefono,correo);
        listasocios.add(sc);
    }
    
    public static void añadirsociofam(String nombre,String apellidos,String telefono,String correo)
    {
        sf = new SocioFamiliar(nombre,apellidos,telefono,correo);
        sf.setListahijos(listahijos);
        listasocios.add(sf);
    }
    
    public static void añadirhijo(String nombre,LocalDate fecha)
    {
        Hijo h = new Hijo (nombre,fecha);
        listahijos.add(h);
    }
    
    public static int comprobarsocio()
    {
        return listasocios.size();
    }
    
    public static boolean comprobarcorreo(String correo)
    {
        int x;
        for (x=0;x<listasocios.size() && !listasocios.get(x).getCorreo().equals(correo);x++){}
        if (x==listasocios.size())
            return false;
        return true;
    }
    
    public static String mostrardatos(int x)
    {
        String texto = "";
        
        Hijo h = listahijos.get(x);
        texto += h.toString();
        
        return texto;
    }
    
    public static void borrartodo()
    {
       listahijos.clear();
    }
    
    public static void eliminarhijo(int x)
    {
        listahijos.remove(x);
    }
    
    public static void actualizar()
    {
        vb.dispose();
        
        vb = new VBorrar(v,true);
        vb.setVisible(true);
    }
    
    public static String mostrardatossocio()
    {
        String texto = "";
        
        for (int x=0;x<listasocios.size();x++)
        {
            texto += "Datos socio numero de la posicion: " + x + "\n";
            try
            {
                sf = (SocioFamiliar) listasocios.get(x);
                
                        texto += "     Nombre: " + listasocios.get(x).getNombre() + 
                        "\n     Apellidos: " + listasocios.get(x).getApellidos() + 
                        "\n     Telefono: " + listasocios.get(x).getTelefono() + 
                        "\n     Correo: " + listasocios.get(x).getCorreo() +
                        "\n     Hijos: " + "\n";
                for (int y=0;y<sf.getListahijos().size();y++)
                {
                            texto += "       -Hijo numero: " + y+1 + "\n"
                            + "           Nombre: " + sf.getListahijos().get(y).getNombre() + "\n"
                            + "           Fecha Nac: " + sf.getListahijos().get(y).getFechanac() + "\n";
                }
                texto += "-------------------------------------------------------------------------------\n";
            }
            catch (ClassCastException e)
            {
                sc = (SocioIndividual) listasocios.get(x);
                texto +="     Nombre: " + listasocios.get(x).getNombre() + 
                        "\n     Apellidos: " + listasocios.get(x).getApellidos() + 
                        "\n     Telefono: " + listasocios.get(x).getTelefono() + 
                        "\n     Correo: " + listasocios.get(x).getCorreo() + "\n"
                        + "----------------------------------------------------------------\n";
            }
        }
        
        return texto;
    }
}
