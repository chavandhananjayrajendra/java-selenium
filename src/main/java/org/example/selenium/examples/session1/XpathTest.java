package org.example.selenium.examples.session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
 driver.findElement(By.xpath("//*[@id=\"input-searchsearchpage-input\"]")).sendKeys("dhananjay");



    }
}
