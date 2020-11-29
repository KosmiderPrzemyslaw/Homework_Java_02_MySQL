package day_1;

import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {
    public static void main(String[] args) {
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            String addFirstCinema = "INSERT INTO products_ex.cinemas(name, address) VALUES ('casyno', 'szpitalna')";
            String addSecondCinema = "INSERT INTO products_ex.cinemas(name, address) VALUES ('cinemacity', 'rybnicka')";
            String addThirdCinema = "INSERT INTO products_ex.cinemas(name, address) VALUES ('multikino', 'gliwice')";

            Statement statement = connection.createStatement();
            statement.executeUpdate(addFirstCinema);
            statement.executeUpdate(addSecondCinema);
            statement.executeUpdate(addThirdCinema);

            String addFirstClient = "INSERT INTO products_ex.clients(name, surname) VALUES ('Jan', 'Kowalik')";
            String addSecondClient = "INSERT INTO products_ex.clients(name, surname) VALUES ('Monika', 'Stasial')";
            String addThirdClient = "INSERT INTO products_ex.clients(name, surname) VALUES ('Krzyssztof', 'Krocz')";

            statement.executeUpdate(addFirstClient);
            statement.executeUpdate(addSecondClient);
            statement.executeUpdate(addThirdClient);

            String addFirstMovie = "INSERT INTO products_ex.movies(title, description, rating) VALUES ('title1', 'decs', 2.3433)";
            String addSecondMovie = "INSERT INTO products_ex.movies(title, description, rating) VALUES ('title2', 'decs', 4213.213)";
            String addThirdMovie = "INSERT INTO products_ex.movies(title, description, rating) VALUES ('title3', 'decs', 234.23)";

            statement.executeUpdate(addFirstMovie);
            statement.executeUpdate(addSecondMovie);
            statement.executeUpdate(addThirdMovie);

            String addFirstOrder = "INSERT INTO products_ex.orders(description) values ('opis1')";
            String addSecondOrder= "INSERT INTO products_ex.orders(description) values ('opis2')";
            String addThirdOrder = "INSERT INTO products_ex.orders(description) values ('opis3')";

            statement.executeUpdate(addFirstOrder);
            statement.executeUpdate(addSecondOrder);
            statement.executeUpdate(addThirdOrder);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
