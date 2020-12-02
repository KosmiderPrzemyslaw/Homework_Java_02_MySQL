package day_2;

import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id filmu do usunięcia: ");

        try {
            Connection connection = new DBConnection().getConnection();
            printAllMovies(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void printAllMovies(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(
                "SELECT products_ex.movies.movie_id, products_ex.movies.title FROM products_ex.movies");
        PrintUtil.print(resultSet, "movie_id", "title");

    }

}
