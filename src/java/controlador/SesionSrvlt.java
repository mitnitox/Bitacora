
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Usuario;
import negocio.Turno;
import negocio.Novedad;


public class SesionSrvlt extends HttpServlet {
    private String id_usuario;
    private String id_ultimo_turno;
    private String nombres;
    private String apellidos;
    private int numero_novedades;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");
        String cerrar = request.getParameter("cerrar");
        String abrir_turno = request.getParameter("abrir_turno");
        
        Usuario u = new Usuario();
        
        u.setCorreo(correo);
        u.setPass(pass);
        
        try (PrintWriter out = response.getWriter()) {
            
            u.UsuarioExiste(pass, correo);
            
            if(u.getValido()==true){
                HttpSession session = request.getSession(true);//crea una session si no existe una  
    		session.setMaxInactiveInterval(-1); //-1 sesion nunca caduca? //1 minutos de duración  
    		session.setAttribute("login", correo); //supongo que username en este caso es un String pero podría ser cualquier otro objeto.  
                
                Turno turno = new Turno();
                turno.getIdTurnoUsuario();
                for(int i=0;i<turno.getCantidad();i++){
                    id_ultimo_turno=turno.getId(i);
                    nombres=turno.getNombres(i);
                    apellidos=turno.getApellidos(i);
                }
                Novedad novedad = new Novedad();
                novedad.getIdNovedad();
                numero_novedades=novedad.getCantidad();
                out.println("Numero de novedades "+numero_novedades);
                
                request.setAttribute("numero_novedades", new Integer(numero_novedades));
                request.setAttribute("id_ultimo_turno", id_ultimo_turno);
                request.setAttribute("nombres", nombres);
                request.setAttribute("apellidos", apellidos);
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                response.sendRedirect("menu.jsp");
                
                
    		response.sendRedirect("menu.jsp");
            }
            else{
                HttpSession session = request.getSession(false);
                response.sendRedirect("login.jsp");
            }
            
            if(cerrar !=null && cerrar.equals("1")){
			HttpSession session = request.getSession(false);
			session.invalidate();
            }
            
            
            
            
            
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
