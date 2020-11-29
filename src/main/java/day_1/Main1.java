package day_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
    private static final String QUERY = "CREATE DATABASE products_ex";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?useSSL=false&characterEncoding=utf8",
                "root",
                "coderslab")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(Main2.createTableProducts);
            statement.executeUpdate(Main2.createTableOrders);
            statement.executeUpdate(Main2.createTableClients);
            statement.executeUpdate(Main2.createTableCinemas);
            statement.executeUpdate(Main2.createTableMovies);
            statement.executeUpdate(Main2.createTableTickets);
            statement.executeUpdate(Main2.createTablePayments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
