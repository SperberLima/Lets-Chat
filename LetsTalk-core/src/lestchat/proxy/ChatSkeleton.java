package lestchat.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import letschat.envio.ListaOnline;
import letschat.util.Comunicacao;
import letschat.util.Grupo;
import letschat.util.Mensagem;
import letschat.util.Usuario;

public class ChatSkeleton extends Thread {

    private Socket socket;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Usuario user;
    private ArrayList<Grupo> grupos;

    private ChatSkeleton() {
    }

    public ChatSkeleton(Socket socket) {
        try {
            this.socket = socket;
            this.reader = Comunicacao.getInput(socket);

        } catch (IOException ex) {

        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void process() throws IOException, ClassNotFoundException {

        writer = Comunicacao.getOutput(socket);

        try {

            Usuario usuario = (Usuario) reader.readObject();

            if (usuario == null) {
                throw new Exception("O usuario deve ser informado");
            }
            user = usuario;

            ListaOnline.addOnline(writer, user);

            writer.writeObject(usuario);

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        while (true) {
            switch (reader.readUTF().toLowerCase()) {
                case "criargrupo":
                    this.CriarGrupo();
                    break;
                case "msg":
                    this.EnviarMsg();
                    break;
                case "sair":
                    //this.Sair();
            }
        }
    }

    @Override
    public void run() {
        try {
            this.process();
            this.getSocket().close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void CriarGrupo() throws IOException, ClassNotFoundException {
        Grupo g1 = (Grupo) reader.readObject();
        grupos.add(g1);

        ListaOnline.getGrupos().add(g1);

        for (int i = 0; i < g1.getSize(); i++) {
            for (int j = 0; j < ListaOnline.getSize(); j++) {
                if (g1.getGrupo().get(i).getId() == ListaOnline.getUsers().get(j).getId()) {
                    ListaOnline.getOnline().get(j).writeUTF("atualizargrupo");
                }
            }
        }

    }
    
    public void EnviarMsg() {

        Mensagem msg;

        try {
            reader = Comunicacao.getInput(socket);
            writer = Comunicacao.getOutput(socket);

            msg = (Mensagem) reader.readObject();

            if (msg == null) {
                throw new Exception("A mensagem nao pode ser nula");
            }

            if (msg.getDestinatario().getSize() == ListaOnline.getSize()) {
                for (int i = 0; i < ListaOnline.getSize(); i++) {
                    ListaOnline.getOnline().get(i).writeUTF("receber");
                    String str = this.user.getNome()
                            + " disse p/ todos: "
                            + msg.getMsg();

                    ListaOnline.getOnline().get(i).writeUTF(str);
                }
            } else {
                for (int i = 0; i < ListaOnline.getSize(); i++) {
                    if (msg.getDestinatario().Pesquisa(ListaOnline.getUsers().get(i).getId())) {
                        ListaOnline.getOnline().get(i).writeUTF("receber");

                        String str = this.user.getNome()
                                + " disse para "
                                + msg.getDestinatario().getNome()
                                + " : "
                                + msg.getMsg();

                        ListaOnline.getOnline().get(i).writeUTF(str);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
