
package eje2;

import static javax.swing.JOptionPane.*;
import Excepciones.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Eje2 
{   
    //CREACIÓN Y DEFINICION DE ARRAY PARA VALIDAR
        public static String[] idio = {"INGLES","FRANCES","ALEMAN","RUSO"};
        public static String[] niv = {"BASICO","MEDIO","PERFECCIONAMIENTO"};
    
    //CREACIÓN DE LOS ARRAYLIST
        public static ArrayList<ArrayList<Integer>> alumnos  = new ArrayList();
        private static ArrayList<String> idiomas = new ArrayList();
        private static ArrayList<ArrayList<String>> niveles = new ArrayList();
            
    public static void main(String[] args) 
    {   
        try
        {
          datosentrada();  
          listardatos();
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
    
    public static void datosentrada() throws Exception
    {
        boolean error;
        do
        {
            do
            {
                String idioma = comprobar("IDIOMA",idio);
                String nivel = comprobar("NIVEL",niv); 

                error=añadirdatos(idioma,nivel);
            }
            while(!error);
        }
        while(showConfirmDialog(null,"¿DESEAS INTRODUCIR MAS DATOS?")==0);
    }
    
    public static String comprobar(String variable,String[] array) throws Exception
    {
        boolean error;
        String ent = null;
        
        do
        {
            try
            {
                ent = showInputDialog("Introduce el valor de " + variable + ":").toUpperCase();
                
                if (ent.isEmpty())
                    throw new DatoVacio();
                
                if (!Arrays.asList(array).contains(ent))
                    throw new DatoIncorr();
                
                error=true;
            }
            catch (DatoVacio dv)
            {
                showMessageDialog(null,"ERROR: DEBES INTRODUCIR UN CONTENIDO");
                error=false;
            }
            catch (DatoIncorr di)
            {
                String texto = "OPCIONES VALIDAS: \n";
                
                for (int x=0;x<array.length;x++)
                {
                    texto += array[x] + "\n";
                }
                
                showMessageDialog(null,"ERROR:DATO INCORRECTO NO ES NINGUNA DE LAS OPCIONES \n"
                + texto);
                
                error=false;
            }
        }
        while(!error);
        
        return ent;
    }    
    
    public static int comprobaralum() throws Exception
    {
        boolean error;
        int num = 0;
        
        do
        {
            try
            {
                num = Integer.parseInt(showInputDialog("Introduce el numero de alumnos:"));
                
                if (num < 1)
                    throw new NumeroIncor();
                
                error=true;
            }
            catch (NumeroIncor numi)
            {
                showMessageDialog(null,"ERROR: EL NUMERO NO PUEDE SER MENOR A 1");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while (!error);
        
        return num;
    }
    
    public static boolean añadirdatos(String idioma,String nivel) throws Exception
    {   
        boolean error;
        try
        {
                int posidioma,posnivel;
                //SI NO ESTA VACIO
                    if (!idiomas.isEmpty())
                    {
                       //SACAR LA POSICION DEL IDIOMA
                            posidioma = idiomas.indexOf(idioma);

                       //SI EL IDIOMA NO ESTA AÑADIDO
                            if (posidioma == -1)
                            {
                               //AÑADIR EL IDIOMA AL FINAL DEL ARRAYLIST
                                    idiomas.add(idioma);
                               //GUARDAR LA POSICION 
                                    posidioma = idiomas.size()-1;
                               //AÑADIR EL NIVEL
                                    niveles.add(new ArrayList());
                                    niveles.get(niveles.size()-1).add(nivel);
                                    
                               //CREACIÓN DEL ARRAYLIST DE ALUMNOS
                                    alumnos.add(new ArrayList());
                            }
                        //SI EL IDIOMA EXISTE
                            else
                            {
                               //SABER SI ESTA LA POSICION AÑADIDA
                                    posnivel = niveles.get(posidioma).indexOf(nivel);
                                    
                                    //SI EL NIVEL NO ESTA SE AÑADE Y SI ESTA SACAMOS UNA EXCEPCION
                                        if (posnivel == -1)
                                        {
                                            niveles.get(posidioma).add(nivel);
                                        }
                                        else
                                            throw new DatoIncorrecto();
                            }
                    }
                //SI ESTA VACIO
                    else
                    {
                        posidioma = 0;
                       //GUARDAMOS EL IDIOMA
                        idiomas.add(idioma);
                       //GUARDAMOS EL NIVEL
                        niveles.add(new ArrayList());
                        niveles.get(0).add(nivel);
                       //CREACION DEL ARRAYLIST
                        alumnos.add(new ArrayList());
                    }
                    
                    //PEDIMOS EL NUMERO DE ALUMNOS Y LO AÑADIMOS
                        int cantalumnos = comprobaralum();
                        alumnos.get(posidioma).add(cantalumnos);
                        
                    error=true;
        }
        catch (DatoIncorrecto di)
        {
            showMessageDialog(null,"ERROR: YA HAS INTRODUCIDO CANTIDAD DE ALUMNOS EN ESE IDIOMA Y NIVEL");
            error=false;
        }
        
        return error;
    }
    
    public static void listardatos() throws Exception
    {
        String d1 = "",d2 = "",d3 = "";
        
        //DATOS AÑADIDOS
            for (int x = 0;x<alumnos.size();x++)
            {
                d1 += "   Idioma " + idiomas.get(x)+ ":\n";

                for (int y = 0;y<niveles.get(x).size();y++)
                    d1 += "       Nivel " + niveles.get(x).get(y) + " → Total Suma: " + alumnos.get(x).get(y) + "\n";
            }
        
        //TODOS LOS IDIOMAS (TOTALES POR IDIOMA)
            for (int x = 0;x<idiomas.size();x++)
            {
                d2 += "   Idioma " + idiomas.get(x);
                int suma = 0;
                for (int y=0;y<alumnos.get(x).size();y++)
                   suma +=alumnos.get(x).get(y);
                
                d2 += " → Total Suma: " + suma + "\n";
            }
            
        //TODOS LOS NIVELES (TOTALES POR NIVEL)
            for (int x = 0;x<niv.length;x++)
            {
                d3 +="   Nivel " + niv[x];
                int suma = 0;
                for(int z = 0;z < niveles.size(); z++)
                {
                   int y = niveles.get(z).indexOf(niv[x]);
                   if (y != -1)
                       suma += alumnos.get(z).get(y);
                }
                d3 += " → Total Suma: " + suma + "\n";
            }
        
        showMessageDialog(null,"DATOS INTRODUCIDOS: \n" + d1 + ""
                + "\nTOTALES POR IDIOMA \n" + d2 + 
                "\nTOTALES POR NIVEL \n" + d3);
    }
}
