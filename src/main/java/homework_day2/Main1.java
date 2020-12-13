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
                preparedStatement.executeUpdate();

                PreparedStatement preparedStatement1 = connection.prepareStatement
                        ("DELETE homework_day1_mysql.offers " +
                                "FROM homework_day1_mysql.offers " +
                                "WHERE expire < now() " +
                                "AND expire > date_sub(CURRENT_DATE, INTERVAL 4 DAY )");
                preparedStatement1.executeUpdate();

                PreparedStatement preparedStatement2 = connection.prepareStatement
                        ("DELETE homework_day1_mysql.offers " +
                                "FROM homework_day1_mysql.offers " +
                                "WHERE phone LIKE '+48%' " +
                                "AND promoted = 0");

                preparedStatement2.executeUpdate();

                PreparedStatement preparedStatement3 = connection.prepareStatement
                        ("UPDATE homework_day1_mysql.offers " +
                                "SET promoted = 1 " +
                                "WHERE promoted = 0 " +
                                "AND SUBSTRING(phone, 3,2) = 48");

                preparedStatement3.executeUpdate();

                PreparedStatement preparedStatement4 = connection.prepareStatement
                        ("UPDATE homework_day1_mysql.offers " +
                                "SET description = REPLACE(description, 'executed', 'found') " +
                                "WHERE description LIKE '%executed%'" +
                                "AND phone LIKE '(%)%'" +
                                "AND price > 3000");
                preparedStatement4.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
