package models.vo;

import java.io.Serializable;

public class EmpleadoVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int identificacion;
    private String nombre;
    private String apellido;
    private GeneroVO genero;
    private CargoVO cargo;

    public EmpleadoVO() { }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public GeneroVO getGenero() {
        return genero;
    }

    public void setGenero(GeneroVO genero) {
        this.genero = genero;
    }

    public CargoVO getCargo() {
        return cargo;
    }

    public void setCargo(CargoVO cargo) {
        this.cargo = cargo;
    }    
}