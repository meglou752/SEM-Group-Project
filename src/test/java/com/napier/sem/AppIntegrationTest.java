package com.napier.sem;

import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static Connection con;
    @BeforeAll
    static void init()
    {
        con = establishConnection();
    }

    // Establishes a connection to the MySQL database
    static Connection establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:33060/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to establish database connection: " + e.getMessage());
            return null;
        }
    }
    @Test
    void test_topNPopulatedCitiesDistrict() {
        // Assuming 'Noord-Brabant' is a valid district in the database
        String districtName = "Noord-Brabant";
        int N = 1; // Number of top populated cities to retrieve

        City city = new City();
        ResultSet resultSet = city.topNPopulatedCitiesDistrict(con, districtName, N);
        city.displayCities(resultSet);
        assertNotNull(resultSet, "ResultSet should not be null");

        // Assuming resultSet contains only one row with the population as the first column
        try {
            if (resultSet.next()) {
                String cityName = resultSet.getString(1);
                assertEquals("Eindhoven", cityName, "City name should match expected value");
            } else {
                fail("ResultSet is empty");
            }
        } catch (SQLException e) {
            fail("Error while retrieving data from ResultSet: " + e.getMessage());
        }

        System.out.println("TOPNPOPULATEDCITIESDISTRICT TEST::: \n");
        // Assuming displayCities method prints the ResultSet content
    }

/*
    //topNPopulatedCitiesContinent
    @Test
    void test_topNPopulatedCitiesContinent() {
        // Assuming 'Noord-Brabant' is a valid district in the database
        String districtName = "Africa";
        int N = 5; // Number of top populated cities to retrieve

        City city = new City();
        ResultSet resultSet = city.topNPopulatedCitiesContinent(con, districtName, N);
        assertNotNull(resultSet, "ResultSet should not be null");

        System.out.println("TOPNPOPULATEDCITIESCONTINENT TEST::: \n");
        // Assuming displayCities method prints the ResultSet content
        city.displayCities(resultSet);
    }
*/
}
