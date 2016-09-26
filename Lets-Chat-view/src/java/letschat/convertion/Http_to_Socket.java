package letschat.convertion;

import letschat.proxy.IChat;
import letschat.proxy.impl.ClienteStub;

public class Http_to_Socket {
    
    private Http_to_Socket() {}
    
    public static void Logar(String nome)  {
        String host = "localhost";
        int porta = 2224;
        
        IChat cliente = new ClienteStub(host, porta);
        cliente.Logar(nome);
    }
}
