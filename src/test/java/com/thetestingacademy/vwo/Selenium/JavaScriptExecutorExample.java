package com.thetestingacademy.vwo.Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorExample {
    public static void main(String[] args) {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Initialize WebDriver instance (assuming Chrome)
        WebDriver driver = new ChromeDriver();
        // Navigate to a webpage
        driver.get("https://example.com");
        // Initialize JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Example: Perform a click using JavaScriptExecutor
        WebElement elementToClick = driver.findElement(By.id("my_element_id"));
        js.executeScript("arguments[0].click();", elementToClick);
        // Example: Set value of an input field using JavaScriptExecutor
        WebElement inputField = driver.findElement(By.id("my_input_id"));
        String valueToSet = "Hello, world!";
        js.executeScript("arguments[0].value = arguments[1];", inputField, valueToSet);
        // Perform additional actions after using JavaScriptExecutor
        // ...
        // Scroll down the page by pixel
        js.executeScript("window.scrollBy(0, 500);");
        // Alternatively, scroll to a specific element
        WebElement element = driver.findElement(By.id("my_element_id"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        // Close the WebDriver session
        driver.quit();
    }
}


