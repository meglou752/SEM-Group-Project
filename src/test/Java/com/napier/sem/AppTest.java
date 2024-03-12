package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
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
    }

    @Test
    void getContinentDescendingTest() {
        // Assuming App provides a method to get the connection
         // Replace this with the appropriate method in your App class
        c.getContinentDescending(a.con, "Europe");
    }
}