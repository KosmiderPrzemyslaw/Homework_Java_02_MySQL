package day_1;

import DBConnection.DBConnection;

import java.sql.*;

public class Main7 {

    public static String selectAllTickets = "SELECT SUM(products_ex.tickets.quantity) as sumOfTickets FROM products_ex.tickets";
    public static String selectAllPayments = "SELECT products_ex.payments.type AS paymentsByType FROM products_ex.payments GROUP BY type";

    public static void main(String[] args) {
        getDataFromDatabase();
    }

    private static void getDataFromDatabase() {
        try {
            ResultSet resultSet1 = getConnection().createStatement().executeQuery(selectAllTickets);
            PrintUtil.print(resultSet1, "sumOfTickets");

            ResultSet resultSet = getConnection().createStatement().executeQuery(selectAllPayments);
            PrintUtil.print(resultSet, "paymentsByType");

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
