package com.thetestingacademy.vwo.Selenium;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class ActionAndAlertsExample extends CommonToAllTest {
    WebDriver driver;
    WebElement element;

    @Test
    public void actionTest() throws Exception {
        driver = getDriver();
        driver.get(PropertyReader.readKey("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        element = driver.findElement(By.xpath("//button[contains(text(),' Double click Here')]"));
        System.out.println(element.isDisplayed());
        actions.click().build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5));
        fluentWait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).doubleClick().build().perform();
        Alert alert = driver.switchTo().alert();
        System.out.println("AlertMessege::" + alert.getText());
        alert.accept();
        Thread.sleep(5000);
    }

}
