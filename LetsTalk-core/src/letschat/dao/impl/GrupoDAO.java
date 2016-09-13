package letschat.dao.impl;

import java.util.ArrayList;
import letschat.dao.IGrupoDAO;
import letschat.envio.ListaOnline;
import letschat.exception.PersistenciaException;
import letschat.util.Grupo;

public class GrupoDAO implements IGrupoDAO {

    @Override
    public Grupo consultarPorNome(String nome) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();

        for (Grupo e : lista.getGrupos()) {
            if (nome.equals(e.getNome())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Long inserir(Grupo obj) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();

        if (consultarPorNome(obj.getNome()) != null) {
            throw new PersistenciaException("Já existe um grupo com o mesmo nome");
        } else {
            Long i = null;
            for (Grupo rip : lista.getGrupos()) {
                i = rip.getId();
            }

            obj.setId(i + 1);  // Pode dar errado
            lista.getGrupos().add(obj);
            return obj.getId();
        }
    }

    @Override
    public ArrayList listarTodos() throws PersistenciaException {
        return ListaOnline.getGrupos();
    }

    @Override
    public boolean atualizar(Grupo obj) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();
        if (consultarPorNome(obj.getNome()) != null) {
            for (Grupo atual : lista.getGrupos()) {
                if (atual.getNome().equals(obj.getNome())) {
                    atual.setGrupo(obj.getGrupo());
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public Grupo excluir(Grupo obj) throws PersistenciaException {

        ListaOnline lista = ListaOnline.getInstance();

        Grupo rem = this.consultarPorId(obj.getId());

        if (rem != null) {
            lista.getGrupos().remove(obj);
        }

        return obj;
    }

    @Override
    public Grupo consultarPorId(Long id) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();

        for (Grupo e : lista.getGrupos()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }
        return null;
    }

}
