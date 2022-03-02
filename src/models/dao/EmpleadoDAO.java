package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import models.config.MySQLConnection;
import models.interfaces.ICrud;
import models.vo.CargoVO;
import models.vo.EmpleadoVO;
import models.vo.GeneroVO;
import utils.Constants;
import utils.Messages;

public class EmpleadoDAO implements ICrud<EmpleadoVO> {

    private static MySQLConnection xcon;

    public EmpleadoDAO() { }
            
    @Override
    public boolean create(EmpleadoVO empleado) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_crear_empleado(?,?,?,?,?)}");
            ps.setInt(1, empleado.getIdentificacion());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido());
            ps.setInt(4, empleado.getGenero().getId());
            ps.setInt(5, empleado.getCargo().getId());

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
    public LinkedList<EmpleadoVO> readAll() {
        xcon = MySQLConnection.getInstance();
        LinkedList<EmpleadoVO> listaEmpleados = new LinkedList<>();
                
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_listar_empleados}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                EmpleadoVO empleado = new EmpleadoVO();
                CargoVO cargo = new CargoVO();
                GeneroVO genero = new GeneroVO();
                empleado.setId(rs.getInt(Constants.EMP_ID));
                empleado.setIdentificacion(rs.getInt(Constants.EMP_IDENTIFICACION));
                empleado.setNombre(rs.getString(Constants.EMP_NOMBRE));
                empleado.setApellido(rs.getString(Constants.EMP_APELLIDO));
                genero.setId(rs.getInt(Constants.GENERO_ID));
                genero.setName(rs.getString(Constants.GENERO_NOMBRE));
                cargo.setId(rs.getInt(Constants.CARGO_ID));
                cargo.setName(rs.getString(Constants.CARGO_NOMBRE));
                empleado.setGenero(genero);
                empleado.setCargo(cargo);
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return listaEmpleados;
    }

    @Override
    public boolean update(EmpleadoVO empleado) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_editar_empleado(?,?,?,?,?)}");
            ps.setInt(1, empleado.getIdentificacion());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido());
            ps.setInt(4, empleado.getGenero().getId());
            ps.setInt(5, empleado.getCargo().getId());

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
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmpleadoVO read(Object id) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<String, Integer> cargarComboGenero() {
        
        xcon = MySQLConnection.getInstance();
        HashMap<String, Integer> map = new HashMap<>();
        
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_listar_generos}");
            ResultSet rs = ps.executeQuery();
            GeneroVO genero;
            
            while(rs.next()) {
                genero = new GeneroVO();
                genero.setId(rs.getInt(Constants.GENERO_ID));
                genero.setName(rs.getString(Constants.GENERO_NOMBRE));
                map.put(genero.getName(), genero.getId());
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
    
    public HashMap<String, Integer> cargarComboEmpleados() {
        
        xcon = MySQLConnection.getInstance();
        HashMap<String, Integer> map = new HashMap<>();
        
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_listar_empleados}");
            ResultSet rs = ps.executeQuery();
            EmpleadoVO empleado;
            
            while(rs.next()) {
                empleado = new EmpleadoVO();
                empleado.setId(rs.getInt(Constants.EMP_ID));
                empleado.setNombre(rs.getString(Constants.EMP_NOMBRE));
                empleado.setApellido(rs.getString(Constants.EMP_APELLIDO));
                map.put(empleado.getNombre() + " " + empleado.getApellido(), empleado.getId());
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
    
    public HashMap<String, Integer> cargarComboCargos() {
        xcon = MySQLConnection.getInstance();
        HashMap<String, Integer> map = new HashMap<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_listar_cargos}");
            ResultSet rs = ps.executeQuery();
            CargoVO cargo;
            while(rs.next()) {
                cargo = new CargoVO();
                cargo.setId(rs.getInt(Constants.CARGO_ID));
                cargo.setName(rs.getString(Constants.CARGO_NOMBRE));
                map.put(cargo.getName(), cargo.getId());
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
    
    public EmpleadoVO buscarID(int identificacion) {
        xcon = MySQLConnection.getInstance();
        EmpleadoVO empleado = new EmpleadoVO();
        CargoVO cargo = new CargoVO();
        GeneroVO genero = new GeneroVO();
        
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_buscar_empleado_id(?)}");
            ps.setInt(1, identificacion);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                empleado.setId(rs.getInt(Constants.EMP_ID));
                empleado.setIdentificacion(rs.getInt(Constants.EMP_IDENTIFICACION));
                empleado.setNombre(rs.getString(Constants.EMP_NOMBRE));
                empleado.setApellido(rs.getString(Constants.EMP_APELLIDO));
                genero.setId(rs.getInt(Constants.GENERO_ID));
                genero.setName(rs.getString(Constants.GENERO_NOMBRE));
                cargo.setId(rs.getInt(Constants.CARGO_ID));
                cargo.setName(rs.getString(Constants.CARGO_NOMBRE));
                empleado.setGenero(genero);
                empleado.setCargo(cargo);                
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return empleado;
    }

    public LinkedList<EmpleadoVO> readOne(int identificacion) {
        xcon = MySQLConnection.getInstance();
        LinkedList<EmpleadoVO> listaEmpleados = new LinkedList<>();
                
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_buscar_empleado_id(?)}");
            ps.setInt(1, identificacion);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                EmpleadoVO empleado = new EmpleadoVO();
                CargoVO cargo = new CargoVO();
                GeneroVO genero = new GeneroVO();
                empleado.setId(rs.getInt(Constants.EMP_ID));
                empleado.setIdentificacion(rs.getInt(Constants.EMP_IDENTIFICACION));
                empleado.setNombre(rs.getString(Constants.EMP_NOMBRE));
                empleado.setApellido(rs.getString(Constants.EMP_APELLIDO));
                genero.setId(rs.getInt(Constants.GENERO_ID));
                genero.setName(rs.getString(Constants.GENERO_NOMBRE));
                cargo.setId(rs.getInt(Constants.CARGO_ID));
                cargo.setName(rs.getString(Constants.CARGO_NOMBRE));
                empleado.setGenero(genero);
                empleado.setCargo(cargo);
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            Messages.msgError(Constants.ERROR_SERVER);
        } catch (Exception e) {
            Messages.msgError(Constants.ERROR_SYSTEM);            
        } finally {
            xcon.close_connection();
        }
        return listaEmpleados;
    }
       
}