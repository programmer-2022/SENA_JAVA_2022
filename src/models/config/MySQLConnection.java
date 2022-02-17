package models.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Constants;
import utils.Messages;

public class MySQLConnection {
    
    public static MySQLConnection instance;
    private Connection xcon;

    private MySQLConnection() {
        /*String host = "jdbc:mysql://bvr1q09tvhnyq2juurqb-mysql.services.clever-cloud.com:3306/";
        String user = "uj5vgfxi6ybsq4sz";
        String password = "gi0icU1Nbr5fUat4lSFU";
        String db_name = "bvr1q09tvhnyq2juurqb";*/
        
        String url = "jdbc:mysql://localhost:3306/";
        String user = "compensar2021";
        String password = "#R00tk1t9";
        String db_name = "dbcompensar2021";
        /*
        MYSQL_ADDON_DB="bvr1q09tvhnyq2juurqb"
        MYSQL_ADDON_HOST="bvr1q09tvhnyq2juurqb-mysql.services.clever-cloud.com"
        MYSQL_ADDON_PASSWORD="gi0icU1Nbr5fUat4lSFU"
        MYSQL_ADDON_PORT="3306"
        MYSQL_ADDON_URI="mysql://uj5vgfxi6ybsq4sz:gi0icU1Nbr5fUat4lSFU@bvr1q09tvhnyq2juurqb-mysql.services.clever-cloud.com:3306/bvr1q09tvhnyq2juurqb"
        MYSQL_ADDON_USER="uj5vgfxi6ybsq4sz"
        MYSQL_ADDON_VERSION="8.0"*/
        
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
}