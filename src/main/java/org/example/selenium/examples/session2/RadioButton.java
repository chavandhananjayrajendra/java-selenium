package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton    {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();


        WebElement malebtn =  driver.findElement(By.xpath("//input[@id='male']"));

        WebElement femalebtn =  driver.findElement(By.xpath("//input[@id='female']"));

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



    }
}
