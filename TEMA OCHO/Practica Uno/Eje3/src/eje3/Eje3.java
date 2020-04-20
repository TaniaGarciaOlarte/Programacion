
package eje3;

import Clases.*;
import Ventanas.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class Eje3 {
    
    private static ArrayList<Productos> listaprodu;
    private static Productos p = new Productos();
    private final static NumberFormat nf = NumberFormat.getNumberInstance(Locale.ROOT);

    public static void main(String[] args) 
    {
        try
        {
            listaprodu = new ArrayList();
            creacionprodu();
            abrirventana();
        }
        catch (Exception e)
        {
            showMessageDialog(null,e.getMessage());
        }
    }
    
    public static void creacionprodu()
    {
        Productos p1 = new Productos("MANZANAS",20,0.5);
        listaprodu.add(p1);
        Productos p2 = new Productos("NARANJAS",50,1);
        listaprodu.add(p2);
        Productos p3 = new Productos("PATATAS",10,0.5);
        listaprodu.add(p3);
    }
    
    public static void abrirventana()
    {
        V1 v = new V1();
        v.setVisible(true);
    }
    
    public static boolean comprobarpro(String nombre)
    {
        int x;
        
        for (x=0;x<listaprodu.size()&&!listaprodu.get(x).getNombre().equals(nombre);x++){}
        if (x == listaprodu.size())
            return false;
        else
        {
            p = listaprodu.get(x);
            return true;
        }
    }
    
    public static void abrirvcom()
    {
        VCompras v = new VCompras();
        v.setVisible(true);
    }
    
    public static void abrirvvent()
    {
        VVentas vv = new VVentas();
        vv.setVisible(true);
    }
    
    public static void abrirsalir()
    {
        VSalir vs = new VSalir();
        vs.setVisible(true);
    }
    
    public static void abrirprin()
    {
        V1 vp = new V1();
        vp.setVisible(true);
    }
    
    public static Integer comprobaruni(String nombre,int uni)
    {
        int x;
        int unidades = 0;
        
        for (x=0;x<listaprodu.size()&&!listaprodu.get(x).getNombre().equals(nombre);x++){}
        if (x != listaprodu.size())
            unidades = listaprodu.get(x).getUnidades();
        
        int unid = comprobacion(uni,unidades,x);
        
        return unid;
    }
    
    public static void sumar(String nombre,int unida)
    {
        int x;
        int unidades = 0;
        
        for (x=0;x<listaprodu.size()&&!listaprodu.get(x).getNombre().equals(nombre);x++){}
        if (x != listaprodu.size())
            unidades = listaprodu.get(x).getUnidades();
        
        int suma = unidades + unida;
        listaprodu.get(x).setUnidades(suma);
    }
    
    public static int comprobacion(int uni,int unidades,int x)
    {
        int diferencia = unidades - uni;
        
        if (diferencia < 0 )
            return -1;
        else
        {
            listaprodu.get(x).setUnidades(diferencia);
            return diferencia;
        }
    }
    
    public static String importe(int uni,String nombre)
    {
        boolean re = comprobarpro(nombre);
        double precio = 0;
        
        if (re)
        {
            precio = p.preciouni(uni);
        }
        
        return nf.format(precio);
    }
    
    public static void precioun(int uni,String pro,double pre)
    {
        int x;
        
        double precio = 0;
        for (x=0;x<listaprodu.size()&&!listaprodu.get(x).getNombre().equals(pro);x++){}
        if (x != listaprodu.size())
        {
            precio = p.preciou(pre);
            listaprodu.get(x).setPrecio(precio);
        }
    }
    
    public static boolean comprobarproduct(String dato,String expre)
    {
        Pattern pt = Pattern.compile(expre);
        Matcher m = pt.matcher(dato);
        
        if (!m.matches())
            return false;
        else
            return true;
    }
    
    public static void volver(javax.swing.JFrame v)
    {
       v.dispose();
       abrirprin();
    }
}
