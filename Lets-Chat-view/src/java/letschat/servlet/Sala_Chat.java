package letschat.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sala_Chat extends HttpServlet {


    private String jsp = "jsp/erro.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Envia o novo usuario atraves do Stub.
            // Chama o grupo de users online

            String comando = request.getParameter("comando");

            switch(comando) {}
            
            
            
            
            
                String erro = "Nao foi possivel logar. \nTente novamente mais tarde.";
                request.setAttribute("erro", erro);
            

        } catch (Exception e) {
            //return jsp;
        }

        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);

    }
}
