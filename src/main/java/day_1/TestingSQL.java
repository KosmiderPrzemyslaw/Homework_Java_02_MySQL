package day_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestingSQL {
    public static void main(String[] args) {
        String createTableCities = "CREATE TABLE cities (city_id INT AUTO_INCREMENT," +
                " city_name VARCHAR(255) UNIQUE,"
                + " city_population INT,"
                + "PRIMARY KEY(city_id))";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL_JAVA_02?useSSL=false&characterEncoding=utf8",
                "root",
                "coderslab")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableCities);

        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
