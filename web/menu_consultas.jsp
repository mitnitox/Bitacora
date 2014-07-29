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
<title>Consultas</title>
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
                <%
                    String cerrado=(String)request.getAttribute("cerrado");
                    if(cerrado!=null){
                        out.println("Turno "+cerrado);
                    }
                %>
                <h3>CONSULTAS</h3>
                <form method="post" action="TurnoSrvlt">
                    <input type="hidden" name="consulta_turno" value="SI">
                    <button  type="submit" class="btn btn-default btn-lg btn-block">
                        TURNOS&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
                <br>
               <!-- <form method="post" action="TurnoSrvlt">-->
                    <button  type="submit" class="btn btn-primary btn-lg btn-block">
                        MANIOBRAS&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></span>
                    </button>
                <!--</form>-->
                <br>
                <!--<form method="post" action="TurnoSrvlt">-->
                    <button  type="submit" class="btn btn-default btn-lg btn-block">
                        NOVEDADES&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></span>
                    </button>
                <!--</form>-->
                <!--<button type="button" class="btn btn-default btn-lg btn-block" onclick="window.location.href='menu_novedades.jsp'">NOVEDADES
                &nbsp;&nbsp;<span class="glyphicon glyphicon-bell"></span></button>-->
                <!--<button type="button" class="btn btn-primary btn-lg btn-block">
                    SITUACION NAVIERA&nbsp;&nbsp;<span class="glyphicon glyphicon-open"></span></button>--><br><hr>
                <br><button type="button" class="btn btn-primary btn-lg btn-block" onclick="window.location.href='turno.jsp'">
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
