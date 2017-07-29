package fasttrackit.shop.business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by icondor on 22/07/2017.
 */
public class DbAccessProduct {

    public List<Product> getAllProducts() {

        /* se va conecta la db si va returna o lista de produse */

        List<Product> listaDinDB = new ArrayList();
        try {
            Class.forName("org.postgresql.Driver");

            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/6IulianaUser23";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            // 4. create a query statement
            Statement st = conn.createStatement();

            // 5. execute a query
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            // 6. iterate the result set and print the values

            // BIG HACK, DEMO PURPOSE, BECAUSE I CREATE A DEPENDENCY ON HOW THE IMPLEM IS DONE IN UI
            String item;
            while (rs.next()) {

                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));

                listaDinDB.add(p);

            }

            // 7. close the objects
            rs.close();
            st.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDinDB;
    }


    public void insertProduct(Product p) {

        try {
            Class.forName("org.postgresql.Driver");

            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/6IulianaUser23";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
            PreparedStatement pSt = conn.prepareStatement("INSERT INTO products (name, price) VALUES (?,?)");

            pSt.setString(1, p.getName());
            pSt.setDouble(2, p.getPrice());
            int rowsInserted = pSt.executeUpdate();

            // 6. close the objects
            pSt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        Product zahar = new Product();
        zahar.setName("zahar la plic ");
        zahar.setPrice(0.99);
        new DbAccessProduct().insertProduct(zahar);

        Product carneDeVita = new Product();
        carneDeVita.setName("antricot de vita");
        carneDeVita.setPrice(99.99);
        new DbAccessProduct().insertProduct(carneDeVita);
    }

}
