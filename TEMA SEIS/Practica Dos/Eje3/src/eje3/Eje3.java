
package eje3;

import MisClases.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

public class Eje3 {
    private static Empresa [] Empr = new Empresa[3];
    private static ArrayList<Cliente> cli;
    private static ArrayList<Empleado> emp;
    private static ArrayList<Empleado> subor;
    
    public static void main(String[] args) 
    {
        try
        {
            creacionyaña();
            mostrar();
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static void creacionyaña()
    {
        Empr[0] = new Empresa ("Michelin");
        Empr[0].setListaClientes(getListaClientes0());
        Empr[0].setListaEmpleados(getListaEmpleados0());
        
        Empr[1] = new Empresa ("Mercedes",getListaCliente1());
        Empr[1].setListaEmpleados(getListaEmpleados1());
        
        Empr[2] = new Empresa("Egibide",getListaClientes2());
        
        añadirEmpleados(Empr[2]);
    }
    
    public static void añadirEmpleados(Empresa empresa)
    {
        Empleado e = new Empleado("Nives",50,1000);
        empresa.setEmpleado(e);
        e = new Empleado("Pepe",50,1000);
        empresa.setEmpleado(e);
    }
    
    public static ArrayList<Cliente> getListaClientes0()
    {
       cli = new ArrayList();
       
       cli.add(new Cliente("111","c1",21));
       cli.add(new Cliente("211","c2",31));
       cli.add(new Cliente("311","c3",41));
       
       return cli;
    }
    
    public static ArrayList<Empleado> getListaEmpleados0()
    {
        emp = new ArrayList();
        
        agregaremp();
        
        Directivo d = new Directivo("Jefe1",45,50000,"Categoria uno");
        emp.add(d);
        
        subor = new ArrayList();
        subor.add(emp.get(0));
        d.setSubordinados(subor);
        
        d = new Directivo("Jefe2",45,50100,"Categoria uno");
        subor = new ArrayList();
        subor.add(emp.get(1));
        subor.add(emp.get(2));
         
        d.setSubordinados(subor);
        emp.add(d);
        
        return emp;
    }
    
    public static ArrayList<Cliente> getListaCliente1()
    {
        cli = new ArrayList();
        
        cli.add(new Cliente("118","Pepe",27));
        cli.add(new Cliente("418","Juan",37));
        cli.add(new Cliente("618","Imanol",47));
        cli.add(new Cliente("111","Maria",61));
        cli.add(new Cliente("411","Teresa",39));
        
        return cli;
    }
    
    public static ArrayList<Empleado> getListaEmpleados1()
    {
        emp = new ArrayList();
        
        agregemp1();
        
        Directivo d = new Directivo("Jefe 56",45,50000,"Categoria uno");
        subor = new ArrayList();
        subor.add(emp.get(0));
        subor.add(emp.get(1));
        subor.add(emp.get(2));
        subor.add(emp.get(3));
        d.setSubordinados(subor);
        emp.add(d);
        
        d = new Directivo("Jefe 67",45,50100,"Categoria uno");
        subor = new ArrayList();
        subor.add(emp.get(2));
        subor.add(emp.get(3));
        subor.add(emp.get(4));
        d.setSubordinados(subor);
        emp.add(d);
        
        return emp;
    }
    
    public static ArrayList<Cliente> getListaClientes2()
    {
        cli = new ArrayList();
        
        agregarcli();
        
        return cli;
    }
    
    public static void agregarcli()
    {
        cli.add(new Cliente("111","Alumno1",21));
        cli.add(new Cliente("411","Alumno2",31));
        cli.add(new Cliente("611","Alumno3",41));
    }
    
    public static void agregaremp()
    {
        emp.add(new Empleado("e1",21,10000));
        emp.add(new Empleado("e2",31,20000));
        emp.add(new Empleado("e3",41,30000));
    }
    
    public static void agregemp1()
    {
        emp.add(new Empleado("e11",21,10500));
        emp.add(new Empleado("e21",31,20500));
        emp.add(new Empleado("e31",41,30500));
        emp.add(new Empleado("e51",21,100500));
        emp.add(new Empleado("e61",36,40000));
    }
    
    public static void mostrar()
    {
       int max = 0;
       Directivo objmax = null;
        
       for (int x = 0; x < Empr.length; x++)
       {
           //EMPLEADOS DE UNA EMPRESA
              for (int y = 0; y < Empr[x].getListaEmpleados().size();y++)
              {
                  //ES O NO DIRECTIVO
                    if (Empr[x].getListaEmpleados().get(y) instanceof Directivo)
                    {
                        Directivo objeto = (Directivo) Empr[x].getListaEmpleados().get(y);
                        if (objeto.getSubordinados().size() > max)
                        {
                            objmax = objeto;
                            max = objeto.getSubordinados().size();
                        }
                    }
              }     
       }
       
       showMessageDialog(null,"DIRECTIVO CON MAS SUBORDINADOS: " + objmax.getNombre() 
              + "\nCANTIDAD DE EMPLEADOS A SU CARGO: " + max);
    }
}
