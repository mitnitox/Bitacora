<%
	String login = (String)request.getSession().getAttribute("login");
        session.setAttribute("login",login);

	if(login!=null){
		
%>
<%@page contentType="text/html" pageEncoding="UTF-8"
import="negocio.Usuario"%>
<!DOCTYPE html>
<head>
<%@include file="WEB-INF/jspf/header.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menú Turno</title>
</head>
<body>
    <%@include file="WEB-INF/jspf/navtop.jspf"%>
        <!--CONTAINER-->
	<div class="container">
            <%out.println(login);%><a href="SesionSrvlt?cerrar=1">Cerrar Sessión</a><br><br>
            <center>
                <form method="post" action="TurnoSrvlt">
                    <input type="hidden" name="abrir_turno" value="SI">
                    <button id="boton" type="submit" class="btn btn-default btn-lg btn-block">
                        ABRIR TURNO&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar"></span>
                    </button>
                </form><br><hr>
                <script>
                    $( "#boton" ).click(function() {
                        //$(this).hide();
                     });           
                </script>
                   <button type="button" class="btn btn-primary btn-lg btn-block" onclick="window.location.href='menu.jsp'">VOLVER AL MENU</button>
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
