
package Tablas;

import MisClases.*;
import java.sql.*;
import java.util.ArrayList;

public class TablaAsistencia {
    private static Connection con;

    public TablaAsistencia(Connection con) {
        this.con = con;
    }
    
    public Integer contarasistencia(String nombre) throws Exception
    {
        String plantilla = "SELECT COUNT(*) FROM tAsistencias WHERE evento = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
            
        ResultSet resultado = ps.executeQuery();
        
        if (resultado.next())
        {
            Integer contador;
            contador = resultado.getInt(1);
            return contador;
        }
        
        return 0;
    }
    
    public boolean buscari(String evento,String persona) throws Exception
    {
        String plantilla = "SELECT * FROM tAsistencias WHERE evento = ? && persona = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, evento);
            ps.setString(2, persona);
            
        ResultSet resultado = ps.executeQuery();
        return resultado.next();
        /*
            if (resultado.next())
                return true;
            return false;
        */
    }
    
    public void insertar(String evento,String persona) throws Exception
    {
        String plantilla = "INSERT INTO tAsistencias VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, evento);
            ps.setString(2, persona);
            
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1)
            throw new Exception ("El numero de filas insertadas no es uno");
    }
    
    public ArrayList<String> mostrarpersonas(String nombre) throws Exception
    {
        ArrayList<String> listapersonas = new ArrayList();
        
        String plantilla = "SELECT dni,nombre FROM tAsistencias,tPersonas WHERE evento = ? && persona = dni";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
        
        ResultSet resultado = ps.executeQuery();
        
        while(resultado.next())
        {
            Persona p = new Persona();
            p.setDni(resultado.getString("dni"));
            p.setNombre(resultado.getString("nombre"));
            listapersonas.add(p.toString());
        }
        
        return listapersonas;
    }
}
