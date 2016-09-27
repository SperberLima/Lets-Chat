package letschat.domain;

import java.io.ObjectOutputStream;
import java.util.Date;

public class Usuario {
    private String Nome;
    private Long Id;
    private Date acesso;
    //private ObjectOutputStream id;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getAcesso() {
        return acesso;
    }

    public void setAcesso(Date acesso) {
        this.acesso = acesso;
    }
    
    
}
