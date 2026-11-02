package org.example.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //constructor->to initiate webdriver
WebDriver driver;
    LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
   By username =By.xpath("//input[@placeholder='Username']");
    By password =By.xpath("//input[@placeholder='Password']");
    By button = By.xpath("//button[@type='submit']");

    //Action Methods
    public void setUsername(String user){
        driver.findElement(username).sendKeys(user);
    }

    public void setPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }
    public void clickLogin(){
        driver.findElement(button).click();
    }




}
