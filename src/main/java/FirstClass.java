import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.*;

public class FirstClass {
    public static void main(String[] args) {
        try {
            Connection connection = new DBConnection().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from homework_day1_mysql.offers where promoted = 0 and price > 50000 and title like '%l' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            PrintUtil.print(resultSet, "title", "expire");

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM homework_day1_mysql.offers where price < price*2 and promoted = 1 and promoted_to > CURRENT_DATE");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            PrintUtil.print(resultSet2, "title", "price", "expire");

            PreparedStatement preparedStatement3 = connection.prepareStatement("SELECT COUNT(*) AS sum_active FROM homework_day1_mysql.offers WHERE status = 1 and expire > NOW()");
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            PrintUtil.print(resultSet3, "sum_active");

            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT COUNT(homework_day1_mysql.offers.id) AS sum_offers from homework_day1_mysql.offers where status = 1 and promoted_to > CURRENT_DATE and expire < NOW() and price > 300000");
            ResultSet resultSet4 = preparedStatement1.executeQuery();
            PrintUtil.print(resultSet4, "sum_offers");


            PreparedStatement preparedStatement4 = connection.prepareStatement("SELECT homework_day1_mysql.offers.title AS offersTitle FROM homework_day1_mysql.offers ORDER BY id DESC");
            printResults(preparedStatement4, "offersTitle");

            PreparedStatement preparedStatement5 = connection.prepareStatement("SELECT COUNT(*) AS sum_active FROM homework_day1_mysql.offers WHERE expire > NOW() and status = 1");
            printResults(preparedStatement5, "sum_active");

            PreparedStatement preparedStatement6 = connection.prepareStatement
                    ("SELECT owner, COUNT(*) " +
                            "AS sum_user " +
                            "FROM homework_day1_mysql.offers " +
                            "WHERE status = 1 and expire > NOW() GROUP BY owner");
            printResults(preparedStatement6, "owner","sum_user");

            PreparedStatement preparedStatement7 = connection.prepareStatement
                    ("SELECT status as type, COUNT(status) as counter " +
                            "FROM homework_day1_mysql.offers " +
                            "WHERE status = 1 OR status = 2 " +
                            "GROUP BY status " +
                            "ORDER BY type");
            printResults(preparedStatement7, "type", "counter");

            PreparedStatement preparedStatement8 = connection.prepareStatement
                    ("SELECT SUM(price) AS sum_nonactive_nonpromoted " +
                            "FROM homework_day1_mysql.offers " +
                            "WHERE status = 1 AND promoted = 0 and expire < NOW()");
            printResults(preparedStatement8, "sum_nonactive_nonpromoted");



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void printResults(PreparedStatement preparedStatement , String... columnNames) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        PrintUtil.print(resultSet, columnNames);
    }
}
