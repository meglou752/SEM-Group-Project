package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppTest {
    static App a;

    @BeforeAll
    static void init() {
        a = new App();
    }

//    @Test
        // Testing connection to the database
    void testDatabaseConnection() {
        assertNotNull(a.con);
    }

    @Test
        // Testing disconnection from the database
    void testDatabaseDisconnection() {
        assertNull(a.con);
    }
}
