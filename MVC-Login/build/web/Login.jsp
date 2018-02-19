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
        <img src="logo.png"/>
        <form name="form" action="LoginServlet" method="post">
            <fieldset> <legend> Datos de Usuario </legend>
            Usuario: <input type="text" name="usuario" /><br/>
            Contraseña: <input type="password" name="password" /><br/>
            
            <p style="color:red"><%=(request.getAttribute("mensaError") == null) ? ""
                 : request.getAttribute("mensaError")%></p>
            
            <input type="submit" value="Entrar">
            <input type="reset" value="Borrar">            
            </fieldset>
                 
        </form>
    </body>
</html>
