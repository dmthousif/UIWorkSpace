package com.thetestingacademy.thousifWorkSpace.Selenium;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class WindowHandlesExample extends CommonToAllTest {
    WebDriver driver;
    @Test
    public void handleWindows() throws Exception {

        driver = getDriver();
        driver.get(PropertyReader.readKey("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[contains(text(),'SeleniumTutorial')]")).click();
        String ParentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String wind:windows){

            if(!wind.equals(ParentWindow)){
                driver.switchTo().window(wind).getTitle();
                System.out.println("Window Title::"+driver.switchTo().window(wind).getTitle());
                driver.close();
            }

        }
    }
}
