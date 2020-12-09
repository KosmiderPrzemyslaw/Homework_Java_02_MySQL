package day_2;

import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        Connection connection = connectToDb();


        ResultSet allMoviesFromDb = getAllMoviesFromDb(connection);

        try {
            PrintUtil.print(allMoviesFromDb, "movie_id", "title", "rating");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet getAllMoviesFromDb(Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT products_ex.movies.movie_id, products_ex.movies.title, products_ex.movies.rating FROM products_ex.movies");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    private static Connection connectToDb() {
        Connection connection = null;

        {
            try {
                connection = new DBConnection().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
