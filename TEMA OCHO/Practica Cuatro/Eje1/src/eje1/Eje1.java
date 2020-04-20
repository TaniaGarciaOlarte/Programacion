
package eje1;

import MisClases.*;
import Ventanas.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.*;
import org.apache.commons.codec.digest.DigestUtils;

public class Eje1 {
    
    //ArrayList
        public static ArrayList<Cliente> listaClientes;
        public static ArrayList<Cuenta> listaCuentas;
        
    //Ventanas
        private static VP v;
        private static VLogin vl;
        private static VOpera vo;
        
    //Guardar objetos
        private static Cliente cliente;
        private static Cuenta cuenta;
        private static Cuenta cuentasecu;

    public static void main(String[] args) {
        creardatos();
        accederp();
    }
    
    public static void accederp()
    {
        v = new VP();
        v.setVisible(true);
    }
    
    public static void creardatos()
    {
       listaClientes = new ArrayList();
       
       //Encriptar Clave
            String clave = "012345";
            String claveEncriptada=DigestUtils.md5Hex(clave);
       
       //PrimerCliente     
            Cliente p = new Cliente("11111111A","Tania Garcia",claveEncriptada);
            listaCuentas = new ArrayList();
            Cuenta c = new Cuenta("01010101010101010101");
            Movimiento m = new Movimiento(LocalDate.now(),"Ingreso",100);
            c.setMovimiento(m);
            m = new Movimiento(LocalDate.now(),"Ingreso",150);
            c.setMovimiento(m);
            m = new Movimiento(LocalDate.now(),"Transferencia",100);
            c.setMovimiento(m);
            m = new Movimiento(LocalDate.now(),"Pago de Recibo",50);
            c.setMovimiento(m);
            listaCuentas.add(c);
            c = new Cuenta("01010101010101010102");
            m = new Movimiento(LocalDate.now(),"Ingreso",500);
            c.setMovimiento(m);
            m = new Movimiento(LocalDate.now(),"Ingreso",10000);
            c.setMovimiento(m);
            listaCuentas.add(c);
            c = new Cuenta("01010101010101010103");
            listaCuentas.add(c);
            c = new Cuenta("01010101010101010104");
            listaCuentas.add(c);
            c = new Cuenta("01010101010101010105");
            listaCuentas.add(c);
            c = new Cuenta("01010101010101010106");
            listaCuentas.add(c);
            p.setListaCuentas(listaCuentas);
            listaClientes.add(p);
            
        //EncriptarClave
            clave = "060319";
            claveEncriptada = DigestUtils.md5Hex(clave);
            
        //SegundoCliente
            p = new Cliente("72599524R","Julen Rodriguez",claveEncriptada);
            listaCuentas = new ArrayList();
            c = new Cuenta("64940603190503981215");
            m = new Movimiento(LocalDate.now(),"Ingreso",100);
            c.setMovimiento(m);
            m = new Movimiento(LocalDate.now(),"Ingreso",150);
            c.setMovimiento(m);
            m = new Movimiento(LocalDate.now(),"Pago de Recibo",100);
            c.setMovimiento(m);
            m = new Movimiento(LocalDate.now(),"Ingreso",100);
            c.setMovimiento(m);
            m = new Movimiento(LocalDate.now(),"Ingreso",1000);
            c.setMovimiento(m);
            listaCuentas.add(c);
            c = new Cuenta("05031906031902102029");
            listaCuentas.add(c);
            p.setListaCuentas(listaCuentas);
            listaClientes.add(p);
    } 
    
    public static void mostraracceso()
    {
        vl = new VLogin(v,true);
        vl.setVisible(true);
    }
    
    public static boolean validarformato(String dni,String expre)
    {
        Pattern pt = Pattern.compile(expre);
        Matcher m = pt.matcher(dni);
        
        if (!m.matches())
            return false;
        return true;
    }
    
    public static boolean validarDni(String dni)
    {
        int x;
        for (x = 0;x < listaClientes.size() && !listaClientes.get(x).getDni().equals(dni);x++){}
        if (x== listaClientes.size())
            return false;
        else
        {
            cliente = listaClientes.get(x);
            return true;
        }
    }
    
    public static boolean validarclave(String clave)
    {
        String claveencri = DigestUtils.md5Hex(clave);
        return claveencri.equals(cliente.getClave());
        
        /*if (claveencri.equals(c.getClave()))
            return true;
        return false;*/
    }
    
    public static void mostraropera()
    {
        v.dispose();
        vl.dispose();
        vo = new VOpera();
        vo.setVisible(true);
    }
    
    public static int numcuentas()
    {
        return cliente.getNumeroCuentas();
    }
    
    public static String numcuenta(int x)
    {
        return cliente.getCuenta(x).getNumero();
    }
    
    public static void setCuenta(int x)
    {
        cuenta = cliente.getCuenta(x);
    }
    
    public static String getMovimiento(int x)
    {
        return cuenta.getMovimiento(x).toString();
    }
    
    public static Double getSaldo()
    {
        return cuenta.getSaldo();
    }
    
    public static int getnmov()
    {
        return cuenta.getListaMovimiento().size();
    }
    
    public static void recibo(String importe)
    {
        Movimiento m = new Movimiento(LocalDate.now(),"Pago de Recibo",Double.parseDouble(importe));
        cuenta.setMovimiento(m);
    }
    
    public static boolean comprobarsiexistecuenta(String cuenta)
    {
        int x;
        int y;
        boolean encontrado=false;
        
        for (x=0;x<listaClientes.size() && !encontrado;x++)
        {
            for (y = 0;y<listaClientes.get(x).getListaCuentas().size() && !listaClientes.get(x).getListaCuentas().get(y).getNumero().equals(cuenta);y++){}
            if (y !=listaClientes.get(x).getListaCuentas().size()) 
            {
                encontrado=true;
                cuentasecu = listaClientes.get(x).getListaCuentas().get(y);
            }
            else
                encontrado=false;
        }
        
        return encontrado;
    }
    
    public static void transferenciaex(String importe)
    {
        Movimiento m = new Movimiento(LocalDate.now(),"Ingreso",Double.parseDouble(importe));
        cuentasecu.setMovimiento(m);
        m = new Movimiento(LocalDate.now(),"Transferencia",Double.parseDouble(importe));
        cuenta.setMovimiento(m);
    }
    
    public static void transferencia(String importe)
    {
        Movimiento m = new Movimiento(LocalDate.now(),"Transferencia",Double.parseDouble(importe));
        cuenta.setMovimiento(m);
    }
}
