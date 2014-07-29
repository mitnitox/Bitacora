
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Puerto;
import negocio.Turno;
import negocio.Usuario;

public class TurnoSrvlt extends HttpServlet {
    private String id_usuario;
    private String id_puerto;
    private String id_turno;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        
        
        String abrir_turno = request.getParameter("abrir_turno");
        String cerrar_turno = request.getParameter("cerrar_turno"); 
        String menu_novedad = request.getParameter("menu_novedad");
        String consulta_turno = request.getParameter("consulta_turno");
        Usuario u = new Usuario();
        Turno t = new Turno();
       
        try (PrintWriter out = response.getWriter()) {
                
                out.println("Servlet Turnos");
                String correo_sesion = (String)request.getSession().getAttribute("login");
                out.println("sesion: "+correo_sesion);
                
                if(correo_sesion!=null){
                    
                    String abierto="Abierto";
                    String cerrado="Cerrado";
                    u.getIdUsuario(correo_sesion);
                    u.getIdPuerto(correo_sesion);
                    
                    if(menu_novedad!=null && menu_novedad.equals("SI")){
                        response.sendRedirect("menu_novedades.jsp");
                    }
                    // obtengo el id_usuario e id_puerto
                    for(int i=0;i<u.getCantidad();i++){
                        id_usuario = u.getId(i);
                        id_puerto = u.getPuerto(i);
                    }
             
                    t.getIdTurno();
                    for(int i=0;i<t.getCantidad();i++){
                        id_turno=t.getId(i);
                    }
                    out.println("id_usuario: "+id_usuario);
                    out.println("id_puerto: "+id_puerto);
                    out.println("utimo id: "+id_turno);
             
                    //Obtener la Fecha actual
                    Calendar Calendario = Calendar.getInstance();
                    String anio = Integer.toString(Calendario.get(Calendar.YEAR));
                    String mes = Integer.toString(Calendario.get(Calendar.MONTH) + 1);
                    String dia = Integer.toString(Calendario.get(Calendar.DATE));
                    String fecha_actual =(anio+"-"+mes+"-"+dia);
             
                    //Obtener la Hora actual
                    //HOUR  muestra 12 y no 24
                    String horax = Integer.toString(Calendario.get(Calendar.HOUR_OF_DAY));
                    String minuto = Integer.toString(Calendario.get(Calendar.MINUTE));
                    String segundo = Integer.toString(Calendario.get(Calendar.SECOND));
                    String hora_actual=(horax+":"+minuto+":"+segundo);
             
                    int estado = 1;

                    //Abre un turno (inserta en la tabla turno un nuevo registro)
                    if(abrir_turno!=null && abrir_turno.equals("SI")&& estado==1){  
                        out.println("Turno abierto");
                        String estado_bd = Integer.toString(estado);
                        t.abrir_Turno(id_usuario, id_puerto, fecha_actual, hora_actual, estado_bd);
                        request.setAttribute("abierto", abierto);
                        request.getRequestDispatcher("menu_operaciones.jsp").forward(request, response);
                        response.sendRedirect("menu_operaciones.jsp");
                    }    
                    estado=0;
                    if(cerrar_turno!=null && cerrar_turno.equals("SI")&& estado==0){ 
                        out.println("Turno cerrado");
                        String estado_bds = Integer.toString(estado);
                        t.cerrar_turno(fecha_actual, hora_actual, estado_bds, id_turno);
                        request.setAttribute("cerrado", cerrado);
                        request.getRequestDispatcher("menu.jsp").forward(request, response);
                        response.sendRedirect("menu.jsp");
                    } 
                    if(consulta_turno!=null && consulta_turno.equals("SI")){
                        response.sendRedirect("turno_view.jsp");
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
