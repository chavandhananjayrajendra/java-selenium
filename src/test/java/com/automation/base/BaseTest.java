
package com.automation.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    protected static final Logger log =
            LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {

        log.info("Starting browser");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");

        log.info("Application opened successfully");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            log.info("Closing browser");
            driver.quit();
        }
    }
}
