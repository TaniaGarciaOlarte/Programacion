
package eje5;

import BaseDeDatos.*;
import MisClases.*;
import Tablas.*;
import Ventanas.*;
import java.time.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

public class Eje5 {
    private static VentanaPrincipal vp;
    private static VentanaBorraryModificar vb;
    private static VentanaCrear vc;
    private static VentanaInscripcion vi;
    
    private static TablaAcontecimiento ta;
    private static TablaAsistencia tas;
    private static TablaPersona tp;
    
    private static Acontecimiento a;
    private static Persona p;
    
    private static BaseDeDatos bd;
    
    private static ArrayList<Acontecimiento> lista;
    private static ArrayList<Acontecimiento> listainscri;
    
    
    private static String[] lugares = {"Artium","Buesa Arena","Iradier Arena","Mendizorroza","Teatro Principal"};
    
    public static void main(String[] args) {
        try
        {
            bd = new BaseDeDatos();
            bd.conectar();
            
            ta = new TablaAcontecimiento(bd.getCon());
            tp = new TablaPersona(bd.getCon());
            tas = new TablaAsistencia(bd.getCon());
        
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
        
        switch (operacion)
        {
            case "Crear":
                vc = new VentanaCrear(vp,true);
                visibilizar(vc);
              break;
            case "Borrar":
            case "Editar":    
                vb = new VentanaBorraryModificar(vp,true,operacion);
                visibilizar(vb);
              break;
            default:
                vi = new VentanaInscripcion(vp,true);
                visibilizar(vi);
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
    
    public static boolean llenarinscri(javax.swing.JComboBox jc) throws Exception
    {
        jc.removeAllItems();
        
        lista = ta.mostrartodo();
        
        for (int x=0;x<lista.size();x++)
        {
            listainscri = ta.sacarlista(LocalDate.now(),tas.contarasistencia(lista.get(x).getNombre()));
        }
        
        if (listainscri.isEmpty())
            return false;
        
        for (int y=0;y<listainscri.size();y++)
        {
            jc.addItem(listainscri.get(y).getNombre());
        }
  
        return true;
    }
    
    public static String mostrardato(String valor,String nombre) throws Exception
    {
        a = ta.buscarnombre(nombre);
        
        if (valor.equals("Fecha"))
            return a.getFecha().toString();
        else
            return a.getHorai().toString();
    }
    
    public static boolean buscarpersona(String dni) throws Exception
    {
        p = tp.buscarp(dni);
        
        return p != null;
        /*
            if (p == null)
                return false;
            return true;
        */
    }
    
    public static String getNombre()
    {
        return p.getNombre();
    }
    
    public static String getPApellido()
    {
        return p.getPapellido();
    }
    
    public static String getSApellido()
    {
        return p.getSapellido();
    }
    
    public static String getTelefono()
    {
        return p.getTelefono();
    }
    
    public static boolean buscarinscri(String evento,String persona) throws Exception
    {
        boolean existe = tas.buscari(evento,persona);
        
        return existe;
        /*
            if (existe)
                return true;
            return false;
        */
    }
    
    public static void insertarasistencia(String evento,String persona,javax.swing.JDialog jd) throws Exception
    {
        a = ta.buscarnombre(evento);
        
        p.setAcontecimiento(a);
        a.setPersona(p);
        
        tas.insertar(evento,persona);
        showMessageDialog(null,"PERSONA INSCRITA EN EL EVENTO");
        salirv(jd);
    }
    
    public static void insertarpersona(String dni,String nombre,String papellido,String sapellido,String telefono) throws Exception
    {
        p = new Persona(dni,nombre,papellido,sapellido,telefono);
        tp.insertar(p);
        showMessageDialog(null,"PERSONA INSERTADA CORRECTAMENTE");
    }
}
