package letschat.servlet.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import letschat.convertion.Http_to_Socket;
import letschat.util.Usuario;

public class Logar {

    public static String execute(HttpServletRequest request)
            throws ServletException, IOException {
        String jsp = "/jsp/erro.jsp";
        try {
            // Envia o novo usuario atraves do Stub.
            // Chama o grupo de users online
            String nome = request.getParameter("usuario");
            
                Usuario user = Http_to_Socket.Logar(nome);
                if (user != null) {
                    request.setAttribute("user", user);
                    jsp = "/jsp/Sala_Chat.jsp";
                } else {
                    String erro = "Nao foi possivel logar. \nTente novamente mais tarde.";
                    request.setAttribute("erro", erro);
                    
                }
            
        } catch (Exception e) {
            return jsp = "/jsp/erro.jsp";
            
        }
        
        return jsp;
    }
}
