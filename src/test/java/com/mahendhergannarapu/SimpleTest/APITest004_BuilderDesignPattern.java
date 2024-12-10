package com.mahendhergannarapu.SimpleTest;

public class APITest004_BuilderDesignPattern {
    //Change Returntype of each method as Class name
    //"this" always points to current/calling object. Returning the same
    // to have same reference

    public APITest004_BuilderDesignPattern step1()
    {
        System.out.println("Step1 started");
        System.out.println("Step1 done");
        return this;
    }

    public APITest004_BuilderDesignPattern step2()
    {
        System.out.println("Step2 started");
        System.out.println("Step2 done");
        return this;
    }

    public APITest004_BuilderDesignPattern step3(String name)
    {
        System.out.println("Step3 started");
        System.out.println("Step3 done-> " +name);
        return this;
    }

    public static void main(String[] args) {
        APITest004_BuilderDesignPattern np =new APITest004_BuilderDesignPattern();
        np.step1().step2().step3("Mahendher");
    }
}
