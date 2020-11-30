package day_1;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main6 {

    public static void main(String[] args) {
        selectMoviesStartWith();
    }

    private static void selectMoviesStartWith() {
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connectionConnection = dbConnection.getConnection();
            PreparedStatement preparedStatement =
                    connectionConnection.prepareStatement("SELECT * FROM products_ex.movies WHERE title like 'W%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            PrintUtil.print(resultSet, "title");

            PreparedStatement preparedStatement1 =
                    connectionConnection.prepareStatement("SELECT  * FROM products_ex.tickets WHERE products_ex.tickets.price > 5.30");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            PrintUtil.print(resultSet1, "ticket_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
