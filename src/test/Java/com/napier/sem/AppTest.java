package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppTest {
    static App a;

    @BeforeAll
    static void init() {
        a = new App();
        a.connect(); // Establish connection to the database
    }

    @Test
        // Testing connection to the database
    void testDatabaseConnection() {
        assertNotNull(a.con);
    }

    @Test
        // Testing disconnection from the database
    void testDatabaseDisconnection() {
        a.disconnect();
        assertNull(a.con);
    }
}
