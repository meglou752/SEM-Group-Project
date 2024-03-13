package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)


class CapitalTest
{
    static App a;
    static Capital e;

    @BeforeAll
    public static void init() {
        a = new App();
        e = new Capital();
    }

    @Test
    public void topNPopulatedCapitals_NotNullTest() {
        try {
            ResultSet resultSet = e.topNPopulatedCapitals(a.con, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void topNPopulatedCapitals_NegativeNTest() {
        try {
            ResultSet resultSet = e.topNPopulatedCapitals(a.con, -5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void topNPopulatedCapitals_NullConTest() {
        try {
            ResultSet resultSet = e.topNPopulatedCapitals(null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }



    @Test
    public void getNRegionCapitals_NotNullTest() {
        try {
            ResultSet resultSet = e.getNRegionCapitalsDescending(a.con, "Western Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void getNRegionCapitals_NegativeNTest() {
        try {
            ResultSet resultSet = e.getNRegionCapitalsDescending(a.con, "Western Europe", -1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void getNRegionCapitals_NullRegionTest() {
        try {
            ResultSet resultSet = e.getNRegionCapitalsDescending(a.con, null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void getNRegionCapitals_NullConTest() {
        try {
            ResultSet resultSet = e.getNRegionCapitalsDescending(null, "Western Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }



    @Test
    public void getContinentCapitalsDescending_NotNullTest() {
        try {
            ResultSet resultSet = e.getContinentCapitalsDescending(a.con, "Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getContinentCapitalsDescending_NullConTest() {
        try {
            ResultSet resultSet = e.getContinentCapitalsDescending(null, "Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getContinentCapitalsDescending_NullContinentTest() {
        try {
            ResultSet resultSet = e.getContinentCapitalsDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }



    @Test
    public void topNPopulatedCapitalsByContinent_NotNullTest() {
        try {
            ResultSet resultSet = e.topNPopulatedCapitalsByContinent(a.con, "Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void topNPopulatedCapitalsByContinent_NegativeNTest() {
        try {
            ResultSet resultSet = e.topNPopulatedCapitalsByContinent(a.con, "Europe", -1);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void topNPopulatedCapitalsByContinent_NullRegionTest() {
        try {
            ResultSet resultSet = e.topNPopulatedCapitalsByContinent(a.con, null, 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void topNPopulatedCapitalsByContinent_NullConTest() {
        try {
            ResultSet resultSet = e.topNPopulatedCapitalsByContinent(null, "Europe", 5);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }



    @Test
    public void getCapitalsPopulationDesc_NotNullTest() {
        try {
            ResultSet resultSet = e.getCapitalsPopulationDesc(a.con);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getCapitalsPopulationDesc_NullConTest() {
        try {
            ResultSet resultSet = e.getCapitalsPopulationDesc(null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }



    @Test
    public void getRegionCapitalsDescending_NotNullTest() {
        try {
            ResultSet resultSet = e.getRegionCapitalsDescending(a.con, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getRegionCapitalsDescending_NullConTest() {
        try {
            ResultSet resultSet = e.getRegionCapitalsDescending(null, "Western Europe");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    @Test
    public void getRegionCapitalsDescending_NullContinentTest() {
        try {
            ResultSet resultSet = e.getRegionCapitalsDescending(a.con, null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


//    @Test
//    public void DisplayCaps_NullTest()
//    {
//        try {
//            e.displayCapitals(null);
//        } catch (Exception e) {
//            fail("Exception thrown: " + e.getMessage());
//        }
//    }

}