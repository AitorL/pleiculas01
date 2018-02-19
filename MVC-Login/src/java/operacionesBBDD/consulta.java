package operacionesBBDD;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import util.ConexionBD;
import modelo.cocheObj;
@WebServlet(name="consulta",urlPatterns=("/consulta"))

    public class consulta extends HttpServlet {
    
        private static final long serialVersionUID = 1L;
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /*if ( request.getSession().getAttribute("nombreUsuario") == null ) {  // Si no existe una sesión ir a login.jsp
           request.getRequestDispatcher("Login.jsp").include(request, response); 
           out.println("<p style=\"color:red; font-weight:bold\">");
	   out.println("Para entrar debe autenticarse primero.</p>");
        
        } else {*/
        try {
            
        Connection conn = ConexionBD.createConnection();     
        Statement stmt = conn.createStatement();
        
        String sqlStr = "select * from coches";
        ResultSet rset = stmt.executeQuery(sqlStr);
       
        ArrayList <cocheObj> listacoches = new ArrayList <cocheObj>(); 
        
        //cocheObj Coche = new cocheObj();
        //listacoches.add(Coche);
        while (rset.next()) {
            String matricula = rset.getString("matricula");
            String marca = rset.getString("marca");
            String modelo = rset.getString("modelo");
            String descripcion = rset.getString("descripcion");
            Double precio = rset.getDouble("precio");
            String estado = rset.getString("estado");
            String imagen = rset.getString("imagen");

            cocheObj Coche = new cocheObj(matricula,marca,modelo,descripcion,precio,estado,imagen);
            listacoches.add(Coche);
            
        }
        request.setAttribute("listacoches", listacoches);   
        
        rset.close();
        stmt.close();
        conn.close(); 
                
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaVista.jsp");
        dispatcher.forward(request, response); 
        
        
        } catch (Exception ex) {
        ex.printStackTrace();
        } 

   
        }
   }
//}