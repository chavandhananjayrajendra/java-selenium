package com.automation.base;

import com.automation.utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest2 {

    // ThreadLocal maintains a separate WebDriver for each thread
    // Useful when executing tests in parallel
    protected static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();
    protected static final Logger log =
            LogManager.getLogger(BaseTest.class);
    // BeforeMethod executes before every test method
    @BeforeMethod

    // Receives browser name from TestNG XML
    @Parameters("browser")
    public void setUp(@Optional("") String browser) {

        // Load common configuration values
        ConfigReader.loadConfig();

        // If XML does not provide browser, use config.properties
        if (browser.isEmpty()) {
            browser = ConfigReader.getProperty("browser");
        }
        System.out.println("BROWSER RECEIVED: " + browser);

        // Select browser based on the provided name
        switch (browser.toLowerCase()) {

            case "chrome":

                // Create Chrome browser instance
                driver.set(new ChromeDriver());
                break;

            case "firefox":

                // Create Firefox browser instance
                driver.set(new FirefoxDriver());
                break;

            case "edge":

                // Create Edge browser instance
                driver.set(new EdgeDriver());
                break;

            default:

                // Throw error for unsupported browser
                throw new IllegalArgumentException(
                        "Invalid browser: " + browser);
        }

        // Maximize browser window
        getDriver().manage().window().maximize();

        // Open application URL from config.properties
        getDriver().get(ConfigReader.getProperty("url"));
    }

    // Returns WebDriver belonging to the current thread
    public WebDriver getDriver() {

        return driver.get();
    }

    // AfterMethod executes after every test method
    @AfterMethod
    public void tearDown() {

        // Check whether browser instance exists
        if (getDriver() != null) {

            // Close browser and end WebDriver session
            getDriver().quit();

            // Remove WebDriver from current thread
            driver.remove();
        }
    }
}