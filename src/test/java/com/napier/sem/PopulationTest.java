package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;


class PopulationTest
{
    static App a; //initialising app class
    static Population p; //initialising population class


    @BeforeAll
    public static void init() {
        //instantiating before test methods
        a = new App();
        p = new Population();
    }

    //Test method to check getDistrictPopulation with null connection
    @Test
    void getDistrictPopulation_NullConTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(null, "Constantine");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getDistrictPopulation with null district
    @Test
    void getDistrictPopulation_NullTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getDistrictPopulation with normal data
    @Test
    void getDistrictPopulation_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getDistrictPopulation(a.con, "Constantine");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getWorldPopulation with null connection
    @Test
    void getWorldPopulation_NullConTest()
    {
        try {
            ResultSet resultSet = p.getWorldPopulation(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getWorldPopulation with connection
    @Test
    void getWorldPopulation_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getWorldPopulation(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getRegionPopulations with null connection
    @Test
    void getRegionPopulations_NullConTest()
    {
        try {
            ResultSet resultSet = p.getRegionPopulations(null, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getRegionPopulations null region
    @Test
    void getRegionPopulations_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getRegionPopulations(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getRegionPopulations with normal data
    @Test
    void getRegionPopulations_normalDataTest()
    {
        try {
            ResultSet resultSet = p.getRegionPopulations(a.con, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getAllRegionPopulations with null connection
    @Test
    void getAllRegionPopulations_NullConTest()
    {
        try {
            ResultSet resultSet = p.getAllRegionPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getAllRegionPopulations with connection
    @Test
    void getAllRegionPopulations_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getAllRegionPopulations(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getCountryPopulation with null connection
    @Test
    void getCountryPopulation_NullConTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(null, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getCountryPopulations with null country
    @Test
    void getCountryPopulation_NullTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getCountryPopulation with normal data
    @Test
    void getCountryPopulation_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getCitPopulation with null connection
    @Test
    void getCityPopulation_NullConTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulation(null, "Edinburgh");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getCityPopulation with null city
    @Test
    void getCityPopulation_NullTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getCityPopulation with normal data
    @Test
    void getCityPopulation_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getCountryPopulation(a.con, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getCitPopulationAll with null connection
    @Test
    void getCityPopulationAll_NullConTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulationCountry(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getCitPopulationAll with connection
    @Test
    void getCityPopulationAll_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getCityPopulationCountry(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getContinentCityPopulations with null connection
    @Test
    void getContinentCityPopulations_NullConTest()
    {
        try {
            ResultSet resultSet = p.getContinentCityPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getContinentCityPopulations with connection
    @Test
    void getContinentCityPopulations_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getContinentCityPopulations(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getContinentPopulations with null connection
    @Test
    void getContinentPopulations_NullConTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(null, "Africa");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getContinentPopulations with null continent
    @Test
    void getContinentPopulations_NullTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check getContinentPopulations with normal data
    @Test
    void getContinentPopulations_NotNullTest()
    {
        try {
            ResultSet resultSet = p.getContinentPopulations(a.con, "Africa");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    //Test method to check displayPopulations with null resultset
    @Test
    void displayPopulations_NullTest()
    {
        try {
            p.displayPopulations(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getPopulationByLanguageDesc_NullTest()
    {
        try {
            ResultSet resultSet = p.getPopulationByLanguageDesc(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getPopulationByLanguageDesc_NullConTest()
    {
        try {
            ResultSet resultSet = p.getPopulationByLanguageDesc(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}