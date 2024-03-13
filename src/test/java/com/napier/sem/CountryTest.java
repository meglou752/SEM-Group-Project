package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CountryTest {
    static App a; //initialising app class
    static Country c; //initialising country class

    @BeforeAll
    public static void init() {
        //instantiating before test methods
        a = new App();
        c = new Country();
    }

    @Test
    // Test to check getTopRegionDescending with normal data
    public void getTopRegionDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Eastern Europe", 1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopRegionDescending with null region
    @Test
    public void getTopRegionDescending_NullTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopRegionDescending with negative n
    @Test
    public void getTopRegionDescending_NegativeNTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Southern and Central Asia", -1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopRegionDescending with null connection
    @Test
    public void getTopRegionDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(null, "Southern and Central Asia", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check getTopNPopulatedCountries on normal data
    @Test
    public void getTopNPopulatedCountries_NotNullTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(a.con, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check getTopNPopulatedCountries on negative n
    @Test
    public void getTopNPopulatedCountries_NegativeNTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(a.con, -5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check getTopNPopulatedCountries on null connection
    @Test
    public void getTopNPopulatedCountries_NullConTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check getCountryDescending on connection
    @Test
    public void getCountryDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.getCountryDescending(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check getCountryDescending on null connection
    @Test
    public void getCountryDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getCountryDescending(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check GetContinentDescending on normal data
    @Test
    public void getContinentDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(a.con, "Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check GetContinentDescending on null con
    @Test
    public void getContinentDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(null, "Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check GetContinentDescending on null continent
    @Test
    public void getContinentDescending_NullContinentTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check topNPopulatedCountriesContinent on normal data
    @Test
    public void topNPopulatedCountriesContinent_NotNullTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountriesContinent(a.con, "Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check topNPopulatedCountriesContinent on null continent
    @Test
    public void topNPopulatedCountriesContinent_NullContinentTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountriesContinent(a.con, null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check topNPopulatedCountriesContinent on null connection
    @Test
    public void topNPopulatedCountriesContinent_NullConTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountriesContinent(null, "Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check countryRegionDescending on normal data
    @Test
    public void countryRegionDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.countryRegionDescending(a.con, "Southern and Central Asia");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check countryRegionDescending on null region
    @Test
    public void countryRegionDescending_NullRegionTest() {
        try {
            ResultSet resultSet = c.countryRegionDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check countryRegionDescending on null connection
    @Test
    public void countryRegionDescending_NullConTest() {
        try {
            ResultSet resultSet = c.countryRegionDescending(null, "Southern and Central Asia");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test to check DisplayCountries on null ResultSet
    @Test
    public void DisplayCountries_NullTest()
    {
        try {
            c.displayCountries(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}