package org.example.selenium.examples.session2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//accept,dismiss,gettext,sendkeys-alert methods

//accept()-close alert box using ok button
//dismiss()-close alert box using cancel button
//getText()-capture text value from alert
//sendkeys()- pass the text into inputbox inside the alert


public class HandleAlerts {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();


       //Normal Alert with OK Button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();

        Thread.sleep(5000);
//        Alert myAlert = driver.switchTo().alert();
//        myAlert.accept();

        driver.switchTo().alert().accept();


        //Confirmation alert- OK & Cancel
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();

        Thread.sleep(5000);

//        driver.switchTo().alert().accept(); //close alert window using OK Button
        driver.switchTo().alert().dismiss(); // close alert window using cancel button


        //3: prompt alert-input box
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();   // opens an alert window


        Alert myalert = driver.switchTo().alert();

        System.out.println("Text msg on alert " + myalert.getText());
        myalert.sendKeys("Dhananjay");

        myalert.accept();


        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();

        if(result.contains("Dhananjay")){
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }



    }
}
