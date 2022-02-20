package models.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import models.config.MySQLConnection;
import models.interfaces.ICrud;
import models.vo.ActaVO;
import utils.Constants;
import utils.Messages;

public class ActaDAO implements ICrud<ActaVO>{

    private static MySQLConnection xcon;
    
    public ActaDAO() { }

    @Override
    public boolean create(ActaVO acta) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_crear_acta(?,?,?,?,?,?)}");
            ps.setString(1, acta.getCodigo());
            ps.setDate(2, acta.getFecha());
            ps.setString(3, acta.getObservaciones());
            ps.setString(4, acta.getResponsableProveedor());
            ps.setInt(5, acta.getProveedor().getId());
            ps.setInt(6, acta.getEmpleado().getId());
                
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
    public LinkedList<ActaVO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ActaVO obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActaVO read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
