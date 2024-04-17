package com.napier.sem;

import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void test_topNPopulatedCapitals()
    {
        Capital capital = new Capital();
        ResultSet resultset = capital.topNPopulatedCapitals((app.connect("localhost:33060", 30000)), 5);
        capital.displayCapitals(resultset);
        assertNotNull(capital);

    }
}
