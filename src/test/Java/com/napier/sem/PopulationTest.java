package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PopulationTest {
    static App a;
    static Population p;

    @BeforeAll
    static void init() {
        a = new App();
        p = new Population();
    }

    @Test
        //Testing 'getRegionPopulations' function on a valid input
    void testGetRegionPopulations_ValidInput()
    {
        assertNotNull(p.getRegionPopulations(a.con, "Southern Europe"));
    }

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