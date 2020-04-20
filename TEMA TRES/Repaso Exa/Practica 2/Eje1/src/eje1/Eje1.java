/*1. Introducir por teclado el numero de horas trabajadas por un empleado 
e imprimir el sueldo que le corresponde cobrar teniendo en cuenta que
cada hora normal se paga a 10 euros y cada hora extra a 15.

    -Las horas extras son aquellas superiores a las cuarenta.
    -En algunos casos, a la nomina calculada hay que sumarle un plus de 
100 euros segun el estado civil y el nivel de estudios del empleado. 
    -Esta ultima informacion tambien la obtendremos a traves del teclado. 

    -El estado civil puede ser S de soltero, C de casado, V de viudo y D de
divorciado (S C V D ).
    -El nivel de estudios puede ser P de primario, M de medo y S de
superior (P M S).
    -Llevan el plus de 100 euros las siguientes combinaciones: SP VS SM
CS VP SS DS.*/

package eje1;

import static javax.swing.JOptionPane.*;
import Excepciones.*;

public class Eje1 
{
    public static void main(String[] args) 
    {
        try
        {
            int horas=comprohoras();
            char civil=comprocivil();
            char estudios=comproestudios();
            preciohoras(horas,civil,estudios);
        }
        catch (NullPointerException npe)
        {
            showMessageDialog(null,"CANCELADO");
        }
        catch (Exception e)
        {
            showMessageDialog(null,"PROBLEMAS: " + e.getClass() + " " + e.getMessage());
        }
    }
    
    public static int entrada() throws Exception
    {
        return Integer.parseInt(showInputDialog("Introduce las horas trabajadas:"));
    }
    
    public static char entradac(String variable) throws Exception
    {
        return showInputDialog("Introduce el " + variable).charAt(0);
    }
    
    public static int comprohoras() throws Exception
    {
        boolean error;
        int hora=0;
        
        do
        {
            try
            {
                hora=entrada();
                
                if (hora < 1)
                    throw new HoraIncorrecta();
                
                error=true;
            }
            catch (HoraIncorrecta hi)
            {
                showMessageDialog(null,"HORAS INCORRECTAS (A PARTIR DE 1 HORA)");
                error=false;
            }
            catch (NumberFormatException nfe)
            {
                showMessageDialog(null,"SOLO NUMEROS");
                error=false;
            }
        }
        while(!error);
        
        return hora;
    }
    
    public static char comprocivil() throws Exception
    {
        boolean error;
        char civil = 0;
        
        do
        {
            try
            {
                civil=entradac("estado civil:");
                
                civil=Character.toUpperCase(civil);
               
                if (civil!='S' && civil!='C' && civil!='V' && civil!='D')
                    throw new EstadoCivilIncorrecto();
                
                error=true;
            }
            catch (EstadoCivilIncorrecto eci)
            {
                showMessageDialog(null,"EL ESTADO CIVIL ES INCORRECTO:\n"
                        + "SOLO PUEDE SER S(SOLTERO),C(CASADO),V(VIUDO),D(DIVORCIADO)");
                error=false;
            }
            catch (StringIndexOutOfBoundsException siobe)
            {
                showMessageDialog(null,"CAMPO VACIO: DEBES INTRODUCIR UN CARACTER");
                error=false;
            }
        }
        while (!error);
        
        return civil;
    }
    
     public static char comproestudios() throws Exception
    {
        boolean error;
        char estudio=0;
        
        do
        {
            try
            {
                estudio=entradac("nivel de estudio:");
                
                estudio=Character.toUpperCase(estudio);
                
                if (estudio !='P' && estudio !='M' && estudio !='S')
                    throw new EstudioIncorrecto();
                
                error=true;
            }
            catch (EstudioIncorrecto ei)
            {
                showMessageDialog(null,"ESTUDIOS INCORRECTOS:\n"
                        + "SOLO P(PRIMARIO),M(MEDIO) Y S(SUPERIOR)");
                error=false;
            }
            catch (StringIndexOutOfBoundsException siobe)
            {
                showMessageDialog(null,"CAMPO VACIO: DEBES INTRODUCIR UN CARACTER");
                error=false;
            }
        }
        while (!error);
        
        return estudio;
    }
    
    public static void preciohoras (int horas,char civil,char estudios) throws Exception
    {
        final int HORASN=10;
        final int HORASE=15;
        
        int result;
        
        if (horas > 40)
        {
            result=40*HORASN + (horas-40)*HORASE;
        }
        else
        {
            result=horas*HORASN;
        }
        
        comprobacionplus(result,civil,estudios);
    }
    
    public static void comprobacionplus(int result,char civil,char estudios) throws Exception
    {
        final int PLUS=300;
        
        if (civil=='S' || estudios=='S' || (civil=='V' && estudios=='P'))
            result+=PLUS;
        
        showMessageDialog(null,"El sueldo de dicho trabajador es: " + result);
    }
       
}
