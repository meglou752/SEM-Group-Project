package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Capital {

    public String capital;
    public String name;
    public int population;


    /**
     *
     * @param con the connection to the database
     * @param N the number of top populated capital cities to display
     * @return the resultset containing the top N populated capital cities in the world
     */
    public ResultSet topNPopulatedCapitals(Connection con, int N)
    {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name AS capital, country.name, city.population \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.capital = city.ID " +
                            "ORDER BY city.population DESC " +
                            "LIMIT " + N + ";";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    /**
     * Search for specified number of Capitals in a Region sorted by the highest Population
     * @param con the database connection
     * @param region the region of which the function searches through
     * @param N the limit of records to return
     * @return ResultSet
     */
    public ResultSet getNRegionCapitalsDescending(Connection con, String region, int N) {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name AS capital, country.name, city.population \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.capital = city.ID " +
                            "ORDER BY city.population DESC " +
                            "LIMIT " + N + ";";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    /**
     *
     * @param con connection to the database
     * @param continent continent to get capital cities from
     * @return the resultset of the capital cities in said continent, organised by population size
     */
    public ResultSet getContinentCapitalsDescending(Connection con, String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name AS capital, country.name, city.population \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.continent = '" + continent + "' " +
                            "AND country.capital = city.ID " +
                            "ORDER BY city.population DESC ";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    /**
     *
     * @param con connection to the database
     * @param continent continent to get capital cities from
     * @param N the limit of records to return
     * @return the resultset of the N largest capital cities in said continent
     */

    public ResultSet topNPopulatedCapitalsByContinent(Connection con, String continent, Integer N) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT country.name AS name, city.name as capital, city.population\n" +
                    "FROM country\n" +
                    "INNER JOIN city ON city.countryCode = country.code\n" +
                    "WHERE country.continent = '" + continent + "'\n" +
                    "ORDER BY city.population\n" +
                    "DESC LIMIT " + N + ";";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    public ResultSet getCapitalsPopulationDesc(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT country.name AS name, city.name as capital, city.population\n" +
                    "FROM country\n" +
                    "INNER JOIN city ON city.countryCode = country.code\n" +
                    "WHERE country.capital = city.ID " +
                    "ORDER BY city.population DESC;";




            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }


    /**
     * Display the contents of ResultSet for capital functions
     * @param resultSet containing capital details from other method calls
     */
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