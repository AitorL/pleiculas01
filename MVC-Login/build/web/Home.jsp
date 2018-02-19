<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coches Classics</title>
        <style type="text/css">
            body {
                background-color: lightgrey;
            }
        </style>
    </head>
    <body>
        <div id="cabecera">
    <center> <img src="logo.png"/> </center>
        <p>Bienvenido <b><%=request.getAttribute("nombreUsuario") %></b>
        || <a href="LogoutServlet">Cerrar sesión</a> </p>
        </div>
        
        <div id="menu">
<!--        <b> MENU: </b>
        <a href="consulta">Consultar</a> |
        <a href="modificar">Modificar</a> |
        <a href="alta">Alta</a> -->
        <jsp:include page="menu.jsp"/>
        </div>
        
        <hr/>
        
        <div id="cuerpo">
            <jsp:include page=""/>
        </div>
        <hr>
        <div id="pie">
            Pie
        </div>
        
    </body>
</html>
