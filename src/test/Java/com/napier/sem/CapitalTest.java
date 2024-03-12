package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CapitalTest {
    static App a;
    static Capital c;

    @BeforeAll
    static void init() {
        a = new App();
        c = new Capital();
    }

}