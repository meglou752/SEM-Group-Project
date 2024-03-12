package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CapitalTest {
    static App a;
    static Capital c;

    @BeforeAll
    static void init() {
        a = new App();
        c = new Capital();
        c.capital = "";
        c.name = "";
        c.population = 0;
    }

}
