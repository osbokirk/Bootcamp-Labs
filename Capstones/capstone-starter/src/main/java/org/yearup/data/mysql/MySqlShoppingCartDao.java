package org.yearup.data.mysql;
import org.yearup.models.ShoppingCart;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlShoppingCartDao extends MySqlDaoBase implements org.yearup.data.ShoppingCartDao {
    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId) {

        String query = "Call GetProductsFromShoppingCart (?)";
        try (Connection connection = getConnection()){

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }
    @Override
    public void clearCart(int userId){
        String query = "Call DeleteShoppingCart(?)";

        try(Connection connection  =  getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,userId);
            preparedStatement.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void addToCart(int userId,int productId){
        String query = "Call AddItemToShoppingCart (?,?)";
        try (Connection connection = getConnection()){

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updateCart (int userId,int productId, int quantity){
        String query = "Call UpdateShoppingCart (?,?)";
        try (Connection connection = getConnection()){

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
