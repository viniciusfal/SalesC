package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.ConnectionFactory;
import Model.Product;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {

    public void save(Product product) {

        String sql = "INSERT INTO products(name, size, color, created_at, updated_at)"
                + "VALUES (?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, product.getName());
            statement.setInt(2, product.getSize());
            statement.setString(3, product.getColor());
            statement.setDate(4, new Date(product.getCreated_at().getTime()));
            statement.setDate(5, new Date(product.getUpdated_at().getTime()));

            statement.execute();

        } catch (SQLException ex) {

            throw new RuntimeException("Erro ao salvar o produto " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Product product) {
        String sql = "UPDATE products SET "
                + "name = ?,"
                + "size = ?,"
                + "color = ?,"
                + "created_at = ?,"
                + "updated_at = ? "
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, product.getName());
            statement.setInt(2, product.getSize());
            statement.setString(3, product.getColor());
            statement.setDate(4, new Date(product.getCreated_at().getTime()));
            statement.setDate(5, new Date(product.getUpdated_at().getTime()));
            statement.setInt(6, product.getId());

            statement.execute();
            
           

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o produto " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void removeById(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar produto " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Product> getAll() {
        String sql = "SELECT * FROM products";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Product> products = new ArrayList<Product>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) { // Enquanto o resultSet não parar
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setSize(resultSet.getInt("size"));
                product.setColor(resultSet.getString("color"));
                product.setCreated_at(resultSet.getDate("created_at"));
                product.setUpdated_at(resultSet.getDate("updated_at"));

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.format(product.getCreated_at());
                sdf.format(product.getUpdated_at());

                products.add(product);

            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro em encontrar produtos " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return products;
    }

    public List<Product> getForName(String name) {
        // Vai pesquisar todos que começam e terminar com esse name
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Product> products = new ArrayList<Product>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + name + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) { // Enquanto o resultSet não parar
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setSize(resultSet.getInt("size"));
                product.setColor(resultSet.getString("color"));
                product.setCreated_at(resultSet.getDate("created_at"));
                product.setUpdated_at(resultSet.getDate("updated_at"));

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.format(product.getCreated_at());
                sdf.format(product.getUpdated_at());

                products.add(product);

            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro em encontrar produtos " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return products;
    }

    
    public List<Product> getForColor(String color) {
        // Vai pesquisar todos que começam e terminar com esse name
        String sql = "SELECT * FROM products WHERE color LIKE ?"; 
            

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Product> products = new ArrayList<Product>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+color+"%");
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) { // Enquanto o resultSet não parar
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setSize(resultSet.getInt("size"));
                product.setColor(resultSet.getString("color"));
                product.setCreated_at(resultSet.getDate("created_at"));
                product.setUpdated_at(resultSet.getDate("updated_at"));

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.format(product.getCreated_at());
                sdf.format(product.getUpdated_at());

                products.add(product);

            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro em encontrar produtos " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return products;
    }
    
    public List<Product> getForSize(int size) {
        // Vai pesquisar todos que começam e terminar com esse name
        String sql = "SELECT * FROM products WHERE size LIKE ?"; 
            

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Product> products = new ArrayList<Product>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+size+"%");
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) { // Enquanto o resultSet não parar
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setSize(resultSet.getInt("size"));
                product.setColor(resultSet.getString("color"));
                product.setCreated_at(resultSet.getDate("created_at"));
                product.setUpdated_at(resultSet.getDate("updated_at"));

              

                products.add(product);

            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro em encontrar produtos " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return products;
    }
}

