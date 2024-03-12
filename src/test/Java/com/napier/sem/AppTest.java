package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppTest {
    static App a;
    static Country c;
    static City d;
    static Capital e;
    static Population f;

    @BeforeAll
    static void init() {
        a = new App();
        c = new Country();
        d = new City();
        e = new Capital();
        f = new Population();
        a.connect();
    }

    @Test
    void getContinentDescendingTest()
    {
        c.getContinentDescending(a.con, "Europe");
        c.getContinentDescending(a.con, null);
        c.getContinentDescending(a.con, "4");
        // Testing connection to the database
    void testDatabaseConnection() {
        assertNotNull(a.con);
    }

    @Test
    void getTopRegionDescendingTest()
    {
        c.getTopRegionDescending(a.con,"Southern and Central Asia", 5);
        c.getTopRegionDescending(a.con,null, 5);
        c.getTopRegionDescending(a.con,"Southern and Central Asia", -1);
        c.getTopRegionDescending(null, "Southern and Central Asia", 9);
    }

    void getNRegionCapitalsDescendingTest()
    {
        d.getTopRegionCityDescending(a.con, "Western Europe", 6);
    }


    @Test
        // Testing disconnection from the database
    void testDatabaseDisconnection() {
        a.disconnect();
        assertNull(a.con);
    }
}
