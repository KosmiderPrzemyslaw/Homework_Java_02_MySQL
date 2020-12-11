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

            connection.prepareStatement("SELECT * FROM homework_day1_mysql.offers where price < price*2 and promoted = 1 and promoted_to > CURRENT_DATE");
            ResultSet resultSet2 = preparedStatement.executeQuery();
            PrintUtil.print(resultSet2, "title", "price", "expire");

            connection.prepareStatement("SELECT COUNT(*) AS sum_active FROM homework_day1_mysql.offers WHERE status = 1 and expire > NOW()");
            ResultSet resultSet3 = preparedStatement.executeQuery();
            PrintUtil.print(resultSet3, "status", "title");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
