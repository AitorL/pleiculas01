<%@page import="java.util.ArrayList"%>
<%@page import="modelo.cocheObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
            <%   
        request.setCharacterEncoding("UTF-8");
        ArrayList <cocheObj> listacoches = (ArrayList <cocheObj>) request.getAttribute("listacoches");
    %>
    <body>
        
     
        <div>  
            <jsp:include page="menu.jsp"/>
            <article>
                    <div> 
                        <div>
                            <h2><strong>Listado de Productos</strong>
                                <span>Conectado como <strong><%= session.getAttribute("user") %>
                                </strong></span>
                            </h2>
                        </div>
                    </div>    
            <%
               if ( listacoches != null )  {
            %>    
                <hr>
              <%
                    for ( cocheObj coche : listacoches ) {                      
              %>
                    <div>
                        <span><%= coche.getMatricula() %></span><br/>
                        <span><%= coche.getMarca() %></span><br/>
                        <span><%= coche.getModelo() %></span><br/>
                        <span><%= coche.getPrecio() %></span><br/>
                        <span><%= coche.getEstado() %></span><br/>
                        <span><%= coche.getDescripcion() %></span><br/>
                        <span><img src="img<%= coche.getImagen() %>.jpg"/></span><br/>
                        
                        </div>
                         
                    </div>    
                        
              <%
                    }
                }
              %>
    </body>
</html>
