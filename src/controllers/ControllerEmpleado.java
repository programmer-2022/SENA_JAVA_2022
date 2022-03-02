package controllers;

import java.util.HashMap;
import java.util.LinkedList;
import models.dao.EmpleadoDAO;
import models.interfaces.ICrud;
import models.vo.EmpleadoVO;

public class ControllerEmpleado implements ICrud<EmpleadoVO>{
    
    private final EmpleadoDAO dao;
    
    public ControllerEmpleado() { 
        dao = new EmpleadoDAO();
    }

    @Override
    public boolean create(EmpleadoVO empleado) {
        return dao.create(empleado);
    }

    @Override
    public LinkedList<EmpleadoVO> readAll() {
        return dao.readAll(); 
    }

    public LinkedList<EmpleadoVO> readOne(int identificacion) {
        return dao.readOne(identificacion); 
    }

    @Override
    public boolean update(EmpleadoVO empleado) {
        return dao.update(empleado);
    }

    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmpleadoVO read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
    public HashMap<String, Integer> cargarComboGeneros() {
        return dao.cargarComboGenero();
    }
    
    public HashMap<String, Integer> cargarComboCargos() {
        return dao.cargarComboCargos();
    }   
    
    public EmpleadoVO buscarID(int identificacion) {
        return dao.buscarID(identificacion);
    }
    
    public HashMap<String, Integer> cargarComboEmpleados() {
        return dao.cargarComboEmpleados();
    }            
}
