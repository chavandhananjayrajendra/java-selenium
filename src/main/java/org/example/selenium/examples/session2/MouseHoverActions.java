package org.example.selenium.examples.session2;



//---------------Mouse-Actions


//Mouse-Hover-------->moveToElement(element)
//right-click------->contextClick(element)
//double-click------->doubleClick(element)
//drag-and-drop

//moveToElement()-> move to specifed action objects writtem
//->build()----->create an action
//->perform()--------> perform an action--------> without build and perform the mouse action will never initiated.

//Actions-----------> predefined class provided in selenium

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//mouse cursor on a particular element
public class MouseHoverActions {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
         WebElement desktops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
         WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
         Actions act = new Actions(driver);   // need to pass driver to Actions constructor
        act.moveToElement(desktops).moveToElement(mac).build().perform();    //need to end actions objects everytime with build and perform   //optional--->was used in older versionsa //but sometimes required this


        act.moveToElement(desktops).moveToElement(mac).click().perform();    //same as the previous one    but perform method can create as well as complete the action-->no need to build() then




    }
}
