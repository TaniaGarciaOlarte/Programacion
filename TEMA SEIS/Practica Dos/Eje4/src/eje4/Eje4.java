package eje4;

import MisClases.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static javax.swing.JOptionPane.*;

public class Eje4 {
    private static Vuelo v;
    private static Avion a;
    private static Piloto p;
    private static ArrayList<Asiento> lista;
    private static Asiento as;
    private static Pasajero pa;
    private static Ciudad c;
    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) 
    {
        try
        {
           creacion();
           relaciones();
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS:  " + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static void creacion() throws Exception
    {
        vuelo();
        avion();
        piloto();
        asientos();
        pasajeros();
        ciudad();
    }
    
    public static void vuelo() throws Exception
    {
        v = new Vuelo();
        
        //Introducir datos
            v.setNumvuelo(1);
            v.setHorasalida("10:00");
            v.setHorallegada("15:00");
            v.setLugarorigen("Foronda");
            v.setLugardestino("Los Rodeos");
            v.setTipovuelo("Comercial");
            
          //Fechas
            //FechaSalida
                String fechaS= "15-01-2020";
                Date date = sdf.parse(fechaS);
                v.setFechasalida(date);
            //FechaLlegada
                String fechaF = "20-01-2020";
                date = sdf.parse(fechaF);
                v.setFecharegreso(date);
    }
    
    public static void avion()
    {
        a = new Avion();
        
        //Introducir datos
            a.setAerolinea("Iberia");
            a.setCodavion("001");
            a.setNumasientos(100);
            a.setComportamiento("dos");
    }
    
    public static void piloto()
    {
        p = new Piloto();
        
        //Introducir datos
            p.setCodigoPiloto("098");
            p.setNombre("Tania");
            p.setApellido("Garcia");
            p.setNumeroDeLicencia(9);
    }
    
    public static void asientos()
    {
        lista = new ArrayList();
        
        //Asiento 1
            as = new Asiento();

            //Introducir datos
                as.setNumeroasiento(1);
                as.setEstado(true);
                as.setComportamiento("uno");
                
           //Relacion entre vuelo y asiento
                as.setVuelo(v);
                
           //Añadir el asiento 1 al arraylist
              lista.add(as);
        
        //Asiento 2
            as = new Asiento();

            //Introducir datos
                as.setNumeroasiento(2);
                as.setEstado(true);
                as.setComportamiento("uno");
                
           //Relacion entre vuelo y asiento
                as.setVuelo(v);
           
           //Añadir el asiento 2 al arraylist
               lista.add(as);
            
        //Asiento 3
            as = new Asiento();

            //Introducir datos
                as.setNumeroasiento(3);
                as.setEstado(true);
                as.setComportamiento("dos");
                
           //Relacion entre vuelo y asiento
                as.setVuelo(v);
                
           //Añadir el asiento 3 al arraylist
               lista.add(as);
            
        //Añadimos el arrayList el cual contiene los datos de los asientos    
            v.setAsientos(lista);
    }
    
    public static void pasajeros()
    {
        pa = new Pasajero();
        
        //Introducir datos
            pa.setCedula("11.111.111A");
            pa.setNombre("Pepe");
            pa.setApellido("Gonzalez");
            pa.setSexo("Masculino");
            pa.setEdad(30);
    }
    
    public static void ciudad()
    {
        c = new Ciudad();
        
        //Introducir datos
            c.setNombre("Vitoria");
            c.setCodigociudad("01");
    }
    
    public static void relaciones()
    {
        //AVION-VUELO
            v.setAvion(a);
            a.setVuelo(v);
        //VUELO-PILOTO
            v.setPiloto(p);
            ArrayList<Vuelo> l = p.getListavuelos();
            l.add(v);
            p.setListavuelos(l);
        //PASAJERO-VUELO
            v.setPasajero(pa);
            pa.setVuelo(v);
        //ASIENTO-PASAJERO
            pa.setAsiento(as);
            as.setPasajeros(pa);
        //VUELO-CIUDAD
            c.setVuelo(v);
            v.setCiudad(c);
    }
}
