package factorymetod.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLAdapter implements IDBAdapter{

    static{
        try {
            new com.mysql.jdbc.Driver();
        } catch (Exception e) {}
    }
    
    @Override
    public Connection getConnection() {
        try {
            String connectionString = getConnectionString();
            String name = "root";
            String password = "diosdeb";
            Connection connection = DriverManager.getConnection(connectionString, name, password);
            System.out.println("connection class => " + connection.getClass().getCanonicalName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private String getConnectionString(){
            return "jdbc:mysql://localhost:3306/factorymetod?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
        }
}
