package eje2;

import MisClases.Estudio;
import MisClases.Pelicula;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

public class Eje2 
{
    private static Estudio[] listaEstudios = new Estudio[5];
    private static ArrayList<Pelicula> listaPeliculas = new ArrayList();
    private static  ArrayList<String> telefonos = new ArrayList();
    private static char[] año = new char[4];
    private static ArrayList <Pelicula> lista;
     private static ArrayList <Estudio> listaest;
    
    public static void main(String[] args) 
    {
        try
        {
            creaciondeobjetos();
            relacionar();
            mostrarinfo();
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
    
    public static void creaciondeobjetos() throws Exception
    {
        creaciondeestudios();
        creaciondepeliculas();
    }
    
    public static void creaciondeestudios() throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        //1ºESTUDIO
            telefonos = new ArrayList();
            telefonos.add("111111111");
            telefonos.add("111111112");
            listaEstudios[0] = new Estudio("Universal", "Los Angeles"," C/ a","www.universal.es",sdf.parse("1950-09-23"),"EEUU",telefonos);
       
        //2ºESTUDIO
            telefonos = new ArrayList();
            telefonos.add("222222221");
            telefonos.add("222222222");
            
            //listaEstudios[1] = new Estudio("Warner Bros", "California"," C/ c","www.warner.es",sdf.parse("1956-01-10"),"EEUU",telefonos);
            listaEstudios[1] = new Estudio();
            listaEstudios[1].setNombre("Warner Bros");
            listaEstudios[1].setPais("EEUU");
            listaEstudios[1].setCiudad("California");
            listaEstudios[1].setDireccion(" C/ c");
            listaEstudios[1].setFechafundacion(null);
            listaEstudios[1].setDirweb("www.warner.es");
            listaEstudios[1].setTelefonos(telefonos);
            listaEstudios[1].setFechafundacion(sdf.parse("1956-01-10"));    
            
        //3ºESTUDIO
            telefonos = new ArrayList();
            telefonos.add("333333331");
            telefonos.add("333333332");
            listaEstudios[2] = new Estudio("Walt Disney", "Los Angeles"," C/ b","www.disney.es",sdf.parse("1960-09-23"),"EEUU",telefonos);
        
        //4ºESTUDIO
            telefonos = new ArrayList();
            telefonos.add("444444441");
            telefonos.add("444444442");
            listaEstudios[3] = new Estudio("Paramount", "Los Angeles"," C/ d","www.paramount.es",sdf.parse("1955-09-23"),"EEUU",telefonos);
        
        //5ºESTUDIO
            telefonos = new ArrayList();
            telefonos.add("555555551");
            telefonos.add("555555552");
            listaEstudios[4] = new Estudio("20Th Century Fox", "Los Angeles"," C/ e","www.fox.es",sdf.parse("1953-09-23"),"EEUU",telefonos);
    }
    
    public static void creaciondepeliculas() throws Exception
    {
         listaPeliculas = new ArrayList();
         
            //1ºPELICULA
                año[0] = '1';
                año[1] = '9';
                año[2] = '8';
                año[3] = '0';
                listaest = new ArrayList();
                listaest.add(listaEstudios[0]);
                listaest.add(listaEstudios[2]);
                Pelicula p = new Pelicula("ET",año,90.7f,"Infantil",listaest);
                listaPeliculas.add(p);

            //2ºPELICULA
                año[0] = '1';
                año[1] = '9';
                año[2] = '9';
                año[3] = '7';
                listaest = new ArrayList();
                listaest.add(listaEstudios[1]);
                listaest.add(listaEstudios[2]);
                listaPeliculas.add(new Pelicula("Titanic",año,180,"Romántica",listaest));
                
            //3ºPELICULA
                año[0] = '2';
                año[1] = '0';
                año[2] = '0';
                año[3] = '3';
                listaest = new ArrayList();
                listaest.add(listaEstudios[4]);
                listaPeliculas.add(new Pelicula("El señor de los anillos",año,133,"Ciencia ficción",listaest));
            
            //4ºPELICULA
                año[0] = '2';
                año[1] = '0';
                año[2] = '0';
                año[3] = '3';
                listaest = new ArrayList();
                listaest.add(listaEstudios[3]);
                listaest.add(listaEstudios[4]);
                listaest.add(listaEstudios[1]);
                listaest.add(listaEstudios[2]);
                listaPeliculas.add(new Pelicula("Piratas del Caribe",año,220,"Aventuras",listaest));
            
            //5ºPELICULA
                año[0] = '1';
                año[1] = '9';
                año[2] = '9';
                año[3] = '4';
                listaest = new ArrayList();
                listaest.add(listaEstudios[1]);
                listaPeliculas.add(new Pelicula("El rey león",año,97,"Infantil",listaest));
    }
    
    public static void relacionar() throws Exception
    {
        lista = new ArrayList();
        
        lista.add(listaPeliculas.get(0));
        listaEstudios[0].setListaPeliculas(lista);
        
        lista = new ArrayList();
        lista.add(listaPeliculas.get(1));
        lista.add(listaPeliculas.get(3));
        lista.add(listaPeliculas.get(4));
        listaEstudios[1].setListaPeliculas(lista);
        
        lista = new ArrayList();
        lista.add(listaPeliculas.get(0));
        lista.add(listaPeliculas.get(1));
        lista.add(listaPeliculas.get(3));
        listaEstudios[2].setListaPeliculas(lista);
        
        lista = new ArrayList();
        lista.add(listaPeliculas.get(3));
        listaEstudios[3].setListaPeliculas(lista);
        
        lista = new ArrayList();
        lista.add(listaPeliculas.get(2));
        lista.add(listaPeliculas.get(3));
        listaEstudios[4].setListaPeliculas(lista);
    }
    
    public static void mostrarinfo() throws Exception
    {
        buscarpml();
        nomestudiomphp();
    }
    
    public static void buscarpml() throws Exception
    {
        float max = 0;
        Pelicula objeto = null;
        
        for(int x=0; x < listaPeliculas.size();x++)
        {
            if (listaPeliculas.get(x).getDuracion() > max)
            {
                max = listaPeliculas.get(x).getDuracion();
                objeto = listaPeliculas.get(x);
            }
        }
        
        String text = "";
        String texto = "";
        
        for (int x = 0; x < objeto.getListaEstudios().size();x++)
            text += "\n  -" + objeto.getListaEstudios().get(x).getNombre();
        
        texto += "LA PELICULA MAS LARGA: \n"
                + "  -" + objeto.getTitulo() + "\nSE HA PRODUCIDO EN:" + text;
        
        showMessageDialog(null,texto);
    }
    
    public static void nomestudiomphp() throws Exception
    {
        int max = 0;
        Estudio objeto = null;
        
        for(int z = 0;z < listaEstudios.length; z++)
            for(int x=0; x < listaEstudios.length;x++)
            if (listaEstudios[x].getListaPeliculas().size() > max)
            {
                max = listaEstudios[x].getListaPeliculas().size();
                objeto = listaEstudios[x];
            }
        
       String mensaje = "";
        
       for (int x = 0; x < objeto.getListaPeliculas().size();x++)
            mensaje += "\n  -" + objeto.getListaPeliculas().get(x).getTitulo();
        
        showMessageDialog(null,"EL ESTUDIO QUE MAS A PRODUCIDO ES: \n "
                + " -" 
                + objeto.getNombre() + "\n"
                        + "Y HA PRODUCIDO " + mensaje);
    }
}
