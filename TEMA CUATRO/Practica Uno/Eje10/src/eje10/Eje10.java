
package eje10;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Eje10 
{
    private static int matriz[][] = new int [4][4];
    private static boolean contenido = false;
    
    public static void main(String[] args) 
    {
        boolean error;
        try
        {
            do{
                try{
                    int num=0;
                    do{
                        num=commenu();
                        funcionmenu(num);
                    }
                    while(num!=7);
                    
                    error=true;
                }
                catch (DatoIncorrecto di)
                {
                    showMessageDialog(null,"DEBES RELLENAR EL ARRAY ANTES DE REALIZAR LAS OPERACIONES");
                    error=false;
                }
            }
            while (!error);            
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
    
    public static int menu() throws Exception
    {
        return Integer.parseInt(showInputDialog("ELIGE UNA OPCIÓN: \n"
                + "1-.RELLENAR TODA LA MATRIZ DE NÚMEROS, DEBES PEDIRSELOS AL USUARIO \n"
                + "2-.SUMA DE UNA FILA QUE SE PEDIRÁ AL USUARIO(CONTROLAR QUE ELIJA UNA CORRECTA) \n"
                + "3-.SUMA DE UNA COLUMNA QUE SE PEDIRA AL USUARIO (CONTROLAR QUE ELIJA UNA CORRECTA) \n"
                + "4-.SUMA LAS DIAGONALES PRINCIPAL \n"
                + "5-.SUMA LA DIAGONAL INVERSA \n"
                + "6-.LA MEDIA DE TODOS LOS VALORES DE LA MATRIZ \n"
                + "7-.SALIR"));
    }
    
    public static int commenu() throws Exception
    {
        boolean error;
        int num=0;
        
        do
        {
            try
            {
              num=menu();
              
              if (num<1 || num >7)
                  throw new NumeroIncorrecto();
                          
              error=true;  
            }
            catch (NumeroIncorrecto ni)
            {
              showMessageDialog(null,"NUMERO INCORRECTO (DEL 1 AL 7)");
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
    
    public static void funcionmenu(int num) throws Exception
    {
        switch (num)
        {
            case 1:
                rellenar();
                contenido = true;
                break;
            case 2:
                if (contenido)
                    sumarfila();
                else
                    throw new DatoIncorrecto();
                break;
            case 3:
                if (contenido)
                    sumarcolumna();
                else
                    throw new DatoIncorrecto();
                break;
            case 4:
                if (contenido)
                    sumardiagonalprinci();
                else
                    throw new DatoIncorrecto();
                break;
            case 5:
                if (contenido)
                    sumardiagonalinvers();
                else
                    throw new DatoIncorrecto();
                break;
            case 6:
                if (contenido)
                    media();
                else
                    throw new DatoIncorrecto();
                break;
        }
    }
    
    public static int entrada(int x, int y) throws Exception
    {
        boolean error;
        int ent = 0;
        
        do
        {
            try
            {
                ent = Integer.parseInt(showInputDialog("Introduce el valor de la fila " + x + " y la columna " + y));
                
                if (ent < 1)
                    throw new ValorIncorrecto();
                
                error=true;
            }
            catch (ValorIncorrecto vi)
            {
                showMessageDialog(null,"VALOR INCORRECTO (MINIMO 1)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
        return ent;
        
    }
    
    public static void rellenar () throws Exception
    {
        for (int x=0;x<matriz.length;x++)
        {
            for (int y=0;y<matriz[x].length;y++)
            {
                matriz[x][y] = entrada(x,y);
            }
        }
    }
    
    public static int entradaint(String variable) throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce el valor de " + variable + " (0 - 3)"));
    }
    
    public static void sumarfil(int fila) throws Exception
    {
        int suma = 0;
        String texto = "";
        
        for (int x=0;x<matriz[fila].length;x++)
        {
            texto += matriz[fila][x] + " ";
            suma += matriz[fila][x];
        }
        
        showMessageDialog(null,"NUMEROS SUMADOS --> " + texto + "\n"
                + "EL RESULTADO DE LA FILA " + fila + " es de: " + suma);     
    }
    
    public static void sumarfila() throws Exception
    {
        boolean error;
        int fila=0;
        
        do
        {
            try
            {
               fila = entradaint("fila");
               
               if (fila < 0 || fila >3)
                   throw new FilaIncorrecta();
               
               sumarfil(fila);
               
               error=true;
            }
            catch (FilaIncorrecta fi)
            {
                showMessageDialog(null,"FILA INCORRECTA (DEL 0 AL 3)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
    }
    
    public static void sumarcolum(int columna) throws Exception
    {
        int suma = 0;
        String texto = "";
        
        for (int x=0;x<matriz[0].length;x++)
        {
            texto += matriz[x][columna] + " ";
            suma += matriz[x][columna];
        }
        
        showMessageDialog(null,"NUMEROS SUMADOS --> " + texto + "\n"
                + "EL RESULTADO DE LA FILA " + columna + " es de: " + suma);
    }
    
    public static void sumarcolumna() throws Exception
    {
       boolean error;
       int columna=0;
        
        do
        {
            try
            {
               columna = entradaint("columna");
               
               if (columna < 0 || columna >3)
                   throw new ColumnaIncorrecta();
               
               sumarcolum(columna);
               
               error=true;
            }
            catch (ColumnaIncorrecta fi)
            {
                showMessageDialog(null,"COLUMNA INCORRECTA (DEL 0 AL 3)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
    }
    
    public static void sumardiagonalprinci() throws Exception
    {
        int suma = 0;
        String texto = "";
        
        for (int x=0;x<matriz.length;x++)
        {
           suma += matriz[x][x];
           texto += matriz[x][x] + " ";
        }
        
        showMessageDialog(null,"LOS VALORES DE LAS DIAGONALES PRINCIPALES SON: " + texto + "\n"
                + "EL RESULTADO DE LA SUMA ES: " + suma);
    }
    
    public static void sumardiagonalinvers() throws Exception
    {
        int suma = 0;
        String texto = "";
        
        for (int x=0,y=3;x<matriz.length;x++,y--)
        {
            texto += matriz[x][y] + " ";
            suma += matriz[x][y];
        }
        
        showMessageDialog(null,"EL VALOR DE LAS DIAGONALES INVERSAS SON: " + texto + "\n"
                + "EL RESULTADO DE LA SUMA ES: " + suma);
    }
    
    public static void media() throws Exception
    {
        int suma = 0;
        String texto = "";
        
        for(int x = 0; x < matriz.length; x++)
            for(int y = 0; y < matriz[x].length; y++)
            {
                texto += matriz[x][y] + " ";
                suma+=matriz[x][y];
            }
        double media = suma/(matriz.length*matriz[0].length);
        
        NumberFormat nf = NumberFormat.getInstance(Locale.ROOT);
        
        showMessageDialog(null,"EL VALOR DE CADA CELDA ES:" + texto + "\n"
                + "LA MEDIA ES: " + nf.format(media));
    }
    
}
