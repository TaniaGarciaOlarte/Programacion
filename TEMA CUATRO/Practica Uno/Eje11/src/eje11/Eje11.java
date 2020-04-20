
package eje11;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje11 
{
    private final static String productos[][] = {{"KitKar","Chicles de fresa","Lacasitos","Palotes"},{"Kinder Bueno","Bolsa variada Haribo","Chetoos","Twix"},{"Kinder bueno","M&M","Papa Delta","Chicles de menta"},{"Lacasitos","Crunch","Milkybar","KitKar"}};
    private final static double precios[][] = {{1.1,0.8,1.5,0.9},{1.8,1,1.2,1},{1.8,1.3,1.2,0.8},{1.5,1.1,1.1,1.1}};
    private static int cantidades[][] = new int [4][4];
    private static int ventas[][] = new int [4][4];
    
    public static void main(String[] args) 
    {
       int menu = 0;
       
       try
       {
           inicializarcantidad();
           
           do
           {
                menu = comprobarmenu();
                opmen(menu);
           }
           while(menu !=4);
           
           mostrarventas();
       }
       catch (NullPointerException npe)
       {
           showMessageDialog(null,"CANCELADO");
       }
       catch (Exception e)
       {
           showMessageDialog(null,"PROBLEMAS:" + e.getClass() + " " + e.getMessage());
       }
    }
    
    public static void inicializarcantidad() throws Exception
    {
        for (int x=0;x<cantidades.length;x++)
        {
            for (int y=0;y<cantidades[x].length;y++)
                cantidades[x][y]=5;
        }
    }
    
    public static int menu() throws Exception
    {
        return Integer.parseInt(showInputDialog("ELIGE UNA OPCIÓN: \n"
                + "1-.PEDIR GOLOSINAS \n"
                + "2-.MOSTRAR GOLOSINAS \n"
                + "3-.RELLENAR GOLOSINAS \n"
                + "4-.APAGAR MAQUINA"));
    }
    
    public static int comprobarmenu() throws Exception
    {
        boolean error;
        int num = 0;
        
        do
        {
            try
            {
                num = menu();
                
                if (num <1 || num >4)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"OPCION INCORRECTA (DEL 1 AL 4)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return num;
    }
    
    public static void opmen(int menu) throws Exception
    {
        switch (menu)
        {
            case 1:
                pedirgolo();
                break;
            case 2:
                mostrargolo();
                break;
            case 3:
                rellenargolo();
                break;
        }
    }
    
    public static String entString() throws Exception
    {
        boolean error;
        String vari = null;
        
        do
        {
            try
            {
                vari = showInputDialog("Introduce el codigo:");
                
                if (vari.length() !=2)
                    throw new VariIncorrecta();
                
                for (int x=0;x<vari.length();x++)
                {
                    if (!Character.isDigit(vari.charAt(x)))
                        throw new DatoErroneo();
                }
                
                error=true;
            }
            catch (VariIncorrecta vi)
            {
                showMessageDialog(null,"EL CODIGO DEBE CONTENER 2 DIGITOS (1ºNUM -> FILA - 2ºNUM -> COLUMNA)");
                error=false;
            }
            catch (DatoErroneo de)
            {
                showMessageDialog(null,"DATO ERRONEO (SOLO NUMEROS)");
                error=false;
            }
        }
        while(!error);
        
        return vari;
    }
    
    public static void pedirgolo() throws Exception
    {
        boolean error;
        do
        {
            try
            {
                String dato = entString();

                //Fila
                    int fila = dato.charAt(0) - '0';
                    if (fila <0 || fila >cantidades.length)
                        throw new DatoIncorrecto();
                
                //Columna
                    int columna = dato.charAt(1) - '0';
                    if (columna <0 || columna >cantidades[fila].length)
                        throw new DatoIncorrecto();
                
                if (cantidades[fila][columna] == 0)
                    showMessageDialog(null,"NO HAY MAS UNIDADES DEL PRODUCTO INDICADO");
                else
                {
                    showMessageDialog(null,"EL PRODUCTO " + fila + columna + " CUESTA:" + precios[fila][columna]);
                    cantidades [fila][columna] -=1;
                    ventas[fila][columna] +=1;
                }
                
                error=true;
            }
            catch (DatoIncorrecto di)
            {
                showMessageDialog(null,"DATO INCORRECTO LA GOLOSINA INDICADA NO EXISTE");
                error=false;
            }
        }
        while(!error);
    }
    
    public static void mostrargolo() throws Exception
    {
        String texto = "";
        
        for (int x=0;x<productos.length;x++)
            for (int y=0;y<productos[x].length;y++)
                texto += "CODIGO: " + x + y + " NOMBRE_PRODUCTO: " + productos[x][y] + " PRECIO: " + precios[x][y] + "\n"; 
        
        showMessageDialog(null,"LISTA DE PRODUCTOS: \n" + texto);
    }
    
    public static int comprobarcantidad() throws Exception
    {
        boolean error;
        int canti = 0;
        
        do
        {
            try
            {
                canti = Integer.parseInt(showInputDialog("Introduce la cantidad a añadir:"));
                
                if (canti<1)
                    throw new CantidadIncorrecta();
                
                error=true;
            }
            catch (CantidadIncorrecta ci)
            {
                showMessageDialog(null,"CANTIDAD INCORRECTA (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return canti;
    }
    
    public static void rellenargolo() throws Exception
    {
        boolean error;
        String contra = showInputDialog("Introduce la contraseña:");
        
        if (contra.equals("MaquinaExpendedora2019"))
        {
            do
            {
                try
                {
                    String pos = entString();
            
                    int fila = pos.charAt(0) - '0';
                    if (fila<0 || fila>cantidades.length)
                        throw new DatoInc();
                    
                    int columna = pos.charAt(1) - '0';
                    if (columna<0 || columna>cantidades.length)
                        throw new DatoInc();
                    
                    int cantidad = comprobarcantidad();
                    cantidades[fila][columna] += cantidad;
                    
                    error=true;
                }
                catch(DatoInc din)
                {
                    showMessageDialog(null,"DATO INCORRECTO LA GOLOSINA INDICADA NO EXISTE");
                    error=false;
                }
            }
            while(!error);
        }
        else
            showMessageDialog(null,"ERROR:LA CONTRASEÑA INTRODUCIDA NO ES LA DEL TECNICO");
    }
    
    public static void mostrarventas() throws Exception
    {
        String texto = "";
        
        for (int x=0;x<productos.length;x++)
            for (int y=0;y<productos[x].length;y++)
                if (ventas[x][y] !=0)
                    texto += "CODIGO: " + x + y + " NOMBRE: " + productos[x][y] + " SE HAN VENDIDO: " + ventas[x][y];
        
        if (texto.equals(""))
        {
            showMessageDialog(null,"NO SE HA VENDIDO NADA");
        }
        else
        {
            showMessageDialog(null,texto);
        }
    }
}
