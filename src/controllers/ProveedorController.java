package controllers;

import java.util.HashMap;
import java.util.LinkedList;
import models.dao.ProveedorDAO;
import models.interfaces.ICrud;
import models.vo.ProveedorVO;

public class ProveedorController implements ICrud<ProveedorVO> {

    private final ProveedorDAO dao;
    
    public ProveedorController() {
        dao = new ProveedorDAO();
    }

    @Override
    public boolean create(ProveedorVO proveedor) {
        return dao.create(proveedor);
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
    
    public HashMap<String, Integer> cargarComboProveedores() {
        return dao.cargarComboProveedores();
    }    
    
    public ProveedorVO buscarProveedor(String nit) {
        return dao.buscarProveedor(nit);
    } 
}