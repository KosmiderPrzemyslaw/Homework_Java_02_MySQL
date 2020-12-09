package day_2;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main5 {
    public static void main(String[] args) {
        try {
            Connection connection = new DBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products_ex.cinemas SET address='Stadion Narodowy' WHERE name like '%z'");
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement("DELETE FROM products_ex.payments WHERE CAST(payment_date as DATETIME) < DATE_SUB(NOW(), INTERVAL 4 DAY )");
            preparedStatement1.executeUpdate();

            PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE products_ex.movies SET rating = 5.4 where length(description) > 0");
            preparedStatement2.executeUpdate();

            PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE products_ex.tickets SET price = 0.5 * price WHERE quantity = 2");
            preparedStatement3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
