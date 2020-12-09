package day_2;

import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {


        try {
            Connection connection = new DBConnection().getConnection();
            printAllMovies(connection);
            int movieIdToRemove = getMovieId();
            removeMovieById(movieIdToRemove, connection);
            printAllMovies(connection);
            findMovieById(7, connection);

         //  PrintUtil.print(resultSet, "title", "description");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void printAllMovies(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(
                "SELECT products_ex.movies.movie_id, products_ex.movies.title FROM products_ex.movies");
        System.out.println("-------Lista wszystkich filmów-------");
        PrintUtil.print(resultSet, "movie_id", "title");

    }

    private static int getMovieId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id filmu");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Podaj Id filmu! Wprowadź liczbę całkowitą!");
        }
        return scanner.nextInt();
    }

    private static void removeMovieById(int id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products_ex.movies WHERE movie_id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Usunięto film  o id " + id);
    }

    private static void findMovieById(int id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT products_ex.movies.movie_id, products_ex.movies.title FROM products_ex.movies where products_ex.movies.movie_id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        PrintUtil.print(resultSet, "movie_id", "title");
    }
}
