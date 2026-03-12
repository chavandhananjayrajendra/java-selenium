package org.example.selenium.examples.testng.Grouping;

import org.testng.annotations.Test;

public class LoginTests {
    @Test(priority = 1,groups = {"sanity"})
    void loginByEmail(){
        System.out.println("Login-Email");

    }
    @Test(priority = 2,groups = {"sanity"})
    void loginByInsta(){
        System.out.println("Login-Instagram");


    }
    @Test(priority = 3,groups = {"sanity"})
    void loginByX(){
        System.out.println("Login-TwitterX");
    }



}
