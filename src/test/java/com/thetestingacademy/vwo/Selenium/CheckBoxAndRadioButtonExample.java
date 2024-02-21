package com.thetestingacademy.vwo.Selenium;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class CheckBoxAndRadioButtonExample extends CommonToAllTest {
    WebDriver driver;

    @Test
    public void test() throws Exception {
        driver = getDriver();
        driver.get(PropertyReader.readKey("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //input[@type='checkbox']

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(WebElement checkbox:checkboxes){

            if(!checkbox.isSelected()){
                checkbox.click();
                System.out.println("CheckBox::"+checkbox.getText());
            }


        }

        Thread.sleep(10000);
        driver.quit();
    }
}
