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
    void testGetRegionPopulations_NormalData() {
        try {
            p.name = "Constantine";
            p.population = 100000;
            p.urbanPopulation = 30000;
            p.ruralPopulation = 70000;
            ResultSet resultSet = p.getDistrictPopulation("Constantine");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}