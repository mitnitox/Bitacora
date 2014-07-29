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
                <% String mAtraque =(String)request.getAttribute("mAtraque");
                           String mZarpe =(String)request.getAttribute("mZarpe");
                           String aux="";
                            if(mAtraque!=null){
                                aux=mAtraque;
                            }
                            if(mZarpe!=null){
                                aux=mZarpe;
                            }
                        %> 
                    <h2 class="form-signin-heading">MANIOBRA <%=aux%></h2>
                   
                    <form method="post" action="ManiobraSrvlt">
                        <input type="hidden" name="tipo_maniobra" value="<%=aux%>">
                        <input type="text" name="fecha" class="form-control" id="fecha" placeholder="FECHA <%=aux%>"><br>
                        <input type="text" name="nauto" class="form-control" id="auto" placeholder="BUSCAR NAVE"><br>
                         <script>
				jQuery('#fecha').datetimepicker();
                        </script>
                        <script>
                            var datos=<%=formatoJson %>
				jQuery( "#auto" ).autocomplete({
                                    source: datos
                            });
                        </script>
                        <select name="bita1" class="form-control">
                            <option value="1">BITA 1</option>
                            <option value="2">BITA 2</option>
                            <option value="3">BITA 3</option>
                            <option value="4">BITA 4</option>
                            <option value="5">BITA 5</option>
                            <option value="6">BITA 6</option>
                            <option value="7">BITA 7</option>
                            <option value="8">BITA 8</option>
                        </select><br>
                        <select name="bita2" class="form-control">
                            <option value="1">BITA 1</option>
                            <option value="2">BITA 2</option>
                            <option value="3">BITA 3</option>
                            <option value="4">BITA 4</option>
                            <option value="5">BITA 5</option>
                            <option value="6">BITA 6</option>
                            <option value="7">BITA 7</option>
                            <option value="8">BITA 8</option>
                        </select><br>
                        <select name="sitio" class="form-control">
                            <option value="1 NORTE">SITIO 1 NORTE</option>
                            <option value="2 NORTE">SITIO 2 NORTE</option>
                            <option value="3 SUR">SITIO 3 SUR</option>
                            <option value="4 SUR">SITIO 4 SUR</option>
                        </select><br>
                        <input type="text" name="c_proa" class="form-control" placeholder="CALADO PROA"><br>
                        <input type="text" name="c_popa" class="form-control" placeholder="CALADO POPA"><br>
                        <input type="text" name="nacionalidad" class="form-control" placeholder="NACIONALIDAD"><br>
                        <textarea  rows="3" name="obs" class="form-control" placeholder="OBSERVACIONES..."></textarea><br>
                        <button  type="submit" name="enviar_maniobra" class="btn btn-success btn-lg btn-block">
                        ENVIAR&nbsp;&nbsp;<span class="glyphicon glyphicon-ok"></span>
                        </button>
                    </form>
                <!--<form method="post" action="TurnoSrvlt">
                    <input type="hidden" name="cerrar_turno" value="SI">
                    <button  type="submit" class="btn btn-warning btn-lg btn-block">
                        CERRAR TURNO&nbsp;&nbsp;<span class="glyphicon glyphicon-calendar"></span>
                    </button>
                </form>-->
                    <hr>
                    <button type="button" class="btn btn-default btn-lg btn-block" onclick="window.location.href='menu_maniobra.jsp'">VOLVER ATRAS</button>
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
