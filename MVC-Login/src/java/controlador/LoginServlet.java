
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("password");
        
        if ( usuario.isEmpty() ) {          
           request.setAttribute("mensaError", "Debe introducir el usuario"); 
           request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }  
        if ( clave.isEmpty() ) {          
           request.setAttribute("mensaError", "Debe introducir la contraseña"); 
           request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }  
 
        LoginBean loginBean = new LoginBean();  // Las clases Bean son utilizadas en Java para acceder a la información.
 
        // Establecer datos del Bean. Así solamente nosotros podremos acceder a ella en el futuro
        loginBean.setUsuario(usuario); 
        loginBean.setClave(clave);
 
        LoginBD loginBD = new LoginBD(); // Esta clase contiene la lógica de la aplicación (gestionar un login)
 
        String userValidar = loginBD.autenticaUsuario(loginBean); // LLama a la función de LoginBD
 
        if ( userValidar.equals("OK") ) // Si éxito, redirigir a la página inicial 
        {
            // Guardar el usuario para futuros accesos desde otras páginas de esta aplicación
            request.setAttribute("nombreUsuario", usuario); 
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
        }
        else  // Si error, guardar el mensaje de error, para mostrarlo en la página de Login
        {
            request.setAttribute("nombreUsuario", usuario); 
            request.setAttribute("mensaError", userValidar); 
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
