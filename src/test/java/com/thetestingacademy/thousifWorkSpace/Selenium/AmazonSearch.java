package com.thetestingacademy.thousifWorkSpace.Selenium;

import com.thetestingacademy.basetest.CommonToAllTest;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class AmazonSearch extends CommonToAllTest {

    WebDriver driver;
    WebElement element;

    @Test
    public void automateSearch() throws Exception {

        driver = getDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions actions = new Actions(driver);
        //searchBox.sendKeys("mobile");
        actions.sendKeys(searchBox,"mobile").build().perform();
        Thread.sleep(5000);
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/descendant::div[@class='s-suggestion s-suggestion-ellipsis-direction']"));

        for (WebElement result : searchResults) {
            System.out.println("SearchResult::" + result.getText());
            if (result.getText().equalsIgnoreCase("mobile under 7000"))
                try {
                    // Your code to interact with the element
                    result.click();
                } catch (StaleElementReferenceException e) {
                    // Element is stale, handle the exception here
                    System.out.println("Stale element exception occurred. Retrying...");
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                    wait.until(ExpectedConditions.stalenessOf(result));
                    result.click();
                    // You can retry finding the element or perform any other action
                }


        }
        Thread.sleep(10000);
    }
}
