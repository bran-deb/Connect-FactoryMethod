package factorymetod.dao;

import emtitys.Product;
import factorymetod.factory.DBAdapterFactory;
import factorymetod.factory.IDBAdapter;
import factorymetod.types.DBType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductDAO {
    
    private IDBAdapter adapter;
    
    public ProductDAO(){
        adapter = DBAdapterFactory.getAdapter();
    }
    
    public void saveProduct(Product product){
        
        try {
            String sql = "insert into productos values (?,?,?)";
            Connection connection = adapter.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Product> getAllProducts(){
        try {
            String sql = "select * from productos";
            Connection connection = adapter.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            
            List<Product> products = new ArrayList<>();
            
            while(results.next()){
                Long id = results.getLong(1);
                String name = results.getString(2);
                double price = results.getDouble(3);
                Product current = new Product(id, name, price);
                products.add(current);
            }
            return products;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
