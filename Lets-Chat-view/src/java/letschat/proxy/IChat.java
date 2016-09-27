package letschat.proxy;

import letschat.domain.Usuario;
import letschat.domain.Grupo;

public interface IChat<Entidade> {
    
    public Usuario Logar(String Nome);
    public String ReceberMensagem();
    public boolean EnviarMensagem(Entidade mensagem);
    public Grupo getOnline();
}
