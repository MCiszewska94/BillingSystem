package JDBC;
import java.sql.*;


public class JDBCConnection {
    private static Statement statement = null;


    public static Statement createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingsystem",
                    "root", "gosia");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statement;
    }

}
