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
<title>Novedades</title>
</head>
<body>
    <%@include file="WEB-INF/jspf/navtop.jspf"%>
        <!--CONTAINER-->
	<div class="container">
            <%out.println(login);%><a href="SesionSrvlt?cerrar=1">Cerrar Sessión</a><br><br>
            <center>
                <form method="post" action="NovedadSrvlt">
                    <input type="hidden" name="nave" value="SI">
                    <button type="submit" class="btn btn-default btn-lg btn-block">
                       NOVEDAD DE LA NAVE&nbsp;&nbsp;<span class="glyphicon glyphicon-bullhorn"></span>
                    </button>
                </form><br>
                <form method="post" action="NovedadSrvlt">
                    <input type="hidden" name="muelle" value="SI">
                    <button type="submit" class="btn btn-default btn-lg btn-block">
                        NOVEDAD DEL MUELLE&nbsp;&nbsp;<span class="glyphicon glyphicon-bullhorn"></span>
                    </button>
                </form><br>
                <form method="post" action="TurnoSrvlt">
                    <input type="hidden" name="cerrar_turno" value="SI">
                    <button  type="submit" class="btn btn-danger btn-lg btn-block">
                        CERRAR TURNO&nbsp;&nbsp;<span class="glyphicon glyphicon-remove"></span>
                    </button>
                </form>
                    <hr>
                    <button type="button" class="btn btn-primary btn-lg btn-block" onclick="window.location.href='menu_operaciones.jsp'">VOLVER ATRAS</button>
                    <!--<button type="button" class="btn btn-primary btn-lg btn-block" onclick="window.location.href='menu.jsp'">VOLVER AL MENU</button>-->
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
