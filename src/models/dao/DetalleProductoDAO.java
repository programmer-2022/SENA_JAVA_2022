package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import models.config.MySQLConnection;
import models.interfaces.ICrud;
import models.vo.CategoriaVO;
import models.vo.DetalleProductoVO;
import models.vo.ProductoVO;
import models.vo.ProveedorVO;
import utils.Constants;
import utils.Messages;


public class DetalleProductoDAO implements ICrud<DetalleProductoVO>{
    
    private static MySQLConnection xcon;

    public DetalleProductoDAO() { }

    @Override
    public boolean create(DetalleProductoVO detalle) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_crear_detalle_producto(?,?,?,?)}");
            ps.setInt(1, detalle.getCantidad());
            ps.setDate(2, detalle.getFecha());
            ps.setInt(3, detalle.getProveedor().getId());
            ps.setInt(4, detalle.getProducto().getId());
            if(ps.executeUpdate() > 0) return true;
                        
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return false;
    }

    @Override
    public LinkedList<DetalleProductoVO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DetalleProductoVO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleProductoVO read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public DetalleProductoVO buscarProducto(String nit, String codigo, String fecha) {
        xcon = MySQLConnection.getInstance();
        DetalleProductoVO detalle = new DetalleProductoVO();
        ProveedorVO proveedor = new ProveedorVO();
        ProductoVO producto = new ProductoVO();
        CategoriaVO categoria = new CategoriaVO();
        
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_buscar_detalle_producto(?,?,?)}");
            ps.setString(1, nit);
            ps.setString(2, codigo);
            ps.setString(3, fecha);            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                detalle.setId(rs.getInt(Constants.DETALLE_ID));
                detalle.setCantidad(rs.getInt(Constants.DETALLE_CANTIDAD));
                detalle.setFecha(rs.getDate(Constants.DETALLE_FECHA));
                
                proveedor.setId(rs.getInt(Constants.PROVEEDOR_ID));
                proveedor.setNombre(rs.getString(Constants.PROVEEDOR_NOMBRE));
                
                producto.setId(rs.getInt(Constants.PRODUCT_ID));
                producto.setCode(rs.getString(Constants.PRODUCT_CODE));
                producto.setName(rs.getString("NombreProducto"));
                producto.setSerial(rs.getString(Constants.PRODUCT_SERIAL));
                producto.setStatus(rs.getString(Constants.PRODUCT_ESTADO));
                
                categoria.setId(rs.getInt(Constants.CATEGORIA_ID));
                categoria.setName(rs.getString(Constants.CATEGORIA_NAME));
                
                producto.setCategoria(categoria);
                detalle.setProveedor(proveedor);
                detalle.setProducto(producto);                
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        } 
        return detalle;
    }
    
    public ArrayList<DetalleProductoVO> buscarTodos(String nit, String fecha) {
        xcon = MySQLConnection.getInstance();
        ArrayList<DetalleProductoVO> lista = new ArrayList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_buscar_detalle_producto_todos(?,?)}");
            ps.setString(1, nit);
            ps.setString(2, fecha);            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DetalleProductoVO detalle = new DetalleProductoVO();
                ProveedorVO proveedor = new ProveedorVO();
                ProductoVO producto = new ProductoVO();
                CategoriaVO categoria = new CategoriaVO();
                detalle.setId(rs.getInt(Constants.DETALLE_ID));
                detalle.setCantidad(rs.getInt(Constants.DETALLE_CANTIDAD));
                detalle.setFecha(rs.getDate(Constants.DETALLE_FECHA));
                
                proveedor.setId(rs.getInt(Constants.PROVEEDOR_ID));
                proveedor.setNombre(rs.getString(Constants.PROVEEDOR_NOMBRE));
                
                producto.setId(rs.getInt(Constants.PRODUCT_ID));
                producto.setCode(rs.getString(Constants.PRODUCT_CODE));
                producto.setName(rs.getString("NombreProducto"));
                producto.setSerial(rs.getString(Constants.PRODUCT_SERIAL));
                producto.setStatus(rs.getString(Constants.PRODUCT_ESTADO));
                
                categoria.setId(rs.getInt(Constants.CATEGORIA_ID));
                categoria.setName(rs.getString(Constants.CATEGORIA_NAME));
                
                producto.setCategoria(categoria);
                detalle.setProveedor(proveedor);
                detalle.setProducto(producto);
                lista.add(detalle);
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        } 
        return lista;
    }   
   
}