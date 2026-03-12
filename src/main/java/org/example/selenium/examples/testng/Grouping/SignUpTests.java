package org.example.selenium.examples.testng.Grouping;

import org.testng.annotations.Test;

public class SignUpTests {

    @Test(priority = 1,groups = {"regression"})
    void signupByEmail(){
        System.out.println("SIGNUP-Email");

    }
    @Test(priority = 2,groups = {"regression"})
    void signupByInsta(){
        System.out.println("SIGNUP-Instagram");


    }
    @Test(priority = 3,groups = {"regression"})
    void signupByX(){
        System.out.println("SIGNUP-TwitterX");
    }

}
