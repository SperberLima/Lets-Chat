package letschat.dao;

import java.util.ArrayList;
import letschat.exception.PersistenciaException;

public interface IGenericDAO <Entidade> {

    Long inserir(Entidade obj) throws PersistenciaException;

    boolean atualizar(Entidade obj) throws PersistenciaException;

    Entidade excluir(Entidade obj) throws PersistenciaException;

    ArrayList<Entidade> listarTodos() throws PersistenciaException;
    
    Entidade consultarPorId(Long id) throws PersistenciaException;
}
