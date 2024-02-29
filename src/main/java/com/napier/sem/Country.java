package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Country {
    public String code;
    public String name;
    public String continent;
    public String region;
    public int population;
    public Integer capital;

    public ResultSet topNPopulatedCountries(Connection con, int N) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital\n" +
                            "FROM country\n" +
                            "ORDER BY country.population DESC" +
                            "LIMIT " + N + ";";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }
    public ResultSet getCountryDescending(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital\n" +
                            "FROM country\n" +
                            "ORDER BY country.population DESC;";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //display function which takes resultset as a parameter, allowing more flexibility later
    public void displayCountries(ResultSet resultSet) {
        try {
            // Iterate through the ResultSet and print country details
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String continent = resultSet.getString("continent");
                String region = resultSet.getString("region");
                int population = resultSet.getInt("population");
                int capital = resultSet.getInt("capital");

                System.out.println("Country code: " + code + " Country name: " + name + " Continent: " + continent +
                        " Region: " + region + " Population: " + population + " Capital: " + capital + "\n");
            }
        } catch (Exception e) {
            System.out.println("Failed to display country details");
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

