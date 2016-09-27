package letschat.proxy;

import letschat.domain.Usuario;

public interface IChat<Entidade> {
    
    public Usuario Logar(String Nome);
    public String ReceberMensagem();
    public boolean EnviarMensagem(Entidade mensagem);
}
