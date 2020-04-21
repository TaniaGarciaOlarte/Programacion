/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;

import BaseDeDatos.*;
import MisClases.*;
import Tablas.*;
import Ventanas.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author taniagarcia
 */
public class Eje1 {
    private static VentanaPrincipal vp;
    private static VPersonas vper;
    private static BaseDeDatos bd;
    private static TablaPersona tp;
    
    private static ArrayList<Persona> listapersonas;
    private static Persona p;
    
    public static void main(String[] args){
       try
       {
           bd = new BaseDeDatos();
           bd.conectar();

           tp = new TablaPersona(bd.getCon());
           
           //Creamos la tabla de Personas en la bd
                tp.creartabla();

           vp = new VentanaPrincipal();
           vp.setVisible(true);
       }
       catch (Exception e)
       {
           bd.desconectar();
           showMessageDialog(null,e.getMessage());
       }     
    }
    
    public static void salir()
    {
        bd.desconectar();
        System.exit(0);
    }
    
    public static void ventanapersonas(String operacion) throws Exception
    {
        listapersonas = tp.seleccionarTodo();
        vp.setVisible(false);
        vper = new VPersonas(vp,true,operacion);
        vper.setVisible(true);
    }
    
    public static boolean consultarpersona(String nombre) throws Exception
    {
        p = tp.personanombre(nombre);
        return p != null;
        
        /*
            if (p == null)
                return false;
            return true;
        */
    }
    
    public static String mostrardatos()
    {
        String texto = "";
        texto = "DATOS DE LA PERSONA: \n"
                + "" + p.toString();
        return texto;
    }
    
    public static int personasreg() throws Exception
    {
        listapersonas = tp.seleccionarTodo();
        return listapersonas.size();
    }
    
    public static void insertarpersona(String nombre,String edad,String profesion,String telefono) throws Exception
    {
        p = new Persona(nombre,edad,profesion,telefono);
        tp.intestar(p);
    }
    
    public static void ventanap(javax.swing.JDialog jf) throws Exception
    {
        jf.dispose();
        vp.setVisible(true);
    }
    
    public static String mostrarnombre(int cont)
    {
        return listapersonas.get(cont).getNombre();
    }
    
    public static String mostraredad(int cont)
    {
        return listapersonas.get(cont).getEdad();
    }
    
    public static String mostrarprofesion(int cont)
    {
        return listapersonas.get(cont).getProfesion();
    }
    
    public static String mostrartelefono(int cont)
    {
        return listapersonas.get(cont).getTelefono();
    }
}
