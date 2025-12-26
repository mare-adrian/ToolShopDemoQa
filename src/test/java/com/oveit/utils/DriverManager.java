package com.oveit.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    //The driver
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        //Driver setup. Can be as many drivers as you need and the browser can be chosen from an environment variable for example
        if (browser.equalsIgnoreCase("chrome")) {
            //Used for local testing with visual feedback
            ChromeOptions options = new ChromeOptions();
            //Set incognito mode -> always test in incognito mode
            options.addArguments("--incognito");
            options.addArguments("disable-cache"); // dezactivează cache
            driver = new ChromeDriver(options);
            //Set implicit timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //set windows size because in headless mode cannot use maximize
            driver.manage().window().setSize(new Dimension(1920, 1080));
        } else if (browser.equalsIgnoreCase("chrome-headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().setSize(new Dimension(1920, 1080));
        } else if (browser.equalsIgnoreCase("firefox")) {
            //add code for firefox
        }
        //Add code for as many drivers as you want
        return driver;
    }
}
