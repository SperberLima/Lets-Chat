package letschat;

import letschat.proxy.impl.ClienteStub;

public class Cliente {

    public static void main(String[] args) {
        
        ClienteStub eu = new ClienteStub("localhost", 2223);
        
    }
}
