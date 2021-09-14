package com.marialazarnk.docs;

import org.junit.jupiter.api.*;

public class Junit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests!\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Afterrrrrr all tests!\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before test!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After test.\n");
    }


    @Test
    void firstTest() {
        System.out.println("I love you qa.guru!");
    }

    @Test
    void secondTest() {
        System.out.println("I don't love u, qa.guru!");
    }

}

