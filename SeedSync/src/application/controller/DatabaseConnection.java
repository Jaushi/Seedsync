package application.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection databaseLink;

    public Connection getConnection() {
        String databaseName = System.getenv("MYSQL_DATABASE");
        String databaseUser = System.getenv("MYSQL_USER");
        String databasePassword = System.getenv("MYSQL_PASSWORD");
        String databaseHost = System.getenv("MYSQL_HOST");
        String url = "jdbc:mysql://" + databaseHost + ":3306/" + databaseName;

        try {
            // Register Database Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            System.out.println("Database connected successfully!");

            // Perform a simple query to verify the connection
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 1");
            if (resultSet.next()) {
                System.out.println("Test query executed successfully!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return databaseLink;
    }
}
