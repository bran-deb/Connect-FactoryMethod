
import emtitys.Product;
import factorymetod.dao.ProductDAO;
import factorymetod.factory.DBAdapterFactory;
import factorymetod.factory.IDBAdapter;
import factorymetod.factory.MySQLAdapter;
import factorymetod.factory.PostgresAdaptter;
import factorymetod.types.DBType;
import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String args[]){
        
        Product product1 = new Product(8, "producto 1", 10);
        
        ProductDAO dao = new ProductDAO();
        //dao.saveProduct(product1);
        
        
        
        List<Product> allProducts = dao.getAllProducts();
        for(Product current : allProducts){
            System.out.println(current);
        }
        
        
        //IDBAdapter adapter = DBAdapterFactory.getAdapter(DBType.MYSQL);
        //Connection connection = adapter.getConnection();
        //PostgresAdaptter adapter = new PostgresAdaptter();
        //Connection conection = adapter.getConnection();
        //MySQLAdapter adaptersql = new MySQLAdapter();
        //Connection connection = adaptersql.getConnection();
    }
}
