package day_1;

import DBConnection.DBConnection;

import java.sql.*;

public class Main7 {

    public static void main(String[] args) {
        try {
            Statement statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getDataFromDatabase(String statement) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(statement);
            ResultSet resultSet = preparedStatement.executeQuery();
            PrintUtil.print(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        DBConnection dbConnection = null;
        try {
            dbConnection = new DBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection.getConnection();
    }
}
