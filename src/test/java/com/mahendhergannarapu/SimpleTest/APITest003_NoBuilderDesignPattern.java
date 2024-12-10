package com.mahendhergannarapu.SimpleTest;

public class APITest003_NoBuilderDesignPattern {
    public void step1()
    {
        System.out.println("Step 1");
    }

    public void step2()
    {
        System.out.println("Step 2");
    }

    public void step3(String param)
    {
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        APITest003_NoBuilderDesignPattern ndp = new APITest003_NoBuilderDesignPattern();
        ndp.step1();
        ndp.step2();
        ndp.step3("Mahendher");
    }
}
