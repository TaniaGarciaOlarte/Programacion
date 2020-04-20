
package eje1;

import Enumeraciones.*;
import static javax.swing.JOptionPane.*;
import Excepciones.*;
import MisClases.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;


public class Eje1 {
    private static ArrayList<Vehiculo> listavehiculo = new ArrayList();
    private static ArrayList<Persona> listapersona = new ArrayList();
    
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
    
    public static void alta()
    {
        do
        {
            Persona p = añadirpersona();
            p.setListavehiculos(añadirvehiculo(p));
            
            listapersona.add(p);
        }
        while(showConfirmDialog(null,"¿DESEAS AÑADIR MAS PERSONAS?")==0);
    }
    
    public static Persona añadirpersona()
    {
        //Introducir datos
            String dni = comprobardni(); 
            String nombre = obtenerdato("EL NOMBRE","^[A-Za-z]+([ ][A-Za-z]+)?");
            String apellidos = obtenerdato("LOS APELLIDOS","^[A-Za-z]+[ ][A-Za-z]+");
            String direccion = obtenerdato("LA DIRECCION","^C/[A-Za-z\\u00f1\\u00d1]+( [A-Za-z\\u00f1\\u00d1]+)*[ ][0-9]{1,2}[ ][0-9]{1,2}º[A-Z]$");
            String telefono = obtenerdato("EL NUMERO DE TELEFONO","^(6|7)[0-9]{8}$");
        
        return new Persona (dni,nombre,apellidos,direccion,telefono);
    }
    
    public static ArrayList<Vehiculo> añadirvehiculo(Persona p)
    {
        ArrayList<Vehiculo> vehiculos = new ArrayList();
        do{
            boolean error;
            String matricula = comprobarmatri();
            String tipodato = obtenerdato("EL TIPO DE VEHICULO","^(coche|moto|camion)$");

            do{
                try{
                    String mar = showInputDialog("Introduce LA MARCA del " + tipodato + ":").toUpperCase();

                    switch (tipodato)
                    {
                        case "coche":
                            vehiculos.add(new Coche(marcacoche.valueOf(mar),matricula,p)); 
                            break;
                        case "moto":
                            Moto m1 = new Moto(marcamoto.valueOf(mar),matricula,p);
                            vehiculos.add(m1);
                            break;
                        default:
                            vehiculos.add(new Camion(marcacamion.valueOf(mar),matricula,p));
                    }
                    
                    listavehiculo.add(vehiculos.get(vehiculos.size()-1));

                    error = true;
                }
                catch (IllegalArgumentException iae)
                {
                    showMessageDialog(null,"LA MARCA INTRODUCIDA ES INCORRECTA");
                    error = false;
                }
            }
            while(!error);
        }
        while(showConfirmDialog(null,"¿DESEAS AÑADIR MAS VEHICULOS?")==0);
        
        return vehiculos;
    }
    
    public static String obtenerdato(String campo,String exp)
    {
        boolean error;
        String dato = null;
        
        do
        {
            try
            {
                dato = showInputDialog(null,"Introduce " + campo + ":");
                
                Pattern pt = Pattern.compile(exp);
                Matcher m = pt.matcher(dato);
                
                if (!m.matches())
                    throw new DatoNoValido(campo);
                
                error = true;
            }
            catch (DatoNoValido dnv)
            {
                showMessageDialog(null,dnv.getCampo());
                error = false;
            }
        }
        while(!error);
        
        return dato;
    }
    
    public static String comprobardni()
    {
        boolean error;
        String dni = "";
        
        do
        {
            try
            {
                dni = showInputDialog("Introduce EL DNI de la persona:");
                
                Pattern pt = Pattern.compile("^[0-9]{8}[A-Z]$");
                Matcher m = pt.matcher(dni);
                
                if (!m.matches())
                    throw new DatoNoValido("DNI");
                
                int x;
                for (x = 0;x<listapersona.size() && !listapersona.get(x).getDni().equals(dni);x++){}
                
                if (x != listapersona.size())
                    throw new DNIError();
                
                /*final String dni2 = dni; //Constante para poder usarla en la funcion lamda
                    if (listapersona.stream().anyMatch(pe -> pe.getDni().equals(dni2)))
                        throw new DNIError();
                */
                    
                error = true;
            }
            catch (DatoNoValido dnv)
            {
                showMessageDialog(null,dnv.getCampo());
                error = false;
            }
            catch (DNIError me)
            {
                showMessageDialog(null,"ERROR: EL DNI INDICADO YA ESTA INTRODUCIDO");
                error = false;
            }
        }
        while(!error);
        
        return dni;
    }
    
    public static String comprobarmatri()
    {
        boolean error;
        String matri = "";
        
        do
        {
            try
            {
                matri = showInputDialog("Introduce LA MATRICULA del vehiculo:");
                
                Pattern pt = Pattern.compile("^[0-9]{4}[A-Z]{3}");
                Matcher m = pt.matcher(matri);
                
                if (!m.matches())
                    throw new DatoNoValido("MATRICULA");
                
                int x;
                for (x = 0;x<listavehiculo.size() && !listavehiculo.get(x).getMatricula().equals(matri);x++){}
                
                if (x != listavehiculo.size())
                    throw new MatriError();
                    
                error = true;
            }
            catch (DatoNoValido dnv)
            {
                showMessageDialog(null,dnv.getCampo());
                error = false;
            }
            catch (MatriError me)
            {
                showMessageDialog(null,"ERROR: LA MATRICULA INDICADA YA ESTA INTRODUCIDA");
                error = false;
            }
        }
        while(!error);
        
        return matri;
    }
    
    private static void mostrardatos()
    {
        //Eje1 → Nombre de las personas con mas de un vehiculo
           System.out.println("EJE1 → NOMBRE DE LAS PERSONAS CON MAS DE UN VEHICULO");
           
           //Forma1
                List<Persona> eje1 = listapersona.stream().filter(p -> p.getListavehiculos().size()>1).collect(Collectors.toList());
                eje1.stream().forEach(p->System.out.println(p.getNombre()));
           
           //Forma2
                listapersona.stream().filter(p->p.getListavehiculos().size() > 1).forEach(p->System.out.println(p.getNombre()));
                
           //Forma3
                for (int x = 0; x < listapersona.size();x++)
                {
                    if (listapersona.get(x).getListavehiculos().size() > 1)
                        System.out.println(listapersona.get(x).getNombre());
                }

        //Eje2 → Nombre de la persona que mas vehiculos tiene
           System.out.println("Eje2 → NOMBRE DE LA PERSONA QUE MAS VEHUCULOS TIENE");
           
           //Forma1
            Optional<Persona> eje2 = listapersona.stream().max(Comparator.comparing(p->p.getListavehiculos().size()));
            if (eje2.isPresent())
                System.out.println(eje2.get().getNombre());
           
           //Forma2
            int max = 0;
            Persona pmax = null;
            for(Persona p: listapersona)
                if (p.getListavehiculos().size() > max)
                {
                    max = p.getListavehiculos().size();
                    pmax = p;
                }
            System.out.println(pmax.getNombre());
           
        //Eje3 → Nombre de la persona que mas motos tiene
            System.out.println("Eje3 → NOMBRE DE LA PERSONA QUE MAS MOTOS TIENE");
            
            //Forma1
                Optional<Persona> eje3 = listapersona.stream().max(Comparator.comparingInt(p->p.getNumeroMotos()));
                if (eje3.isPresent())
                    System.out.println(eje3.get().getNombre());
            
            //Forma2
                int maxmotos = 0;
                Persona pmaxmoto = null;
                for (Persona p: listapersona)
                {
                    int numeroMotos = 0;
                    for (Vehiculo v: p.getListavehiculos())
                        if (v instanceof Moto)
                            numeroMotos++;
                    
                    if (numeroMotos > maxmotos)
                    {
                        maxmotos = numeroMotos;
                        pmaxmoto = p;
                    }
                }
                System.out.println(pmaxmoto.getNombre());
        
        //Eje4 → ¿Hay alguna persona que tenga una moto de la marca Ducate?
            System.out.println("Eje4 → ¿HAY ALGUNA PERSONA QUE TENGA UNA MOTO DE LA MARCA DUCATE?");
            
            //Saber si hay o no motos Ducate
                boolean variable = listapersona.stream().allMatch(p->p.getMotoDucate());
                
                if (variable == true)
                    System.out.println("SI hay alguna persona que tenga una moto de la marca ducate");
                else
                    System.out.println("NO hay alguna persona que tenga una moto de la marca ducate");
            
            //Cantidad de personas que tienen la moto Ducate
                long contador = listapersona.stream().filter(p->p.getMotoDucate()).count();
                System.out.println("Hay " + contador + " personas que tiene una moto Ducate");
        
        //Eje5 → Lista ordenada alfabeticamente de todas las personas indicando su numero de vehiculos
            System.out.println("Eje5 → LISTA ORDENADA ALFABETICAMENTE DE TODAS LAS PERSONAS INDICANDO SU NUMERO DE VEHICULOS");
            
            listapersona.stream().sorted(Comparator.comparing(p->p.getNombre())).forEach(p->System.out.println("NOMBRE: " + p.getNombre() + " → CANTIDAD DE VEHICULOS: " + p.getListavehiculos().size()));
    }
}
