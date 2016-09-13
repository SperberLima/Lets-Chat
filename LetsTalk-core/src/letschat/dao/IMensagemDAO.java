package letschat.dao;

public interface IMensagemDAO<Entidade> {

    public boolean EnviarMsg(Entidade e);

    public Entidade ReceberMsg();

}
