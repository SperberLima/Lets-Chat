package letschat.dao;

import letschat.exception.PersistenciaException;

public interface IGenericNamedDAO<Entidade> extends IGenericDAO<Entidade> {

    Entidade consultarPorNome(String nome) throws PersistenciaException;
}
