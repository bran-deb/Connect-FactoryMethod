package factorymetod.factory;

import org.postgresql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;


public class PostgresAdaptter implements IDBAdapter{

    static{
        try {
            new Driver();
        } catch (Exception e) {}
    }
    
    @Override
    public Connection getConnection() {
        try {
            String urlConnection = getConnectionString();
            String user = "postgres";
            String password = "diosdeb";
            Connection connection = DriverManager.getConnection(urlConnection, user, password);
            System.out.println("connection class => " + connection.getClass().getCanonicalName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }   
    }
    
    public String getConnectionString(){
        return "jdbc:postgresql://localhost:5432/factoryMethod";
    }
}
