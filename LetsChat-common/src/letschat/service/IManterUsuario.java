package letschat.service;

import java.util.ArrayList;

public interface IManterUsuario<Entidade> {

    boolean Logar(Entidade user);

    boolean ValidaTempo(Entidade user);

    ArrayList<String> listarTodos();

}
