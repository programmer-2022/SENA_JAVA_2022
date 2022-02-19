package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import models.config.MySQLConnection;
import models.interfaces.ICrud;
import models.vo.CategoriaVO;
import models.vo.DetalleProductoVO;
import models.vo.ProductoVO;
import utils.Constants;
import utils.Messages;

public class ProductoDAO implements ICrud<ProductoVO> {

    private static MySQLConnection xcon;
    private boolean exito;
    
    public boolean crear(DetalleProductoVO detalle) {
        xcon = MySQLConnection.getInstance();
        xcon.setAutocommitDisable();
        try {
            PreparedStatement psProducto = xcon.getConnection().prepareCall("{call sp_crear_producto(?,?,?,?,?)}");
            psProducto.setString(1, detalle.getProducto().getCode());
            psProducto.setString(2, detalle.getProducto().getName());
            psProducto.setString(3, detalle.getProducto().getSerial());
            psProducto.setString(4, detalle.getProducto().getStatus());
            psProducto.setInt(5, detalle.getProducto().getCategoria().getId());
            psProducto.executeUpdate();
            //Retornar el ID del producto
            ProductoVO pro = new ProductoVO();
            
            PreparedStatement psConsulta = xcon.getConnection().prepareCall("{call sp_buscar_producto_codigo(?)}");
            psConsulta.setString(1, detalle.getProducto().getCode());
            ResultSet rs = psConsulta.executeQuery();
            while(rs.next()) {
                pro.setId(rs.getInt(Constants.PRODUCT_ID));
            }
                        
            PreparedStatement psDetalle = xcon.getConnection().prepareCall("{call sp_crear_detalle_producto(?,?,?,?)}");
            psDetalle.setInt(1, detalle.getCantidad());
            psDetalle.setDate(2, detalle.getFecha());
            psDetalle.setInt(3, detalle.getProveedor().getId());
            psDetalle.setInt(4, pro.getId());
            psDetalle.executeUpdate();
            xcon.Commit();
            exito = true;
        } catch (SQLException e) {
            xcon.rollBack();
            Messages.msgError(Constants.ERROR_SERVER);
            exito = false;
        } catch (Exception e) {
            xcon.rollBack();
            Messages.msgError(Constants.ERROR_SYSTEM);
            exito = false;
        } finally {
            xcon.close_connection();
        }
        return exito;
    }   
    
    @Override
    public boolean create(ProductoVO producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<ProductoVO> readAll() {
        xcon = MySQLConnection.getInstance();
        LinkedList<ProductoVO> listaProductos = new LinkedList<>();
                
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_listar_productos}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ProductoVO producto = new ProductoVO();
                CategoriaVO categoria = new CategoriaVO();
                producto.setId(rs.getInt(Constants.PRODUCT_ID));
                producto.setName(rs.getString(Constants.PRODUCT_NAME));
                producto.setCode(rs.getString(Constants.PRODUCT_CODE));
                producto.setSerial(rs.getString(Constants.PRODUCT_SERIAL));
                producto.setStatus(rs.getString(Constants.PRODUCT_ESTADO));
                
                categoria.setId(rs.getInt(Constants.CATEGORIA_ID));
                categoria.setName(rs.getString(Constants.CATEGORIA_NAME));
                producto.setCategoria(categoria);
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return listaProductos;
    }

    public ProductoVO readOne(String codigo) {
        xcon = MySQLConnection.getInstance();
        ProductoVO producto = new ProductoVO();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_buscar_producto_codigo(?)}");
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                producto.setId(rs.getInt(Constants.PRODUCT_ID));
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return producto;
    }
    
    @Override
    public boolean update(ProductoVO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductoVO read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    public HashMap<String, Integer> cargarComboCategorias() {
        xcon = MySQLConnection.getInstance();
        HashMap<String, Integer> map = new HashMap<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_listar_categorias}");
            ResultSet rs = ps.executeQuery();
            CategoriaVO categoria;
            while(rs.next()) {
                categoria = new CategoriaVO();
                categoria.setId(rs.getInt(Constants.CATEGORIA_ID));
                categoria.setName(rs.getString(Constants.CATEGORIA_NAME));
                map.put(categoria.getName(), categoria.getId());
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return map;
    }        
                
}