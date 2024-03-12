package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CityTest {
    static App a;
    static City c;

    @BeforeAll
    static void init() {
        a = new App();
        a.connect(); // Establish connection to the database
        c = new City();
    }

    @Test
        // Test topNPopulatedCitiesDistrict function
    void testTopNPopulatedCitiesDistrict() {
        try {
            ResultSet resultSet = c.topNPopulatedCitiesDistrict(a.con, "Noord-Brabant", 3);
            assertNotNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }

    // Add more tests for City class as needed
}
