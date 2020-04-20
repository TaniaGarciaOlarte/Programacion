/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import MisClases.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TaNiA
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
    
    private ArrayList<Persona> listadepersonas;
    private ArrayList<Usuario> listausuarios;
    
    @Override
    public void init() throws ServletException{
        listadepersonas = new ArrayList();
        listausuarios = new ArrayList();
        
        usuariopepe();
        usuariotania();
    }
    
    public void usuariopepe()
    {
        listausuarios.add(new Usuario("pr09","12345Abcde"));
        listausuarios.add(new Usuario("pepito","Abcde12345"));
        
        Persona p = new Persona("Pepe Ruiz","111111111A");
        p.setListaUsuarios(listausuarios);
        listadepersonas.add(p);
    }
    
    public void usuariotania()
    {
        listausuarios = new ArrayList();
        
        listausuarios.add(new Usuario("tania15","Jm12345"));
        listausuarios.add(new Usuario("taniagarcia15","Tg12345"));
        
        Persona p = new Persona("Tania Garcia","22222222B");
        p.setListaUsuarios(listausuarios);
        listadepersonas.add(p);
    }
    
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
        
        String usuario = request.getParameter("usuario");
        String contra = request.getParameter("contra");
        int x,y=0;
        boolean encontrado=false;
        
        for(x=0;x<listadepersonas.size() && !encontrado;x++)
        {
            for(y=0;y<listadepersonas.get(x).getListaUsuarios().size() && !listadepersonas.get(x).getListaUsuarios().get(y).getUsuario().equals(usuario);y++){}
            if(y<listadepersonas.get(x).getListaUsuarios().size())
                encontrado = true;
        }
        
        if (encontrado)
        {
            Usuario u = listadepersonas.get(x-1).getListaUsuarios().get(y);
            if(u.getContra().equals(contra))
                responder("Bienvenid@ al Ejercicio1 " + listadepersonas.get(x-1).getNombre(),response,true);
            else
                responder("Usuario o contraseña no valido",response,false);
        }
        else
        {
            responder("Usuario o contraseña no valido",response,false);
        }
    }    
        
    private void responder(String mensaje,HttpServletResponse response,boolean ejemplo) throws ServletException,IOException
    {
        
            response.setContentType("texthtml.charse=UTF-8");
            try(PrintWriter out = response.getWriter())
            {
                if(ejemplo)
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Ejercicio1</title>");
                    out.println("<head>");
                    out.println("<body>");
                    out.println("<h1>" + mensaje + "</h1>");
                    out.println("<a href=http://localhost:8080/Eje1/> Volver a la Pagina Principal</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
                else
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<style>");
                    out.println("h1 {color:red;font-size:15pt;};");
                    out.println("</style>");
                    out.println("<title>Error</title>");
                    out.println("<meta http-equiv=Refresh content=2;url=http://localhost:8080/Eje1/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>" + mensaje + "</h1>");
                    out.println("</body>");
                    out.println("</html>");   
                }   
            }
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

}
