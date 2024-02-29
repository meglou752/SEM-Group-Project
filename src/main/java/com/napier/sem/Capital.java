package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Capital {

    public String capital;
    public String name;
    public int population;

    public ResultSet getNRegionCapitalsDescending(Connection con, String region, int N) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name AS capital, country.name, city.population \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.region = '" + region + "' " +
                            "ORDER BY city.population DESC " +
                            "LIMIT " + N;


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    //display function which takes resultset as a parameter, allowing more flexibility later
    public void displayCapitals(ResultSet resultSet) {
        try {
            // Iterate through the ResultSet and print capital details
            while (resultSet.next()) {
                String capital = resultSet.getString("capital");
                String name = resultSet.getString("name");
                int population = resultSet.getInt("population");

                System.out.println("Capital: " + capital + " Country Name: " + name + " Population: " + population + "\n");
            }
        } catch (Exception e) {
            System.out.println("Failed to display capital details");
        } finally {
            // Close the ResultSet to free resources
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet");
            }
        }
    }
}