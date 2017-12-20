package JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static JDBC.JDBCConnection.createConnection;

public class CategoryDao {
    private Statement statement;

    public List<String> getCategoriesWithGivenLanguage(String lang) {
        List<String> categories = new ArrayList<>();
        try {
                    statement = createConnection();
            ResultSet rs = statement.executeQuery(String.format("SELECT * from categories WHERE lang = '%s'", lang));
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void addCategory(String category, String lang) {
        try {
            statement = createConnection();
            String query = "INSERT INTO categories VALUES(?,?)";
            PreparedStatement preparedStatement = createConnection().getConnection().prepareStatement(query);
            preparedStatement.setString(1, category);
            preparedStatement.setString(2, lang);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(String name) {
        try {
            statement = createConnection();
            String query = "DELETE FROM categories WHERE category = ?";
            PreparedStatement preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
