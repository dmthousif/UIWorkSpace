package com.thetestingacademy.vwo.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileUploadAndDownloadExample {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        // Set ChromeOptions to disable browser notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);
        // Maximize browser window
        driver.manage().window().maximize();
        // Open the web page where file upload is to be tested
        driver.get("http://demo.guru99.com/test/upload/");
        // File Upload Example
        // Find the file input field and send the file path
        WebElement fileInput = driver.findElement(By.id("uploadfile_0"));
        File file = new File("path_to_your_file");
        fileInput.sendKeys(file.getAbsolutePath());
        // Click the Upload button
        driver.findElement(By.id("submitbutton")).click();
        // Wait for file upload success message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'successfully')]")));
        System.out.println("File uploaded successfully: " + uploadSuccessMessage.getText());
        // File Download Example
        // Open the web page where file download is to be tested
        driver.get("http://demo.guru99.com/test/yahoo.html");
        // Find the link to download the file and click it
        WebElement downloadLink = driver.findElement(By.id("messenger-download"));
        downloadLink.click();
        // Wait for the download to complete (you may need to adjust this based on your network speed)
        try {
            Thread.sleep(5000); // Wait for 5 seconds for demonstration purposes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File downloaded successfully!");
        // Close the browser
        driver.quit();
    }
}


