
package eje2;

import MisClases.*;
import Ventanas.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

public class Eje2 {
    private static ArrayList<Multa> listamultas;
    private static ArrayList<Propietario> propietarios;
    private static ArrayList<Vehiculo> listavehiculos;
    
    public static void main(String[] args) 
    {
        try
        {
            listamultas = new ArrayList();
            propietarios = new ArrayList();
            listavehiculos = new ArrayList();
            creacion();
            mostrarventana();
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"Problmeas: " + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static void creacion()
    {
        //Propietarios
            Propietario p = nuevopro("Tania","72850951S");
            Propietario p1 = nuevopro("Julen","72599524R");
            Propietario p2 = nuevopro("Jon Ander","18599137A");
            
            añadirp(p,p1,p2);
            
        //Multas
            Multa m = nuevamul("10","Exceso de velocidad");
            Multa m1 = nuevamul("20","Hablar por telefono");
            Multa m2 = nuevamul("30","No llevar el cinto");
            Multa m3 = nuevamul("40","Conducir bajo los efectos del alcohol");
            
            añadirm(m,m1,m2,m3);
            
        //Vehiculos
            Vehiculo v = nuevovehi("1111AAA","Mercedes","Cla 2019","Negro",p);
            Vehiculo v1 = nuevovehi("2222BBB","Audi","A3 Sportback","Blanco",p1);
            Vehiculo v2 = nuevovehi("3333CCC","Peugeot","508","Azul",p2);
            
            añadirv(v,v1,v2);
    }
    
    public static Propietario nuevopro(String nombre,String dni)
    {
        return new Propietario (nombre,dni);
    }
    
    public static Multa nuevamul(String cod,String descripcion)
    {
        return new Multa(cod,descripcion);
    }
    
    public static Vehiculo nuevovehi(String mat,String mar,String mo,String co,Propietario p)
    {
        return new Vehiculo(mat,mar,mo,co,p);
    }
    
    public static void añadirp(Propietario p,Propietario p1,Propietario p2)
    {
        propietarios.add(p);
        propietarios.add(p1);
        propietarios.add(p2);
    }
    
    public static void añadirm(Multa m,Multa m1,Multa m2,Multa m3)
    {
        listamultas.add(m);
        listamultas.add(m1);
        listamultas.add(m2);
        listamultas.add(m3);
    }
    
    public static void añadirv(Vehiculo v,Vehiculo v1,Vehiculo v2)
    {
        listavehiculos.add(v);
        listavehiculos.add(v1);
        listavehiculos.add(v2);
    }
    
    public static void mostrarventana()
    {
        VPrin vp = new VPrin();
        vp.setVisible(true);
    }
    
    public static void mostrarvtipo()
    {
        VSecun vs = new VSecun();
        vs.setVisible(true);
    }
    
    public static String mostrar()
    {
        String texto = "";
        
        for (int x=0;x<listamultas.size();x++)
        {
            texto += listamultas.get(x).toString();
        }
        
        return texto;
    }
    
    public static boolean comprobarmatri(String matri)
    {
        int x;
        
        for (x=0;x<listavehiculos.size() && !listavehiculos.get(x).getMatricula().equals(matri);x++){}
        if (x == listavehiculos.size())
            return false;
        
        return true;
    }
    
    public static String mostrardni(String matri)
    {
        int x;
        String dni = null;
        
        for (x=0;x<listavehiculos.size() && !listavehiculos.get(x).getMatricula().equals(matri);x++){}
        if (x != listavehiculos.size())
            dni = listavehiculos.get(x).getP().getDni();
        else
            dni = "";
        
        return dni;      
    }
    
    public static boolean comprobarcod(String cod)
    {
        int x;
        
        for (x=0;x<listamultas.size()&&!listamultas.get(x).getCod().equals(cod);x++){}
        if (x==listamultas.size())
            return false;
        return true;
    }
    
    public static String mostrardesc(String cod)
    {
        int x;
        String desc = "";
        
        for (x=0;x<listamultas.size()&&!listamultas.get(x).getCod().equals(cod);x++){}
        if (x!=listamultas.size())
            desc = listamultas.get(x).getDescripcion();
        
        return desc;
    }
    
    public static Multa sacarpos(String cod)
    {
        int x;
        Multa m = null;
        
        for (x=0;x<listamultas.size()&&!listamultas.get(x).getCod().equals(cod);x++){}
        if (x!=listamultas.size())
            m = listamultas.get(x);
        
        return m;
    }
    
    public static void añadirdato(String cod, String matri)
    {
        Multa m = sacarpos(cod);
        
        int x;
        
        for (x=0;x<listavehiculos.size() && !listavehiculos.get(x).getMatricula().equals(matri);x++){}
        if (x != listavehiculos.size())
            listavehiculos.get(x).setMulta(m);    
    }
    
    public static String mostrarlistado()
    {
        String texto = "";
        for (int x=0;x<listavehiculos.size();x++)
        {
            if (!listavehiculos.get(x).getMultas().isEmpty())
                texto += listavehiculos.get(x).toString();
        }
        
        return texto;
    }
}
