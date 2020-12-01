package day_1;

import DBConnection.DBConnection;

import java.sql.*;

public class Main7 {

    public static String selectAllTickets = "SELECT SUM(products_ex.tickets.quantity) as sumOfTickets FROM products_ex.tickets";
    public static String selectAllPayments = "SELECT products_ex.payments.type, COUNT(*) AS paymentsByType FROM products_ex.payments GROUP BY type";
    public static String selectAvgOneTicketPriceFromTickets = "SELECT AVG(products_ex.tickets.price) as avgPrice FROM products_ex.tickets";
    public static String selectLastFivePaymentsStartingFromSecond = "SELECT products_ex.payments.payment_date FROM products_ex.payments ORDER BY payment_date DESC, payment_id DESC LIMIT 1,5";
    public static String query = "SELECT products_ex.payments.type, COUNT(*) as countByType FROM products_ex.payments group by type having countByType > 2";
    public static String query1 = "SELECT sum(products_ex.tickets.quantity) as sumOfTickets FROM products_ex.tickets where price > 4";

    public static void main(String[] args) {
        getDataFromDatabase();
    }

    private static void getDataFromDatabase() {
        try {
            ResultSet resultSet1 = getConnection().createStatement().executeQuery(selectAllTickets);
            PrintUtil.print(resultSet1, "sumOfTickets");

            ResultSet resultSet = getConnection().createStatement().executeQuery(selectAllPayments);
            PrintUtil.print(resultSet, "paymentsByType");

            ResultSet resultSet2 = getConnection().createStatement().executeQuery(selectAvgOneTicketPriceFromTickets);
            PrintUtil.print(resultSet2, "avgPrice");

            ResultSet resultSet3 = getConnection().createStatement().executeQuery(selectLastFivePaymentsStartingFromSecond);
            PrintUtil.print(resultSet3, "payment_date");

            ResultSet resultSet4 = getConnection().createStatement().executeQuery(query);
            PrintUtil.print(resultSet4, "countByType");

            ResultSet resultSet5 = getConnection().createStatement().executeQuery(query1);
            PrintUtil.print(resultSet5, "sumOfTickets");

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
