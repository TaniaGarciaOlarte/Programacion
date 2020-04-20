
package eje1;

import java.util.ArrayList;
import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Eje1 {

    private static ArrayList <Double> array = new ArrayList();
    private final static NumberFormat nf = NumberFormat.getNumberInstance(Locale.ROOT);
    
    public static void main(String[] args) 
    {
        int num = 0;
        try
        {
            do
            {
                añadirdatos();
            }
            while (showConfirmDialog(null,"¿DESEAS INTRODUCIR DATOS EN EL ARRAYLIST?")==0);

            do
            {
                num = conmenu();
                smenu(num);
            }
            while (num !=10);
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
    
    public static void añadirdato() throws Exception
    {
        double dato = entdouble("Introduce el valor a añadir:");
        array.add(dato);
    }
    
    public static void añadirdatos() throws Exception
    {
        boolean error;
        
        do
        {
            try
            {
                añadirdato();
                
                error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
    }
    
    public static int menu() throws Exception
    {
        return Integer.parseInt(showInputDialog("MENU:\n"
                + "1.VISUALIZAR EL VALOR MAXIMO Y EL MINIMO \n"
                + "2.SOLICITAR UN NUMERO Y BUSCARLO \n"
                + "3.SOLICITAR UN NUMERO,BUSCARLO Y BORRARLO \n"
                + "4.CONVERTIR EL ARRAYLIST EN UN ARRAY \n"
                + "5.SI NO ESTA VACIO, MOSTRAR EL NUMERO DE ELEMENTOS QUE CONTIENE \n"
                + "6.INSERTAR UN NUEVO ELEMENTO POR EL FINAL \n"
                + "7.INSERTAR UN NUEVO ELEMENTO EN LA POSICION QUE TE INDIQUE EL USUARIO \n"
                + "8.BORRAR UN ELEMENTO DE UNA POSICIÓN CONCRETA \n"
                + "9.CALCULAR LA SUMA Y LA MEDIA ARITMETICA DE LOS VALORES CONTENIDOS \n"
                + "10.FINALIZAR"));
    }
    
    public static int conmenu() throws Exception
    {
        boolean error;
        int num = 0;
        
        do
        {
            try
            {
                num = menu ();
                
                if (num <1 || num >10)
                    throw new NumeroIncorrecto();
                
                error=true;
            }
            catch (NumeroIncorrecto ni)
            {
                showMessageDialog(null,"EL NUMERO INTRODUCIDO ES INCORRECTO (DEL 1 AL 1O)");
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
    
    public static void smenu(int num) throws Exception
    {
        switch (num)
        {
            case 1:
                maxmin();
                break;
            case 2:
                buscnum();
                break;
            case 3:
                borrarnum();
                break;
            case 4:
                convertir();
                break;
            case 5:
                numele();
                break;
            case 6:
                nuevoele();
                break;
            case 7:
                nuevoelepos();
                break;
            case 8:
                borrarelepos();
                break;
            case 9:
                calcsumaymedia();
        }
    }
    
    public static double entdouble (String variable) throws Exception
    {
       return Double.parseDouble(showInputDialog(variable));
    }
    
    public static void maxmin() throws Exception
    {
        boolean error;
        
        do
        {
            try
            {
                Double max = Collections.max(array);
                Double min = Collections.min(array);

                showMessageDialog(null,"EL MAXIMO ES: " + nf.format(max) + " EL MINIMO ES: " + nf.format(min)); 
                error=true;
            }
            catch (NoSuchElementException nee)
            {
                showMessageDialog(null,"EL ARRAYLIST ESTA VACIO DEBES INTRODUCIR CONTENIDO");
                error=true;
            }
        }
        while(!error);
        
        
        /*double max = lista.get(0);
          double min = lista.get(0);
        
        for (int x=1;x<array.size();x++)
        {
            if (array.get(x)<min)
            {
                min = array.get(x);
            }
            
            if (array.get(x)>max)
            {
                max = array.get(x);
            }
        }
        */  
    }
    
    public static void buscnum() throws Exception
    {
        boolean error;
        double num = 0;
        
        do
        {
            try
            {
                num = entdouble("Introduce el numero a buscar:");
                
                if (array.contains(num))
                    showMessageDialog(null,"EL NUMERO " + nf.format(num) + " SI ESTA INTRODUCIDO EN EL ARRAYLIST Y ESTA EN LA POSICION " + array.indexOf(num));
                else
                    showMessageDialog(null,"EL NUMERO " + nf.format(num) + " NO ESTA INTRODUCIDO EN EL ARRAYLIST");
                
                error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
    }
    
    public static void borrarnum() throws Exception
    {
        boolean error;
        double num = 0;
        
        do
        {
            try
            {
                num = entdouble ("Introduce el numero a borrar:");
                
                if (array.contains(num) == false)
                    throw new NumeroNoEncontrado();
                else
                {
                    array.remove(num);
                    showMessageDialog(null,"EL NUMERO " + nf.format(num) + " HA SIDO BORRADO CORRECTAMENTE");
                }
                
                error=true;
            }
            catch (NumeroNoEncontrado nne)
            {
                showMessageDialog(null,"EL NUMERO " + num + " NO A SIDO ENCONTRADO");
                
                if (showConfirmDialog(null,"¿DESEAS ELIMINAR UN NUMERO NUEVO?:")==0)
                    error=false;
                else
                    error=true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
    }
    
    public static void convertir() throws Exception
    {
        Double [] array2 = new Double[array.size()];
        array2 = array.toArray(array2);
        
        String texto = "";
        
        for (int x=0;x<array2.length;x++)
        {
            texto += "POSICION: " + x + " VALOR: " + array2[x] + "\n";
        }
        
        showMessageDialog(null,"DATOS DEL ARRAY: \n"
                + texto);
    }
    
    public static void numele() throws Exception
    {
        if (array.isEmpty())
            showMessageDialog(null,"EL ARRAYLIST ESTA VACIO");
        else
            showMessageDialog(null,"EL NUMERO DE ELEMENTOS DEL ARRRAYLIST ES DE: " + array.size());
    }
    
    public static void nuevoele() throws Exception
    {  
        añadirdatos();
    }
    
    public static int entrint() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce la posicion:"));
    }
    
    public static void nuevoelepos() throws Exception
    {
        boolean error;
        boolean correcto;
        
        do{
            try{
                double dato = entdouble("Introduce el valor a añadir:");
                do
                {
                    try
                    {
                        int pos = entrint();
                        
                        if (pos < 0)
                            throw new PosicionInc();
                        
                        array.add(pos,dato);

                        error=true;
                    }
                    catch (PosicionInc pi)
                    {
                        showMessageDialog(null,"LA POSICION ES INCORRECTA (MINIMO 0)");
                        error=false;
                    }
                    catch (IndexOutOfBoundsException iobe)
                    {
                        if (array.size() == 0)
                        {
                            showMessageDialog(null,"LA POSICION ES INCORRECTA: (SOLO PUEDES INSERTAR LA POSICION 0)");
                        }
                        else
                        {
                            showMessageDialog(null,"LA POSICION ES INCORRECTA: (SOLO PUEDES INSERTAR DE LA POSICION 0 HASTA LA " + array.size() + ")");
                        }
                        
                        error=false;
                    }
                }
                while(!error);
                
                correcto = true;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                correcto = false;
            }
        }
        while(!correcto);
    }
    
    public static void borrarelepos() throws Exception
    {
        boolean error;
        
        do
        {
            try
            {
                if (array.isEmpty())
                    throw new ArrayVacio();
                
                int pos = entrint();
                
                if (pos < 0)
                    throw new PosInc();
                
                array.remove(pos);
                
                error=true;
            }
            catch (ArrayVacio av)
            {
                showMessageDialog(null,"ARRAY VACIO: NO PUEDES ELIMINAR NINGUN ELEMENTO");
                error=true;
            }
            catch (PosInc pi)
            {
                showMessageDialog(null,"POSICION INCORRECTA (MINIMO 0)");
                error=false;
            }
        }
        while(!error);
    }
    
    public static void calcsumaymedia() throws Exception
    {
        double suma = 0;
        
        for (int x=0;x<array.size();x++)
        {
            suma += array.get(x);
        }
        
        double media = suma / array.size();
        
        showMessageDialog(null,"EL RESULTADO DE LA SUMA ES: " + nf.format(suma) + "\n"
                + "LA MEDIA ES DE: " + nf.format(media));
        
    }
    
}
