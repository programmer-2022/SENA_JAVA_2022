package controllers;

import java.util.HashMap;
import java.util.LinkedList;
import models.dao.ProductoDAO;
import models.interfaces.ICrud;
import models.vo.DetalleProductoVO;
import models.vo.ProductoVO;

public class ProductController implements ICrud<ProductoVO>{

    private final ProductoDAO dao;
    
    public ProductController() {
        dao = new ProductoDAO();
    }

    public boolean crear(DetalleProductoVO detalle) {
        return dao.crear(detalle);
    }
    
    @Override
    public boolean create(ProductoVO producto) {
        return dao.create(producto);
    }

    @Override
    public LinkedList<ProductoVO> readAll() {
        return dao.readAll();
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
        return dao.cargarComboCategorias();
    }
    
    public ProductoVO readOne(String codigo) { 
        return dao.readOne(codigo);
    }
}