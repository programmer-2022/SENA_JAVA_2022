package models.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import models.config.MySQLConnection;
import models.interfaces.ICrud;
import models.vo.DetalleProductoVO;
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
    
}