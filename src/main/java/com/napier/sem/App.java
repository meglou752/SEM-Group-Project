package com.napier.sem;
import java.sql.*;

public class App {
    private Connection con = null;

    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        // Create new Country
        Population f = new Population();

        // Connect to database
        a.connect();
        // Get ResultSet of cities
        ResultSet resultSet = f.getDistrictPopulation(a.con,  "Constantine");

        // Display cities
        f.displayPopulation(resultSet);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println(("Connection closed"));
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

}