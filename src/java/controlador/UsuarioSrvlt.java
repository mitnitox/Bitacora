
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioSrvlt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        
        String accion = request.getParameter("accion");
        String id; 
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("Servlet Usuario");
            String correo_sesion = (String)request.getSession().getAttribute("login");
            out.println("sesion: "+correo_sesion);
            
            if(correo_sesion!=null){
                
                out.println("Servlet Usuario");
          
                accion = request.getParameter("accion");
            
                if(accion!=null && accion.equals("editar")){
                    id = request.getParameter("id");
                    out.println("id OK");
                //response.sendRedirect("usuario_view.jsp");
                }
            }
            else{
                HttpSession session = request.getSession(false);
                response.sendRedirect("login.jsp");
            }
        }
            
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
