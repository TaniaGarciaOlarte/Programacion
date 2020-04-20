/*9. Desarrolla un proyecto que te permita visualizar las facturas que los
clientes tienen que pagar por comprar en un almacen unos productos.

    -Como datos de entrada tendremos que solicitar el nombre del cliente y
por cada uno de los productos que adquiera, cantidad, precio unitario
y porcentaje de IVA que se le aplica (Normal 21 %, reducido 10 % y
supereducido 4 %)
    -Con estos datos nuestro proyecto visualizara en un cuadro de dialogo 
la factura que el cliente debe abonar.

Ejemplo para un cliente:
    -Pepe Rodriguez
    -3 unidades a un precio de 100 euros 4 % de iva
    -2 unidades a un precio de 50.5 euros 4 % de iva
    -5 unidades a un precio de 20 euros 10 % de iva

Factura que debemos visualizar:
    -NOMBRE: Pepe Rodriguez
    -LINEAS DE DETALLE:
        3 x 100 = 300
        2 x 50.5 = 101
        5 x 20 = 100
    -TOTAL SIN IVA 501
        4 % de 401 = 16.04
        10 % de 100 = 10
    -TOTAL IVA 26.04
    -TOTAL CON IVA 527.04*/

package eje9;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Eje9 
{
    //Productos
    private static int unidades,iva;
    private static double precio;

    //Totales
    private static double totalsiniva;
    private static double total4,total10,total21;
    
    //FormatoNumero
    private static NumberFormat nf=NumberFormat.getNumberInstance(Locale.ROOT);
        
    
    public static void main(String[] args) 
    {
       try
       {
         String nombre=compnombre();
         
         while (!nombre.equalsIgnoreCase("Fin"))
         {
            String lineapedido="";
            
            //inicializamos variables
                totalsiniva=0;
                total4=0;
                total10=0;
                total21=0;
                
            do
            {
               //Solicitar productos
                unidades=compuni();
                precio=compecio();
                iva=compiva();
               
               lineapedido+=pedido();
            }
            while(showConfirmDialog(null,"¿DESEAS INTRODUCIR MAS PRODUCTOS?")==0);

            calculartotales(lineapedido,nombre);
            
            nombre=compnombre();
         }
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS:" + e.getClass() + " " + e.getMessage());
       }
    }
   
    public static String entradas() throws Exception
    {
        return showInputDialog("Introduce el nombre:");
    }
    
    public static String compnombre() throws Exception
    {
        boolean error;
        String nombre=null;
        
        do
        {
            try
            {
                nombre=entradas();
                
                if (nombre.isEmpty())
                    throw new CampoVacio();
                
                for(int x=0;x<nombre.length();x++)
                {
                    if (Character.isDigit(nombre.charAt(x)))
                        throw new CampoIncorrecto();
                }
                
                error=true;
            }
            catch (CampoVacio cv)
            {
                showMessageDialog(null,"CAMPO VACIO:DEBES INTRODUCIR UN NOMBRE");
                error=false;
            }
            catch (CampoIncorrecto ci)
            {
                showMessageDialog(null,"SOLO LETRAS");
                error=false;
            }
        }
        while(!error);
        
        return nombre;
    }
    
    public static int entradain(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable));
    }
    
    public static int compuni() throws Exception
    {
        boolean error;
        int uni=0;
        
        do
        {
            try
            {
                uni=entradain("unidades:");
                
                if (uni<1)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"NUMERO INCORRECTO (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return uni;
    }
    
    public static double entradadou() throws Exception
    {
        return Double.parseDouble(showInputDialog("Introduce el precio:"));
    }
    
    public static double compecio() throws Exception
    {
        boolean error;
        double precio=0;
        
        do
        {
            try
            {
                precio=entradadou();
                
                if (precio<1)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"ERROR:NUMEROINCORRECTO (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"ERROR:SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return precio;
    }
    
    public static int compiva() throws Exception
    {
       boolean error;
       int iva=0;
       
       do
       {
           try
           {
               iva=entradain("iva");
               
               if(iva!=4 && iva!=10 && iva!=21)
                   throw new IvaIncorrecto();
               
               error=true;
           }
           catch (IvaIncorrecto ii)
           {
               showMessageDialog(null,"IVA INCORRECTO (SOLO 4,10 Y 21)");
               error=false;
           }
           catch (NumberFormatException nfe)
           {
               showMessageDialog(null,"SOLO NUMEROS");
               error=false;
           }
       }
       while(!error);
       
       return iva;
    }
    
    public static String pedido() throws Exception
    { 
        double totaluni=unidades*precio;
        totalsiniva+=totaluni;
        
        gestioniva(totaluni);
        
       return unidades + " x " + nf.format(precio) + " = " + nf.format(totaluni) + "\n";
    }
    
    public static void gestioniva(double totaluni) throws Exception
    {
        switch (iva)
        {
            case 4:
                total4+=totaluni;
                break;
            case 10:
                total10+=totaluni;
                break;
            default:
                total21+=totaluni;
        }
    }
    
    public static void calculartotales(String lineapedido,String nombre) throws Exception
    {
        String lineaproc="";
        double totaliva=0,subtotal=0;
        final double NORMAL=0.21;
        final double REDUCIDO=0.10;
        final double SUPEREDUCIDO=0.04;
        
        if(total4 !=0)
        {
            subtotal=total4*SUPEREDUCIDO;
            lineaproc+="4% de " + nf.format(total4) + " = " + nf.format(subtotal) + "\n";
            totaliva+=subtotal;
        }
        if (total10 !=0)
        {
            subtotal=total10*REDUCIDO;
            lineaproc+="10% de " + nf.format(total10) + " = " + nf.format(subtotal) + "\n";
            totaliva+=subtotal;
        }
        if(total21 !=0)
        {
            subtotal=total21*NORMAL;
            lineaproc+="10% de " + nf.format(total21) + " = " + nf.format(subtotal) + "\n";
            totaliva+=subtotal;
        }
        double total=totalsiniva+totaliva;
        
        String factura="NOMBRE: " + nombre + "\n"
                + "LINEAS DE DETALLE:\n"
                + lineapedido
                +  "TOTAL SIN IVA" + nf.format(totalsiniva) + "\n"
                + lineaproc 
                + "TOTAL IVA " + nf.format(totaliva) + "\n"
                + "TOTAL CON IVA " + nf.format(total);
        
        showMessageDialog(null,factura);
    }
   
}
