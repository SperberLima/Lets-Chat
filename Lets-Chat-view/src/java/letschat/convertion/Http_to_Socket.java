package letschat.convertion;

import letschat.proxy.IChat;
import letschat.proxy.impl.ClienteStub;
import letschat.util.Usuario;

public class Http_to_Socket {
    
    private Http_to_Socket() {}
    
    public static Usuario Logar(String nome)  {
        String host = "localhost";
        int porta = 2223;
        
        IChat cliente = new ClienteStub(host, porta);
        return cliente.Logar(nome);
    }
    
    
    
}
