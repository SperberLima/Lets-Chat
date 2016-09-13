package letschat.services.impl;

import java.util.ArrayList;
import java.util.Date;
import letschat.dao.IGrupoDAO;
import letschat.dao.IUsuarioDAO;
import letschat.dao.impl.GrupoDAO;
import letschat.dao.impl.UsuarioDAO;
import letschat.exception.PersistenciaException;
import letschat.service.IManterUsuario;
import letschat.util.Grupo;
import letschat.util.Usuario;

public class ManterUsuario implements IManterUsuario<Usuario> {
    
    @Override
    public boolean Logar(Usuario user) {
        try {
            IUsuarioDAO usuarioDAO = new UsuarioDAO();
            if(usuarioDAO.inserir(user) != null){
                IGrupoDAO grupoDAO = new GrupoDAO();
                Grupo geral = grupoDAO.consultarPorNome("Geral");
                geral.getGrupo().add(user);
                grupoDAO.atualizar(geral);
                return true;
            }else{
                return false;
            }
        } catch (PersistenciaException ex) {
            return false;
        }
    }

    @Override
    public boolean ValidaTempo(Usuario user) {
        try {
            IUsuarioDAO userDAO = new UsuarioDAO();
            Usuario novo = userDAO.consultarPorNome(user.getNome());
            if(novo != null){
                novo.setAcesso(new Date());
                return userDAO.atualizar(novo);
            }else{
                return false;
            }
        } catch (PersistenciaException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<String> listarTodos() {
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            ArrayList<String> lista = new ArrayList<>();
            for(Usuario user : usuarioDAO.listarTodos()){
                lista.add(user.getNome());
            }
            return lista;
        } catch (PersistenciaException ex) {
            return null;
        }
    }

}
