package com.mahendhergannarapu.TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting06_TestNG_Parameter {

    @Parameters("browser")
    @Test
    void Example(String value)
    {
        System.out.println("Browser Name is " +value);
        //Open the browser and select the "some information"
        if(value.equalsIgnoreCase("chrome"))
        {
            System.out.println("Start my Testing");
        }

        if(value.equalsIgnoreCase("firefox"))
        {
            System.out.println("Start my Testing");
        }
    }
}
