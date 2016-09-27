package letschat.proxy.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import letschat.domain.Mensagem;
import letschat.proxy.IChat;
import letschat.domain.Comunicacao;
import letschat.domain.Grupo;
import letschat.domain.Usuario;

public class ClienteStub implements IChat<Mensagem> {

    private String host;
    private int porta;
    private Socket socket;

    private ClienteStub() {
    }

    public ClienteStub(String host, int porta) {
        try {
            this.host = host;
            this.porta = porta;
            this.socket = new Socket(host, porta);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
    
    @Override
    public Grupo getOnline() {
        ObjectOutputStream writer;
        ObjectInputStream reader;

        try {
            writer = Comunicacao.getOutput(socket);
            reader = Comunicacao.getInput(socket);

            writer.writeUTF("obterListaOnline");
            return (Grupo) reader.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario Logar(String Nome) {
        ObjectOutputStream writer;
        ObjectInputStream reader;

        try {
            writer = Comunicacao.getOutput(socket);
            reader = Comunicacao.getInput(socket);

            Usuario user = new Usuario();

            user.setNome(Nome);
            writer.writeObject(user);
            writer.flush();

            user = (Usuario) reader.readObject();

            return user;

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String ReceberMensagem() {
        ObjectInputStream reader;

        try {

            reader = Comunicacao.getInput(socket);

            String msg = reader.readUTF();

            return msg;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean EnviarMensagem(Mensagem mensagem) {
        ObjectInputStream reader;
        ObjectOutputStream writer;

        try {

            reader = Comunicacao.getInput(socket);
            writer = Comunicacao.getOutput(socket);

            writer.writeUTF("msg");

            writer.writeUTF(mensagem.getMsg());

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

}
