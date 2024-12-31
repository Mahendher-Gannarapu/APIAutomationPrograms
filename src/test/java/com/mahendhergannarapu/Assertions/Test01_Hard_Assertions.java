package com.mahendhergannarapu.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01_Hard_Assertions {

    @Test
    public void test_HardAssertExample()
    {
        System.out.println("Start the Program");
        Assert.assertTrue(false);
        //When it is false the Assertion should not be executed when fails testcase
        System.out.println("End the Program");

        //Verify the Expected result = Actual Result
        Assert.assertEquals("Mahendher", "Mahendher");
        Assert.assertEquals("Srihansh", "Mahendher");
    }
}
