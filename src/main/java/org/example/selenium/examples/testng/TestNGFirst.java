package org.example.selenium.examples.testng;

import org.testng.annotations.Test;

public class TestNGFirst {


    @Test(priority = 1)
    void logout(){
        System.out.println("Logging off");
    }
    @Test(priority = 0)
    void login(){
        System.out.println("Logging into system");
    }

    @Test( priority = -1)
    void open(){
        System.out.println("Hello Dhananjay,Opening");
    }



}
