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

    /**
     * Find specified number of Regions in a Country sorted by the highest Population
     * @param con the database connection
     * @param region the region to search for
     * @param N the limit of database entries to retrieve
     * @return ResultSet
     */
    public ResultSet getTopRegionDescending(Connection con, String region, int N) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital " +
                            "FROM country " +
                            "WHERE country.region = '" + region + "' " +
                            "ORDER BY country.population DESC " +
                            "LIMIT " + N;


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }


    /**
     * Retrieves the top 'N' countries, on the current
     * connection to the database, and organizes them by size descending.
     *
     * @param con the database connection
     * @param N the number of top countries to retrieve
     * @return a ResultSet containing the top 'N' countries
     */

    public ResultSet topNPopulatedCountries(Connection con, int N) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital\n" +
                            "FROM country\n" +
                            "ORDER BY country.population DESC\n" +
                            "LIMIT " + N + ";";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Retrieves all countries organised by size descending on the current connection to the database.
     * @param con the database connection
     * @return a resultSet containing all countries organised by size descending
     */
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

    /**
     * Find Countries in Continent Sorted by the highest population
     * @param con the database connection
     * @param continent_name the continent to search through
     * @return ResultSet
     */
    public ResultSet getContinentDescending(Connection con, String continent_name) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital " +
                            "FROM country " +
                            "WHERE country.continent = '" + continent_name + "' " + // Enclose in single quotes
                            "ORDER BY country.population DESC";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     *
     * @param con the connection to the database
     * @param continentName the continent of which the function searches through
     * @param N the number of top populated countries to display
     * @return the resultset containing the top N countries in the selected continent  */
    public ResultSet topNPopulatedCountriesContinent(Connection con, String continentName, int N)
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital " +
                            "FROM country " +
                            "WHERE country.continent = '" + continentName + "' " + // Enclose in single quotes
                            "ORDER BY country.population DESC " +
                            "LIMIT " + N + ";";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Displays the contents of ResultSet for country functions
     * @param resultSet containing country details from other method calls
     */
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

