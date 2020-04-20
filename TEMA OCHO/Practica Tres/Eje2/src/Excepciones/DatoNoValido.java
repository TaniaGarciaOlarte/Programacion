
package Excepciones;

import javax.swing.JTextField;

public class DatoNoValido extends Exception{
    private String campo;
    private javax.swing.JTextField cuadro;

    public DatoNoValido(String campo, JTextField cuadro) {
        this.campo = campo;
        this.cuadro = cuadro;
    }

    public String getCampo() {
        return campo;
    }

    public JTextField getCuadro() {
        return cuadro;
    }
}
