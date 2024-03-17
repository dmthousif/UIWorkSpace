package com.thetestingacademy.thousifWorkSpace.Selenium;
import com.thetestingacademy.basetest.CustomTestListener;
import com.thetestingacademy.basetest.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomTestListener.class)
public class runfailedTestCases {


    @Test(enabled = true,retryAnalyzer = RetryAnalyzer.class)
        public void testRetry() {
            // Example test method that may fail
            System.out.println("Executing testRetry...");
            Assert.fail("Failing the test intentionally.");
        }


    @Test()
    public void testRetry2() {
        // Example test method that may fail
        System.out.println("Executing testRetry2...");
        Assert.fail("Failing the test intentionally2.");
    }
}
