<%
	String login = (String)request.getSession().getAttribute("login");
        

	if(login!=null){
		
%>
<%@page contentType="text/html" pageEncoding="UTF-8"
import="negocio.Usuario"
import="negocio.Turno"
%>
<!DOCTYPE html>
<head>
<%@include file="WEB-INF/jspf/header.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultas Turno</title>
</head>
<body>
    <%@include file="WEB-INF/jspf/navtop.jspf"%>
        <!--CONTAINER-->
	<div class="container">
            <%
                out.println("<b>"+login+"</b>");

            %>
            <a href="SesionSrvlt?cerrar=1">Cerrar Sessión</a><br>
            <center>
                <h3>TURNOS REALIZADOS</h3>
                <table class="table table-hover">
                                <th>ID</th><th>Nombres</th><th>Apellidos</th><th>Puerto</th><th>Fecha Inicio</th><th>Hora</th><th>Fecha Termino</th><th>Hora</th>
                                <tr>
                                    <%
                                        
					Turno t = new Turno();
						
					t.ConsultaTurno();
					//out.println(t.getCantidad()); probando hacer un push
					for(int i=0; i<t.getCantidad();i++){
                                            out.println("<tr><td><a href='UsuarioSrvlt?id="+t.getId(i)+"&accion=editar'>"+t.getId(i)+"</a></td>");
                                            out.println("<td><a href=''>"+t.getNombres(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+t.getApellidos(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+t.getPuerto(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+t.getFechaInicio(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+t.getHoraInicio(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+t.getFechaFinal(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+t.getHoraFinal(i)+"</a></td>");
					}                         
                                    %>                                    
                                </tr>
                                
                            </table>
                <br><hr>
                    <br><hr>
                <br><button type="button" class="btn btn-primary btn-lg btn-block" onclick="window.location.href='menu_consultas.jsp'">
                    VOLVER&nbsp;&nbsp;<span class="glyphicon"></span>
                </button>
            </center>
	</div>	
<!--FIN CONTAINER-->
            
        
        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </body>
    
    <%}
        else{
            response.sendRedirect("login.jsp");
        }
    %>
