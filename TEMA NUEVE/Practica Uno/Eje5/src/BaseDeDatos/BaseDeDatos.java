
package BaseDeDatos;

import java.sql.*;

public class BaseDeDatos {
    private Connection con;

    public BaseDeDatos() {
    }
    
    public void conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
                String bd = "bdt9p1e2";
                String url = "jdbc:mysql://localhost:3307/"+bd;
                String login = "root";
                String password = "";
            
            con = DriverManager.getConnection(url,login,password);
            
            if (con == null)
                throw new Exception("Problemas con la conexion");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void desconectar()
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Problemas cerrando la conexion");
        }
    }
    
    public Connection getCon()
    {
        return con;
    }
}
