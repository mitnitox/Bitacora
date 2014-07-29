<%
	String login = (String)request.getSession().getAttribute("login");
        session.setAttribute("login",login);

	if(login!=null){
		
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <head>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navtop.jspf"%>
        <!--CONTAINER-->
	<div class="container">
		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="#inicio" data-toggle="tab">Inicio</a></li>
			<li><a href="#turno" data-toggle="tab">Turno</a></li>
			<li><a href="#arribos" data-toggle="tab">Arribos</a></li>
			<li><a href="#zarpes" data-toggle="tab">Zarpes</a></li>
			<li><a href="#novedades" data-toggle="tab">Novedades (3)</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane fade in active" id="inicio"><h2>Menú</h2></div>
			<div class="tab-pane fade" id="turno"><h2>Menú Turno</h2></div>
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
