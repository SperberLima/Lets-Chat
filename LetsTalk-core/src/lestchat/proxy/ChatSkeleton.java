package lestchat.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import letschat.envio.ListaOnline;
import letschat.exception.PersistenciaException;
import letschat.service.IManterUsuario;
import letschat.domain.Comunicacao;
import letschat.domain.Grupo;
import letschat.domain.Mensagem;
import letschat.domain.Usuario;

public class ChatSkeleton extends Thread {

    private Socket socket;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Usuario user;
    private ArrayList<Grupo> grupos;
    private ArrayList<Mensagem> msgs;

    private ChatSkeleton() {
    }

    public ChatSkeleton(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectInputStream getReader() {
        return reader;
    }

    public void setReader(ObjectInputStream reader) {
        this.reader = reader;
    }

    public ObjectOutputStream getWriter() {
        return writer;
    }

    public void setWriter(ObjectOutputStream writer) {
        this.writer = writer;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Mensagem> getMsgs() {
        return msgs;
    }

    public void setMsgs(ArrayList<Mensagem> msgs) {
        this.msgs = msgs;
    }
    

    public void process() throws IOException, ClassNotFoundException {

        this.writer = Comunicacao.getOutput(socket);
        this.reader = Comunicacao.getInput(socket);
        
        try {
            Usuario usuario = (Usuario) reader.readObject();

            if (usuario == null) {
                throw new PersistenciaException("O usuario deve ser informado");
            }
            user = usuario;

        } catch (IOException | ClassNotFoundException | PersistenciaException ex) {
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
                case "msgpendente":
                    this.MsgsPendentes();
                    break;
                case "grupopendente":
                    this.GruposPendentes();
                    break;
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
                if (Objects.equals(g1.getGrupo().get(i).getId(), ListaOnline.getTodos().get(j).user.getId())) {
                    ListaOnline.getTodos().get(j).grupos.add(g1);
                }
            }
        }
    }
    
    public void MsgsPendentes() {
        try {
            reader = Comunicacao.getInput(socket);
            writer = Comunicacao.getOutput(socket);
            
            writer.writeObject(msgs);
            
            msgs = null;
            System.gc();
            
            msgs = new ArrayList<>();
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void GruposPendentes() {
        try {
            reader = Comunicacao.getInput(socket);
            writer = Comunicacao.getOutput(socket);
            
            writer.writeObject(grupos);
            
            grupos = null;
            System.gc();
            
            grupos = new ArrayList<>();
            
        } catch(IOException ex) {
            ex.printStackTrace();
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
                    String str = this.user.getNome()
                            + " disse p/ todos: "
                            + msg.getMsg();
                    
                    msg.setMsg(str);
                    
                    ListaOnline.getTodos().get(i).msgs.add(msg);
                      
                }
            } else {
                for (int i = 0; i < ListaOnline.getSize(); i++) {
                    if (msg.getDestinatario().Pesquisa(ListaOnline.getTodos().get(i).user.getId())) {

                        String str = this.user.getNome()
                                + " disse para "
                                + msg.getDestinatario().getNome()
                                + " : "
                                + msg.getMsg();
                        msg.setMsg(str);
                        
                        ListaOnline.getTodos().get(i).msgs.add(msg);
                        
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
