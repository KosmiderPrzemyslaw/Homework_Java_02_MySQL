package day_1;

public class Main2 {

    static String createTableProducts = "CREATE TABLE IF NOT EXISTS products " +
            "(product_id INT AUTO_INCREMENT," +
            "product_name VARCHAR(255)," +
            "description VARCHAR(255)," +
            "price DECIMAL(5,2), " +
            "PRIMARY KEY (product_id))";

    static String createTableOrders = "CREATE TABLE IF NOT EXISTS orders " +
            "(order_id INT AUTO_INCREMENT," +
            "description VARCHAR(255)," +
            "PRIMARY KEY (order_id))";

    static String createTableClients = "CREATE TABLE IF NOT EXISTS clients " +
            "(client_id INT AUTO_INCREMENT, " +
            "name VARCHAR(255)," +
            "surname VARCHAR (255)," +
            "PRIMARY KEY(client_id))";

    static String createTableCinemas = "CREATE TABLE IF NOT EXISTS cinemas " +
            "(cinema_id INT AUTO_INCREMENT," +
            "name VARCHAR(255)," +
            "address VARCHAR(255)," +
            "PRIMARY KEY(cinema_id))";

    static String createTableMovies = "CREATE TABLE IF NOT EXISTS movies " +
            "(movie_id INT AUTO_INCREMENT," +
            "title VARCHAR(255)," +
            "description VARCHAR(255)," +
            "rating DECIMAL(2,1)," +
            "PRIMARY KEY(movie_id))";
}
