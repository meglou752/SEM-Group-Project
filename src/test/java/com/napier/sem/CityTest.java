package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CityTest {
    static App a;
    static City c;

    @BeforeAll
    static void init() {
        a = new App();
        c = new City();
    }
}
