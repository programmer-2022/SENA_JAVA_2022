package controllers;

import java.util.LinkedList;
import models.dao.DetalleProductoDAO;
import models.interfaces.ICrud;
import models.vo.DetalleProductoVO;

public class DetalleProductoController implements ICrud<DetalleProductoVO> {
    
    private final DetalleProductoDAO dao;
    
    public DetalleProductoController() {
        dao = new DetalleProductoDAO();
    }

    @Override
    public boolean create(DetalleProductoVO detalle) {
        return dao.create(detalle);
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