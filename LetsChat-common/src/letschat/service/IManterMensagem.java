package letschat.service;

public interface IManterMensagem<Entidade> {

    Entidade ReceberMensagem(Entidade ent);

    void EnviarMensagem(Entidade ent);

}
