package day_2;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main4 {
    public static void main(String[] args) {
        Connection connection;

        {
            try {
                connection = new DBConnection().getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement("DELETE FROM products_ex.payments WHERE CAST(payment_date as datetime)< DATE_SUB(NOW(), INTERVAL 4 DAY )");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
