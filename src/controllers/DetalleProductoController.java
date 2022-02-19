package controllers;

import java.util.ArrayList;
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
        return dao.readAll();
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
        return dao.buscarProducto(nit, codigo, fecha);
    }    
    
    public ArrayList<DetalleProductoVO> buscarTodos(String nit, String fecha) {
        return dao.buscarTodos(nit, fecha);
    }   
    
}