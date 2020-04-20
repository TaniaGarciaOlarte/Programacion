/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import MisClases.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author taniagarcia
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String fecha = request.getParameter("fechar");
        
        //Convertir a LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate f = LocalDate.parse(fecha,formatter); 
            
        int comensales = Integer.parseInt(request.getParameter("comensales"));
            
        //Comprobar si hay sitio por franja y dia
            boolean haysitio = comprobarCapacidad(f,request.getParameter("franjah"),comensales);
            if (haysitio)
            {
                //Si hay sitio.Guardamos la reserva
                    Reserva r = new Reserva(f,request.getParameter("franjah"),comensales,request.getParameter("colorm"),request.getParameter("demandas"));
                    listaReservas.add(r);
                    
                //Cliente nuevo
                    String telefono = request.getParameter("telefono");
                    if (existe(telefono))
                    {
                        c.setReserva(r);
                        r.setC(c);
                    }
                    else
                    {
                        c = new Cliente(request.getParameter("nombre"),request.getParameter("correo"),request.getParameter("telefono"));
                        c.setReserva(r);
                        r.setC(c);
                        listaClientes.add(c);
                    }
                
                //Mostrar reserva confirmada
                    response.setContentType("text/html;charset=UTF-8");
                        try (PrintWriter out = response.getWriter())
                        {
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Reserva Realizada</title>");
                            out.println("<style>");
                            out.println("td{font-size:10pt;text-align:center}");
                            out.println("#titulo{background-color:#78A4EB ;font-size:16pt}");
                            out.println("#cli{background-color:#AEC8F3}");
                            out.println("table{border-collapse: collapse}");
                            out.println("#a{background-color:#C9DAF7}");
                            out.println("td:hover{font-size:14pt}");
                            out.println("#b{background-color:#E4ECFB}");
                            out.println("</style>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1 align=center>Reserva realizada correctamente</h1>");
                            out.println("<table align=center>");
                            out.println("<tr>");
                            out.println("<th id=titulo colspan=4><u><i>Detalles de la Reserva</i></u></th>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<th id=cli colspan=2><u>Datos del Cliente</u></th>");
                            out.println("<th id=cli colspan=2><u>Datos de la Reserva</u></th>");
                            out.println("</tr>");
                            out.println("<tr id=a>");
                            out.println("<td colspan=2><b>Nombre: </b>" + c.getNombre() + "</td>");
                            out.println("<td colspan=2><b>Fecha de Reserva: </b>" + r.getFecha() + "</td>");
                            out.println("</tr>");
                            out.println("<tr id=b>");
                            out.println("<td colspan=2><b>Correo Electr&oacute;nico: </b>" + c.getCorreo() + "</td>");
                            out.println("<td colspan=2><b>Franja Horaria: </b>" + r.getFranjah() + "</td>");
                            out.println("</tr>");
                            out.println("<tr id=a>");
                            out.println("<td colspan=2><b>Telefono: </b>" + c.getTelefono() + "</td>");
                            out.println("<td colspan=2><b>Comensales: </b>" + r.getComensales() + "</td>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td colspan=2></td>");
                            out.println("<td colspan=2 id=b><b>Color del mantel: </b>" + r.getColor() + "</td>");
                            out.println("</tr>");
                            out.println("<tr>");
                            out.println("<td colspan=2></td>");
                            out.println("<td colspan=2 id=a><b>Demandas especiales: </b>" + r.getDemandas() + "</td>");
                            out.println("</tr>");
                            out.println("</table>");
                            
                            out.println("<p align=center><a href=http://localhost:8080/Eje2/> Volver al Formulario</a></p>");
                            out.println("</body>");
                            out.println("</html>");
                        }
            }
            else
            {
                //No hay sitio. Mensaje de no reserva
                    response.setContentType("text/html;charset=UTF-8");
                        try (PrintWriter out = response.getWriter())
                        {
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Error</title>");
                            out.println("<meta http-equiv=Refresh content=2;url=http://localhost:8080/Eje2/>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h3 style=color:red>El local esta lleno. Elige otro dia u otra franja horaria</h3>");
                            out.println("</body>");
                            out.println("</html>");
                        }  
            }
    }
    
    private boolean comprobarCapacidad(LocalDate f,String franjahoraria,int comensales)
    {
        int x,nro = comensales;
        for (x=0;x<listaReservas.size() && nro <=10;x++)
        {
            if (listaReservas.get(x).getFecha().isEqual(f) && listaReservas.get(x).getFranjah().equals(franjahoraria))
            {
                nro += listaReservas.get(x).getComensales();
                r = listaReservas.get(x);
            }    
        }
        return nro <= 10;
        
        /*
            if (nro >10)
                return false;
            return true;
        */
    }

    private boolean existe(String telefono)
    {
        int x;
        for(x=0;x<listaClientes.size() && !listaClientes.get(x).getTelefono().equals(telefono);x++){}
        if (x == listaClientes.size())
            return false;
        c = listaClientes.get(x);
        return true;
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //Variables globales
        private ArrayList<Reserva> listaReservas = new ArrayList();
        private ArrayList<Cliente> listaClientes = new ArrayList();
        private Cliente c;
        private Reserva r;
}
