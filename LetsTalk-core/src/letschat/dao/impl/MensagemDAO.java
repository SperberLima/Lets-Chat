package letschat.dao.impl;

import letschat.dao.IMensagemDAO;
import letschat.util.Mensagem;

public class MensagemDAO implements IMensagemDAO<Mensagem>{

    @Override
    public Mensagem ReceberMsg() {
        return null;
    }

    @Override
    public boolean EnviarMsg(Mensagem e) {
        return false;
    }

}
