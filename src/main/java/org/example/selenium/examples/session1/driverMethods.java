package org.example.selenium.examples.session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//1) get methods
//2) conditional methods
//3) browser methods
//4) navigational methods
//5) wait methods.


public class driverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().minimize();

        driver.get("https://www.flipkart.com/");

//        driver.manage().window().minimize();
//get methods...we can access these methods through webdriver instance

//        //displays title of the URL
//        //getTitle()
        System.out.println("Title of the URl is "+ driver.getTitle());
//
//        //getCurrentUrl()
//        //displays actual URL
        System.out.println("Website is " +driver.getCurrentUrl());
//
//
//       //getPageSource()
//        //returns the souce code of the website
        System.out.println("Source code of the webpage is "+ driver.getPageSource());
//

        //getWindowHandle() - returns ID of the single browser Windows
        //whenever website is opened a unique ID is generated for the webpage
        //it is dynamic and changes as we run or reload different webpages on a brbrowser
        String windowid = driver.getWindowHandle();
        System.out.println("Window ID is : "+windowid);


        //getWindowHandles()- returns ID's of the multiple  browser windows



        //conditional methods---access these commands through WebElement

        //-----
        //returns boolean value (true / false )

        //isDisplayed()
        //isEnabled()
        //isSelected()

        //isDisplayed() logo is displayed or not ( display status of the element )
        WebElement logo = driver.findElement(By.xpath("//a[@aria-label='Minutes']"));
        System.out.println("Display status of logo "+ logo.isDisplayed());


        //isEnabled() whether a search box is enabled  to type or not( check the status of the element )

        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        System.out.println("Search Enabled : "+ search.isEnabled());



        //isSelected() can used to check whether element is selected or not

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
WebElement malebtn =  driver.findElement(By.xpath("//input[@id='gender-male']"));

        WebElement femalebtn =  driver.findElement(By.xpath("//input[@id='gender-female']"));

        //before selection
        System.out.println("Before selection");
        System.out.println(malebtn.isSelected());
        System.out.println(femalebtn.isSelected());

        //clicking on male  radio button

        malebtn.click();

        System.out.println("After selectiing Male ");

        //after selecting male
        System.out.println(malebtn.isSelected());
        System.out.println(femalebtn.isSelected());

        //clicking on female radio button

        femalebtn.click();


        System.out.println("After selectiing Female ");

        //after selecting female
        System.out.println(malebtn.isSelected());
        System.out.println(femalebtn.isSelected());




        //browser methods
       // -----
             //   close()- close single browser
        //quit()- close multiple browser windows









    }
}
