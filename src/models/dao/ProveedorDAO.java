package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import models.config.MySQLConnection;
import models.interfaces.ICrud;
import models.vo.CargoVO;
import models.vo.ProveedorVO;
import utils.Constants;
import utils.Messages;

public class ProveedorDAO implements ICrud<ProveedorVO>{

    private static MySQLConnection xcon;

    public ProveedorDAO() { }
    
    @Override
    public boolean create(ProveedorVO proveedor) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_crear_proveedor(?,?,?,?,?)}");
            ps.setString(1, proveedor.getNit());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getEmail());

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
    public LinkedList<ProveedorVO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ProveedorVO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProveedorVO read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
    public ProveedorVO buscarProveedor(String nit) {
        xcon = MySQLConnection.getInstance();
        ProveedorVO proveedor = new ProveedorVO();
        
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_buscar_proveedor_nit(?)}");
            ps.setString(1, nit);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                proveedor.setId(rs.getInt(Constants.PROVEEDOR_ID));
                proveedor.setNit(rs.getString(Constants.PROVEEDOR_NIT));
                proveedor.setNombre(rs.getString(Constants.PROVEEDOR_NOMBRE));
                proveedor.setTelefono(rs.getString(Constants.PROVEEDOR_TELEFONO));
                proveedor.setDireccion(rs.getString(Constants.PROVEEDOR_DIRECCION));
                proveedor.setEmail(rs.getString(Constants.PROVEEDOR_EMAIL));
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return proveedor;
    }    
    
    public HashMap<String, Integer> cargarComboProveedores() {
        xcon = MySQLConnection.getInstance();
        HashMap<String, Integer> map = new HashMap<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_listar_proveedores}");
            ResultSet rs = ps.executeQuery();
            ProveedorVO proveedor;
            while(rs.next()) {
                proveedor = new ProveedorVO();
                proveedor.setId(rs.getInt(Constants.PROVEEDOR_ID));
                proveedor.setNombre(rs.getString(Constants.PROVEEDOR_NOMBRE));                
                map.put(proveedor.getNombre(), proveedor.getId());
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