package com.mahendhergannarapu.TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting04_TestNG_Groups_Reg {

    @Test(groups = {"sanity", "qa", "preprod"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa","preprod", "reg"})
    public void RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"dev","stage"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"sanity", "qa", "preprod"})
    public void sanityRun1(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa","preprod", "reg"})
    public void RegRun2(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"dev","stage"})
    public void SmokeRun3(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}