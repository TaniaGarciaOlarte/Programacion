
package Tablas;

import MisClases.*;
import java.sql.*;
import java.util.ArrayList;

public class TablaPersona {
    private Connection con;

    public TablaPersona(Connection con) {
        this.con = con;
    }
    
    public void creartabla() throws Exception
    {
        try
        {
            String plantilla = "CREATE TABLE tPersonas (nombre VARCHAR(30) PRIMARY KEY,edad VARCHAR(2) NOT NULL,profesion VARCHAR(50) NOT NULL,telefono VARCHAR(9) NOT NULL)";
            PreparedStatement ps = con.prepareStatement(plantilla);

            ps.execute();
            ps.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("Error al crear la tabla:" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
    }
    
    public void intestar(Persona p) throws Exception
    {
        String plantilla = "INSERT INTO tPersonas VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getEdad());
            ps.setString(3, p.getProfesion());
            ps.setString(4, p.getTelefono());
            
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1)
            throw new Exception("El numero de filas insertadas no es uno");
    }
    
    public Persona personanombre(String nombre) throws Exception
    {
        String plantilla = "SELECT * FROM tPersonas WHERE nombre =?";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
            
        ResultSet resultado = ps.executeQuery();
        if (resultado.next())
        {
            Persona p = new Persona();
            p.setNombre(resultado.getString("nombre"));
            p.setEdad(resultado.getString("edad"));
            p.setProfesion(resultado.getString(3));
            p.setTelefono(resultado.getString(4));
            
            return p;
        }
        else
            return null;
    }
    
    public ArrayList<Persona> seleccionarTodo() throws Exception
    {
        ArrayList<Persona> lista = new ArrayList();
        
        String plantilla = "SELECT * FROM tPersonas";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ResultSet resultado = ps.executeQuery();
        while(resultado.next())
        {
            Persona p = new Persona();
            p.setNombre(resultado.getString("nombre"));
            p.setEdad(resultado.getString("edad"));
            p.setProfesion(resultado.getString(3));
            p.setTelefono(resultado.getString(4));
            
            lista.add(p);
        }
        
        return lista;
    }
}
