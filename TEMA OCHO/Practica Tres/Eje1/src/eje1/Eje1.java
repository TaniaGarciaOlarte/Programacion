
package eje1;

import MisClases.*;
import Ventanas.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

public class Eje1 {

    private static Proveedor[] listaprovee;
    private static Producto[] listaproduct;
    private static ArrayList<Cliente> listaclientes;
    
    public static VP v;
    public static VSalir vs;
    
    private static Producto objprodu;
    private static Cliente objclient;
    private static Proveedor objprovee;
    
    public final static int volumen = 2;
    public final static int ppago = 3;
    
    public static void main(String[] args) {
        creardatos();
        listaclientes = new ArrayList();
        v = new VP();
        v.setVisible(true);
    }
    
    public static void creardatos()
    {
        //Proveedores
            listaprovee = new Proveedor[4];
            listaprovee[0] = new Proveedor("JulenS.A");
            listaprovee[1] = new Proveedor("TaniaS.A");
            listaprovee[2] = new Proveedor("VIS.A");
            listaprovee[3] = new Proveedor("JonAnderS.A");
            
        //Productos
            listaproduct = new Producto[3];
            listaproduct[0] = new Producto("MANZANAS",10,1);
            listaproduct[1] = new Producto("NARANJAS",20,0.5);
            listaproduct[2] = new Producto("PLATANOS",30,0.2);
            
        //Relacion entre proveedores y productos
            listaproduct[0].setProveedor(listaprovee[0]);
            listaproduct[0].setProveedor(listaprovee[1]);
            
            listaproduct[1].setProveedor(listaprovee[2]);
            
            listaproduct[2].setProveedor(listaprovee[3]);
    }
    
    public static boolean comprobarproduct(String producto)
    {
        int x;
        for (x = 0;x<listaproduct.length && !listaproduct[x].getNombre().equals(producto);x++){}
        if (x != listaproduct.length)
        {
            objprodu = listaproduct[x];
            return true;
        }
        objprodu = null;
        return false;
    }
    
    public static boolean comprobaruni(int unidades)
    {
        return unidades <= objprodu.getUnidades();
        
        /*if (unidades < objprodu.getUnidades())
            return false;
        return true;*/
    }
    
    public static double preciuni(int unidades)
    {
        return objprodu.preciouni(unidades);
    }
    
    public static void llenarprovee(javax.swing.JComboBox jcb)
    {   
        for (int x = 0; x <objprodu.getListaproveedor().size();x++)
        {
            jcb.addItem(objprodu.getListaproveedor().get(x).getNombre());
            
            /*Añadir indicando la posicion x-> nºposicion
                jcb.insertItemAt(objprodu.getListaproveedor().get(x).getNombre(),x);*/
        }    
        
        //objprodu.getListaproveedor().stream().forEach(o -> jcb.addItem(o.getNombre()));
    }
    
    public static void guardarprovee(int x)
    {
        objprovee = objprodu.getListaproveedor().get(x);
    }
    
    public static double calcularimporte(int unidades,boolean v,boolean pp)
    {
        double resultado;
        int desc = 0;
        resultado = objprodu.preciouni(unidades);
        
        if (v)
            desc += volumen;
        if (pp)
            desc += ppago;
        
        resultado = resultado * (100 - desc)/100;
        
        return resultado;
    }
    
    public static void venta(int unidades,String cliente)
    {
        objprodu.vuni(unidades);
        
        //Cliente
            int x;
            for (x =0; x<listaclientes.size() && !listaclientes.get(x).getNombre().equals(cliente);x++){}
            if (x == listaclientes.size())
            {
                //Cliente inexistente
                    objclient = new Cliente(cliente);
                    objclient.setProductos(objprodu);
                    listaclientes.add(objclient);
            }
            else
            {
                objclient = listaclientes.get(x);
                if (!objclient.getListaproductos().contains(objprodu))
                    objclient.getListaproductos().add(objprodu);
            }
            
        showMessageDialog(null,"¡VENTA REALIZADA CORRECTAMENTE!");    
        empezar();    
    }
    
    public static void empezar()
    {
        v.dispose();
        v = new VP(false);
        v.setVisible(true);
    }
    
    public static void compra(int unidades,double precioc)
    {
        objprodu.cuni(unidades,precioc);
        showMessageDialog(null,"¡COMPRA REALIZADA CORRECTAMENTE!");
        empezar();
    }
    
    public static void salir()
    {
        System.exit(0);
    }
    
    public static void cancelar()
    {
        vs = new VSalir(v,true);
        vs.setVisible(true);
    }
    
    public static void limpiar()
    {
        vs.dispose();
        v.limpiar();
    }
    
    public static String mostrar()
    {
        String texto = "DATOS SOBRE LOS PRODUCTOS \n"
                + "--------------------------------------";
        
        for (int x = 0; x < listaproduct.length; x++)
        {
            texto += "\n " + listaproduct[x].getNombre() + "\n"
                    + "  -Unidades: " + listaproduct[x].getUnidades() + "\n"
                    + "  -Precio: " + listaproduct[x].getPrecio() + "\n";
            
            texto += "  -PROVEEDORES: \n";
            for (int y = 0; y < listaproduct[x].getListaproveedor().size();y++)
            {
                texto += "     -" + listaproduct[x].getListaproveedor().get(y).getNombre() + "\n";
            }
            texto += "  -CLIENTES: \n";
            for (int y = 0; y<listaclientes.size();y++)
                if (listaclientes.get(y).getListaproductos().contains(listaproduct[x]))
                  texto += "    -" + listaclientes.get(y).getNombre() + "\n";
            
            texto += "-------------------------------------";
        }
        
        return texto;
    }
}
