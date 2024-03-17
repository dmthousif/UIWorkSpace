package com.thetestingacademy.basetest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Hashtable;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxCount =4;

    public boolean retry(ITestResult result){
        while(retryCount<maxCount){
            retryCount++;
            return true;

        }
        return false;
    }
}
