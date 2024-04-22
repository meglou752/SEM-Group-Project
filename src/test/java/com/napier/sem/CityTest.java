package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CityTest
{
    static App a; //initialising app class
    static City d; //initialising country class

    @BeforeAll
    public static void init() {
        //instantiating before test methods
        a = new App();
        d = new City();
    }

    // Test to check getNPopulatedCitiesDistrict with normal data
    @Test
    public void topNPopulatedCitiesDistrict_NotNullTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCitiesDistrict(a.con, "Noord-Brabant", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getNPopulatedCitiesDistrict with negative N value
    @Test
    public void topNPopulatedCitiesDistrict_NegativeNTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCitiesDistrict(a.con, "Noord-Brabant", -5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check topNPopulatedCitiesDistrict with null district name
    @Test
    public void topNPopulatedCitiesDistrict_NullDistrictTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCitiesDistrict(a.con, null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check topNPopulatedCitiesDistrict with null connection
    @Test
    public void topNPopulatedCitiesDistrict_NullConTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCitiesDistrict(null, "Noord-Brabant", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }




    // Test to check topNPopulatedCitiesContinent with normal data
    @Test
    public void topNPopulatedCitiesContinent_NotNullTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCitiesContinent(a.con, "Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check topNPopulatedCitiesContinent with negative N value
    @Test
    public void topNPopulatedCitiesContinent_NegativeNTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCitiesContinent(a.con, "Europe", -1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check topNPopulatedCitiesContinent with region null
    @Test
    public void topNPopulatedCitiesContinent_NullRegionTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCitiesContinent(a.con, null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check topNPopulatedCitiesContinent with connection null
    @Test
    public void topNPopulatedCitiesContinent_NullConTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCitiesContinent(null, "Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }




    // Test to check topNPopulatedCities with normal data
    @Test
    public void topNPopulatedCities_NotNullTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCities(a.con, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check topNPopulatedCities with null connection
    @Test
    public void topNPopulatedCities_NullConTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCities(null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check topNPopulatedCities with negative N
    @Test
    public void topNPopulatedCities_NegativeNTest() {
        try {
            ResultSet resultSet = d.topNPopulatedCities(a.con, -5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }




    // Test to check getTopRegionCityDescending with normal data
    @Test
    public void getTopRegionCityDescending_NotNullTest() {
        try {
            ResultSet resultSet = d.getTopRegionCityDescending(a.con, "Western Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopRegionCityDescending with negative N value
    @Test
    public void getTopRegionCityDescending_NegativeNTest() {
        try {
            ResultSet resultSet = d.getTopRegionCityDescending(a.con, "Western Europe", -1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopRegionCityDescending with null region
    @Test
    public void getTopRegionCityDescending_NullRegionTest() {
        try {
            ResultSet resultSet = d.getTopRegionCityDescending(a.con, null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopRegionCityDescending with null connection
    @Test
    public void getTopRegionCityDescending_NullConTest() {
        try {
            ResultSet resultSet = d.getTopRegionCityDescending(null, "Western Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }




    // Test to check getCitiesInContinentDesc with normal data
    @Test
    public void getCitiesInContinentDesc_NotNullTest() {
        try {
            ResultSet resultSet = d.getCitiesInContinentDesc(a.con, "Asia");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getCitiesInContinentDesc with connection null
    @Test
    public void getCitiesInContinentDesc_NullConTest() {
        try {
            ResultSet resultSet = d.getCitiesInContinentDesc(null, "Asia");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getCitiesInContinentDesc with null continent
    @Test
    public void getCitiesInContinentDesc_NullRegionTest() {
        try {
            ResultSet resultSet = d.getCitiesInContinentDesc(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }





    // Test to check getCountryCityDescending with normal data
    @Test
    public void getCountryCityDescending_NotNullTest() {
        try {
            ResultSet resultSet = d.getCountryCityDescending(a.con, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getCountryCityDescending with null connection
    @Test
    public void getCountryCityDescending_NullConTest() {
        try {
            ResultSet resultSet = d.getCountryCityDescending(null, "France");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getCountryCityDescending with null countryName
    @Test
    public void getCountryCityDescending_NullContinentTest() {
        try {
            ResultSet resultSet = d.getCountryCityDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }





    // Test to check getRegionCityDescending with normal data
    @Test
    public void getRegionCityDescending_NotNullTest() {
        try {
            ResultSet resultSet = d.getRegionCityDescending(a.con, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getRegionCityDescending with null connection
    @Test
    public void getRegionCityDescending_NullConTest() {
        try {
            ResultSet resultSet = d.getRegionCityDescending(null, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getRegionCityDescending with null region
    @Test
    public void getRegionCityDescending_NullRegionTest() {
        try {
            ResultSet resultSet = d.getRegionCityDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }






    // Test to check getCityDescending with normal data
    @Test
    public void getCityDescending_NotNullTest() {
        try {
            ResultSet resultSet = d.getCityDescending(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getCityDescending with null connection
    @Test
    public void getCityDescending_NullConTest() {
        try {
            ResultSet resultSet = d.getCityDescending(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }




    // Test to check getDistrictCityDescending with normal data
    @Test
    public void getDistrictCityDescending_NotNullTest() {
        try {
            ResultSet resultSet = d.getDistrictCityDescending(a.con, "Buenos Aires");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getDistrictCityDescending with null connection
    @Test
    public void getDistrictCityDescending_NullConTest() {
        try {
            ResultSet resultSet = d.getDistrictCityDescending(null, "Buenos Aires");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getDistrictCityDescending with null district
    @Test
    public void getDistrictCityDescending_NullDistrictTest() {
        try {
            ResultSet resultSet = d.getDistrictCityDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }







    // Test to check getTopCountryCityDescending with normal data
    @Test
    public void getTopCountryCityDescending_NotNullTest() {
        try {
            ResultSet resultSet = d.getTopCountryCityDescending(a.con, "France", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopCountryCityDescending with negative N
    @Test
    public void getTopCountryCityDescending_NegativeNTest() {
        try {
            ResultSet resultSet = d.getTopCountryCityDescending(a.con, "France",-1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopCountryCityDescending with null countryName
    @Test
    public void getTopCountryCityDescending_NullCountryTest() {
        try {
            ResultSet resultSet = d.getTopCountryCityDescending(a.con, "null",5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // Test to check getTopCountryCityDescending with null connection
    @Test
    public void getTopCountryCityDescending_NullConTest() {
        try {
            ResultSet resultSet = d.getTopCountryCityDescending(null, "France",5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


    //Test to check displayCities on null ResultSet
    @Test
    public void displayCities_NullTest()
    {
        try {
            d.displayCities(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}