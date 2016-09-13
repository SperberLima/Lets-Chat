package letschat.envio;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import letschat.util.Grupo;
import letschat.util.Usuario;

public class ListaOnline {
    private static ArrayList<ObjectOutputStream> online = new ArrayList<>();
    private static ArrayList<Grupo> grupos = new ArrayList<>();
    private static ArrayList<Usuario> users = new ArrayList<>();
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
        return ListaOnline.online.size();
    }
    
    public static void addOnline(ObjectOutputStream user, Usuario usuario) {
        ListaOnline.online.add(user);
        ListaOnline.users.add(usuario);
    }
    
    public static void remOnline(ObjectOutputStream user) {
        ListaOnline.online.remove(user);
    }

    public static ArrayList<Usuario> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<Usuario> users) {
        ListaOnline.users = users;
    }

    public static ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public static void setGrupos(ArrayList<Grupo> grupos) {
        ListaOnline.grupos = grupos;
    }

    public static ArrayList<ObjectOutputStream> getOnline() {
        return online;
    }

    public static void setOnline(ArrayList<ObjectOutputStream> online) {
        ListaOnline.online = online;
    }
    
}
