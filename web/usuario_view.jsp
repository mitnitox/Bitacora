<%
	String login = (String)request.getSession().getAttribute("login");

	if(login!=null){
		
%>
<%@page contentType="text/html" pageEncoding="UTF-8"
import="negocio.Usuario"%>
<!DOCTYPE html>
<head>
<%@include file="WEB-INF/jspf/header.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuarios</title>
</head>
<body>
    <%@include file="WEB-INF/jspf/navtop.jspf"%>
        <!--CONTAINER-->
	<div class="container">
            <%out.println(login);%><a href="SesionSrvlt?cerrar=1">Cerrar Sessión</a><br><br>
		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="#inicio" data-toggle="tab">Inicio</a></li>
			<li><a href="#usuarios" data-toggle="tab">Usuarios</a></li>
			<li><a href="#arribos" data-toggle="tab">Arribos</a></li>
			<li><a href="#zarpes" data-toggle="tab">Zarpes</a></li>
			<li><a href="#novedades" data-toggle="tab">Novedades (3)</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane fade in active" id="inicio">
                            <h2>Usuarios</h2></div>
                            
			<div class="tab-pane fade" id="usuarios">
                            <h2>Usuarios</h2>
                            <table class="table table-hover">
                                <th>ID</th><th>Nombres</th><th>Apellidos</th><th>Correo</th><th>Password</th><th>Cargo</th><th>Puerto</th><th>Perfil</th><th>Estado</th>
                                <tr>
                                    <%
					Usuario u = new Usuario();
						
					u.mostrar();
					//out.println(u.getCantidad());
					for(int i=0; i<u.getCantidad();i++){
                                            out.println("<tr><td><a href='UsuarioSrvlt?id="+u.getId(i)+"&accion=editar'>"+u.getId(i)+"</a></td>");
                                            out.println("<td><a href=''>"+u.getNombres(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+u.getApellidos(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+u.getCorreo(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+u.getPass(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+u.getCargo(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+u.getPuerto(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+u.getPerfil(i)+"</a></td>");
                                            out.println("<td><a href='#'>"+u.getEstado(i)+"</a></td>");
					}                         
                                    %>                                    
                                </tr>
                                
                            </table>
                        </div>
			<div class="tab-pane fade" id="arribos"><h2>Menú Arribos</h2></div>
			<div class="tab-pane fade" id="zarpes"><h2>Menú Zarpes</h2></div>
			<div class="tab-pane fade" id="novedades"><h2>Menú Novedades</h2></div>
		</div>
	</div>	
<!--FIN CONTAINER-->
            
         
        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </body>
    
    <%}
        else{
            response.sendRedirect("login.jsp");
        }
    %>