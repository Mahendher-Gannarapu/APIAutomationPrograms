package com.mahendhergannarapu.TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting07_TestNG_AlwaysRun {
// Testcase always run not missing
    @Test
    public void test1()
    {
        System.out.println("1");
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true) //ignoring while execute
    public void test2()
    {
        System.out.println("2");
        Assert.assertTrue(true);
    }

    @Test
    public void test3()
    {
        System.out.println("3");
        Assert.assertTrue(true);
    }
}
