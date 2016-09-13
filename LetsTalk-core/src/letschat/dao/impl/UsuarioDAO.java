package letschat.dao.impl;

import java.util.ArrayList;
import letschat.dao.IUsuarioDAO;
import letschat.envio.ListaOnline;
import letschat.exception.PersistenciaException;
import letschat.util.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public Usuario consultarPorNome(String nome) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();

        for (Usuario e : lista.getUsers()) {
            if (nome.equals(e.getNome())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Long inserir(Usuario obj) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();

        if (consultarPorNome(obj.getNome()) != null) {
            throw new PersistenciaException("Já existe um grupo com o mesmo nome");
        } else {
            Long i = null;
            for (Usuario rip : lista.getUsers()) {
                i = rip.getId();
            }

            obj.setId(i + 1);  // Pode dar errado
            lista.getUsers().add(obj);
            return obj.getId();
        }
    }

    @Override
    public ArrayList<Usuario> listarTodos() throws PersistenciaException {
        return ListaOnline.getUsers();
    }

    @Override
    public boolean atualizar(Usuario obj) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();
        if (consultarPorNome(obj.getNome()) != null) {
            for (Usuario atual : lista.getUsers()) {
                if (atual.getNome().equals(obj.getNome())) {
                    atual.setNome(obj.getNome());
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public Usuario excluir(Usuario obj) throws PersistenciaException {

        ListaOnline lista = ListaOnline.getInstance();

        Usuario rem = this.consultarPorId(obj.getId());

        if (rem != null) {
            lista.getUsers().remove(obj);
        }

        return obj;
    }

    @Override
    public Usuario consultarPorId(Long id) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();

        for (Usuario e : lista.getUsers()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }
        return null;
    }

}
