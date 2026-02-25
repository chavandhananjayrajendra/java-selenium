package org.example.selenium.examples.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*

1) Login-----@BeforeClass->Execute once before all test method will execute
2)Search -----@Test
3) Adv Search ---@Test
4) Logout ---@AfterClass->Execute once after all test method execution is done.

 */

public class Annotations2 {


    @BeforeClass
    void login(){
        System.out.println("This is login ..");
    }
    @Test(priority = 1)
    void search(){
        System.out.println("this is search.. ");
    }

    @Test
    void advancedsearch(){
        System.out.println("this is advanced search");
    }

    @AfterClass
    void logout(){


        System.out.println("this is logout..");
    }
}
