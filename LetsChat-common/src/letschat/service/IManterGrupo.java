package letschat.service;

import java.util.ArrayList;

public interface IManterGrupo<Entidade> {

    boolean Criar(Entidade e);

    boolean Sair(Entidade e);

    ArrayList<String> listarTodos();

    boolean Convidar(Entidade e);
}
