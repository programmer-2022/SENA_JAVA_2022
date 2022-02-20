package controllers;

import java.util.LinkedList;
import models.dao.ActaDAO;
import models.interfaces.ICrud;
import models.vo.ActaVO;

public class ActaController implements ICrud<ActaVO> {

    private final ActaDAO dao;
    
    public ActaController() { 
        dao = new ActaDAO();
    }
    
    @Override
    public boolean create(ActaVO acta) {
        return dao.create(acta);
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
