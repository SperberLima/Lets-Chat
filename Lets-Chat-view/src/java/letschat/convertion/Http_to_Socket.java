package letschat.convertion;

import letschat.proxy.IChat;
import letschat.proxy.impl.ClienteStub;

public class Http_to_Socket {

    private IChat chat;
    
    public Http_to_Socket() {
    }

    public IChat Logar(String nome) {
        String host = "localhost";
        int porta = 2224;
        chat = new ClienteStub(host, porta);
        return chat;
    }

   
}
