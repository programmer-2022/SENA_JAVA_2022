package utils;

public class Constants {
    
    public static final String OK_INSERT = "Se ha insertado el registro correctamente";
    public static final String OK_UPDATE = "Se ha actualizado el registro correctamente";
    public static final String OK_DELETE = "Se ha eliminado el registro correctamente";
    public static final String ERROR_INSERT = "Error, al insertar un registro";
    public static final String ERROR_UPDATE = "Error, al actualizar un registro";
    public static final String ERROR_DELETE = "Error, al eliminar un registro";
    public static final String REQUIRED = "Los campos no pueden estar vacíos";
    public static final String ONLY_NUMBERS = "El campo admite solo números";
    public static final String NOT_FOUND = "Registro no encontrado";
    public static final String DATOS_DUPLICADOS = "El registro ya se encuentra en la base de datos";
    public static final String UPDATE = "UPDATE";
    public static final String INSERT = "INSERT";
    public static final String PASSWORD_INVALID = "Las contraseñas no coinciden";
    public static final String ERROR_CREDENTIALS = "Credenciales incorrectas";
    public static final String USER_EXIST = "El usuario ya se encuentra registrado";
    
    public static final int ROL_ADMIN = 3;
    public static final int ROL_AUXILIAR = 4;
    
    //base de datos
    public static final String ERROR_SERVER = "Error en el servidor, consulte con el administrador del sistema";
    
    public static final String DATABASE_CONNECTED = "Database is connected";
    public static final String DRIVER_NOT_FOUND = "MySQL JDBC Driver no encontrado !!";
    public static final String DATABASE_ERROR = "Error en la Conexión de datos";
    
    
    //Errores de sistema
    public static final String ERROR_SYSTEM = "Error en el sistema, consulte con el administrador del sistema";
        
    //tabla empleados
    public static final String EMP_ID = "EmpleadoID";
    public static final String EMP_IDENTIFICACION = "EmpIdentificacion";
    public static final String EMP_NOMBRE = "EmpNombre";
    public static final String EMP_APELLIDO = "EmpApellido";
    
    //tabla cargos
    public static final String CARGO_ID = "CargoID";
    public static final String CARGO_NOMBRE = "CarNombre";
    
    //tabla generos
    public static final String GENERO_ID = "GeneroID";
    public static final String GENERO_NOMBRE = "GenNombre";
    
    //tabla roles
    public static final String ROL_ID = "IdRol";
    public static final String ROL_NOMBRE = "RolNombre";
    
    //tabla usuarios
    public static final String USER_ID = "UsuarioID";
    public static final String USER_NAME = "UsuNombre";
    public static final String USER_PASS = "UsuClave";
    public static final String USER_ROL_ID = "TblRoles_IdRol";
    
    public static final String PATH_SERIAL_EMPLEADO = System.getProperty("user.dir").concat("\\output\\empleado.dat");
    public static final String PATH_SERIAL_TODOS_EMPLEADOS = System.getProperty("user.dir").concat("\\output\\empleados.dat");
    
    //Credenciales permisos usuarios
    public static final String PATH_CREDENTIALS = System.getProperty("user.dir").concat("\\output\\credentials.dat");
    
}