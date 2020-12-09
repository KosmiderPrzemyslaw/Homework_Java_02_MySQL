package day_2;

import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Connection connection = connectToDb();
        String query = "SELECT * FROM products_ex.tickets";

        try {
            List<String> allTickets = getDataFromDbToArrayList(connection, query);
            for (String ticket : allTickets
            ) {
                System.out.print(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet allMoviesFromDb = getAllMoviesFromDb(connection);
        try {
            List<String> movieListFormDb = getAllMoviesFromDbPutToArrayList(connection);
            for (String movie : movieListFormDb
            ) {
                System.out.print(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    private static List<String> getAllMoviesFromDbPutToArrayList(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products_ex.movies");
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        List<String> movieList = new ArrayList<>(columnCount);

        while (resultSet.next()) {
            int i = 1;
            while (i <= columnCount) {
                movieList.add(resultSet.getString(i++) + ", ");
            }
            movieList.add("\n");
        }
        return movieList;
    }

    private static List<String> getDataFromDbToArrayList(Connection connection, String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int countColumn = resultSetMetaData.getColumnCount();
        List<String> stringList = new ArrayList<>(countColumn);

        while (resultSet.next()) {
            int i = 1;
            while (i <= countColumn) {
                stringList.add(resultSet.getMetaData().getColumnName(i) + ": " + resultSet.getString(i++) + " ");
            }

            stringList.add("\n");
        }
        return stringList;
    }

}


