package lestchat.proxy.threads;

import java.util.Date;
import letschat.envio.ListaOnline;
import letschat.util.Grupo;
import letschat.util.Usuario;

public class ConfereTempo {

    private ConfereTempo() {

    }

    public static void Confere() {
        ListaOnline lista = ListaOnline.getInstance();

        for (Usuario user : lista.getUsers()) {
            if ((user.getAcesso().getTime() - new Date().getTime()) >= 120000) { // 2 minutos ???
                ConfereTempo.Remover(user);
            }
        }
    }

    public static void Remover(Usuario user) {
        // Tira ele dos grupos em que esta
        for (Grupo b : ListaOnline.getGrupos()) {
            for (Usuario u : b.getGrupo()) {
                if (u.equals(user)) {
                    b.getGrupo().remove(user);
                }
            }
        }

        for (Usuario u : ListaOnline.getUsers()) {
            if (u.equals(user)) {
                ListaOnline.getUsers().remove(user);
            }
        }
    }

}
