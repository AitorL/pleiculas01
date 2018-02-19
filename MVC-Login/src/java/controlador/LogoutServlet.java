
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
     
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Comprobar si hay una sesión vigente. Si no la hay, no se crea (parámetro false)
        HttpSession session = request.getSession(false); 
 
        if ( session != null ) 
        {
            session.invalidate(); // Eliminar sesión existente
            // Poner valor en atributo de sesión y redireccionar al Login 
            request.setAttribute("mensaError", "Sesión cerrada con éxito");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
            requestDispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
