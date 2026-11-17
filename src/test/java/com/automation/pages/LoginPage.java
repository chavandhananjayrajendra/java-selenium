package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;

        // Initialize all @FindBy elements
        PageFactory.initElements(driver, this);
    }

    // Username textbox
    @FindBy(id = "username")
    WebElement txtUsername;

    // Password textbox
    @FindBy(id = "password")
    WebElement txtPassword;

    // Login button
    @FindBy(css = "button[type='submit']")
    WebElement btnLogin;

    // Login result message
    @FindBy(id = "flash")
    WebElement txtMessage;

    // Enter username
    public void setUsername(String username) {
        txtUsername.sendKeys(username);
    }

    // Enter password
    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    // Click login
    public void clickLogin() {
        btnLogin.click();
    }

    // Get login result message
    public String getMessage() {
        return txtMessage.getText();
    }

    // Complete login action
    public void login(String username, String password) {

        setUsername(username);
        setPassword(password);
        clickLogin();
    }
}