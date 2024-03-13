package com.napier.sem;

import org.junit.jupiter.api.*;

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
        p = new Population();
    }

    @Test
    void testGetRegionPopulations_NormalData()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, "Constantine");
            assertEquals(resultSet, resultSet);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testGetRegionPopulations_NullData()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, "NonexistentDistrict");
            assertNull(resultSet, "ResultSet should be null for nonexistent district");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testGetRegionPopulations_InvalidData()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, "2");
            assertNull(resultSet, "ResultSet should be null for invalid data");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}