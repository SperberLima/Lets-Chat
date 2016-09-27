package letschat.proxy;

import letschat.util.Usuario;
import letschat.util.Grupo;

public interface IChat<Entidade> {
    
    public Usuario Logar(String Nome);
    public String ReceberMensagem();
    public boolean EnviarMensagem(Entidade mensagem);
    public Grupo getOnline();
}
