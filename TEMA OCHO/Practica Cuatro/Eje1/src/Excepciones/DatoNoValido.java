/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author taniagarcia
 */
public class DatoNoValido extends Exception{
    private String campo;

    public DatoNoValido(String campo) {
        this.campo = campo;
    }

    public DatoNoValido() {
    }

    public String getCampo() {
        return campo;
    }
}
