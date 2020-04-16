package factorymetod.factory;

import factorymetod.types.DBType;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Stream;


public class DBAdapterFactory {
    
    private static final String DB_TYPE = "dbadaptertype";
    
    public static IDBAdapter getAdapter(DBType type){
        switch (type){
            case MYSQL:
                return new MySQLAdapter();
            case POSTGRES:
                return new PostgresAdaptter();
            default:
                return null;
        }
    }
    
    public static IDBAdapter getAdapter(){
        try {
            Properties p = loadProperties();
            String dbType = p.getProperty(DB_TYPE);
            System.out.println(p);
            return (IDBAdapter)Class.forName(dbType).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        }

    private static Properties loadProperties(){
        try {
            Properties p = new Properties();
            InputStream stream = DBAdapterFactory.class.getClassLoader().getResourceAsStream("./META-INF/dbadapter.properties");
            p.load(stream);
            
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}