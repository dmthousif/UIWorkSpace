package com.thetestingacademy.thousifWorkSpace.Selenium;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class framesandiframesExample extends CommonToAllTest {
    WebDriver driver;
    WebElement element;

    @Test
    public void test() throws Exception {
        driver = getDriver();
        driver.get(PropertyReader.readKey("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Alternatively, scroll to a specific element
        element = driver.findElement(By.xpath("//iframe[@id='iframe2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        driver.switchTo().frame(2);  //By Index
        Thread.sleep(4000);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe1"); // By Name
        Thread.sleep(4000);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(element); // By WebElement
        Thread.sleep(4000);
    }
}
