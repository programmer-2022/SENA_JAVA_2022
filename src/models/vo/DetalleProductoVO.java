package models.vo;

import java.sql.Date;

public class DetalleProductoVO {

    private int id;
    private ProveedorVO proveedor;
    private int cantidad;
    private Date fecha;
    private ProductoVO producto;
    
    public DetalleProductoVO() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProveedorVO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorVO proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ProductoVO getProducto() {
        return producto;
    }

    public void setProducto(ProductoVO producto) {
        this.producto = producto;
    }       
}