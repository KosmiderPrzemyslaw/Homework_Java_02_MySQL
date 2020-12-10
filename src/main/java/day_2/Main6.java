package day_2;

import DBConnection.DBConnection;
import day_1.PrintUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main6 {
    public static void main(String[] args) {
        while (true) {
            getAllCinemasFromDb();
            String choice = InputUtil.askUser("Your choice");

            switch (choice.toLowerCase()) {
                case "x": {
                    System.out.println("bye!");
                }
                return;

                case "e": {

                }
            }

        }

    }

    private static void getAllCinemasFromDb() {
        try {
            Connection connection = new DBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from products_ex.cinemas");
            ResultSet resultSet = preparedStatement.executeQuery();
            PrintUtil.print(resultSet, "cinema_id", "name", "address");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void askAndModifyRecord(Connection connection) throws SQLException {
        int id = InputUtil.askForValidNumber("Type id of the cinema to be modified: ");

        String name = InputUtil.askUser("Type new name");
        String addresses = InputUtil.askUser("Type new address: ");

        updateCinema(connection, id, name, addresses);
    }

    private static void updateCinema(Connection connection, int id, String name, String addresses) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE products_ex.cinemas SET name = ?, address = ? WHERE cinema_id = ?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, addresses);
        preparedStatement.setInt(3, id);

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 1) {
            System.out.println("Successfully edited cinema with ID: " + id);
        } else {
            System.out.println("Something went wrong - the cinema ID: " + id + "was not edited");
        }

    }
}
