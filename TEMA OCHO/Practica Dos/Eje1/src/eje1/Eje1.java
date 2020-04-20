
package eje1;

import Ventanas.*;

public class Eje1 {

    public static void main(String[] args) {
        VP vprin = new VP();
        vprin.setVisible(true);
    }
    
    public static boolean comprobarvacio(javax.swing.JTextField jt)
    {
        if (jt.getText().isEmpty())
            return true;
        else
            return false;
    }
    
    public static boolean comprobarcoma(javax.swing.JTextField jt,String dato)
    {
        if (jt.getText().contains(dato))
            return true;
        else
            return false;
    }
    
}
