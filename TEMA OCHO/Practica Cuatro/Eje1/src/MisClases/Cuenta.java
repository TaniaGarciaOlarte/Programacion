
package MisClases;

import java.util.ArrayList;

public class Cuenta {
    private String numero;
    private ArrayList<Movimiento>listaMovimiento;

    public Cuenta(String numero) {
        this.numero = numero;
        listaMovimiento = new ArrayList();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ArrayList<Movimiento> getListaMovimiento() {
        return listaMovimiento;
    }

    public void setListaMovimiento(ArrayList<Movimiento> listaMovimiento) {
        this.listaMovimiento = listaMovimiento;
    }
    
    public void setMovimiento(Movimiento m)
    {
        listaMovimiento.add(m);
    }
    
    public Movimiento getMovimiento(int x)
    {
        return listaMovimiento.get(x);
    }
    
    public Double getSaldo()
    {
        double saldo = 0;
        for (int x=0;x<listaMovimiento.size();x++)
        {
            if (listaMovimiento.get(x).getDescri().equals("Transferencia") || listaMovimiento.get(x).getDescri().equals("Pago de Recibo"))
                saldo-=listaMovimiento.get(x).getImporte();
            else
                saldo+=listaMovimiento.get(x).getImporte();
        }
        
        return saldo;
    }
}
