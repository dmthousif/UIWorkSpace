package com.thetestingacademy.vwo.Selenium;

import com.thetestingacademy.basetest.CommonToAllTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class UIAutomationWorkSpace extends CommonToAllTest {

    WebDriver driver;

    @Test
    public void test() throws IOException {
        driver = getDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("letsbdift");
        driver.findElement(By.id("pass")).sendKeys("pass");
        driver.findElement(By.name("login")).click();
        File snapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(snapshot, new File("PathTosaveSnapshot.jpg"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
