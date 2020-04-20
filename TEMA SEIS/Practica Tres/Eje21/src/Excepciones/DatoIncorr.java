
package Excepciones;

public class DatoIncorr extends Exception{
    private String campo;

    public DatoIncorr(String campo) {
        this.campo = campo;
    }
    
    public String getErr()
    {
        return campo + " NO VALIDO";
    }
}
