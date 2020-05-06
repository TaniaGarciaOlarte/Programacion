
package Tablas;

import MisClases.*;
import java.sql.*;

public class TablaPersona {
    private Connection con;

    public TablaPersona(Connection con) {
        this.con = con;
    }
    
    public Persona buscarp(String dni) throws Exception
    {
        String plantilla = "SELECT * FROM tPersonas WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, dni);
            
        ResultSet resultado = ps.executeQuery();
        
        if(resultado.next())
        {
            Persona p = new Persona();
            p.setDni(resultado.getString("dni"));
            p.setNombre(resultado.getString("nombre"));
            p.setPapellido(resultado.getString(3));
            p.setSapellido(resultado.getString(4));
            p.setTelefono(resultado.getString("telefono"));
            
            return p;
        }
        
        return null;
    }
    
    public void insertar(Persona p) throws Exception
    {
        String plantilla = "INSERT INTO tPersonas VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, p.getDni());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getPapellido());
            ps.setString(4, p.getSapellido());
            ps.setString(5, p.getTelefono());
        
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1)
            throw new Exception("El numero de filas insertadas no es uno");
    }
    
}
