package com.thetestingacademy.vwo.Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class screenShot {
static WebDriver driver;
    public static void main(String[] args) throws IOException {
       File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File(""));
    }
}
