package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
//getText()--->capture inner text of the element

//only inner text are captured by the getText() method that's why we are not able to run & verify the if-else condition

//capture value of value attribute from field-2
//instead of getText() will use getAttribute("value") which will help us to get value attribute text

//
//getText() Vs getAttribute (attribute)
//<input id="xyz"> welcome </input>
//getText() --> returns the inner text --> welcome
//getAttribute("id") --returns the value of attribute ---> xyz
//        <input value="welcome"></input>
//        getAttribute("value") ---> welcome


public class DoubleClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");


        WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
        WebElement button=driver.findElement(By.xpath("//button [normalize-space()='Copy Text']"));
        box1.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        box1.sendKeys("CHAVAN");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        Actions act = new Actions(driver);
        act.doubleClick(button).perform();

//        String text = box2.getText();
        String text = box2.getAttribute("value");
        System.out.println(text);
        if(text.equals("CHAVAN")){
            System.out.println("sURNAME COPIED SUCCESSFULLY");
        }
        else{
            System.out.println("copying unsuccessful");
        }

    }
}
