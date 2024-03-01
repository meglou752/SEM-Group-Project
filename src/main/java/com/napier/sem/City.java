package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class City {

    public String name;
    public String countryCode;
    public String district;
    public int population;

    /**
     *
     * @param con the database connection
     * @param districtName the name of the district to gather cities from
     * @param N the number of highest populated cities to retrieve
     * @return the resultset containing the top 'N' populated cities in a district
     */
    public ResultSet topNPopulatedCitiesDistrict(Connection con, String districtName, int N)
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE city.district = " + "'" + districtName + "'\n" +
                            "ORDER BY city.population DESC\n" +
                            "LIMIT " + N + ";";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     *
     * @param con the database connection
     * @param N the number of highest populated cities to retrieve
     * @return the resultset containing the top 'N' cities
     */
    public ResultSet topNPopulatedCities(Connection con, int N)
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "ORDER BY city.population DESC\n" +
                            "LIMIT " + N + ";";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public ResultSet getTopRegionCityDescending(Connection con, String region, int N) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.region = '" + region + "' " +
                            "ORDER BY city.population DESC " +
                            "LIMIT " + N;


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     *
     * @param con the database connection
     * @param continentName the continent to get cities from
     * @return the resultset containing countries of said continent
     */
    public ResultSet getCitiesInContinentDesc(Connection con, String continentName)
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.continent = '" + continentName + "'\n" +
                            "ORDER BY city.population DESC;";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }
    public ResultSet getCountryCityDescending(Connection con, String countryName) {
    public ResultSet getTopRegionCityDescending(Connection con, String region, int N) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.region = '" + region + "' " +
                            "ORDER BY city.population DESC " +
                            "LIMIT " + N;


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //display function which takes resultset as a parameter, allowing more flexibility later
    public void displayCities(ResultSet resultSet) {
        try {
            // Iterate through the ResultSet and print country details
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String countryCode = resultSet.getString("countryCode");
                String district = resultSet.getString("district");
                int population = resultSet.getInt("population");

                System.out.println("Name: " + name + " Country Code: " + countryCode + " district: " + district +
                        " population: " + population + "\n");
            }
        } catch (Exception e) {
            System.out.println("Failed to display city details");
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