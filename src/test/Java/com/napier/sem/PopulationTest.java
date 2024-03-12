package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PopulationTest {
    static App a;
    static Population p;

    @BeforeAll
    static void init() {
        a = new App();
        a.connect(); // Establish connection to the database
        p = new Population();
    }

    @Test
        // Testing getRegionPopulations function on a valid input
    void testGetRegionPopulations_ValidInput() {
        try {
            ResultSet resultSet = p.getRegionPopulations(a.con, "Western Europe");
            assertNotNull(resultSet);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }

    // Add more tests for Population class as needed
    @Test
        //Testing 'getRegionPopulations' function on an invalid region
    void testGetRegionPopulations_InvalidInput()
    {
        assertNull(p.getRegionPopulations(a.con, "test"));
    }

    @Test
        //Testing 'getRegionPopulations function on a null region
    void testGetRegionPopulations_NullRegion()
    {
        assertNull(p.getRegionPopulations(a.con, null));
    }

    @Test
        //Testing 'GetRegionPopulations' function on a null database connection
    void testGetRegionPopulations_NullConnection()
    {
        assertNull(p.getRegionPopulations(null, "Southern Europe"));
    }

}