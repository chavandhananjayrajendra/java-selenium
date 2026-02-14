package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {
    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement inputBox = driver.findElement(By.xpath("//input[@id= 'name']"));


       //----------------typecasting needed if the driver class is "WebDriver"
//        JavascriptExecutor js =


        //no casting object of Chromedriver class can store the variable of  
//        JavascriptExecutor js =  driver;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //passing the text into textbox->alternative for sendKeys() method
        js.executeScript("arguments[0].setAttribute('value','John')",inputBox);
        WebElement radiobutton = driver.findElement(By.xpath("//input[@id='male']"));


        //clicking on element-> alternate to click
        js.executeScript("arguments[0].click()",radiobutton);







    }
}
