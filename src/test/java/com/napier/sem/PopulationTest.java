package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;


class PopulationTest
{
    static App a;
    static Population p;

    @BeforeAll
    public static void init() {
        a = new App();
        p = new Population();
    }
    @Test
    void getDistrictPopulation_NullConTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(null, "Constantine");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getDistrictPopulation_NullTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getDistrictPopulation_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, "Constantine");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getWorldPopulation_NullConTest()
    {
        try {
            ResultSet resultSet = p.getWorldPopulation(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getWorldPopulation_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getWorldPopulation(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getRegionPopulations_NullConTest()
    {
        try {
            ResultSet resultSet = p.getRegionPopulations(null, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getRegionPopulations_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getRegionPopulations(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getRegionPopulations_normalDataTest()
    {
        try {
            ResultSet resultSet = p.getRegionPopulations(a.con, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getAllRegionPopulations_NullConTest()
    {
        try {
            ResultSet resultSet = p.getAllRegionPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getAllRegionPopulations_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getAllRegionPopulations(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCountryPopulation_NullConTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(null, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCountryPopulation_NullTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCountryPopulation_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulation_NullConTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulation(null, "Edinburgh");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulation_NullTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulation_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulationAll_NullConTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulationAll(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulationAll_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulationAll(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentCityPopulations_NullConTest()
    {
        try {
            ResultSet resultSet = p.getContinentCityPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentCityPopulations_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getContinentCityPopulations(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentPopulations_NullConTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(null, "Africa");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentPopulations_NullTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentPopulations_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(a.con, "Africa");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void displayPopulations_NullTest()
    {
        try {
            p.displayPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}