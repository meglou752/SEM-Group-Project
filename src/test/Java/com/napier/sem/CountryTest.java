package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CountryTest {
    static App a;
    static Country c;

    @BeforeAll
    static void init() {
        a = new App();
        c = new Country();
    }

    @Test
        // Test getTopRegionDescending function
    void getTopRegionDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Southern and Central Asia", 5);
            assertNotNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
   @Test
    void getTopRegionDescending_NullTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Southern and Central Asia", 5);
            assertNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getTopRegionDescending_NegativeNTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Southern and Central Asia", -1);
            assertNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getTopRegionDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(null, "Southern and Central Asia", 5);
            assertNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getTopNPopulatedCountries_NotNullTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(a.con, 5);
            assertNotNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getTopNPopulatedCountries_NegativeNTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(a.con, -5);
            assertNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getTopNPopulatedCountries_NullConTest() {
        try {
            ResultSet resultSet = c.topNPopulatedCountries(null, 5);
            assertNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getCountryDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.getCountryDescending(a.con);
            assertNotNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getCountryDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getCountryDescending(null);
            assertNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getContinentDescending_NotNullTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(a.con, "Europe");
            assertNotNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getContinentDescending_NullConTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(null, "Europe");
            assertNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void getContinentDescending_NullContinentTest() {
        try {
            ResultSet resultSet = c.getContinentDescending(a.con, null);
            assertNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    @Test
    void DisplayCountries_NullTest()
    {
        try {
            c.displayCountries(null);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }
    // Add more tests for Country class as needed
}
