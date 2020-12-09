package day_2;

import DBConnection.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        try {
            Connection connection = new DBConnection().getConnection();
            String selectPayment = "SELECT products_ex.payments.payment_date FROM products_ex.payments WHERE payment_date > '2020-12-08'";
            List<String> paymentsList = GetDataFromDbToArrayList.getDataFromDbToArrayList(connection, selectPayment);
            printList(paymentsList);

            List<String> ticketList = selectAllTicketsFromDb(connection);
            printList(ticketList);


            int ticketId = getInt("Podaj id biletu: ");
            int ticketQuantity = getInt("Podaj ilość sprzedanych biletów: ");
            boolean b = checkTicketIdInDb(ticketId, connection);
            BigDecimal ticketPrice = getTicketPrice("Podaj cenę biletu: ");


            putDataIntoDatabase(ticketId, ticketQuantity, ticketPrice, b, connection);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private static List<String> selectAllTicketsFromDb(Connection connection) throws SQLException {
        String selectAllTickets = "SELECT * FROM products_ex.tickets";
        return GetDataFromDbToArrayList.getDataFromDbToArrayList(connection, selectAllTickets);
    }

    private static void printList(List<String> strings) {
        for (String s : strings
        ) {
            System.out.print(s);
        }
    }

    private static int getInt(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        int number;
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("To nie jest liczba calkowita!");
            System.out.println(prompt);
        }
        number = scanner.nextInt();

        return number;
    }

    private static boolean checkTicketIdInDb(int id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT products_ex.tickets.ticket_id FROM products_ex.tickets");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            if (resultSet.getInt(1) == id) {
                return true;
            }
        }
        return false;
    }

    private static void putDataIntoDatabase(int ticketId, int quantity, BigDecimal ticketPrice, boolean isTicketInDb, Connection connection) throws SQLException {
        if (!isTicketInDb) {
            BigDecimal ticketsQuantity = new BigDecimal(quantity);
            ticketPrice = ticketsQuantity.multiply(ticketPrice);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products_ex.tickets(ticket_id, quantity, price) VALUES (?,?,?)");
            preparedStatement.setInt(1, ticketId);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setBigDecimal(3, ticketPrice);
            preparedStatement.executeUpdate();
            System.out.println("Poprawnie dodano dane do bazy");
        } else {
            System.out.println("Nie można dodać! Istnieje już bilet o danym Id!");
        }
    }

    private static BigDecimal getTicketPrice(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextBigDecimal()) {
            scanner.next();
            System.out.println("To nie jest poprawna wartość!");
            System.out.println(prompt);
        }
        return scanner.nextBigDecimal();
    }
}
