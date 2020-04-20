
package ejercicio9;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showConfirmDialog;
import Excepciones.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Ejercicio9 
{
    static boolean correcto;
    
    public static void main(String[] args) throws Exception 
    {
       NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
       String nombre; 
       int unidades,iva;
       double precio,resultadounipre,resultadosiniva = 0,resultadoiva4 = 0,resultadoiva10 = 0,resultadoiva21 = 0,resultadototal4=0,resultadototal10=0,resultadototal21=0,resultadoiva=0;
       String linea="",lineaiva4="",lineaiva10="",lineaiva21="";
       
       try{
        final double NORMAL=0.21;
        final double REDUCIDO=0.10;
        final double SUPEREDUCIDO=0.04;

        nombre=comprobarnombre();
        int respuesta;

        do
        {
            unidades=comprobarunidad();
            precio=comprobarprecio();
            iva=comprobariva();
            
            resultadounipre=unidades*precio;

            respuesta =showConfirmDialog(null, "Te pregunto si quieres continuar:");
            double resultado= unidades*precio;
            
            linea +="\n" + unidades + "x" + precio + "=" + nf.format(resultado);
            resultadosiniva+=resultado;
            
            switch (iva)
            {
                case 4:
                    resultadoiva4+=resultadounipre;
                    resultadototal4=SUPEREDUCIDO*resultadoiva4;
                    lineaiva4=iva + "% de " + nf.format(resultadoiva4) + "=" + nf.format(resultadototal4);
                break;
                case 10:
                    resultadoiva10+=resultadounipre;
                    resultadototal10=REDUCIDO*resultadoiva10;
                    lineaiva10=+ iva + "% de " + nf.format(resultadoiva10) + "=" + nf.format(resultadototal10);
                break;
                case 21:
                    resultadoiva21+=resultadounipre;
                    resultadototal21=NORMAL*resultadoiva21;
                    lineaiva21=+ iva + "% de " + nf.format(resultadoiva21) + "=" + nf.format(resultadototal21);
                break;
            }
        }
        while(respuesta == 0);
        
        String lineatotal=lineaiva4+ "\n" + lineaiva10 + "\n" + lineaiva21;
        resultadoiva+=resultadototal4 + resultadototal10+resultadototal21;
        
        double resultadoconiva=resultadosiniva+resultadoiva;
        
        showMessageDialog(null,"NOMBRE: " + nombre + "\n" 
                + "LINEAS DE DETALLE:" + linea 
                + "\nTOTAL SIN IVA " + nf.format(resultadosiniva)
                + "\n" + lineatotal 
                + "TOTAL IVA " + nf.format(resultadoiva) 
                + "\nTOTAL C0N IVA " + nf.format(resultadoconiva));
       }
       catch (NullPointerException npe)
       {
           showMessageDialog(null,"Cancelado");
       }
       catch (Exception e)
       {
           showMessageDialog(null,"Problemas");
       }
    }
        
    public static int num(String variable)
    {
        return Integer.parseInt(showInputDialog("Introduce el dato " + variable + ":"));
    }
    
    public static int comprobarunidad() throws Exception
    {
        int unidades=0;
        correcto=false;
        do
        {
            try{
                unidades=num("unidades");
                
                if (unidades <1)
                    throw new UnidadesIncorrectas();
                
                correcto=true;
            }
            catch(UnidadesIncorrectas ui)
            {
                showMessageDialog(null,"El valor debe ser minimo un 1");
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"Se debe introducir un numero");
            }
        }
        while(!correcto);
       
        return unidades;
    }
    
    public static double comprobarprecio() throws Exception
    {
        double precio = 0;
        correcto=false;
        
        do
        {
            try
            {
                precio=Double.parseDouble(showInputDialog("Introduce el precio de la unidad:"));
                
                if (precio < 0.1)
                    throw new PrecioIncorrecto();
                
                correcto=true;
            }
            catch(PrecioIncorrecto iv)
            {
                showMessageDialog(null,"El precio debe tener un importe minimo de 0.1");
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"Se debe introducir un numero");
            }
        }
        while(!correcto);
        
        return precio;
    }
    
    public static int comprobariva() throws Exception
    {
        int iva=0;
        correcto=false;
        
        do
        {
            try{
                iva=num("IVA");
                
                if (iva!=4 && iva!=10 && iva!=21)
                    throw new IVAIncorrecto();
                
                correcto=true;
            }
            catch(IVAIncorrecto iv)
            {
                showMessageDialog(null,"Solo se puede introducir un 4 un 10 o un 21 porciento de IVA");
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"Se debe introducir un numero");
            }
        }
        while(!correcto);
       
        return iva;
        
    }
    
    public static String comprobarnombre() throws Exception
    {
        String nombre = null;
        correcto=false;
        
           do{
             try{
                nombre=showInputDialog("Introduce el nombre:");

                if (nombre.isEmpty())
                    throw new NombreVacio();

                for (int x=0;x<nombre.length();x++)
                {
                    if (Character.isDigit(nombre.charAt(x)))
                        throw new NombreFallido();
                }
                correcto=true;
            }
            catch (NombreVacio nv)
            {
                showMessageDialog(null,"El campo no puede estar vacio");
            }
            catch (NombreFallido nf)
            {
                showMessageDialog(null,"El caracter introducido no puede contener numeros");
            }
        }
       while(!correcto);
        
       return nombre;
    }
}
