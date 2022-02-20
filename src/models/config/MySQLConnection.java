package models.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constants;
import utils.Messages;

public class MySQLConnection {
    
    public static MySQLConnection instance;
    private Connection xcon;

    private MySQLConnection() {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "compensar2021";
        String password = "#R00tk1t9";
        String db_name = "dbcompensar2021";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            xcon = DriverManager.getConnection(url + db_name, user, password);
        } catch (ClassNotFoundException e) {
            Messages.msgError(Constants.DRIVER_NOT_FOUND);
        } catch (SQLException e) {
            Messages.msgError(Constants.DATABASE_ERROR);
        }    
    }
        
    public synchronized static MySQLConnection getInstance() {
        if(instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return xcon;
    }
    
    public void close_connection() {
        instance = null;
    }
    
    public void setAutocommitDisable() {
        try {
            xcon.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollBack() {
        try {
            xcon.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Commit() {
        try {
            xcon.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}