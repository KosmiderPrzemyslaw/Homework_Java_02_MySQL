package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/MySQL_JAVA_02?useSSL=false&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "coderslab";


    public static Connection connectToDb() {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
