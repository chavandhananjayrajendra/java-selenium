package org.example.selenium.concepts.locators_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByID {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D://bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

//        WebElement element = driver.findElement(By.id("userName"));
//        element.sendKeys("dhananjaychavan");
//
//        WebElement user = driver.findElement(By.name("username"));
//        user.sendKeys("dhananjay");

        driver.findElement(By.cssSelector("#userName")).sendKeys("Dhananjay");


        //using label
        driver.findElement(By.xpath("//label[text()='Email']/ancestor::div/following-sibling::div/input")).sendKeys("abc@test.com");



    }
}
