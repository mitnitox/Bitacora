
<%@page contentType="text/html" pageEncoding="UTF-8"
import="negocio.Usuario"%>
<!DOCTYPE html>
<head>
<%@include file="WEB-INF/jspf/header.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicio de Sesión</title>
</head>
<body>  
     <div class="container">
        <form class="form-signin well-sm" method="post" action="SesionSrvlt">
            <h2 class="form-signin-heading">Iniciar Sesi&oacute;n</h2>
            <input type="text" name="correo" class="form-control" placeholder="Correo electronico"><br>
            <input type="password" name="pass" class="form-control" placeholder="Password">
            <label class="checkbox">
            </label>
            <button class="btn btn-large btn-primary" type="submit" name="iniciar_sesion">Ingresar</button>
        </form>
     </div>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </body>
