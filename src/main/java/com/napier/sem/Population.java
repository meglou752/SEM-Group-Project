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

    /**
     * Get the Population of Specified District
     * @param con the database connection
     * @param District the District to search for
     * @return ResultSet
     */
    public ResultSet getDistrictPopulation(Connection con, String District) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "'" + District + "' as name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE city.District = '" + District + "'\n" +
                            "GROUP BY name";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    /**
     * Get Population of the World
     * @param con the database connection
     * @return ResultSet
     */
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
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code;";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    /**
     * Get population of a region
     * @param con the database connection
     * @param Region the region to produce population report on
     */
    public ResultSet getRegionPopulations(Connection con, String Region) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "'" + Region + "' AS name, \n" +
                            "SUM(country.Population) AS population, \n" +
                            "SUM(city.Population) AS UrbanPop, \n" +
                            "ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "SUM(country.population - city.population) AS RuralPop \n" +
                            "FROM country \n" +
                            "LEFT JOIN city ON country.Code = city.CountryCode \n" +
                            "WHERE country.region = '" + Region + "' " +
                            "GROUP BY name;";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get region populations");
            return null;
        }
    }


    /**
     * Display the contents of ResultSet for the Population
     * @param resultSet containing population details from other method calls
     */
    public void displayPopulations(ResultSet resultSet) {
        try {
            // Check if the ResultSet is null
            if (resultSet != null) {
                // Iterate through the ResultSet and print population details
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    long population = resultSet.getLong("population");
                    long urbanPopulation = resultSet.getLong("UrbanPop");
                    double urbanPopPercentage = resultSet.getDouble("UrbanPopPercentage");
                    long ruralPopulation = resultSet.getLong("RuralPop");
                    double ruralPopPercentage = resultSet.getDouble("RuralPopPercentage");

                    System.out.println("Name: " + name + " total population: " + population + " Urban Population: " + urbanPopulation + " Urban Percentage: " + urbanPopPercentage + "% Rural Population: " + ruralPopulation + " Rural Percentage: " + ruralPopPercentage + "%\n");
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