package com.napier.sem;
import java.sql.*;

public class App {
    public static Connection con = null;
    /**
     * The entry point of the application.
     * <p>
     * This method initializes the application, connects to the database, retrieves
     * the top N populated countries, displays them, and then disconnects from the database.
     * </p>
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        // Create new Country

        Country c = new Country();
        City d = new City();
        Capital e = new Capital();
        Population f = new Population();

        // Connect to database
        a.connect();
        //ResultSet resultSet = c.getTopRegionDescending(a.con, "Southern and Central Asia", 5);
        // ResultSet resultSet = c.topNPopulatedCountries(a.con, 5);
        // ResultSet resultSet = c.getCountryDescending(a.con);
        // ResultSet resultSet = c.getContinentDescending(a.con, "Asia");
        //ResultSet resultSet = c.topNPopulatedCountriesContinent(a.con, "Asia", 4);
        //ResultSet resultSet = c.countryRegionDescending(a.con, "Southern and Central Asia");
        // ResultSet resultSet = c.topNPopulatedCountriesContinent(a.con, "Asia", 4);

        // ResultSet resultSet = d.topNPopulatedCitiesDistrict(a.con, "Noord-Brabant", 3);
        // ResultSet resultSet = d.topNPopulatedCities(a.con, 5);
        // ResultSet resultSet = d.getTopRegionCityDescending(a.con, "Western Europe", 6);
        // ResultSet resultSet = d.getCitiesInContinentDesc(a.con, "Asia");
        // ResultSet resultSet = d.getCountryCityDescending(a.con, "France");
        //ResultSet resultSet = d.topNPopulatedCitiesContinent(a.con, "Europe", 5);
       // ResultSet resultSet = d.getRegionCityDescending(a.con, "Western Europe");
        //ResultSet resultSet = d.getCityDescending(a.con);
        ResultSet resultSet = d.getDistrictCityDescending(a.con, "Buenos Aires");

        // ResultSet resultSet = e.topNPopulatedCapitals(a.con, 5);
        // ResultSet resultSet = e.getNRegionCapitalsDescending(a.con, "Western Europe", 6);
        //ResultSet resultSet = e.getContinentCapitalsDescending(a.con, "Asia");
        //ResultSet resultSet = e.topNPopulatedCapitalsByContinent(a.con, "Europe", 5);
         // ResultSet resultSet = e.getCapitalsPopulationDesc(a.con);


        //ResultSet resultSet = f.getWorldPopulation(a.con);
        // ResultSet resultSet = f.getDistrictPopulation(a.con,  "Constantine");
        //ResultSet resultSet = f.getRegionPopulations(a.con, "Western Europe");
       // ResultSet resultSet = f.getCountryPopulation(a.con, "Germany");
        //ResultSet resultSet = f.getCityPopulation(a.con, "Edinburgh");
        //ResultSet resultSet = f.getCityPopulationAll(a.con);


        //c.displayCountries(resultSet);
       d.displayCities(resultSet);
        //e.displayCapitals(resultSet);
        //f.displayPopulations(resultSet);



        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println(("Connection closed"));
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Get the connection to the MySQL database.
     * @return The connection object.
     */

}