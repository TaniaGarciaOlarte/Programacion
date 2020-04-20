package ejercicio1;

public class Ejercicio1 
{
    static int resultadohoras=0;
    static int resultado=0;
    static String estado="";
    static String nivel="";
    static String ni="";
    
    
    public static void main(String[] args) 
    {
        int horas=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Introduce el numero de horas trabajadas: "));
        String civil=javax.swing.JOptionPane.showInputDialog("Introduce el estado civil:");
        String nivele=javax.swing.JOptionPane.showInputDialog("Introduce el nivel de estudios:");
     
        resultadohoras=hora(horas);
        estado=estado1(civil);
        nivel=nivel1(nivele);
        ni=estadonivel2();
        resultado=result();
        
        javax.swing.JOptionPane.showMessageDialog(null,resultado);
       
    }  
    
//Funcion calcular horas
    
    public static int hora(int horas)
    {
        if (horas > 0 && horas <=40)
        {
            resultadohoras=horas*10;
        }
        else
            if (horas > 40)
            {
               resultadohoras=40*10 + (horas-40)*15;
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Error: Las horas introducidas son incorrectas"); 
            }
        return resultadohoras;
    }
    
//Función definir estado
    public static String estado1(String civil)
    {
        if (civil.compareToIgnoreCase("Soltero")==0)
        {
            estado="S";
        }
        else
        {
            if (civil.compareToIgnoreCase("Casado")==0)
            {
                estado="C";
            }
            else
            {
                if (civil.compareToIgnoreCase("Viudo")==0)
                {
                    estado="V";
                }
                else
                {
                    if (civil.compareToIgnoreCase("Divorciado")==0)
                    {
                        estado="D";
                    }
                    else
                    {
                        javax.swing.JOptionPane.showMessageDialog(null,"Error: El estado civil introducido es incorrecto");
                    }
                }
            }
        }
        return estado;
    }
    
    //Funcion definir nivel
    public static String nivel1(String nivele)
    {
        if (nivele.equalsIgnoreCase("Primario"))
        {
            nivel="P";
        }
        else
        {
            if (nivele.equalsIgnoreCase("Medo"))
            {
                nivel="M";
            }
            else
            {
                if (nivele.equalsIgnoreCase("Superior"))
                {
                    nivel="S";
                }
                else
                {
                    javax.swing.JOptionPane.showMessageDialog(null,"Error: El nivel introducido es incorrecto");
                }
            }
        }
        return nivel;
    }
    
    //Funcion definir estadoynivel
    public static String estadonivel2()
    {
        if (estado.equalsIgnoreCase("S")&& nivel.equalsIgnoreCase("P"))
            {
                 ni="SP";   
            }
        else
        {
            if (estado.equalsIgnoreCase("V")&& nivel.equalsIgnoreCase("S"))
                {
                   ni="VS";     
                }
            else
            {
                if (estado.equalsIgnoreCase("S")&& nivel.equalsIgnoreCase("M"))
                {
                    ni="SM";
                }
                else
                {
                    if (estado.equalsIgnoreCase("C")&& nivel.equalsIgnoreCase("S"))
                    {
                        ni="CS";
                    }
                    else
                    {
                        if (estado.equalsIgnoreCase("V")&& nivel.equalsIgnoreCase("P"))
                        {
                            ni="VP";
                        }
                        else
                        {
                            if (estado.equalsIgnoreCase("S")&& nivel.equalsIgnoreCase("S"))
                            {
                                ni="SS";
                            }
                            else
                            {
                                if (estado.equalsIgnoreCase("D")&& nivel.equalsIgnoreCase("S"))
                                {
                                    ni="DS";
                                }
                            }
                        }
                    }
                }
            }
        }
        return ni;
    }
    
    //Función calcular plus
    public static int result()
    {
        if (ni.compareTo("SP")==0||ni.compareTo("VS")==0||ni.compareTo("SM")==0||ni.compareTo("CS")==0||ni.compareTo("VP")==0||ni.compareTo("SS")==0||ni.compareTo("DS")==0)
        {
            resultado=resultadohoras+100;
        }
        else
        {
            resultado=resultadohoras;
        }                      
        return resultado;
     }   
    }


