package org.example.selenium.examples.session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
 driver.findElement(By.xpath("//*[@id=\"input-searchsearchpage-input\"]")).sendKeys("dhananjay");



    }
}
