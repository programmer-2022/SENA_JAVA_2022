package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import models.config.MySQLConnection;
import models.interfaces.ICrud;

import models.vo.RolesVO;
import models.vo.UsuarioVO;
import utils.Constants;
import utils.Messages;

public class UsuarioDAO implements ICrud<UsuarioVO>{

    private static MySQLConnection xcon;

    public UsuarioDAO() { }
    
    @Override
    public boolean create(UsuarioVO user) {
        xcon = MySQLConnection.getInstance();
        
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_crear_usuario(?,?,?)}");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRol().getId());

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
    public LinkedList<UsuarioVO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UsuarioVO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioVO read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
    public HashMap<String, Integer> cargarComboRoles() {
        xcon = MySQLConnection.getInstance();
        HashMap<String, Integer> map = new HashMap<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_listar_roles}");
            ResultSet rs = ps.executeQuery();
            RolesVO rol;
            while(rs.next()) {
                rol = new RolesVO();
                rol.setId(rs.getInt(Constants.ROL_ID));
                rol.setName(rs.getString(Constants.ROL_NOMBRE));
                map.put(rol.getName(), rol.getId());
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
    
    public UsuarioVO buscarNombreUsuario(String nombre) {
        xcon = MySQLConnection.getInstance();
        UsuarioVO user = new UsuarioVO();
        RolesVO rol = new RolesVO();
        
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_buscar_nombre_usuario(?)}");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                user.setId(rs.getInt(Constants.USER_ID));
                user.setUsername(rs.getString(Constants.USER_NAME));
                user.setPassword(rs.getString(Constants.USER_PASS));
                rol.setId(rs.getInt(Constants.USER_ROL_ID));
                user.setRol(rol);
            }            
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return user;
    }

}