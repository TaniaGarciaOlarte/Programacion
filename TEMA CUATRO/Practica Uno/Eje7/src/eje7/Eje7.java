
package eje7;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje7 
{
    public static void main(String[] args) 
    {
       boolean error;
       try
       {
           do
           {
             try{
                double importe=comprobarint("importe");
                double pago=comprobarint("pago");

                if (pago<importe)
                    throw new PagoIncorrecto();
                
                vueltas(importe,pago);

                error=true;
             }
             catch (PagoIncorrecto pi)
             {
                 showMessageDialog(null,"EL VALOR DEL PAGO TIENE QUE SER MAYOR AL DEL IMPORTE");
                 error=false;
             }
             
           }
           while(!error);
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
    
    public static double comprobarint(String variable) throws Exception
    {
        boolean error;
        double vari = 0;
        
        do
        {
            try
            {
                vari=Double.parseDouble(showInputDialog("Introduce el valor de " + variable + ":"));
                
                if (vari<=0)
                    throw new DatoIncorrecto();
                
                error=true;
            }
            catch (DatoIncorrecto di)
            {
                 showMessageDialog(null,"EL IMPORTE O PAGO DEBE SER MAYOR A 0");
                 error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return vari;
    }
    
    public static void vueltas(double importe,double pago) throws Exception
    {
        double diferencia=pago-importe;
        double result=diferencia;
        
        //Declaracion de arrays
            double[] monedas={500,200,100,50,20,10,5,2,1,0.5,0.20,0.10,0.05,0.02,0.01};
            double[] devolver= new double[15];
        
        //Repetitiva para saber las vueltas
            for (int i=0;i<monedas.length;i++)
            {
                if (result>=monedas[i])
                {
                    //Redondear la cantidad
                        devolver[i]=Math.floor(result/monedas[i]);

                    //Modificar el importe del result
                        result-=(devolver[i]*monedas[i]);
                }
            }
        
        //Mostrar mensaje
            String linea="";

            for (int i=0;i<monedas.length;i++)
            {
                if (devolver[i]>0)
                 linea+= monedas[i] + " : " + devolver[i] + "\n";
            }
            showMessageDialog(null,"IMPORTE A DEVOLVER:" + diferencia + "\n"
                    + linea);
    }
}
