
package Tablas;

import MisClases.*;
import java.sql.*;
import java.time.*;

public class TablaAcontecimiento {
    private Connection con;

    public TablaAcontecimiento(Connection con) {
        this.con = con;
    }
    
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
            Acontecimiento a = new Acontecimiento();
            a.setNombre(resultado.getString("nombre"));
            a.setLugar(resultado.getString("lugar"));
            a.setFecha(LocalDate.parse(String.valueOf(resultado.getDate("fecha"))));
            a.setHorai(resultado.getTime(4).toLocalTime());
            a.setHoraf(resultado.getTime(5).toLocalTime());
            a.setAforo(resultado.getInt(6));
       
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
            Acontecimiento a = new Acontecimiento();
            a.setNombre(resultado.getString("nombre"));
            a.setLugar(resultado.getString("lugar"));
            a.setFecha(LocalDate.parse(String.valueOf(resultado.getDate("fecha"))));
            a.setHorai(resultado.getTime(4).toLocalTime());
            a.setHoraf(resultado.getTime(5).toLocalTime());
            a.setAforo(resultado.getInt(6));
            
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
            Acontecimiento a = new Acontecimiento();
            a.setNombre(resultado.getString("nombre"));
            a.setLugar(resultado.getString("lugar"));
            a.setFecha(LocalDate.parse(String.valueOf(resultado.getDate("fecha"))));
            a.setHorai(resultado.getTime(4).toLocalTime());
            a.setHoraf(resultado.getTime(5).toLocalTime());
            a.setAforo(resultado.getInt(6));
            
            return a;
        }
        
        return null;        
    } 
}
