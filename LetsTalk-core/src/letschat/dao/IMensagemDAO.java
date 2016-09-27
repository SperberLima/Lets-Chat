package letschat.dao;

import letschat.exception.PersistenciaException;

public interface IMensagemDAO<Entidade> {

    public Long inserir(Entidade e) throws PersistenciaException;
    public Entidade consultarPorNome(String nome)throws PersistenciaException;

}
