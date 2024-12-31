package com.mahendhergannarapu.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test02_Soft_Assertions {

    //Soft Assertion :Even it is fails will continue to doing next
    @Test
    public void test_SoftAssertExample()
    {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start the Program");
        softAssert.assertTrue(false);
        System.out.println("This line will be executed");
        softAssert.assertAll();

        //Verify the Expected result = Actual Result
        Assert.assertEquals("Mahendher", "Mahendher");
        Assert.assertEquals("Srihansh", "Mahendher");
    }
}
