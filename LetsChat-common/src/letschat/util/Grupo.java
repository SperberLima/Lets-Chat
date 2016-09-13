package letschat.util;

import java.util.ArrayList;

public class Grupo {
    
    private ArrayList<Usuario> users;
    private String Nome;
    private Long Id;
    

    public Grupo() {
        users = new ArrayList<>();
    }    

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
    public ArrayList<Usuario> getGrupo() {
        return users;
    }
    
    public int getSize() {
        return users.size();
    }    
    
    public void setGrupo(ArrayList<Usuario> grupo) {
        this.users = grupo;
    }
    
    public void addaoGrupo(Usuario user) {
        this.users.add(user);
    }
    
    public Usuario remover (Usuario user) {
        
        for(int i = 0; i < users.size() ; i++ ) {
            if(users.get(i).getId() == user.getId()) {
                users.remove(users.get(i));
            }
        }
        
        return null;
    }

    
    public boolean Pesquisa(Long id) {
        
        for(Usuario usuario : users) {
            if(usuario.getId() == id ) {
                return true;
            }
        }
        
        return false;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }


    
}
