import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstClass {
    public static void main(String[] args) {
        try {
            Connection connection = new DBConnection().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from homework_day1_mysql.offers where promoted = 0 and price > 50000 and title like '%l' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            PrintUtil.print(resultSet, "title", "expire");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
