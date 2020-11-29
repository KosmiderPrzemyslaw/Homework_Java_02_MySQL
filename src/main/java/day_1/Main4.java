package day_1;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {

        int cinemaId = getCinemaId();


        Scanner cinemaName = new Scanner(System.in);
        System.out.println("Podaj nazwe kina: ");
        String name = cinemaName.next();

        Scanner cinemaAddress = new Scanner(System.in);
        System.out.println("Podaj adres kina: ");
        String address = cinemaAddress.next();
        try {
            addCinema(cinemaId, name, address);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static int getCinemaId() {
        Scanner cinemaId = new Scanner(System.in);
        System.out.println("Podaj id kina: ");
        while (!cinemaId.hasNextInt()) {
            System.out.println("Podaj liczbę całkowitą!");
            System.out.println("Podaj id kina");
            cinemaId.next();
        }
        int id = cinemaId.nextInt();
        try {
            System.out.println(checkIdInDb(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    static void addCinema(int id, String name, String address) throws SQLException {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO products_ex.cinemas(cinema_id, name, address) VALUES (?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, address);
        preparedStatement.executeUpdate();
    }

    static String checkIdInDb(int id) throws SQLException {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM products_ex.cinemas");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            //String cinemaId = resultSet.getString("cinema_id");
            int cinemaId = resultSet.getInt("cinema_id");
            if (cinemaId == id) {
                System.out.println("Istnieje już kino o podanym ID!");
            }
        }

        return null;
    }
}
