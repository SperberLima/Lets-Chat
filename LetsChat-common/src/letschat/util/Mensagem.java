package letschat.util;

public class Mensagem {
    private Long id;
    private Grupo destinatario;
    private String msg;

    public Mensagem() {
    }

    public Grupo getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Grupo destinatario) {
        this.destinatario = destinatario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
