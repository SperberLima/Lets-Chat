package letschat;

import letschat.proxy.IChat;
import letschat.proxy.impl.ClienteStub;

public class Cliente {

    public static void main(String[] args) {
        
        IChat eu = new ClienteStub("localhost", 2223);
        
    }
}
