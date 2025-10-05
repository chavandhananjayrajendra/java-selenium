package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class OpenInNewTab {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        WebElement mobileTablets = driver.findElement(By.xpath("//span[contains(text(),\"Mobiles & Tablets\")]"));
        Actions act = new Actions(driver);

        //Control+Reglink
        act.keyDown(Keys.CONTROL).click(mobileTablets).keyDown(Keys.CONTROL).perform();   //this click method is getting accepted from Actions class that's why parameter passing can be done for it.
        //for click() through WebElement no parameter passing can be


        //switching to registration page

       List<String > ids =new ArrayList<>(driver.getWindowHandles());

        //switch to mobiles & tablets  page
       driver.switchTo().window(ids.get(1));

        WebElement Iphone15Pro =  driver.findElement(By.xpath("//div[@class=\"JxFEK3 _48O0EI\"]//a[5]"));
        System.out.println(Iphone15Pro.getText());

        //Switch to flipkart home page and search product

        driver.switchTo().window(ids.get(0));
        driver.findElement(By.xpath("//input[@placeholder=\"Search for Products, Brands and More\"]")).sendKeys("realme gt 6t");










    }
}
