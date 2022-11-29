package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.ConnectionFactory;
import Model.Transaction;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

public class TransactionsDAO {

    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions (name, productId, quantity,"
                + " typeOfTransaction, value, created_at) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, transaction.getName());
            statement.setInt(2, transaction.getProductId());
            statement.setInt(3, transaction.getQuantity());
            statement.setString(4, transaction.getTypeOfTransaction());
            statement.setFloat(5, transaction.getValue());
            statement.setDate(6, new Date(transaction.getCreated_at().getTime()));

            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a transação " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void removeById(int id) {
        String sql = "DELETE FROM transactions WHERE id = ?";

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

    public List<Transaction> getAll() {
        String sql = "SELECT * FROM transactions";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Transaction> transactions = new ArrayList<Transaction>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Transaction transaction = new Transaction();

                transaction.setId(resultSet.getInt("id"));
                transaction.setName(resultSet.getString("name"));
                transaction.setProductId(resultSet.getInt("productId"));
                transaction.setQuantity(resultSet.getInt("quantity"));
                transaction.setTypeOfTransaction(resultSet.getString("typeOfTransaction"));
                transaction.setValue(resultSet.getFloat("value"));
                transaction.setCreated_at(resultSet.getDate("created_at"));

                transactions.add(transaction);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar transações " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement,resultSet);
        }

       
        return transactions;

    }
    
     public List<Transaction> getForName(String name) {
        String sql = "SELECT * FROM transactions WHERE name LIKE ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Transaction> transactions = new ArrayList<Transaction>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+name+"%");
            
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Transaction transaction = new Transaction();

                transaction.setId(resultSet.getInt("id"));
                transaction.setName(resultSet.getString("name"));
                transaction.setProductId(resultSet.getInt("productId"));
                transaction.setQuantity(resultSet.getInt("quantity"));
                transaction.setTypeOfTransaction(resultSet.getString("typeOfTransaction"));
                transaction.setValue(resultSet.getFloat("value"));
                transaction.setCreated_at(resultSet.getDate("created_at"));

                transactions.add(transaction);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar transações " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement,resultSet);
        }

       
        return transactions;

    }
     
     public List<Transaction> getForType(String typeOfTransaction) {
        String sql = "SELECT * FROM transactions WHERE typeOfTransaction LIKE ?";

        Connection connection = null;
        PreparedStatement statement = null;
       
        ResultSet resultSet = null;

        List<Transaction> transactions = new ArrayList<Transaction>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1,"%"+typeOfTransaction+"%");
            
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Transaction transaction = new Transaction();

                transaction.setId(resultSet.getInt("id"));
                transaction.setName(resultSet.getString("name"));
                transaction.setProductId(resultSet.getInt("productId"));
                transaction.setQuantity(resultSet.getInt("quantity"));
                transaction.setTypeOfTransaction(resultSet.getString("typeOfTransaction"));
                transaction.setValue(resultSet.getFloat("value"));
                transaction.setCreated_at(resultSet.getDate("created_at"));

                transactions.add(transaction);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar transações " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement,resultSet);
        }

       
        return transactions;

    }
     
}
