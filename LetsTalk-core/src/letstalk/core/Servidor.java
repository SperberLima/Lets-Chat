package letstalk.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import lestchat.proxy.ChatSkeleton;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket server = null;

        try {

            server = new ServerSocket(2223);

            while (true) {

                Socket socket = server.accept();
                ChatSkeleton chat = new ChatSkeleton(socket);
                Thread t = new Thread(chat);
                t.start();
            }
            
        } catch (Exception e) {
            if (server != null) {
                server.close();
            }
        }
    }

}
