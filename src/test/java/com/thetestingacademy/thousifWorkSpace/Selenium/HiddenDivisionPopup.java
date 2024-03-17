package com.thetestingacademy.thousifWorkSpace.Selenium;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class HiddenDivisionPopup extends CommonToAllPage {

    WebDriver driver;
    WebElement element;

    @Test
    public void test() throws Exception {
        driver = getDriver();
        driver.get("https://www.busonlineticket.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        element = driver.findElement(By.id("myDropdown"));




    }
}