package homework_day1;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        try {
            Connection connection = new DBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("CREATE TABLE IF NOT EXISTS images" +
                            "(id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY," +
                            "offer_id INT UNSIGNED," +
                            "src VARCHAR(100)," +
                            "dimension VARCHAR(10))");
            preparedStatement.executeUpdate();


            PreparedStatement preparedStatement1 = connection.prepareStatement
                    ("CREATE TABLE IF NOT EXISTS users_companies " +
                            "(id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY," +
                            "user_id INT UNSIGNED UNIQUE," +
                            "name VARCHAR(30)," +
                            "nip INT," +
                            "street VARCHAR(50)," +
                            "street_nr MEDIUMINT," +
                            "phone CHAR(9)," +
                            "post_code CHAR(6)," +
                            "capital DECIMAL(7,2)," +
                            "rate DECIMAL(5,4)," +
                            "created_ad DATETIME)");

            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
