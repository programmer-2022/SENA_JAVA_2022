package models.vo;

import java.io.Serializable;

public class UsuarioVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
     
    private int id;
    private String username;
    private String password;
    private RolesVO rol;

    public UsuarioVO() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }        

    public RolesVO getRol() {
        return rol;
    }

    public void setRol(RolesVO rol) {
        this.rol = rol;
    }        
}
