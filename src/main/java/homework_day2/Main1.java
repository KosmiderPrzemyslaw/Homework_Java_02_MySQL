package homework_day2;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main1 {
    public static void main(String[] args) {
        Connection connection;

        {
            try {

                connection = new DBConnection().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("UPDATE homework_day1_mysql.offers " +
                                "SET price = price + 1000 " +
                                "WHERE id between 10 and 20");

                PreparedStatement preparedStatement1 = connection.prepareStatement
                        ("");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
