package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        Country[] countries = a.getCountryDescending();

        a.displayCountries(countries);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
                System.out.println(("Connection closed"));
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public Country[] getCountryDescending() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital\n" +
                            "FROM country\n" +
                            "ORDER BY country.population DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Create a list to hold employees
            List<Country> countryList = new ArrayList<>();
            // Iterate through the result set and add employees to the list
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");
                countryList.add(country);
            }
            // Convert list to array
            return countryList.toArray(new Country[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountries(Country[] countries) {
        if (countries != null && countries.length > 0) {
            for (Country country : countries) {
                System.out.println(
                        "Country code: " + country.code + " Country name: " + country.name + " Continent: " + country.continent + " Region: " +
                                country.region + " Population: " + country.population + " Capital: " + country.capital + "\n");
            }
        }
    }
}
