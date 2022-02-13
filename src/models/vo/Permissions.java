package models.vo;

import java.io.Serializable;

public class Permissions implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String username;
    private int rol;

    public Permissions(String username, int rol) {
        this.username = username;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
        
}