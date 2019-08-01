/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.get.Servlet;

import sv.get.Bean.ArticuloBean;
import sv.get.Entidades.Articulos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.get.EJB.ArticuloServiceLocal;

/**
 *
 * @author gerardo
 */
@WebServlet(urlPatterns = "/MostrarArticulo")
public class Mostrar extends HttpServlet {
    @EJB
    private ArticuloServiceLocal artSerLocal;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String nombre = request.getParameter("nombre");
        String descrip = request.getParameter("descripcion");
        
        Articulos art = new Articulos();
        art.setNombre(nombre);
        art.setDescripcion(descrip);
       
        List<Articulos> listaArt = artSerLocal.obtenerMedicamentos();
        
        
//        beanArt.getMedicamento();
//        List<Articulos> listaArt = beanArt.getMedicamento();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Mostrar</title>");            
            out.println("</head>");
            out.println("<body>");
            for(Articulos cate : listaArt){
                out.println("<tr>");
                out.println("<td>"+cate.getId()+"</td>");
                out.println("<td>"+cate.getNombre()+"</td>");
                out.println("</tr>");
            }
            out.println("<h1>Medicamentos en Bodega</h1>");
            
            out.println("<h1>Servlet Mostrar at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
