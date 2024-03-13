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
    void getDistrictPopulation_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(null, "Constantine");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getDistrictPopulation_nullDistrictTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getDistrictPopulation_normalDataTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, "Constantine");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getWorldPopulation_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getWorldPopulation(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getWorldPopulation_normalConnectionTest()
    {
        try {
            ResultSet resultSet = p.getWorldPopulation(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getRegionPopulations_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getRegionPopulations(null, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getRegionPopulations_nullRegionTest()
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
    void getAllRegionPopulations_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getAllRegionPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getAllRegionPopulations_normalConnectionTest()
    {
        try {
            ResultSet resultSet = p.getAllRegionPopulations(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCountryPopulation_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(null, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCountryPopulation_nullCountryTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCountryPopulation_normalDataTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulation_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulation(null, "Edinburgh");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulation_nullCityTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulation_normalDataTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulationAll_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulationAll(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getCityPopulationAll_normalConnectionTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulationAll(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentCityPopulations_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getContinentCityPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentCityPopulations_normalConnectionTest()
    {
        try {
            ResultSet resultSet = p.getContinentCityPopulations(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentPopulations_nullConnectionTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(null, "Africa");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentPopulations_nullContinentTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getContinentPopulations_normalDataTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(null, "Africa");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void displayPopulations_nullResultSetTest()
    {
        try {
            p.displayPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}