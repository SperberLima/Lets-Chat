package letschat.services.impl;

import letschat.dao.IMensagemDAO;
import letschat.dao.impl.MensagemDAO;
import letschat.service.IManterMensagem;
import letschat.util.Mensagem;

public class ManterMensagem implements IManterMensagem<Mensagem> {

    @Override
    // tretas tretosas feitas durante o tempo desse comentario pra ver se o committ funfa
    public Mensagem ReceberMensagem(Mensagem ent) {
        IMensagemDAO msg = new MensagemDAO();
        return (Mensagem) msg.ReceberMsg();
    }

    @Override
    public void EnviarMensagem(Mensagem ent) {
        IMensagemDAO msg = new MensagemDAO();
        msg.SetMsg(ent);
    }

}
