package ejercicio4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;

public class Ejercicio4 
{
    public static void main(String[] args) throws ParseException
    {  
        try{
            boolean correcto = false;
            Date fechain = null,fechafin = null;
                do{
                    try{
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                        fechain=dateFormat.parse(texto());
                        fechafin=dateFormat.parse(texto());
                        correcto=true;
                    }
                    catch(ParseException pe)
                    {
                        showMessageDialog(null,"Solo puedes introducir fechas");
                    }
                   }
                 while(!correcto);

                int dias=(int)((fechafin.getTime()-fechain.getTime())/86400000);

            showMessageDialog(null,"Diferencia de dias:" + dias);
        }
         catch (NullPointerException npe)
         {
            showMessageDialog(null,"Cancelado");
         }
    }
    
    public static String texto()
    {
        return showInputDialog("Introduce la fecha:");
    } 
}
