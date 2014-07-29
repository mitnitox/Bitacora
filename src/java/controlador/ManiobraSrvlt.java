
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
import negocio.TipoManiobra;
import negocio.Maniobra;
import negocio.Nave;

public class ManiobraSrvlt extends HttpServlet {
    private String id_usuario;
    private String id_puerto;
    private String id_turno;
    private String id_tipo_maniobra;
    private String id_nave;
    private String mBita1;
    private String mBita2;
    private String mSitio;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
       
        try (PrintWriter out = response.getWriter()) {
                
                String maniobra = request.getParameter("maniobra");
                String atraque = request.getParameter("atraque");
                String zarpe = request.getParameter("zarpe");
                String enviar_maniobra = request.getParameter("enviar_maniobra");
                
                String mAtraque="ATRAQUE";
                String mZarpe="ZARPE";
                
                out.println("Servlet Maniobras");
                String correo_sesion = (String)request.getSession().getAttribute("login");
                out.println("sesion: "+correo_sesion);
                
                
                
                
                    /*out.println("Bita1: "+mBita1);
                    out.println("Bita2: "+mBita2);
                    out.println("Sitio"+mSitio);*/
                
                if(correo_sesion!=null){
                    if(maniobra!=null && maniobra.equals("SI")){
                        response.sendRedirect("menu_maniobra.jsp");
                    }
                    if(atraque!=null && atraque.equals("SI")){
                        out.println("atraque OK");
                        request.setAttribute("mAtraque", mAtraque);
                        request.getRequestDispatcher("maniobra.jsp").forward(request, response);
                        response.sendRedirect("maniobra.jsp");
                    }
                    if(zarpe!=null && zarpe.equals("SI")){
                        out.println("zarpe OK");
                        request.setAttribute("mZarpe", mZarpe);
                        request.getRequestDispatcher("maniobra.jsp").forward(request, response);
                        response.sendRedirect("maniobra.jsp");
                    }
                    if(enviar_maniobra!=null){
                        
                        Maniobra ma = new Maniobra();
                        Maniobra mSB = new Maniobra();
                        String fechayHora = request.getParameter("fecha");
                        String nauto = request.getParameter("nauto");
                        //String nave = request.getParameter("nave");
                        String bita1 = request.getParameter("bita1");
                        String bita2 = request.getParameter("bita2");
                        String sitio = request.getParameter("sitio");
                        String c_proa = request.getParameter("c_proa");
                        String c_popa = request.getParameter("c_popa");
                        String capacidad = request.getParameter("capacidad");
                        String nacionalidad = request.getParameter("nacionalidad");
                        String obs_maniobra = request.getParameter("obs");
                        String tipo_maniobra = request.getParameter("tipo_maniobra");
                        int estado_m = 1;
                        String estado = Integer.toString(estado_m);
                       
                        //out.println(tipo_maniobra);
                        //out.println(fechayHora);
                        //out.println(nauto);
                        //out.println(nave);
                        //out.println(bita1);
                        //out.println(bita2);
                        //out.println(sitio);
                        //out.println(c_proa);
                        //out.println(c_popa);
                        //out.println(capacidad);
                        //out.println(nacionalidad);
                        //out.println(obs_maniobra);
                        
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
                           //out.println("fecha mysql: "+fechaMysql);
                           //out.println(hora);
                        
                        // Obtengo el ultimo id_turno
                        Turno  turno = new Turno();
                        turno.getIdTurno();
                        for(int i=0;i<turno.getCantidad();i++){
                            id_turno=turno.getId(i);
                        }
                        
                        
                        //Obtengo el tipo de id_tipo_maniobra
                        TipoManiobra tipo = new TipoManiobra();
                        tipo.getIdTipoManiobraN(tipo_maniobra);
                        for(int i=0;i<tipo.getCantidad();i++){
                            id_tipo_maniobra=tipo.getId(i);
                        }
                        //Obtengo el id_nave
                        Nave navex = new Nave();
                        navex.getIdNaveN(nauto);
                        for(int i=0;i<navex.getCantidad();i++){
                            id_nave=navex.getId(i);
                        }
                        
                        
                             mSB.getSitioYbitas();
                        out.println(mSB.getCantidad());
                        
                        //Inserto los datos si las bitas no son iguales si el sitio no está ocupado
                        //y si el tipo_maniobra es ATRAQUE
                        
                        if(tipo_maniobra.equals("ATRAQUE")){
                            
                            if(!bita1.equals(bita2)){

                                ma.seSitio(sitio);
                                ma.setEstado(estado);
                                if(ma.AtraqueValido()==true){
                                    ma.insertar(id_turno, id_tipo_maniobra, fechaMysql, hora, id_nave, bita1, bita2, sitio, c_proa, c_popa, obs_maniobra, estado);
                                    response.sendRedirect("menu_maniobra.jsp");
                                }
                                else{
                                    out.println("El sitio está ocupado");
                                }
                            
                            }
                            else{
                                out.println("Las bitas no pueden ser igules");
                            }
                        } else if(tipo_maniobra.equals("ZARPE")){
                                    if(!bita1.equals(bita2)){
                                        Maniobra mz = new Maniobra();
                                            estado="0";
                                            mz.insertar(id_turno, id_tipo_maniobra, fechaMysql, hora, id_nave, bita1, bita2, sitio, c_proa, c_popa, obs_maniobra, estado);
                                            response.sendRedirect("menu_maniobra.jsp");    
                                    }
                                    else{
                                        out.println("Las bitas no pueden ser igules");
                                    }
                            }
                            
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
