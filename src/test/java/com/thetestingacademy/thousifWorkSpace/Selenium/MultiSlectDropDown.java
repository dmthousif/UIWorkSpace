package com.thetestingacademy.thousifWorkSpace.Selenium;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class MultiSlectDropDown extends CommonToAllTest {

    WebDriver driver;
    WebElement multiSelectDropdown;

    @Test
    public void test() throws Exception {
        driver = getDriver();
        driver.get("https://theautomationzone.blogspot.com/2020/07/basic-dropdown.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        multiSelectDropdown = driver.findElement(By.id("cars"));
        Select selec = new Select(multiSelectDropdown);
        if (selec.isMultiple()) {
            List<WebElement> options = selec.getOptions();
            for (WebElement option : options) {            //// Select all options
                System.out.println("option::" + option.getText());
                option.click();

            }
            Thread.sleep(4000);
            selec.deselectAll();
            Thread.sleep(4000);
            selec.selectByIndex(0);
            selec.selectByValue("opel");
            selec.deselectByVisibleText("Audi");
            Thread.sleep(4000);
        }
    }
}