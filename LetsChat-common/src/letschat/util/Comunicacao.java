package letschat.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Comunicacao {
    
    public static ObjectOutputStream getOutput(Socket socket) throws IOException {
        return new ObjectOutputStream(socket.getOutputStream());
    }
    
    public static ObjectInputStream getInput(Socket socket) throws IOException {
        return new ObjectInputStream(socket.getInputStream());
    }
    
    public static BufferedWriter getBufferedWriter(Socket socket) throws IOException {
        return new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()) );
    }
    
    public static BufferedReader getBufferedReader(Socket socket) throws IOException {
        return new BufferedReader( new InputStreamReader(socket.getInputStream()));
    }
}
