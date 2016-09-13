package letschat.services.impl;

import java.util.ArrayList;
import letschat.dao.IGrupoDAO;
import letschat.dao.impl.GrupoDAO;
import letschat.exception.PersistenciaException;
import letschat.service.IManterGrupo;
import letschat.util.Grupo;
import letschat.util.Usuario;

public class ManterGrupo implements IManterGrupo<Grupo> {
    
    @Override
    public boolean Criar(Grupo grupo) {
        try {
            IGrupoDAO grupoDAO = new GrupoDAO();
            return grupoDAO.inserir(grupo) != null;
        } catch (PersistenciaException ex) {
            return false;
        }
    }

    @Override
    public boolean Convidar(Grupo group) {
        try {
            IGrupoDAO grupoDAO = new GrupoDAO();
            Grupo grupo = grupoDAO.consultarPorNome(group.getNome());
            for (Usuario entrada : group.getGrupo()) {
                boolean existe = false;
                for (Usuario atual : grupo.getGrupo()) {
                    if (atual.equals(entrada)) {
                        existe = true;
                    }
                }
                if (!existe) {
                    grupo.getGrupo().add(entrada);
                }
            }
            return grupoDAO.atualizar(grupo);
        } catch (PersistenciaException ex) {
            return false;
        }
    }

    @Override
    public boolean Sair(Grupo group) {
        try {
            IGrupoDAO grupoDAO = new GrupoDAO();
            Grupo grupo = grupoDAO.consultarPorNome(group.getNome());
            for (Usuario entrada : group.getGrupo()) {
                boolean existe = false;
                for (Usuario atual : grupo.getGrupo()) {
                    if (atual.equals(entrada)) {
                        existe = true;
                    }
                }
                if (existe) {
                    grupo.getGrupo().remove(entrada);
                }
            }
            return grupoDAO.atualizar(grupo);
        } catch (PersistenciaException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<String> listarTodos() {
        try {
            IGrupoDAO grupoDAO = new GrupoDAO();
            ArrayList<String> retorno = new ArrayList<>();
            if (grupoDAO.listarTodos().size() >0) {
                for (Grupo atual : grupoDAO.listarTodos()) {
                    retorno.add(atual.getNome());
                }
            }
            return retorno;
        } catch (PersistenciaException ex) {
            return null;
        }
    }
}
