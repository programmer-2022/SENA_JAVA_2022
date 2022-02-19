package models.vo;

import java.io.Serializable;


public class CategoriaVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;

    public CategoriaVO() { }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}