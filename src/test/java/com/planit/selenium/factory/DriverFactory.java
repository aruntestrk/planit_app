package com.planit.selenium.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.planit.selenium.constants.DriverType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver getWebDriver(DriverType driverType){
    	WebDriver driver;
        switch (driverType){
            case CHROME -> {
            	  WebDriverManager.chromedriver().cachePath("Drivers").setup();
                  driver = new ChromeDriver();
                  driver.manage().window().maximize();
                  return driver;
            }
            case FIREFOX -> {
            	  WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                  driver = new FirefoxDriver();
                  driver.manage().window().maximize();
                return driver;
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
