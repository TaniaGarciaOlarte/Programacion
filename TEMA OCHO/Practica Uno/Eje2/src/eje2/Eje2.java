
package eje2;

import Clases.*;
import Ventanas.*;
import java.util.ArrayList;

public class Eje2 {
    
    private static ArrayList<Persona> personas;
    
    public static void main(String[] args) 
    {
        personas = new ArrayList();
        V1 vn = new V1();
        vn.setVisible(true);
    }
    
    public static void altapersona(String nombre,String apellidos,String dni)
    {
        Persona p = new Persona(nombre,apellidos,dni);
        personas.add(p);
    }
    
    public static boolean validardni(String dni)
    { 
        /*int x;
        for (x=0;x<personas.size()&&!personas.get(x).getDni().equals(dni);x++){}
        if (x == personas.size())
            return true;*/
        
        return personas.stream().anyMatch(p->p.getDni().equals(dni));
    }
    
    public static String datos()
    {
        String datos = "";
        
        for (int x=0;x<personas.size();x++)
        {
            datos += personas.get(x).toString() + "\n";
        }
        
        return datos;
    }
    
    public static void salir()
    {
        V2 v = new V2();
        v.setVisible(true);
    }
    
}
