package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//contextclick()-> right click on the element


public class RightClickAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html#example-html-simple-context-menu");
        driver.manage().window().maximize();
       WebElement button =  driver.findElement(By.xpath("//span[@class = 'context-menu-one btn btn-neutral']"));
       Actions act = new Actions(driver);

       act.contextClick(button).perform();      //rightclick action

        //click on copy
        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();

        Thread.sleep(5000);
        //close-alert box
        driver.switchTo().alert().accept();

    }
}
