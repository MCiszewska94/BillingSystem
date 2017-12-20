package JDBC;

import Modules.Category;
import Modules.Meal;
import Modules.Menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static JDBC.JDBCConnection.createConnection;

public class MenuDao {
    private static Statement statement;

    public List<Meal> getMealsFromGivenCategoryAndLanguage(String cat, String lang) {
        List<Meal> meals = new ArrayList<>();
        try {
            statement = createConnection();
            ResultSet rs = statement.executeQuery(String.format("SELECT name,description," +
                    "cost FROM menu WHERE category = '%s' AND lang = '%s';", cat, lang));
            while (rs.next()) {
                meals.add(new Meal(rs.getString("name"), rs.getString("description")
                        , rs.getDouble("cost")));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meals;
    }

    public void addMeal(String category, String name, String description, double cost, String lang) {
        try {
            statement = createConnection();
            String query = "INSERT INTO menu(category,name,description,cost,lang) VALUES(?,?,?,?,?);";
            PreparedStatement preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1,category);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,description);
            preparedStatement.setDouble(4,cost);
            preparedStatement.setString(5,lang);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMeal(String category,String name){
        try{
            statement = createConnection();
            String query = "DELETE FROM menu WHERE category = ? AND name = ?";
            PreparedStatement preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1,category);
            preparedStatement.setString(2,name);
            preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
