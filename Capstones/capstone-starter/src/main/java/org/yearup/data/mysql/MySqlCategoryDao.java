package org.yearup.data.mysql;

import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories()
    {
        // get all categories
        List<Category> categories =  new ArrayList<>();

        String query = "{Call GetAllCategories}";
        try(Connection connection = this.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            ResultSet resultSet = callableStatement.executeQuery(query);
            while (resultSet.next()){
                Category category = mapRow(resultSet);
                categories.add(category);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return categories;
    }

    @Override   //crashes
    public Category getById(int categoryId)
    {
        // get category by id
        String query = "{Call GetCategoryById(?)}";
        Category  category = new Category();

        try(Connection connection = this.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,categoryId);
            //Crash happened here :(
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                category = mapRow(resultSet);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return category;
    }

    @Override
    public Category create(Category category)
    {
        // create a new category
        String query = "{Call AddCategory(?,?)}";
        Category newCategory = new Category();
        try(Connection connection = this.getConnection(); CallableStatement call = connection.prepareCall(query)){
           // call.setInt(1,category.getCategoryId());
            call.setString(1,category.getName());
            call.setString(2,category.getDescription());

            ResultSet resultSet = call.executeQuery();
            //resultSet.next();
            //newCategory = mapRow(resultSet);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(int categoryId, Category category)
    {
        // update category
        String query = "{Call PutCategory(?,?,?,?)}";
        try(Connection connection = this.getConnection(); CallableStatement call = connection.prepareCall(query)){
            call.setInt(1,categoryId);
            call.setInt(2,category.getCategoryId());
            call.setString(3,category.getName());
            call.setString(4,category.getDescription());
            call.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryId)
    {
        // delete category
        String query = "{Call DeleteCategory(?)}";
        try(Connection connection = this.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,categoryId);
            callableStatement.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
