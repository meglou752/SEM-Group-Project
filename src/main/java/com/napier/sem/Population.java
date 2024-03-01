package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Population {

    public String name;
    public long population;
    public long urbanPopulation;
    public long ruralPopulation;

    public ResultSet getWorldPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "    'Earth' as name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    SUM(country.population - city.population) AS RuralPop \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code;";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    //display function which takes resultset as a parameter, allowing more flexibility later
    //display function which takes resultset as a parameter, allowing more flexibility later
    public void displayPopulation(ResultSet resultSet) {
        try {
            // Check if the ResultSet is null
            if (resultSet != null) {
                // Iterate through the ResultSet and print population details
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    long population = resultSet.getLong("population");
                    long urbanPopulation = resultSet.getLong("UrbanPop");
                    long ruralPopulation = resultSet.getLong("RuralPop");

                    System.out.println("Name: " + name + " total population: " + population + " Urban Population: " + urbanPopulation + " Rural Population: " + ruralPopulation + "\n");
                }
            } else {
                System.out.println("ResultSet is null");
            }
        } catch (SQLException e) {
            System.out.println("Failed to display population details: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the ResultSet to free resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
        }
    }
}