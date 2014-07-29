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
<title>Menú del sistema</title>
</head>
<body>
    <%@include file="WEB-INF/jspf/navtop.jspf"%>
        <!--CONTAINER-->
	<div class="container">
            <%
                out.println("<b>"+login+"</b>");

            %>
                <a href="SesionSrvlt?cerrar=1">Cerrar Sessión</a><br>
            <%
                String id_ultimo_turno=(String)request.getAttribute("id_ultimo_turno");
                String nombres=(String)request.getAttribute("nombres");
                String apellidos=(String)request.getAttribute("apellidos");
                if(id_ultimo_turno!=null && nombres!=null && apellidos!=null){
            %>
                    <br>
                    <%
                    out.println("El último turno fue de: "+nombres+" "+apellidos+"");
                }
            %>
            <center>
                <%
                    String cerrado=(String)request.getAttribute("cerrado");
                    if(cerrado!=null){
                        out.println("Turno "+cerrado);
                    }
                %>
                <br><button type="button" class="btn btn-primary btn-lg btn-block" onclick="window.location.href='turno.jsp'">
                    TURNOS&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar"></span>
                </button>
                <!--<button type="button" class="btn btn-default btn-lg btn-block" onclick="window.location.href='menu_novedades.jsp'">NOVEDADES
                &nbsp;&nbsp;<span class="glyphicon glyphicon-bell"></span></button>-->
                <!--<button type="button" class="btn btn-primary btn-lg btn-block">
                    SITUACION NAVIERA&nbsp;&nbsp;<span class="glyphicon glyphicon-open"></span></button>--><br><hr>
                    <table border="1">
                        <table border="1" class="table table-bordered">
                            <tr>
                                <td colspan="2">SITIO 1 NORTE</td><td>-</td><td colspan="2">SITIO 3 SUR</td>
                            </tr>

                            <tr>
                                <td>BITA 1</td><td>BITA 2</td>
                                <td>-</td><td>BITA 5</td><td>BITA 6</td>
                            </tr>
                            <tr>
                                <td colspan="2">SITIO 2 NORTE</td><td>-</td><td colspan="2">SITIO 4 SUR</td>
                            </tr>

                            <tr>
                                <td>BITA 3</td><td>BITA 4</td>
                                <td>-</td><td>BITA 7</td><td>BITA 8</td>
                            </tr>
                            </table>
                    <br><hr>
                <br><button type="button" class="btn btn-default btn-lg btn-block" onclick="window.location.href='menu_consultas.jsp'">
                    CONSULTAS&nbsp;&nbsp;<span class="glyphicon glyphicon-search"></span>
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
