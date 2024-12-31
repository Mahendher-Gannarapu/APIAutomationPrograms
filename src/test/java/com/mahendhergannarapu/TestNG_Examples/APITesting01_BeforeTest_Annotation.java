package com.mahendhergannarapu.TestNG_Examples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting01_BeforeTest_Annotation {

    @BeforeTest
    public void getToken()
    {
        System.out.println("1");
    }

    @BeforeTest
    public void getBookingID()
    {
        System.out.println("2");
    }

    // While doing PUT request we need to run Token and BookingID for that
    // Here added annotations @BeforeTest and @AfterTest
    @Test
    public void test_PUT()
    {
        System.out.println("3");
    }
}
