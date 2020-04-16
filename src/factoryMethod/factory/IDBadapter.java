package factoryMethod.factory;

import java.sql.Connection;

public interface IDBadapter {
    public Connection getConnection();
}
