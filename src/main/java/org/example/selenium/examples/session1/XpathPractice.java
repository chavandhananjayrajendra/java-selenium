package org.example.selenium.examples.session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * ✅ Xpath: Address of an element
 * It is based on Document Object Model
 * 2 types of xpath
 * absolute xpath ( full Xpath)
 * Example /html/body/header/div/div/div[2]/div/input
 * relative xpath ( partial xpath)
 * Example //*[@id = 'Search']/input
 *here we are using basetest to setup the classes and objects concept using selenium
 *
 * Difference between Absolute & Relative xpaths?
 * 1) Absolute xpath starts with Relative xpath starts with //
 * ---> represents root node
 * 2) Abosulate xpath do not use attributes Relative xpath works with attribute
 * 3) Absolute xpath traverse through each node till it finds element Relative xpath directly jump and find the element by using attribute
 *
 *
 *
 *
 * Relative Xpath Syntax: //tagname[attribute ='value'] or //*[attribute = 'value']
 *
 *
 */

public class XpathPractice {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");


        driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("Dhananjay");

//        driver.findElement(By.xpath("//span[contains(text(),'Minutes')]")).click();

        driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']")).click();
        WebElement phoneInput = driver.findElement(By.xpath("//input[contains(@class, 'r4vIwl BV+Dqf')]"));
        phoneInput.sendKeys("9967210702");

        driver.findElement(By.xpath("//button[contains(@class, 'QqFHMw twnTnD _7Pd1Fp')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'QqFHMw llMuju M5XAsp')]")));
        submitButton.click();


        // Wait up to 60 seconds




    }
}
