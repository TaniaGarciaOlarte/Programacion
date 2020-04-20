package ejercicio2;

public class Ejercicio2 
{
    static String texto="";
    public static void main(String[] args) 
    {
        String a1=javax.swing.JOptionPane.showInputDialog("Visual.Net:");
        String a2=javax.swing.JOptionPane.showInputDialog("Cobol:");
        String a3=javax.swing.JOptionPane.showInputDialog("Java:");
        String a4=javax.swing.JOptionPane.showInputDialog("SQL:");
        
        if (a1.equalsIgnoreCase("Apto")|| a2.equalsIgnoreCase("Apto")|| a3.equalsIgnoreCase("Apto")|| a4.equalsIgnoreCase("Apto") || a1.equalsIgnoreCase("NoApto")|| a2.equalsIgnoreCase("NoApto")|| a3.equalsIgnoreCase("NoApto")|| a4.equalsIgnoreCase("NoApto"))
        {
            texto=aptoNoApto(a1,a2,a3,a4);
            javax.swing.JOptionPane.showMessageDialog(null,texto);
        }
        else
        {
           javax.swing.JOptionPane.showMessageDialog(null,"Error: El texto introducido es incorrecto");
        } 
    }
    
//Función de apto o no apto
    public static String aptoNoApto(String a1,String a2,String a3,String a4)
    {
        if (a1.equalsIgnoreCase("Apto") && a2.equalsIgnoreCase("Apto") && a3.equalsIgnoreCase("Apto") && a4.equalsIgnoreCase("Apto"))
        {
            return "Sobresaliente";
        }
        else
        {
            if (a4.equalsIgnoreCase("Apto") && a2.equalsIgnoreCase("Apto") && (a1.equalsIgnoreCase("Apto")||a3.equalsIgnoreCase("Apto")))
            {
                return "Notable";
            }
            else
            {
                if (a2.equalsIgnoreCase("Apto") && a4.equalsIgnoreCase("Apto"))
                {
                    return "Bien";
                }
                else
                {
                    if ((a4.equalsIgnoreCase("Apto")||a2.equalsIgnoreCase("Apto"))&&((a3.equalsIgnoreCase("Apto"))||a1.equalsIgnoreCase("Apto")))
                            {
                                return "Suficiente";
                            }
                    else
                    {
                       return "Insuficiente";
                    }
                }
            }
        }
    }
}
