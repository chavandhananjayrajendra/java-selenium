package org.example.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage2 {

    //constructor->to initiate webdriver
WebDriver driver;
    LoginPage2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators
/*   By username =By.xpath("//input[@placeholder='Username']");
    By password =By.xpath("//input[@placeholder='Password']");
    By button = By.xpath("//button[@type='submit']");
*/
    @FindBy(xpath = "//input[@placeholder='Username']")  WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")  WebElement password;
    @FindBy(xpath = "//button[@type='submit']")  WebElement button;

    @FindBy(tagName = "a")
    List<WebElement> links;


    //Action Methods
    public void setUsername(String user){
        username.sendKeys(user);
    }

    public void setPassword(String pwd){
       password.sendKeys(pwd);
    }
    public void clickLogin(){
        button.click();
    }




}
