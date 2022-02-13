package controllers;

import java.util.HashMap;
import java.util.LinkedList;
import models.dao.UsuarioDAO;
import models.interfaces.ICrud;
import models.vo.UsuarioVO;

public class UserController implements ICrud<UsuarioVO> {
    
    private final UsuarioDAO dao;            

    public UserController() {
        dao = new UsuarioDAO();
    }

    @Override
    public boolean create(UsuarioVO user) {
        return dao.create(user);
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
        return dao.cargarComboRoles();
    }  
    
    public UsuarioVO buscarNombreUsuario(String nombre) {
        return dao.buscarNombreUsuario(nombre);
    }
}