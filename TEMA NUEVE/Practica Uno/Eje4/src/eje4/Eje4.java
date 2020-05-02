
package eje4;

import BaseDeDatos.*;
import MisClases.*;
import Tablas.*;
import Ventanas.*;
import java.time.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

public class Eje4 {
    private static VentanaPrincipal vp;
    private static VentanaBorraryModificar vb;
    private static VentanaCrear vc;
    
    private static TablaAcontecimiento ta;
    
    private static Acontecimiento a;
    
    private static BaseDeDatos bd;
    
    private static ArrayList<Acontecimiento> lista;
    private static String[] lugares = {"Artium","Buesa Arena","Iradier Arena","Mendizorroza","Teatro Principal"};
    
    public static void main(String[] args) {
        try
        {
            bd = new BaseDeDatos();
            bd.conectar();
            
            ta = new TablaAcontecimiento(bd.getCon());
        
            vp = new VentanaPrincipal();
            vp.setVisible(true);
        }
        catch (Exception e)
        {
            bd.desconectar();
            showMessageDialog(null,e.getMessage());
        }
    }
    
    public static void mostrarv(String operacion)
    {
        vp.setVisible(false);
        
        if (operacion.equals("Crear"))  
        {
            vc = new VentanaCrear(vp,true);
            visibilizar(vc);
        } 
        else
        {
            vb = new VentanaBorraryModificar(vp,true,operacion);
            visibilizar(vb);
        } 
    }
    
    public static void visibilizar(javax.swing.JDialog jd)
    {            
        jd.setVisible(true);
    }
    
    public static void salirv(javax.swing.JDialog jd)
    {
        jd.dispose();
        vp.setVisible(true);
    }
    
    public static boolean buscarnombre(String nombre) throws Exception
    {
        a = ta.buscarnombre(nombre);
        return a != null;
        
        /*
            if (a == null)
                return false;
            return true;
        */
    }
    
    public static boolean comprobarlugar(String lugar,LocalDate fecha,LocalTime hi,LocalTime hf) throws Exception
    {
        a = ta.buscarporlugaruno(lugar, fecha,hi);
        
        if (a!=null)
            return true;
        else
        {
            a = ta.buscarporlugardos(lugar,fecha,hi,hf);
                return a !=null;
                /*if (a !=null)
                    return true;
                return false;*/
        }
    }
    
    public static void insertar(String nombre,String lugar,LocalDate fecha,LocalTime hi,LocalTime hf,Integer aforo) throws Exception
    {
        a = new Acontecimiento(nombre,lugar,fecha,hi,hf,aforo);
        ta.insertar(a);
    }
    
    public static void borrartodo(javax.swing.JDialog jd) throws Exception
    {
        ta.borrartodo();
        showMessageDialog(jd,"TODOS LOS DATOS SE HAN ELIMINADO CORRECTAMENTE");
        salirv(jd);
    }
    
    public static void borrar(String nombre,javax.swing.JDialog jd) throws Exception
    {
        ta.borrarnombre(nombre);
        showMessageDialog(jd,"EL EVENTO " + nombre + " SE HA ELIMINADO CORRECTAMENTE");
        salirv(jd);
    }
    
    public static void salir()
    {
        bd.desconectar();
        vp.dispose();
    }
    
    public static int cantidadeventos() throws Exception
    {
        lista = ta.mostrartodo();
        return lista.size();
    }
    
    public static void mostrarnombre(javax.swing.JComboBox jc) throws Exception
    {
        lista = ta.mostrartodo();
        
        for (int x=0;x<lista.size();x++)
        {
            jc.addItem(lista.get(x).getNombre());
        }
    }
    
    public static void llenarlugar(javax.swing.JComboBox jc,String nombre) throws Exception
    {
        a = ta.buscarnombre(nombre);
        
        for (int x=0;x<lugares.length;x++)
        {
            if (!a.getLugar().equals(lugares[x]))
                jc.addItem(lugares[x]);       
        }
    }
    
    public static boolean comprobarfecha(LocalDate fecha,String nombre) throws Exception
    {
        a = ta.buscarnombre(nombre);
        
        lista = ta.buscareventosf(fecha,a.getLugar(),a.getNombre());
        return lista.isEmpty();
        /*
            if (lista.isEmpty())
                return true;
            return false;
        */
    }
    
    public static void modificarfechayhora(LocalDate fecha,LocalTime horai,LocalTime horaf,javax.swing.JDialog jd,String nombre) throws Exception
    {
        ta.modificarfyh(fecha,horai,horaf,nombre);
        showMessageDialog(null,"SE HA MODIFICADO LA FECHA Y HORAS CORRECTAMENTE");
        salirv(jd);
    }
    
    public static int cantidadaforo(String nombre) throws Exception
    {
        a = ta.buscarnombre(nombre);
        
        return a.getAforo();
    }
    
    public static void modificaraforo(Integer aforo,String nombre,javax.swing.JDialog jd) throws Exception
    {
        ta.modificaraforo(aforo,nombre);
        showMessageDialog(null,"SE HA MODIFICADO EL AFORO CORRECTAMENTE");
        salirv(jd);
    }
    
    public static boolean comprolugar(String lugar,String nombre) throws Exception
    {
        a = ta.buscarnombre(nombre);
        
        boolean valor = comprobarlugar(lugar,a.getFecha(),a.getHorai(),a.getHoraf());
        return valor;
    }
    
    public static void modificarlugar(String lugar,String nombre,javax.swing.JDialog jd) throws Exception
    {
        ta.modificarlugar(lugar,nombre);
        showMessageDialog(null,"SE HA MODIFICADO EL LUGAR CORRECTAMENTE");
        salirv(jd);
    }
}
