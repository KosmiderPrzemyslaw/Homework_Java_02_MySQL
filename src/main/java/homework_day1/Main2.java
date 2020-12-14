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
                            "dimension VARCHAR(10)," +
                            "FOREIGN KEY (offer_id) REFERENCES homework_day1_mysql.offers(id))");
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
                            "created_ad DATETIME," +
                            "FOREIGN KEY (user_id) REFERENCES homework_day1_mysql.users(id))");

            preparedStatement1.executeUpdate();


            PreparedStatement preparedStatement2 = connection.prepareStatement
                    ("CREATE TABLE IF NOT EXISTS customers (" +
                            "customer_id int not null auto_increment," +
                            "name varchar(255) not null ," +
                            "primary key(customer_id))" +
                            "ENGINE = InnoDB CHARSET = utf8");
            preparedStatement2.executeUpdate();

            PreparedStatement preparedStatement3 = connection.prepareStatement
                    ("CREATE TABLE  IF NOT EXISTS addresses(" +
                            "addresses_id int not null ," +
                            "street VARCHAR(255)," +
                            "PRIMARY KEY (addresses_id)," +
                            "FOREIGN KEY (addresses_id) references homework_day1_mysql.customers(customer_id) ON DELETE CASCADE ON UPDATE CASCADE)");
            preparedStatement3.executeUpdate();
//
//            PreparedStatement preparedStatement2 = connection.prepareStatement
//                    ("CREATE TABLE users_addresses" +
//                            "(user_id int(10) NOT NULL," +
//                            "city VARCHAR(50)," +
//                            "street VARCHAR(50)," +
//                            "house_nr VARCHAR(10)," +
//                            "PRIMARY KEY (user_id)," +
//                            "FOREIGN KEY (user_id) REFERENCES homework_day1_mysql.users(id))" +
//                            "ENGINE=InnoDB DEFAULT CHARSET=utf8 ");
//
//            preparedStatement2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
