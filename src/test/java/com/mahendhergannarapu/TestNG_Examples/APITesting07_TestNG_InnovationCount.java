package com.mahendhergannarapu.TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting07_TestNG_InnovationCount {

    @Test(invocationCount = 4)
    public void test1()
    {
        System.out.println("1");
        Assert.assertTrue(true);
    }


}
