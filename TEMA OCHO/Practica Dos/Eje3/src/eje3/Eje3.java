
package eje3;

import Enumeraciones.*;
import MisClases.*;
import Ventanas.*;
import java.util.ArrayList;
import java.util.regex.*;

public class Eje3 {
    private static ArrayList<Equipo> listaequipos;
    private static ArrayList<Jugador> listajugadores;
    private static Equipo e;
    private static VP v1;
    
    public static void main(String[] args) 
    {
        listaequipos = new ArrayList();
        listajugadores = new ArrayList();
        v1 = new VP();
        v1.setVisible(true);
    }
    
    public static boolean comprobarnombre(String nombre)
    {
        int x;
        for (x =0;x<listaequipos.size() && !listaequipos.get(x).getNombre().equals(nombre);x++){}
        if (x == listaequipos.size())
        {
           return true; 
        }
        else
        {
            return false;
        } 
    }
    
    public static boolean comprobarpuesto(String puesto)
    {
        try
        {
            Posicion.valueOf(puesto);
            return true;
        }
        catch(IllegalArgumentException iae)
        {
            return false;
        }
        
    }
    
    public static boolean comprobarnombrejugador(String nombre)
    {
        int x;
        for (x = 0;x<listajugadores.size() && !listajugadores.get(x).getNombre().equals(nombre);x++){}
        if (x != listajugadores.size())
            return false;
        return true;
    }
    
    public static boolean comprobardorsal(String dorsal)
    {
        int x;
        for (x = 0;x<listajugadores.size() && !listajugadores.get(x).getDorsal().equals(dorsal);x++){}
        if (x != listajugadores.size())
            return false;
        return true;
    }
    
    public static void añadirjugador(String nombre,String puesto,String dorsal)
    {
        Jugador j = new Jugador(nombre,Posicion.valueOf(puesto),dorsal);
        listajugadores.add(j);
    }
    
    public static boolean comprobarexpresionregu(String dato,String expre)
    {
        Pattern pt = Pattern.compile(expre);
        Matcher m = pt.matcher(dato);
        if (!m.matches())
            return false;
        return true;
    }
    
    public static boolean grabar(String nombre,String escudo)
    {   
        e = new Equipo(nombre,escudo);
        e.setListajugador(listajugadores);
        listaequipos.add(e);
        
        listajugadores = new ArrayList();
        
        return true;
    }
    
    public static void salir()
    {
        v1.dispose();
        VSalir v= new VSalir();
        v.setVisible(true);
    }
    
    public static String escudo(int pos)
    {
        String escudo;
        
        escudo = listaequipos.get(pos).getEscudo();
        
        return escudo;
    }
    
    public static int capacidadequipos()
    {
        return listaequipos.size();
    }
    
    public static String mostrar(int x)
    {
        String texto = "";
        
        for (int y = 0;y<listaequipos.get(x).getListajugador().size();y++)
        {
            texto+= "\n      -Nombre: " + listaequipos.get(x).getListajugador().get(y).getNombre() + "\n"
                + "           -Puesto: " + listaequipos.get(x).getListajugador().get(y).getPuesto() + "\n"
                + "           -Dorsal: " + listaequipos.get(x).getListajugador().get(y).getDorsal() + "\n";      
        }
        
        return texto;
    }
    
    public static boolean comprobarsiestarepetido(String nombre)
    {        
        int x;
        int y;
        
        for (x=0;x<listaequipos.size();x++)
        {
            for (y=0;y<listaequipos.get(x).getListajugador().size() && !listaequipos.get(x).getListajugador().get(y).getNombre().equals(nombre);y++){}
            if (y == listaequipos.get(x).getListajugador().size())
                return true;
            return false;
        }
        
        return true;
    }
    
    public static String mostrarnombree(int pos)
    {
        String nombre = listaequipos.get(pos).getNombre();
        return nombre;
    }
    
    public static void finalizar()
    {
        System.exit(0);
    }
}
