package day_1;

public class Main2 {

    static String createTableProducts = "CREATE TABLE IF NOT EXISTS products " +
            "(product_id INT UNSIGNED NOT NULL AUTO_INCREMENT," +
            "product_name VARCHAR(255)," +
            "description VARCHAR(255)," +
            "price DECIMAL(5,2), " +
            "PRIMARY KEY (product_id))" +
            "ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci";


    static String createTableOrders = "CREATE TABLE IF NOT EXISTS orders " +
            "(order_id INT unsigned NOT NULL AUTO_INCREMENT," +
            "description VARCHAR(255)," +
            "PRIMARY KEY (order_id))" +
            "ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci";


    static String createTableClients = "CREATE TABLE IF NOT EXISTS clients " +
            "(client_id INT unsigned NOT NULL AUTO_INCREMENT, " +
            "name VARCHAR(255)," +
            "surname VARCHAR (255)," +
            "PRIMARY KEY(client_id))" +
            "ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci";


    static String createTableCinemas = "CREATE TABLE IF NOT EXISTS cinemas " +
            "(cinema_id INT unsigned NOT NULL AUTO_INCREMENT," +
            "name VARCHAR(255)," +
            "address VARCHAR(255)," +
            "PRIMARY KEY(cinema_id))" +
            "ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci";


    static String createTableMovies = "CREATE TABLE IF NOT EXISTS movies " +
            "(movie_id INT unsigned NOT NULL AUTO_INCREMENT," +
            "title VARCHAR(255)," +
            "description VARCHAR(255)," +
            "rating DECIMAL(3,2)," +
            "PRIMARY KEY(movie_id))" +
            "ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci";


    static String createTableTickets = "CREATE TABLE IF NOT EXISTS tickets " +
            "(ticket_id INT unsigned NOT NULL AUTO_INCREMENT," +
            "quantity INT," +
            "price DECIMAL(3,2)," +
            "PRIMARY KEY(ticket_id))" +
            "ENGINE = InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci";


    static String createTablePayments = "CREATE TABLE IF NOT EXISTS payments " +
            "(payment_id INT unsigned NOT NULL AUTO_INCREMENT," +
            "type VARCHAR(255)," +
            "payment_date DATE," +
            "PRIMARY KEY(payment_id))" +
            "ENGINE = InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=101";
}
