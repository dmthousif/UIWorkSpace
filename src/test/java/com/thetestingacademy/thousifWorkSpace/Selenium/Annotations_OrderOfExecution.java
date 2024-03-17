package com.thetestingacademy.thousifWorkSpace.Selenium;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class Annotations_OrderOfExecution {


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(priority = 1)
    public void testMethod1() {
        System.out.println("Test Method 1");

        Random random = new Random();

        //random.ints().limit(3).forEach(System.out::println);
        random.doubles().limit(3).forEach(System.out::println);

    }

    @Test(priority = 2)
    public void testMethod2() {
        System.out.println("Test Method 2");
        Assert.fail("Failing the test to see the test run for the testMethod3");
    }

    @Test(dependsOnMethods = "testMethod2")
    public void testMethod3() {
        System.out.println("Test Method 2");
    }
}
