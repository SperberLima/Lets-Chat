package letschat.envio;

import java.util.ArrayList;
import lestchat.proxy.ChatSkeleton;
import letschat.domain.Grupo;

public class ListaOnline {
    private static ArrayList<ChatSkeleton> todos = new ArrayList<>();
    //private static ArrayList<ObjectOutputStream> online = new ArrayList<>();
    private static ArrayList<Grupo> grupos = new ArrayList<>();
    //private static ArrayList<Usuario> users = new ArrayList<>();
    private static ListaOnline instance = null;
    
    
    private ListaOnline() {    
        Grupo geral = new Grupo();
        geral.setNome("Geral");
        grupos.add(geral);
    }
        
    public static ListaOnline getInstance() {
        if(instance == null ) {
            ListaOnline.instance = new ListaOnline();
        }
        return instance;
    }
    
    public static int getSize() {
        return ListaOnline.todos.size();
    }
    
    public static ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public static void setGrupos(ArrayList<Grupo> grupos) {
        ListaOnline.grupos = grupos;
    }

    public static void addChat(ChatSkeleton chat) {
        ListaOnline.todos.add(chat);
    }

    public static void remChat(ChatSkeleton chat) {
        ListaOnline.todos.remove(chat);
    }
    
    public static ArrayList<ChatSkeleton> getTodos() {
        return todos;
    }

    public static void setTodos(ArrayList<ChatSkeleton> todos) {
        ListaOnline.todos = todos;
    }
    
}
