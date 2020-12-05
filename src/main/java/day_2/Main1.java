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
            int movieIdToRemove = getMovieIdToRemove();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void printAllMovies(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(
                "SELECT products_ex.movies.movie_id, products_ex.movies.title FROM products_ex.movies");
        PrintUtil.print(resultSet, "movie_id", "title");

    }

    private static int getMovieIdToRemove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id filmu do usunięcia: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Podaj Id filmu do usunięcia! Wprowadź liczbę całkowitą!");
        }
        return scanner.nextInt();
    }

    private static void removeMovieById(int id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products_ex.movies WHERE movie_id=?");
        preparedStatement.setInt(1, );
    }
}
