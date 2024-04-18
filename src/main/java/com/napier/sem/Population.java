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
            if (District == null)
            {
                System.out.println("District name is null.");
                return null;
            }
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
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
            System.out.println("Failed to get population details");
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
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
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
            System.out.println("Failed to get population details");
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
            if (Region == null)
            {
                System.out.println("District name is null.");
                return null;
            }
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "'" + Region + "' as name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.region = '" + Region + "'\n" +
                            "GROUP BY name";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Get population of all regions
     * @param con the database connection
     */
    public ResultSet getAllRegionPopulations(Connection con) {
        try {
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "country.region AS name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "GROUP BY name";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Get population of a country
     * @param con the database connection
     * @param Country the country to produce population report on
     */
    ResultSet getCountryPopulation(Connection con, String Country) {
        try {
            if (Country == null)
            {
                System.out.println("Country name is null.");
                return null;
            }
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "'" + Country + "' as name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.name = '" + Country + "'\n" +
                            "GROUP BY name";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Get population of a city
     * @param con the database connection
     * @param City the city to produce population report on
     */

    ResultSet getCityPopulation(Connection con, String City) {
        try {
            if (City == null)
            {
                System.out.println("District name is null.");
                return null;
            }
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "'" + City + "' as name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE city.name = '" + City + "'\n" +
                            "GROUP BY name";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Get population of all countries rural and urban
     * @param con the database connection
     */

    ResultSet getCityPopulationAll(Connection con) {
        try {
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            " country.name AS name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "GROUP BY name";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get population details");
            return null;
        }
    }



    /**
     * Get population of continents
     * @param con the database connection
     */
    public ResultSet getContinentCityPopulations(Connection con) {
        try {
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            " country.continent AS name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "GROUP BY name";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get population details");
            return null;
        }
    }



    /**
     * Get population of a Continent
     * @param con the database connection
     * @param continentName the continent to produce population report on
     */
    public ResultSet getContinentPopulations(Connection con, String continentName) {
        try {
            if (continentName == null)
            {
                System.out.println("Continent name is null.");
                return null;
            }
            if (con == null)
            {
                System.out.println("Connection is null.");
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "'" + continentName + "' as name, \n" +
                            "    SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.continent = '" + continentName + "'\n" +
                            "GROUP BY name";


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Get the population of certain languages, organized largest to smallest
     * @param con Connection to database
     * @return ResultSet containing query results
     */

    public ResultSet getPopulationByLanguageDesc(Connection con) {
        try {
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT \n" +
                            "   countrylanguage.Language AS Language, \n" +
                            "   SUM(country.population) AS population, \n" +
                            "    SUM(city.population) AS UrbanPop, \n" +
                            "    ROUND(SUM(city.population) / SUM(country.population) * 100, 1) AS UrbanPopPercentage, \n" +
                            "    SUM(country.population - city.population) AS RuralPop, \n" +
                            "    ROUND(SUM((country.population - city.population)) / SUM(country.population) * 100, 1) AS RuralPopPercentage \n" +
                            "FROM countrylanguage\n" +
                            "INNER JOIN city ON city.countryCode = country.Code\n" +
                            "INNER JOIN country ON country.Code = countrylanguage.countryCode\n" +
                            "WHERE countrylanguage.language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')\n" +
                            "GROUP BY countrylanguage.language\n" +
                            "ORDER BY population DESC;";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (SQLException e) {
            System.out.println("Failed to get population details: " + e.getMessage());
            return null;
        }
    }

    /**
     * Display the contents of ResultSet for the Population
     * @param resultSet containing population details from other method calls
     */
    public void displayPopulations(ResultSet resultSet) {
        try {
            if (resultSet == null)
            {
                System.out.println("ResultSet is null.");
            }
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