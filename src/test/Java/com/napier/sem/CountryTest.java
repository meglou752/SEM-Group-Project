package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CountryTest {
    static App a;
    static Country c;

    @BeforeAll
    public static void init() {
        a = new App();
        c = new Country();
    }

    @Test
        // Test getTopRegionDescending function
    public void getTopRegionDescending_NotNullTest() {
        try {
            c.code = "EU1";
            c.name = "Estonia";
            c.continent = "continent";
            c.region = "Eastern Europe";
            c.population = 1000;
            c.capital = 1;
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Eastern Europe", 1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
   @Test
    public void getTopRegionDescending_NullTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Southern and Central Asia", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getTopRegionDescending_NegativeNTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Southern and Central Asia", -1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getTopRegionDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(null, "Southern and Central Asia", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getTopNPopulatedCountries_NotNullTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(a.con, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getTopNPopulatedCountries_NegativeNTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(a.con, -5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getTopNPopulatedCountries_NullConTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getCountryDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.getCountryDescending(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getCountryDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getCountryDescending(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getContinentDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(a.con, "Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getContinentDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(null, "Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getContinentDescending_NullContinentTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void topNPopulatedCountriesContinent_NotNullTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountriesContinent(a.con, "Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void topNPopulatedCountriesContinent_NullContinentTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountriesContinent(a.con, null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void topNPopulatedCountriesContinent_NullConTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountriesContinent(null, "Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void countryRegionDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.countryRegionDescending(a.con, "Southern and Central Asia");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void countryRegionDescending_NullRegionTest() {
        try {
            ResultSet resultSet = c.countryRegionDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void countryRegionDescending_NullConTest() {
        try {
            ResultSet resultSet = c.countryRegionDescending(null, "Southern and Central Asia");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void DisplayCountries_NullTest()
    {
        try {
            c.displayCountries(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    // Add more tests for Country class as needed
}
