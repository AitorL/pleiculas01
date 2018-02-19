package modelo;

import java.sql.*;

import util.ConexionBD;

public class LoginBD {
 
    // Comprueba si los datos usuario y contraseña existen en la BD.
    // Retorna un String con el mensaje de error o de éxito.
    public String autenticaUsuario(LoginBean loginBean)
    {
        // Recoger los valores temporales almacenados en el Bean
        String usuario = loginBean.getUsuario(); 
        String clave = loginBean.getClave();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String retorno;
        boolean valido = false;
            
        try
        {
            con = ConexionBD.createConnection(); 
            statement = con.createStatement(); 
            resultSet = statement.executeQuery("select * from usuarios"); 
            
            while ( resultSet.next() )  
            {
                String usuarioBD = resultSet.getString("usr"); 
                String passwordBD = resultSet.getString("pass");

                if ( usuario.equals(usuarioBD) && clave.equals(passwordBD) )
                {
                   valido = true;
                   break;
                }
            }
             
            statement = null;
            resultSet = null;
            con = null; 
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        if ( valido )
           return "OK";
        else
           return "Credenciales no válidas"; 
    }
}
