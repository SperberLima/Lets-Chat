package letschat.dao.impl;

import letschat.dao.IMensagemDAO;
import letschat.envio.ListaOnline;
import letschat.exception.PersistenciaException;
import letschat.util.Grupo;
import letschat.util.Mensagem;
import letschat.util.Usuario;

public class MensagemDAO implements IMensagemDAO<Mensagem>{

    @Override
    public Mensagem consultarPorNome(String nome) throws PersistenciaException {
        ListaOnline lista = ListaOnline.getInstance();

        for (int i =0 ; i < ListaOnline.getSize(); i++) {
            if (nome.equals(lista.getTodos().get(i).getUser().getNome())) {
                
            }
        }
        return null;
    }

    @Override
    public Long inserir(Mensagem obj) throws PersistenciaException {
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
}
