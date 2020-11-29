package day_1;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main5 {
    public static void main(String[] args) {
        try {
            Connection connection = connectToDb();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products_ex.cinemas");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cinemaName = resultSet.getString("name");
                checkLength(cinemaName);
                System.out.println("cinema: " + checkLength(cinemaName) + " length: " + cinemaName.length());


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static String checkLength(String cinemaName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (cinemaName.length() >= 6) {
            char[] chars = cinemaName.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i >= 4) {
                    chars[i] = '.';
                }

                stringBuilder.append(chars[i]);
            }
            return String.valueOf(stringBuilder);
        } else return cinemaName;

    }

    private static Connection connectToDb() throws SQLException {
        DBConnection dbConnection = new DBConnection();
        return dbConnection.getConnection();
    }
}
