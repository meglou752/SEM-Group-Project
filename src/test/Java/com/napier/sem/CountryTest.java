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
        a.connect(); // Establish connection to the database
        c = new Country();
    }

    @Test
        // Test getTopRegionDescending function
    void testGetTopRegionDescending() {
        try {
            ResultSet resultSet = c.getTopRegionDescending(a.con, "Southern and Central Asia", 5);
            assertNotNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }

    // Add more tests for Country class as needed
}
