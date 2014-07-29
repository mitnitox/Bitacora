
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Nave;
import negocio.Novedad;
import negocio.Puerto;
import negocio.TipoNovedad;
import negocio.Turno;
import negocio.Usuario;

public class NovedadSrvlt extends HttpServlet {
    private String id_usuario;
    private String id_puerto;
    private String id_turno;
    private String id_tipo_novedad;
    private String id_nave;
    private int numero_novedades;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
       
        try (PrintWriter out = response.getWriter()) {
                
                out.println("Servlet Novedad");
                String novedadx = request.getParameter("novedad");
                String nave = request.getParameter("nave");
                String muelle = request.getParameter("muelle");
                String enviar_novedad = request.getParameter("enviar_novedad");
                String nNave="NAVE";
                String nMuelle="MUELLE";
                
                String correo_sesion = (String)request.getSession().getAttribute("login");
                out.println("sesion: "+correo_sesion);
                
                if(correo_sesion!=null){
                    
                    if(novedadx!=null && novedadx.equals("SI")){
                        response.sendRedirect("menu_novedades.jsp");
                        out.println("novedades OK");
                    }
                    if(nave!=null && nave.equals("SI")){
                        out.println("nave");
                        request.setAttribute("nNave", nNave);
                        request.getRequestDispatcher("novedad.jsp").forward(request, response);
                        response.sendRedirect("novedad.jsp");
                    }
                    if(muelle!=null && muelle.equals("SI")){
                        out.println("muelle");
                        request.setAttribute("nMuelle", nMuelle);
                        request.getRequestDispatcher("novedad.jsp").forward(request, response);
                        response.sendRedirect("novedad.jsp");
                    }
                    if(enviar_novedad!=null){
                        String tipo_novedad = request.getParameter("tipo_novedad");
                        String con_nave = request.getParameter("con_nave");
                        String sin_nave = request.getParameter("sin_nave");
                        String fechayHora = request.getParameter("fecha");
                        String nauto = request.getParameter("nauto");
                        String obs = request.getParameter("obs");
                        String prioridad = request.getParameter("prioridad");
                        int estado_m = 1;
                        String estado = Integer.toString(estado_m);
                        
                        // Separar Hora y Fecha en 2 arreglos
                           
                        String[] partes = fechayHora.split(" ");
                        String fechax = partes[0]; 
                        String hora = partes[1];
                           
                        //convertir fecha formato mysql
                        String[] formatoActual = fechax.split("/");
                        String anio = formatoActual[0]; //2014
                        String mes = formatoActual[1];//07
                        String dia = formatoActual[2];//11
                           
                           
                        String fechaMysql =(anio+"-"+mes+"-"+dia);
                           
                        out.println("fecha mysql: "+fechaMysql);
                        out.println("hora: "+hora);
                           
                        out.println(nauto);
                        out.println(obs);
                        out.println(prioridad);
                        
                        //Obtengo el id_tipo_novedad 
                        TipoNovedad tn = new TipoNovedad();
                        tn.getIdTipoNovedadN(tipo_novedad);
                        for(int i=0;i<tn.getCantidad();i++){
                            id_tipo_novedad = tn.getId(i);
                        }
                        out.println("id tipo novedad: "+id_tipo_novedad);
                        
                        
                        
                        //obtengo el id_nave
                        Nave navex = new Nave();
                        navex.getIdNaveN(nauto);
                        for(int i=0;i<navex.getCantidad();i++){
                            id_nave = navex.getId(i);
                        }
                        out.println("id nave: "+id_nave);
                        //obtengo el id_turno
                        Turno  turno = new Turno();
                        turno.getIdTurno();
                        for(int i=0;i<turno.getCantidad();i++){
                            id_turno=turno.getId(i);
                        }
                        out.println("ultimo turno: "+id_turno);
                        
                        Novedad  novedad = new Novedad();
                        //Obtengo numero de novedades
                        
                        novedad.getIdNovedad();
                        numero_novedades=novedad.getCantidad();
                        out.println("Numero de novedades "+numero_novedades);
                        
                        if(tipo_novedad.equals("NAVE")){
                            out.println("novedad "+tipo_novedad);
                            novedad.insertar(id_tipo_novedad, id_nave, id_turno, fechaMysql, hora, obs, prioridad, estado);
                        }
                        if(tipo_novedad.equals("MUELLE")){
                            out.println("novedad "+tipo_novedad);
                            novedad.insertar(id_tipo_novedad, "0", id_turno, fechaMysql, hora, obs, prioridad, estado);
                        }
                        response.sendRedirect("menu_novedades.jsp");
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
