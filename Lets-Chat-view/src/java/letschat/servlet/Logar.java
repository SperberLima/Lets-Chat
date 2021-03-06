package letschat.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import letschat.convertion.Http_to_Socket;

public class Logar extends HttpServlet {

    private String jsp = "jsp/erro.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Envia o novo usuario atraves do Stub.
            // Chama o grupo de users online

            String nome = request.getParameter("nome");

            if (nome != null) {
                Http_to_Socket novo = new Http_to_Socket();
                novo.Logar(nome);
                request.setAttribute("nome", nome);
                jsp = "jsp/Sala_Chat.jsp";
            } else {
                String erro = "Nao foi possivel logar. \nTente novamente mais tarde.";
                request.setAttribute("erro", erro);
            }

        } catch (Exception e) {
        }
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);

    }
}
