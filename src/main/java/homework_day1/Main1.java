package homework_day1;

import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main1 {
    public static void main(String[] args) {
        try {
            Connection connection = new DBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM homework_day1_mysql.users where users.name like 'Julia %'");
            ResultSet resultSet = preparedStatement.executeQuery();
            PrintUtil.print(resultSet, "name", "email");

            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from homework_day1_mysql.users order by email desc limit 5");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            PrintUtil.print(resultSet1, "name", "email");

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * from homework_day1_mysql.users where email like '%@yahoo.com' AND name like 'L%'");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            PrintUtil.print(resultSet2, "name", "email");

            PreparedStatement preparedStatement3 = connection.prepareStatement("SELECT * FROM homework_day1_mysql.users where password like SHA2(concat(name, salt), 256)");
            resultSet = preparedStatement3.executeQuery();
            PrintUtil.print(resultSet, "name", "email");

            PreparedStatement preparedStatement4 = connection.prepareStatement("SELECT homework_day1_mysql.offers.id, homework_day1_mysql.offers.title FROM homework_day1_mysql.offers where price > 500000");
            resultSet = preparedStatement4.executeQuery();
            PrintUtil.print(resultSet, "id", "title");

            PreparedStatement preparedStatement5 = connection.prepareStatement("SELECT homework_day1_mysql.offers.id, homework_day1_mysql.offers.price from homework_day1_mysql.offers " +
                    "where homework_day1_mysql.offers.activation_token = '' and homework_day1_mysql.offers.price between '2000' and '4000'");
            resultSet = preparedStatement5.executeQuery();
            PrintUtil.print(resultSet, "id", "price");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
