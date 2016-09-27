package lestchat.proxy.threads;

import java.util.Date;
import lestchat.proxy.ChatSkeleton;
import letschat.envio.ListaOnline;
import letschat.domain.Grupo;
import letschat.domain.Usuario;

public class ConfereTempo extends Thread {

    public ConfereTempo() {}

    @Override
    public void run() {
        ListaOnline lista = ListaOnline.getInstance();
        
        for (ChatSkeleton user : ListaOnline.getTodos()) {
            if ((user.getUser().getAcesso().getTime() - new Date().getTime()) >= 10000) { // 2 minutos ???
                ConfereTempo.Remover(user);
            }
        }
    }

    public static void Remover(ChatSkeleton user) {
        // Tira ele dos grupos em que estah
        for (Grupo b : ListaOnline.getGrupos()) {
            for (Usuario u : b.getGrupo()) {
                if (u.equals(user.getUser())) {
                    b.getGrupo().remove(user.getUser());
                }
            }
        }

        for (ChatSkeleton u : ListaOnline.getTodos()) {
            if (u.equals(user)) {
                ListaOnline.getTodos().remove(user);
            }
        }
    }

}
