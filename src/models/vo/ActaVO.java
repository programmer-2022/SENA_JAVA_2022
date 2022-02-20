package models.vo;

import java.io.Serializable;
import java.sql.Date;

public class ActaVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int id;
    private String codigo;
    private Date fecha;
    private String observaciones;
    private String responsableProveedor;
    private ProveedorVO proveedor;
    private EmpleadoVO empleado;

    public ActaVO() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResponsableProveedor() {
        return responsableProveedor;
    }

    public void setResponsableProveedor(String responsableProveedor) {
        this.responsableProveedor = responsableProveedor;
    }

    public ProveedorVO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorVO proveedor) {
        this.proveedor = proveedor;
    }

    public EmpleadoVO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoVO empleado) {
        this.empleado = empleado;
    }
}