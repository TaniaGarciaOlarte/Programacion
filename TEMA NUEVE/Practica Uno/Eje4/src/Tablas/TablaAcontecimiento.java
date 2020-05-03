
package Tablas;

import MisClases.*;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;

public class TablaAcontecimiento {
    private Connection con;
    private Acontecimiento a;

    public TablaAcontecimiento(Connection con) {
        this.con = con;
    }
    
    public void estructura(ResultSet resultado) throws Exception
    {
        a = new Acontecimiento();
        a.setNombre(resultado.getString("nombre"));
        a.setLugar(resultado.getString("lugar"));
        a.setFecha(LocalDate.parse(String.valueOf(resultado.getDate("fecha"))));
        a.setHorai(resultado.getTime(4).toLocalTime());
        a.setHoraf(resultado.getTime(5).toLocalTime());
        a.setAforo(resultado.getInt(6));
    }
    
    //Practica 2
        public void insertar(Acontecimiento a) throws Exception
        {
            String plantilla = "INSERT INTO tAcontecimientos VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setString(1, a.getNombre());
                ps.setString(2, a.getLugar());
                ps.setDate(3, Date.valueOf(a.getFecha()));
                ps.setTime(4, Time.valueOf(a.getHorai()));
                ps.setTime(5, Time.valueOf(a.getHoraf()));
                ps.setInt(6, a.getAforo());

            int n = ps.executeUpdate();
            ps.close();
            if (n !=1)
                throw new Exception("El numero de filas insertadas no es uno");
        }

        public Acontecimiento buscarnombre (String nombre) throws Exception
        {
            String plantilla = "SELECT * FROM tAcontecimientos WHERE nombre =?";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setString(1, nombre);

            ResultSet resultado = ps.executeQuery();
            if (resultado.next())
            {
                estructura(resultado);

                return a;
            }
            else
                return null;
        }

        public Acontecimiento buscarporlugaruno (String lugar,LocalDate fecha,LocalTime horai) throws Exception
        {

            String plantilla = "SELECT * FROM tAcontecimientos WHERE lugar =? && fecha =? && hora_ini<=? && hora_fin>=?";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setString(1, lugar);
                ps.setString(2, fecha.toString());
                ps.setString(3, horai.toString());
                ps.setString(4, horai.toString());

            ResultSet resultado = ps.executeQuery();
            if(resultado.next())
            {
                estructura(resultado);

                return a;
            }

            return null;
        }

        public Acontecimiento buscarporlugardos (String lugar,LocalDate fecha,LocalTime horai,LocalTime horaf) throws Exception
        {   
            String plantilla = "SELECT * FROM tAcontecimientos WHERE lugar =? && fecha =? && hora_ini>=? && hora_ini<=?";
               PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setString(1, lugar);
                ps.setString(2, fecha.toString());
                ps.setString(3, horai.toString());
                ps.setString(4, horaf.toString());

            ResultSet resultado = ps.executeQuery();
            if(resultado.next())
            {
                estructura(resultado);

                return a;
            }

            return null;        
        } 
        
    //Practica 3
        public ArrayList<Acontecimiento> mostrartodo() throws Exception
        {
            ArrayList<Acontecimiento> lista = new ArrayList();
            
            String plantilla = "SELECT * FROM tAcontecimientos";
                PreparedStatement ps = con.prepareStatement(plantilla);
                
            ResultSet resultado = ps.executeQuery();
            while(resultado.next())
            {
                estructura(resultado);
                
                lista.add(a);
            }
            
            return lista;
        } 
       
        public void borrartodo() throws Exception
        {
            String plantilla = "DELETE FROM tAcontecimientos";
               PreparedStatement ps = con.prepareStatement(plantilla);
                    
            ps.executeUpdate();
            ps.close();
        }
        
        public void borrarnombre(String nombre) throws Exception
        {
            String plantilla = "DELETE FROM tAcontecimientos WHERE nombre =?";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setString(1, nombre);
                
            int n = ps.executeUpdate();
            ps.close();
            
            if (n != 1 )
                throw new Exception("Error a la hora de eliminar el evento");
        }
            
    //Practica 4
        public ArrayList<Acontecimiento> buscareventosf(LocalDate fecha,String lugar,String nombre) throws Exception
        {
            ArrayList<Acontecimiento> lista = new ArrayList();
            
            String plantilla = "SELECT * FROM tAcontecimientos WHERE nombre <> ? && lugar = ? && fecha = ?";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setString(1, nombre);
                ps.setString(2, lugar);
                ps.setDate(3,Date.valueOf(fecha));
            
            ResultSet resultado = ps.executeQuery();
            while(resultado.next())
            {
                estructura(resultado);
                
                lista.add(a);
            }
            
            return lista;
        }
        
        public void modificarfyh(LocalDate fecha,LocalTime horai,LocalTime horaf,String nombre) throws Exception
        {
            String plantilla = "UPDATE tAcontecimientos SET fecha = ?,hora_ini = ?,hora_fin = ? WHERE nombre = ?";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setDate(1, Date.valueOf(fecha));
                ps.setTime(2, Time.valueOf(horai));
                ps.setTime(3, Time.valueOf(horaf));
                ps.setString(4, nombre);
            
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1)
                throw new Exception("El numero de filas actualizadas no es uno");
        }
        
        public void modificaraforo(Integer aforo,String nombre) throws Exception
        {
            String plantilla = "UPDATE tAcontecimientos SET aforo = ? WHERE nombre = ?";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setInt(1, aforo);
                ps.setString(2, nombre);
                
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1)
                throw new Exception("El numero de filas actualizadas no es uno");
        }
        
        public void modificarlugar(String lugar,String nombre) throws Exception
        {
            String plantilla = "UPDATE tAcontecimientos SET lugar = ? WHERE nombre = ?";
                PreparedStatement ps = con.prepareStatement(plantilla);
                ps.setString(1, lugar);
                ps.setString(2, nombre);
            
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1)
                throw new Exception("El numero de filas actualizadas no es uno");
        }
}
