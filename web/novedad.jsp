<%
	String login = (String)request.getSession().getAttribute("login");
        session.setAttribute("login",login);

	if(login!=null){
		
%>
<%@page contentType="text/html" pageEncoding="UTF-8"
import="negocio.Usuario"
import="negocio.Nave"
import="java.util.ArrayList"
import="com.google.gson.Gson"
%>
<!DOCTYPE html>
<head>
<%@include file="WEB-INF/jspf/header.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="datetimepicker-master/jquery.js" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="datetimepicker-master/jquery.datetimepicker.js" type="text/javascript"></script>
<link rel="stylesheet" href="datetimepicker-master/jquery.datetimepicker.css">

<title>Nueva Novedad</title>
</head>
<body>
    <%@include file="WEB-INF/jspf/navtop.jspf"%>
        <!--CONTAINER-->
	<div class="container">
            <%out.println(login);%><a href="SesionSrvlt?cerrar=1">Cerrar Sessión</a><br><br>
            <%
                 Nave naves = new Nave();
                 Gson g = new Gson();
                 naves.mostrar();
                 ArrayList<String> nauto = new ArrayList<String>();
                 for(int i=0;i<naves.getCantidad();i++){
                     nauto.add(naves.getNombre(i));
                 }
                 for(int i=0;i<naves.getCantidad();i++){
                     //out.println("Desde ArrayList "+nauto.get(i));
                 }
                 //conversion a formato Json con Gason de google
                 String formatoJson = g.toJson(nauto);
                 //out.println(formatoJson);

            %>
            <center>
                <%  
                    String nNave =(String)request.getAttribute("nNave");
                    String nMuelle =(String)request.getAttribute("nMuelle");
                    String aux="";
                    if(nNave!=null){
                        aux=nNave;
                    }
                    if(nMuelle!=null){
                        aux=nMuelle;
                    }
                    request.setAttribute("aux",aux);
                    %> 
                    <h2 class="form-signin-heading">NOVEDAD <%=aux%></h2>
                   
                    <form method="post" action="NovedadSrvlt">
                        <input type="hidden" name="tipo_novedad" value="<%=aux%>">
                        <input type="hidden" name="con_nave" value="SI">
                        <input type="hidden" name="sin_nave" value="NO">
                        <input type="text" name="fecha" class="form-control" id="fecha" placeholder="FECHA NOVEDAD"><br>
        
                        <input type="text" name="nauto" class="form-control" id="auto" placeholder="BUSCAR NAVE">
                         <script>
				jQuery('#fecha').datetimepicker();
                        </script>
                        <script>
                            var datos=<%=formatoJson %>
				jQuery( "#auto" ).autocomplete({
                                    source: datos
                            });
                        </script>
                        <%
                            if(aux.equals("MUELLE")){
                        %>
                                <script>
                                    jQuery("#auto").hide();
                                </script>
                        <%
                            }
                            else{
                                %>
                                <br>
                                <%
                            }
                        %>
                        <textarea  rows="3" name="obs" class="form-control" placeholder="OBSERVACIONES..."></textarea><br>
                        PRIORIDAD &nbsp;<input type="radio" name="prioridad" value="BAJA" checked> BAJA
                        <input type="radio" name="prioridad" value="MEDIA"> MEDIA
                        <input type="radio" name="prioridad" value="ALTA"> ALTA
                        <hr>
                        <button  type="submit" name="enviar_novedad" class="btn btn-success btn-lg btn-block">
                        ENVIAR&nbsp;&nbsp;<span class="glyphicon glyphicon-ok"></span>
                        </button>
                    </form>
                <!--<form method="post" action="TurnoSrvlt">
                    <input type="hidden" name="cerrar_turno" value="SI">
                    <button  type="submit" class="btn btn-warning btn-lg btn-block">
                        CERRAR TURNO&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar"></span>
                    </button><br>
                </form>-->
                    <hr>
                    <button type="button" class="btn btn-default btn-lg btn-block" onclick="window.location.href='menu_novedades.jsp'">VOLVER ATRAS</button>
                    <button type="button" class="btn btn-primary btn-lg btn-block" onclick="window.location.href='menu_operaciones.jsp'">VOLVER AL MENU</button>        
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
