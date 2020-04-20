/*2. En un cursillo de programacion se estudian cuatro lenguajes: 
    -Visual.Net
    -Cobol
    -Java
    -SQL
-La nota final del curso depende de una practica que se realiza en los cuatro lenguajes.
-La nota en cada una de las practicas es apto o no apto
-La nota del curso puede ser un sobresaliente, notable, bien, suficiente o insuficiente.

Para calcular la nota del curso hay que seguir las siguientes instrucciones:
    -Apto en los cuatro lenguajes Sobresaliente
    -Apto en SQL, Cobol y uno de los otros dos Notable
    -Apto en Cobol y SQL Bien
    -Apto en SQL y uno entre Java y Visual.Net Suficiente
    -Apto en Cobol y uno entre Java y Visual.Net Suficiente
    -Resto de los casos Insuficiente*/

package eje2;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje2 
{
    public static void main(String[] args) 
    {
        try
        {
            String visual=comprobar("visual");
            String cobol=comprobar("cobol");
            String java=comprobar("java");
            String sql=comprobar("sql");
            
            comprobarnota(visual,cobol,java,sql);
            
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
    
    public static String entrada(String val) throws Exception
    {
        return showInputDialog("Introduce la nota de " + val + " : ").toUpperCase(); 
    }
    
    public static String comprobar(String variable) throws Exception
    {
        boolean error;
        String val=variable;
        
        do
        {
            try
            {
                variable=entrada(val);
                
                if (variable.isEmpty())
                    throw new CampoVacio();
                
                if (!variable.equalsIgnoreCase("apto") && !variable.equalsIgnoreCase("no apto"))
                    throw new NotaIncorrecta();
                
                error=true;
            }
            catch (NotaIncorrecta ni)
            {
                showMessageDialog(null,"NOTA INCORRECTA (SOLO APTO O NO APTO)");
                error=false;
            }
            catch(CampoVacio cv)
            {
                showMessageDialog(null,"CAMPO VACIO (SOLO APTO O NO APTO)");
                error=false;
            }
        }
        while (!error);
        
        return variable;
    }
    
    public static void comprobarnota(String visual,String cobol,String java,String sql) throws Exception
    {
        if (visual.equals("APTO") && cobol.equals("APTO") && java.equals("APTO") && sql.equals("APTO"))
            showMessageDialog(null,"SOBRESALIENTE");
        else
        {
            if (sql.equals("APTO") && cobol.equals("APTO") && (java.equals("APTO") || visual.equals("APTO")))
                showMessageDialog(null,"NOTABLE");
            else
            {
                if (sql.equals("APTO") && cobol.equals("APTO"))
                    showMessageDialog(null,"BIEN");
                else
                {
                    if ((sql.equals("APTO") || cobol.equals("APTO")) && (java.equals("APTO") || visual.equals("APTO")))
                        showMessageDialog(null,"SUFICIENTE");
                    else
                        showMessageDialog(null,"INSUFICIENTE");
                }
            }
        }
    }
}
