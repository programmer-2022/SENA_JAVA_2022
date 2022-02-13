package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import models.config.MySQLConnection;
import models.interfaces.ICrud;
import models.vo.CategoriaVO;
import models.vo.ProductoVO;
import utils.Constants;
import utils.Messages;

public class ProductoDAO implements ICrud<ProductoVO> {

    private static MySQLConnection xcon;
    
    @Override
    public boolean create(ProductoVO producto) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_crear_producto(?,?,?,?,?)}");
            ps.setString(1, producto.getCode());
            ps.setString(2, producto.getName());
            ps.setString(3, producto.getSerial());
            ps.setByte(4, producto.getStatus());
            ps.setInt(5, producto.getCategoria().getId());

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
    public LinkedList<ProductoVO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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