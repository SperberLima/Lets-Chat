package letschat.convertion;

import letschat.proxy.IChat;
import letschat.proxy.impl.ClienteStub;
import letschat.domain.Grupo;

public class Http_to_Socket {

    private IChat chat;
    
    public Http_to_Socket() {
    }

    public void Logar(String nome) {
        String host = "localhost";
        int porta = 2224;
        chat = new ClienteStub(host, porta);
        chat.Logar(nome);
    }

   
}
