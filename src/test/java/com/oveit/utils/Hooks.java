package com.oveit.utils;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    //driver
    public static WebDriver driver;

    //Executed before each test step and can be used to load so test data
    @BeforeStep
    public void loadData() {
        System.out.println("loading some data");
    }

    //Executed before each scenario
    @Before
    public void setup() {
        //It is a good place to initialize the driver
        if (driver == null) {
            driver = DriverManager.getDriver("chrome");
        }
    }

    //Executed after each step in scenario
    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        //Can be used to take screenshots when a step fails
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    //Executed after each scenario
    @After
    public void teardown() {
        //It is a good place for tearing down the session
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
}
