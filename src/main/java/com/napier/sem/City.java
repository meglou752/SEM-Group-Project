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
            if (districtName == null) {
                System.out.println("District name is null.");
                return null;
            }
            if (N < 0)
            {
                System.out.println("N Cannot be negative");
                N = 1;
            }
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
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
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     *
     * @param con the database connection
     * @param continentName the name of the continent to gather cities from
     * @param N the number of highest populated cities to retrieve
     * @return the resultset containing the top 'N' populated cities in a continent
     */
    public ResultSet topNPopulatedCitiesContinent(Connection con, String continentName, int N)
    {
        try {
            if (continentName == null) {
                System.out.println("Continent name is null.");
                return null;
            }
            if (N < 0)
            {
                System.out.println("N Cannot be negative");
                N = 1;
            }
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.continent = " + "'" + continentName + "'\n" +
                            "ORDER BY city.population DESC\n" +
                            "LIMIT " + N + ";";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get city details");
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
            if (N < 0)
            {
                System.out.println("N Cannot be negative");
                N = 1;
            }
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
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
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Find a specified number of Regions with the highest Population
     * @param con the database connection
     * @param region the region to search through
     * @param N the number of database entries to retrieve
     * @return ResultSet
     */
    public ResultSet getTopRegionCityDescending(Connection con, String region, int N) {
        try {
            if (region == null) {
                System.out.println("region name is null.");
                return null;
            }
            if (N < 0)
            {
                System.out.println("N Cannot be negative");
                N = 1;
            }
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
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
            System.out.println("Failed to get city details");
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
            if (continentName == null) {
                System.out.println("Continent name is null.");
                return null;
            }
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
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
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Search for Cities in a Country
     * @param con the database connection
     * @param countryName the country too search through
     * @return ResultSet
     */
    public ResultSet getCountryCityDescending(Connection con, String countryName) {
        try {
            if (countryName == null) {
                System.out.println("region name is null.");
                return null;
            }
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.name = '" + countryName + "'\n" +
                            "ORDER BY city.population DESC;";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Search for Cities in a Region
     * @param con the database connection
     * @param region the country too search through
     * @return ResultSet
     */
    public ResultSet getRegionCityDescending(Connection con, String region) {
        try {
            if (region == null) {
                System.out.println("region name is null.");
                return null;
            }
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.region = '" + region + "' " +
                            "ORDER BY city.population DESC;";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Search for Cities in a world
     * @param con the database connection
     * @return ResultSet
     */

    public ResultSet getCityDescending(Connection con) {
        try {
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "ORDER BY city.population DESC;";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     * Search for Cities in a district
     * @param con the database connection
     * @return ResultSet
     */
    public ResultSet getDistrictCityDescending(Connection con, String district) {
        try {
            if (district == null) {
                System.out.println("District name is null.");
                return null;
            }
            if (con == null) {
                System.out.println("Connection is null.");
                return null;
            }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE city.district = '" + district + "'\n" +
                            "ORDER BY city.population DESC;";

            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get city details");
            return null;
        }
    }



    /**
     * Find a specified number of cities within a country with the highest Population
     * @param con the database connection
     * @param countryName the country to search through
     * @param N the number of database entries to retrieve
     * @return ResultSet
     */

    public ResultSet getTopCountryCityDescending(Connection con, String countryName, int N) {
      try {
          if (countryName == null) {
              System.out.println("region name is null.");
              return null;
          }
          if (N < 0)
          {
              System.out.println("N Cannot be negative");
              N = 1;
          }
          if (con == null) {
              System.out.println("Connection is null.");
              return null;
          }
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.countryCode, city.district, city.population\n" +
                            "FROM country\n" +
                            "INNER JOIN city ON city.countryCode = country.code\n" +
                            "WHERE country.name = '" + countryName + "' " +
                            "ORDER BY city.population DESC " +
                            "LIMIT " + N;


            // Execute SQL statement and return ResultSet
            return stmt.executeQuery(strSelect);
        } catch (Exception e) {
            System.out.println("Failed to get city details");
            return null;
        }
    }



    /**
     * Displays the contents of ResultSet for city functions
     * @param resultSet containing city details from other method calls
     */
    public void displayCities(ResultSet resultSet) {
        try {
            if (resultSet == null) {
                System.out.println("ResultSet is null.");
                return;
            }
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