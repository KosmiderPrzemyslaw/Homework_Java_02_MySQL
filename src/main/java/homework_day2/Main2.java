package homework_day2;

import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        try {
            Connection connection = new DBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("CREATE TABLE IF NOT EXISTS payments (" +
                            "id int," +
                            "type varchar(255)," +
                            "payment_date date," +
                            "PRIMARY KEY (id)," +
                            "FOREIGN KEY (id) REFERENCES cinema.tickets(id))ENGINE=InnoDB CHARSET = utf8");
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement
                    ("SELECT * FROM cinema.tickets AS tickets " +
                            "JOIN cinema.payments AS payments ON tickets.id = payments.id " +
                            "WHERE payments.type = 'cash' AND payments.payment_date < NOW()");
            ResultSet resultSet = preparedStatement1.executeQuery();
            PrintUtil.print(resultSet, "id", "quantity", "price");

            PreparedStatement preparedStatement2 = connection.prepareStatement
                    ("SELECT * FROM cinema.tickets AS tickets" +
                            " JOIN cinema.payments AS payments ON tickets.id = payments.id " +
                            "WHERE payments.payment_date > NOW()");

            ResultSet resultSet1 = preparedStatement2.executeQuery();
            PrintUtil.print(resultSet1, "id", "quantity", "price");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
